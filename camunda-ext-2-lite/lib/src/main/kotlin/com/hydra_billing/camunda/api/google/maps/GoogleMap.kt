package com.hydra_billing.camunda.api.google.maps

import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*
import java.math.BigDecimal
import java.util.*

class GoogleMap(val client: HttpClient) {
    data class AddressComponent(
        val long_name: String,
        val short_name: String,
        val types: Array<String>
    )
    data class Coordinates(val lat: BigDecimal, val lng: BigDecimal)
    data class Bounds(val northeast: Coordinates, val southwest: Coordinates)
    data class Geometry(
        val bounds: Bounds,
        val location: Coordinates,
        val location_type: String,
        val viewport: Bounds
    )

    data class Result(
        val address_components: Array<AddressComponent>,
        val formatted_address: String,
        val geometry: Geometry,
        val place_id: String,
        val types: Array<String>
    )

    data class Response(val results: Array<Result>, val status: String, val error_message: String?)

    fun geocode(address: String): Response {
        val client = this.client

        return runBlocking {
            client.get<Response> {
                url { encodedPath = "/maps/api/geocode/json" }
                parameter("address", address)
            }
        }
    }
}
