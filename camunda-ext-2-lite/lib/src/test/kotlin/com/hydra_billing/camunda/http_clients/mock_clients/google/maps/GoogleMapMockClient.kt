package com.hydra_billing.camunda.http_clients.mock_clients.google.maps

import com.hydra_billing.camunda.http_clients.NullableTypeAdapterFactory
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.*
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.*
import io.ktor.http.*

object GoogleMapMockClient {
    fun getClient(): HttpClient {
        return HttpClient(MockEngine) {
            engine {
                addHandler { request ->
                    when (request.url.fullPath) {
                        "/maps/api/geocode/json?address=Winnetka" -> {
                            val responseHeaders =
                                headersOf(
                                    "Content-Type" to listOf(ContentType.Application.Json.toString())
                                )
                            respond(
                                """
              {
                "results" : [
                   {
                      "address_components" : [
                         {
                            "long_name" : "Winnetka",
                            "short_name" : "Winnetka",
                            "types" : [ "neighborhood", "political" ]
                         },
                         {
                            "long_name" : "Los Angeles",
                            "short_name" : "LA",
                            "types" : [ "locality", "political" ]
                         },
                         {
                            "long_name" : "Los Angeles County",
                            "short_name" : "Los Angeles County",
                            "types" : [ "administrative_area_level_2", "political" ]
                         },
                         {
                            "long_name" : "California",
                            "short_name" : "CA",
                            "types" : [ "administrative_area_level_1", "political" ]
                         },
                         {
                            "long_name" : "United States",
                            "short_name" : "US",
                            "types" : [ "country", "political" ]
                         }
                      ],
                      "formatted_address" : "Winnetka, Los Angeles, CA, USA",
                      "geometry" : {
                         "bounds" : {
                            "northeast" : {
                               "lat" : 34.2355209,
                               "lng" : -118.5534191
                            },
                            "southwest" : {
                               "lat" : 34.1854649,
                               "lng" : -118.588536
                            }
                         },
                         "location" : {
                            "lat" : 34.2048586,
                            "lng" : -118.5739621
                         },
                         "location_type" : "APPROXIMATE",
                         "viewport" : {
                            "northeast" : {
                               "lat" : 34.2355209,
                               "lng" : -118.5534191
                            },
                            "southwest" : {
                               "lat" : 34.1854649,
                               "lng" : -118.588536
                            }
                         }
                      },
                      "place_id" : "ChIJ0fd4S_KbwoAR2hRDrsr3HmQ",
                      "types" : [ "neighborhood", "political" ]
                   }
                ],
                "status" : "OK"
             }""",
                                headers = responseHeaders
                            )
                        }
                        else -> {
                            val responseHeaders =
                                headersOf("Content-Type" to listOf(ContentType.Text.Plain.toString()))
                            respond("Wrong request", headers = responseHeaders)
                        }
                    }
                }
            }

            install(JsonFeature) {
                serializer =
                    GsonSerializer {
                        disableHtmlEscaping()
                        registerTypeAdapterFactory(NullableTypeAdapterFactory())
                    }
            }

            defaultRequest {
                host = "localhost"
                port = 3000
                header("Accept", "application/json")
                header("Content-Type", "application/json")
            }
        }
    }
}
