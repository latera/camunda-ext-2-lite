package com.hydra_billing.camunda.helpers.google.maps

import com.hydra_billing.camunda.helpers.common.ConfigHelper
import com.hydra_billing.camunda.http_clients.GoogleMapClient
import io.ktor.client.HttpClient

object LoginHelper {
    fun getGoogleMapsClient(googleMapsConfig: GoogleMapClient.Config = ConfigHelper.getDefaultGoogleMapConfig()): HttpClient {
        return GoogleMapClient.getClient(googleMapsConfig)
    }
}
