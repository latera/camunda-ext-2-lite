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
 * This delegate is designed to update a EquipmentComponent componentaddress via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraEquipmentComponentId</code> - Equipment component ID (*required*) /Long/
 * - <code>hydraEquipmentComponentAddressTypeId</code> - Equipment component address type ID /
 * [com.hydra_billing.camunda.api.hydra.common_types.AddressType]?/
 * - <code>hydraEquipmentComponentParAddressId</code> - Equipment component par address ID /Long?/
 * - <code>hydraEquipmentComponentBindAddrId</code> - Equipment component bind address ID /Long?/
 * - <code>hydraEquipmentComponentAddressFirmId</code> - Equipment component address firm ID /Long?/
 * - <code>hydraEquipmentComponentAddressBindTypeId</code> - Equipment component address bind type ID
 * /[com.hydra_billing.camunda.api.hydra.common_types.BindAddressType]?/
 * - <code>hydraEquipmentComponentAddressRaw</code> - Equipment component raw address (non-standard address)
 * /String?/
 * - <code>hydraEquipmentComponentAddressCode</code> - Equipment component address (e.g. phone number, email)
 * /String?/
 * - <code>hydraEquipmentComponentAddressFloorNo</code> - Equipment component address floor /Long?/
 * - <code>hydraEquipmentComponentAddressRegionId</code> - Equipment component address region ID /Long?/
 * - <code>hydraEquipmentComponentAddressBeginDate</code> - Equipment component address begin date /String?/
 * - <code>hydraEquipmentComponentAddressEndDate</code> - Equipment component address end date /String?/
 * - <code>hydraEquipmentComponentAddressRem</code> - Equipment component address comment /String?/
 * - <code>hydraEquipmentComponentAddressIntercom</code> - Equipment component address intercom code
 * /String?/
 * - <code>hydraEquipmentComponentAddressEntrance</code> - Equipment component address entrance /String?/
 * - <code>hydraEquipmentComponentAddressFlat</code> - Equipment component address flat /String?/
 * - <code>hydraEquipmentComponentAddressMask</code> - Equipment component address mask /Long?/
 * - <code>hydraEquipmentComponentAddressIsRealSubnet</code> - Equipment component address real subnet flag
 * /String?/
 *
 * The result of this delegate execution is the updated Equipment component address and the following
 * variables stored in the Camunda execution:
 * - <code>hydraEquipmentComponentAddress</code> - Updated Equipment component address /net_devices.Types.AddressParams/
 */
class UpdateEquipmentComponentAddressProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val equipmentComponentId = getLong(execution, "hydraEquipmentComponentId")
        val addressId = getLong(execution, "hydraEquipmentComponentAddressId")
        val equipmentComponentAddress = doAction(restApi, equipmentComponentId, addressId, prepareEquipmentComponentAddressParams(execution))
        setToExecution(execution, equipmentComponentAddress)
    }

    fun doAction(
        restApi: HttpClient,
        equipmentComponentId: Long,
        addressId: Long,
        updateEquipmentComponentAddressParams: UpdateAddressParams
    ): AddressParams {
        return Address(restApi)
            .update(updateEquipmentComponentAddressParams, equipmentComponentId, addressId)
    }

    private fun prepareEquipmentComponentAddressParams(
        execution: DelegateExecution
    ): UpdateAddressParams {
        return UpdateAddressParams(
            n_addr_type_id = getNullableHydraConstant<AddressType>(execution, "hydraEquipmentComponentAddressTypeId"),
            n_par_addr_id = getNullableLong(execution, "hydraEquipmentComponentParAddressId"),
            n_bind_addr_id = getNullableLong(execution, "hydraEquipmentComponentBindAddrId"),
            n_obj_addr_type_id = getNullableHydraConstant<BindAddressType>(execution, "hydraEquipmentComponentAddressBindTypeId"),
            n_region_id = getNullableLong(execution, "hydraEquipmentComponentAddressRegionId"),
            d_begin = getNullableString(execution, "hydraEquipmentComponentAddressBeginDate"),
            d_end = getNullableString(execution, "hydraEquipmentComponentAddressEndDate"),
            n_firm_id = getNullableLong(execution, "hydraEquipmentComponentAddressFirmId") ?: 100,
            vc_code = getNullableString(execution, "hydraEquipmentComponentAddressCode"),
            vc_address = getNullableString(execution, "hydraEquipmentComponentAddressRaw"),
            vc_entrance_no = getNullableString(execution, "hydraEquipmentComponentAddressEntrance"),
            n_floor_no = getNullableLong(execution, "hydraEquipmentComponentAddressFloorNo"),
            vc_flat = getNullableString(execution, "hydraEquipmentComponentAddressFlat"),
            n_mask = getNullableLong(execution, "hydraEquipmentComponentAddressMask"),
            c_fl_is_real_subnet = getNullableString(execution, "hydraEquipmentComponentAddressIsRealSubnet"),
            vc_intercom_code = getNullableString(execution, "hydraEquipmentComponentAddressIntercom"),
            vc_rem = getNullableString(execution, "hydraEquipmentComponentAddressRem")
        )
    }

    private fun setToExecution(
        execution: DelegateExecution,
        equipmentComponentAddress: AddressParams
    ) {
        execution.setVariable(
            "hydraEquipmentComponentAddress",
            DataClassHelper.convertDataClassToMap<AddressParams>(
                equipmentComponentAddress
            )
        )
    }
}
