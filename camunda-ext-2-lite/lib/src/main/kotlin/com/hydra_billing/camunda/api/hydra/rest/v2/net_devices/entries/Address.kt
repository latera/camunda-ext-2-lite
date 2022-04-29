package com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.entries

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.*
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse
import io.ktor.http.*
import kotlinx.coroutines.*

class Address(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    fun create(params: CreateAddressParams, deviceId: Long, entryId: Long): AddressParams {
        val client = this.client

        logger.info("Create address for equipment $deviceId component $entryId with $params")

        val response = runBlocking {
            client.post<AddressResponse> {
                url { encodedPath = "/rest/v2/objects/net_devices/$deviceId/entries/$entryId/addresses" }

                body = mapOf("address" to params)
            }
        }

        return response.address
    }

    fun list(deviceId: Long, entryId: Long): Array<AddressParams> {
        val perPage = 1000
        var page = 1
        val client = this.client
        val result: ArrayList<AddressParams> = ArrayList()

        logger.info("Get addresses for equipment $deviceId")

        while (true) {
            val response = runBlocking {
                client.get<ListAddressesResponse> {
                    url { encodedPath = "/rest/v2/objects/net_devices/$deviceId/entries/$entryId/addresses" }

                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            }
            result.addAll(response.addresses)
            page += 1

            if (response.addresses.size < perPage) {
                break
            }
        }

        return result.toTypedArray()
    }

    fun get(deviceId: Long, entryId: Long, addressId: Long): AddressParams {
        val client = this.client

        logger.info("Get address for equipment $deviceId component $entryId with id $addressId")

        val response = runBlocking {
            client.get<AddressResponse> { url { encodedPath = "/rest/v2/objects/net_devices/$deviceId/entries/$entryId/addresses/$addressId" } }
        }

        return response.address
    }

    fun update(params: UpdateAddressParams, deviceId: Long, entryId: Long, addressId: Long): AddressParams {
        val client = this.client

        logger.info("Update address $addressId for equipment $deviceId component $entryId with $params")

        val response = runBlocking {
            client.put<AddressResponse> {
                url { encodedPath = "/rest/v2/objects/net_devices/$deviceId/entries/$entryId/addresses/$addressId" }

                body = mapOf("address" to params)
            }
        }

        return response.address
    }

    fun delete(deviceId: Long, entryId: Long, addressId: Long): Boolean {
        val client = this.client

        logger.info("Delete address $addressId for equipment $deviceId component $entryId")

        val response: HttpResponse = runBlocking {
            client.delete {
                url { encodedPath = "/rest/v2/objects/net_devices/$deviceId/entries/$entryId/addresses/$addressId" }
            }
        }

        return response.status == HttpStatusCode.NoContent
    }
}
