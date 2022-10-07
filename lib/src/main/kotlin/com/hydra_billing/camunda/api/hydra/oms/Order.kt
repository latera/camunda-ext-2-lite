package com.hydra_billing.camunda.api.hydra.oms

import com.hydra_billing.camunda.Logger.*
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class Order(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }
    data class Order<T>(
        val id: Long,
        val code: String,
        val ext_code: String?,
        val bp_id: String?,
        val bp_state: String?,
        val state: String,
        val archived: Boolean,
        val data: T,
        val done_at: String?,
        val order_type_code: String,
        val user_email: String?
    )

    data class OrderParams<T>(
        val code: String?,
        val ext_code: String?,
        val bp_id: String?,
        val bp_state: String?,
        val state: String,
        val archived: Boolean,
        val data: T,
        val done_at: String?,
        val order_type_code: String,
        val user_email: String?
    )

    data class Response<T>(val order: Order<T>)
    data class ListResponse<T>(val orders: Array<Order<T>>)

    inline fun <reified T> show(code: String): Order<T> {
        val client = this.client

        logger.info("Get order by code $code.")

        val response = runBlocking {
            client.get<Response<T>> { url { encodedPath = "/api/orders/$code" } }
        }

        return response.order
    }

    inline fun <reified T> list(page: Int, page_size: Int): Array<Order<T>> {
        val client = this.client

        logger.info("Get ordes list page = $page page_size = $page_size.")

        val response = runBlocking {
            client.get<ListResponse<T>> {
                url { encodedPath = "/api/orders?page_size=$page_size&page=$page" }
            }
        }

        return response.orders
    }

    inline fun <reified T> create(params: OrderParams<T>): Order<T> {
        val client = this.client

        logger.info("Create order with $params.")

        val response = runBlocking {
            client.post<Response<T>> {
                url { encodedPath = "/api/orders" }
                body = mapOf("order" to params)
            }
        }

        return response.order
    }

    inline fun <reified T> update(params: OrderParams<T>): Order<T> {
        val client = this.client

        logger.debug("Update order with $params.")

        val response = runBlocking {
            client.put<Response<T>> {
                url { encodedPath = "/api/orders/${params.code}" }
                body = mapOf("order" to params)
            }
        }

        return response.order
    }
}
