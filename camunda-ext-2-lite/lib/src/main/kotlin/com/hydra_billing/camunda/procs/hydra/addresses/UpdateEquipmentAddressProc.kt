package com.hydra_billing.camunda.procs.hydra.addresses

import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.Address
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.*
import com.hydra_billing.camunda.helpers.camunda.*
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to update a equipment address via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraEquipmentId</code> - Equipment ID (*required*) /Long/
 * - <code>hydraEquipmentAddressTypeId</code> - Equipment address type ID /
 * [com.hydra_billing.camunda.api.hydra.common_types.AddressType]?/
 * - <code>hydraEquipmentParAddressId</code> - Equipment par address ID /Long?/
 * - <code>hydraEquipmentBindAddrId</code> - Equipment bind address ID /Long?/
 * - <code>hydraEquipmentAddressFirmId</code> - Equipment address firm ID /Long?/
 * - <code>hydraEquipmentAddressBindTypeId</code> - Equipment address bind type ID
 * /[com.hydra_billing.camunda.api.hydra.common_types.BindAddressType]?/
 * - <code>hydraEquipmentAddressRaw</code> - Equipment raw address (non-standard address)
 * /String?/
 * - <code>hydraEquipmentAddressCode</code> - Equipment address (e.g. phone number, email)
 * /String?/
 * - <code>hydraEquipmentAddressFloorNo</code> - Equipment address floor /Long?/
 * - <code>hydraEquipmentAddressRegionId</code> - Equipment address region ID /Long?/
 * - <code>hydraEquipmentAddressBeginDate</code> - Equipment address begin date /String?/
 * - <code>hydraEquipmentAddressEndDate</code> - Equipment address end date /String?/
 * - <code>hydraEquipmentAddressRem</code> - Equipment address comment /String?/
 * - <code>hydraEquipmentAddressIntercom</code> - Equipment address intercom code
 * /String?/
 * - <code>hydraEquipmentAddressEntrance</code> - Equipment address entrance /String?/
 * - <code>hydraEquipmentAddressFlat</code> - Equipment address flat /String?/
 * - <code>hydraEquipmentAddressMask</code> - Equipment address mask /Long?/
 * - <code>hydraEquipmentAddressIsRealSubnet</code> - Equipment address real subnet flag
 * /String?/
 *
 * The result of this delegate execution is the updated Equipment address and the following
 * variables stored in the Camunda execution:
 * - <code>hydraEquipmentAddress</code> - Updated Equipment address /net_devices.Types.AddressParams/
 */
class UpdateEquipmentAddressProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val equipmentId = getLong(execution, "hydraEquipmentId")
        val addressId = getLong(execution, "hydraEquipmentAddressId")
        val EquipmentAddress = doAction(restApi, equipmentId, addressId, prepareEquipmentAddressParams(execution))
        setToExecution(execution, EquipmentAddress)
    }

    fun doAction(
        restApi: HttpClient,
        equipmentId: Long,
        addressId: Long,
        updateEquipmentAddressParams: UpdateAddressParams
    ): AddressParams {
        return Address(restApi)
            .update(updateEquipmentAddressParams, equipmentId, addressId)
    }

    private fun prepareEquipmentAddressParams(
        execution: DelegateExecution
    ): UpdateAddressParams {
        return UpdateAddressParams(
            n_addr_type_id = getNullableHydraConstant<AddressType>(execution, "hydraEquipmentAddressTypeId"),
            n_par_addr_id = getNullableLong(execution, "hydraEquipmentParAddressId"),
            n_bind_addr_id = getNullableLong(execution, "hydraEquipmentBindAddrId"),
            n_obj_addr_type_id = getNullableHydraConstant<BindAddressType>(execution, "hydraEquipmentAddressBindTypeId"),
            n_region_id = getNullableLong(execution, "hydraEquipmentAddressRegionId"),
            d_begin = getNullableString(execution, "hydraEquipmentAddressBeginDate"),
            d_end = getNullableString(execution, "hydraEquipmentAddressEndDate"),
            n_firm_id = getNullableLong(execution, "hydraEquipmentAddressFirmId") ?: 100,
            vc_code = getNullableString(execution, "hydraEquipmentAddressCode"),
            vc_address = getNullableString(execution, "hydraEquipmentAddressRaw"),
            vc_entrance_no = getNullableString(execution, "hydraEquipmentAddressEntrance"),
            n_floor_no = getNullableLong(execution, "hydraEquipmentAddressFloorNo"),
            vc_flat = getNullableString(execution, "hydraEquipmentAddressFlat"),
            n_mask = getNullableLong(execution, "hydraEquipmentAddressMask"),
            c_fl_is_real_subnet = getNullableString(execution, "hydraEquipmentAddressIsRealSubnet"),
            vc_intercom_code = getNullableString(execution, "hydraEquipmentAddressIntercom"),
            vc_rem = getNullableString(execution, "hydraEquipmentAddressRem")
        )
    }

    private fun setToExecution(
        execution: DelegateExecution,
        EquipmentAddress: AddressParams
    ) {
        execution.setVariable(
            "hydraEquipmentAddress",
            DataClassHelper.convertDataClassToMap<AddressParams>(
                EquipmentAddress
            )
        )
    }
}
