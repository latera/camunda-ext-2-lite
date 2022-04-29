package com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types

import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType

data class CreateAddressParams(
    val n_address_id: Long? = null,
    val n_addr_type_id: AddressType,
    val n_par_addr_id: Long? = null,
    val n_bind_addr_id: Long? = null,
    val n_obj_addr_type_id: BindAddressType,
    val n_region_id: Long? = null,
    val d_begin: String? = null,
    val d_end: String? = null,
    val n_firm_id: Long? = null,
    val vc_code: String? = null,
    val vc_address: String? = null,
    val vc_entrance_no: String? = null,
    val n_floor_no: Long? = null,
    val vc_flat: String? = null,
    val n_mask: Long? = null,
    val c_fl_is_real_subnet: String? = null,
    val vc_intercom_code: String? = null,
    val vc_rem: String? = null
)

data class UpdateAddressParams(
    val n_addr_type_id: AddressType? = null,
    val n_par_addr_id: Long? = null,
    val n_bind_addr_id: Long? = null,
    val n_obj_addr_type_id: BindAddressType? = null,
    val n_region_id: Long? = null,
    val d_begin: String? = null,
    val d_end: String? = null,
    val n_firm_id: Long? = null,
    val vc_code: String? = null,
    val vc_address: String? = null,
    val vc_entrance_no: String? = null,
    val n_floor_no: Long? = null,
    val vc_flat: String? = null,
    val n_mask: Long? = null,
    val c_fl_is_real_subnet: String? = null,
    val vc_intercom_code: String? = null,
    val vc_rem: String? = null
)

data class AddressResponse(val address: AddressParams)
data class ListAddressesResponse(val addresses: Array<AddressParams>)

data class AddressParams(
    val n_address_id: Long,
    val n_addr_type_id: AddressType,
    val vc_addr_type_name: String,
    val n_par_addr_id: Long?,
    val vc_code: String?,
    val vc_address: String?,
    val vc_flat: String?,
    val n_region_id: Long?,
    val vc_entrance_no: String?,
    val n_floor_no: Long?,
    val n_firm_id: Long?,
    val n_bind_addr_id: Long?,
    val n_obj_address_id: Long,
    val n_obj_addr_type_id: BindAddressType,
    val d_begin: String?,
    val d_end: String?,
    val vc_rem: String?,
    val vc_intercom_code: String?
)
