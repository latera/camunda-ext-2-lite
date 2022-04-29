package com.hydra_billing.camunda.api

import java.net.URL
import java.util.*
import javax.activation.DataHandler
import javax.activation.DataSource
import javax.activation.FileDataSource
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart
import javax.mail.util.ByteArrayDataSource

object SMTPApi {
    data class Config(
        val host: String,
        val port: Int,
        val user: String,
        val password: String,
        val tls: Boolean,
        val ssl: Boolean,
        val timeout: Long
    )

    fun getSession(config: Config): Session {
        val props = Properties()
        props["mail.smtp.host"] = config.host
        props["mail.smtp.port"] = config.port
        props["mail.mime.encodefilename"] = true
        props["mail.smtp.auth"] = true
        props["mail.smtp.timeout"] = config.timeout
        props["mail.smtp.connectiontimeout"] = config.timeout
        props["mail.smtps.timeout"] = config.timeout
        props["mail.smtps.connectiontimeout"] = config.timeout
        props["mail.smtp.user"] = config.user
        props["mail.smtp.password"] = config.password

        if (config.ssl) {
            props["mail.smtp.ssl.trust"] = true
        }

        if (config.tls) {
            props["mail.smtp.starttls.enable"] = true
            props["mail.smtp.ssl.trust"] = config.host
        }

        return Session.getInstance(props)
    }

    fun getTransport(session: Session): Transport {
        val transport = session.getTransport("smtp")
        transport.connect(
            session.properties["mail.smtp.host"].toString(),
            session.properties["mail.smtp.port"].toString().toInt(),
            session.properties["mail.smtp.user"].toString(),
            session.properties["mail.smtp.password"].toString()
        )

        return transport
    }

    fun prepareMessage(session: Session, from: String, addresses: Array<String>, subject: String): MimeMessage {
        val msg = MimeMessage(session)
        msg.setFrom(from)

        for (address in addresses) {
            msg.addRecipient(Message.RecipientType.TO, InternetAddress(address))
        }
        msg.subject = subject
        msg.sentDate = Date()

        return msg
    }

    fun createTextPart(text: String): BodyPart {
        val textPart = MimeBodyPart()
        textPart.setText(text, "utf-8")
        return textPart
    }

    fun createHTMLPart(html: String): BodyPart {
        val HTMLpart = MimeBodyPart()
        HTMLpart.setText(html, "utf-8", "html")
        return HTMLpart
    }

    fun createAttachmentPart(filePath: String, name: String): BodyPart {
        val attachmentPart = MimeBodyPart()
        val source: DataSource = FileDataSource(filePath)

        attachmentPart.dataHandler = DataHandler(source)
        attachmentPart.fileName = name
        attachmentPart.disposition = Part.ATTACHMENT
        attachmentPart.setHeader("Content-ID", "<$name>")

        return attachmentPart
    }

    fun createAttachmentPartFromString(base64String: String, name: String, type: String): BodyPart {
        val bytes: ByteArray = Base64.getDecoder().decode(base64String)
        val attachmentPart = MimeBodyPart()
        val source: DataSource = ByteArrayDataSource(bytes, type)

        attachmentPart.dataHandler = DataHandler(source)
        attachmentPart.fileName = name
        attachmentPart.disposition = Part.ATTACHMENT
        attachmentPart.setHeader("Content-ID", "<$name>")

        return attachmentPart
    }

    fun createAttachmentPartFromUrl(fileUrl: String, name: String): BodyPart {
        val attachmentPart = MimeBodyPart()
        val url = URL(fileUrl)

        attachmentPart.dataHandler = DataHandler(url)
        attachmentPart.fileName = name
        attachmentPart.disposition = Part.ATTACHMENT
        attachmentPart.setHeader("Content-ID", "<$name>")

        return attachmentPart
    }

    fun sendMultipartMessage(
        session: Session,
        from: String,
        addresses: Array<String>,
        subject: String,
        parts: Array<BodyPart>,
        transport: Transport? = null,
        closeConnection: Boolean = true
    ) {

        val connection = transport ?: getTransport(session)
        val message = prepareMessage(session, from, addresses, subject)

        val multipart = MimeMultipart()

        for (part in parts) {
            multipart.addBodyPart(part)
        }

        message.setContent(multipart)

        sendMessage(connection, message, closeConnection)
    }

    private fun sendMessage(transport: Transport, message: Message, closeConnection: Boolean = true) {
        try {
            transport.sendMessage(message, message.allRecipients)
            if (closeConnection) {
                transport.close()
            }
        } catch (e: Exception) {
            if (transport.isConnected) {
                transport.close()
            }
            throw e
        }
    }
}
