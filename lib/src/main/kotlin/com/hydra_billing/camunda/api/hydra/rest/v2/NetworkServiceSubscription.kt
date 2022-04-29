package com.hydra_billing.camunda.api.hydra.rest.v2

import com.hydra_billing.camunda.Logger.*
import com.hydra_billing.camunda.api.hydra.common_types.AuthorizationType
import com.hydra_billing.camunda.api.hydra.common_types.NetworkServiceSubscriptionType
import io.ktor.client.HttpClient
import io.ktor.client.request.*
import kotlinx.coroutines.*

class NetworkServiceSubscription(val client: HttpClient) {
    companion object : Logged {
        val logger = getLogger()
    }

    data class CreateParams(
        val n_subj_serv_type_id: NetworkServiceSubscriptionType,
        val n_subject_id: Long,
        val n_service_id: Long,
        val n_object_id: Long,
        val n_auth_type_id: AuthorizationType,
        val vc_login: String
    )

    data class Response(val network_service_subscription: NetworkServiceSubscription)
    data class ListResponse(val network_service_subscriptions: Array<NetworkServiceSubscription>)

    data class NetworkServiceSubscription(
        val n_subj_serv_id: Long,
        val n_subj_serv_type_id: NetworkServiceSubscriptionType,
        val n_subject_id: Long,
        val n_service_id: Long?,
        val vc_user_service_name: String?,
        val n_object_id: Long?,
        val n_auth_type_id: AuthorizationType,
        val vc_auth_type: String,
        val vc_login: String?
    )

    fun create(params: CreateParams, subjectId: Long): NetworkServiceSubscription {
        val client = this.client

        logger.info("Create network subscription for subject $subjectId with $params")

        val response = runBlocking {
            client.post<Response> {
                url { encodedPath = "/rest/v2/subjects/$subjectId/network_service_subscriptions/" }

                body = mapOf("address" to params)
            }
        }

        return response.network_service_subscription
    }

    fun list(subjectId: Long): Array<NetworkServiceSubscription> {
        val perPage = 1000
        var page = 1
        val client = this.client
        val result: ArrayList<NetworkServiceSubscription> = ArrayList()

        logger.info("Get network service subscriptions for subject $subjectId")

        while (true) {
            val response = runBlocking {
                client.get<ListResponse> {
                    url { encodedPath = "/rest/v2/subjects/$subjectId/network_service_subscriptions" }

                    parameter("page", page)
                    parameter("per_page", perPage)
                }
            }
            result.addAll(response.network_service_subscriptions)
            page += 1

            if (response.network_service_subscriptions.size < perPage) {
                break
            }
        }

        return result.toTypedArray()
    }
}
