package com.hydra_billing.camunda.procs.hydra.addresses

import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.entries.Address
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.AddressParams
import com.hydra_billing.camunda.api.hydra.rest.v2.net_devices.types.CreateAddressParams
import com.hydra_billing.camunda.helpers.camunda.getHydraConstant
import com.hydra_billing.camunda.helpers.camunda.getLong
import com.hydra_billing.camunda.helpers.camunda.getNullableLong
import com.hydra_billing.camunda.helpers.camunda.getNullableString
import com.hydra_billing.camunda.helpers.common.DataClassHelper
import com.hydra_billing.camunda.helpers.hydra.rest.v2.LoginHelper
import com.hydra_billing.camunda.procs.BaseProc
import io.ktor.client.*
import org.camunda.bpm.engine.delegate.DelegateExecution

/**
 * This delegate is designed to create a equipment component address via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraEquipmentId</code> - Equipment ID (*required*) /Long/
 * - <code>hydraEquipmentComponentId</code> - Equipment component ID (*required*) /Long/
 * - <code>hydraEquipmentComponentAddressTypeId</code> - Equipment component address type ID (*required*) /
 * [com.hydra_billing.camunda.api.hydra.common_types.AddressType]/
 * - <code>hydraEquipmentComponentParAddressId</code> - Equipment component par address ID /Long?/
 * - <code>hydraEquipmentComponentBindAddrId</code> - Equipment component bind address ID /Long?/
 * - <code>hydraEquipmentComponentAddressFirmId</code> - Equipment component address firm ID (default is 100)
 * /Long?/
 * - <code>hydraEquipmentComponentAddressBindTypeId</code> - Equipment component address bind type ID
 * (*required*) /[com.hydra_billing.camunda.api.hydra.common_types.BindAddressType]/
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
 * The result of this delegate execution is the created Equipment component address and the following
 * variables stored in the Camunda execution:
 * - <code>hydraEquipmentComponentAddress</code> - Created Equipment component address /net_devices.Types.AddressParams/
 */
class CreateEquipmentComponentAddressProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val equipmentId = getLong(execution, "hydraEquipmentComponentId")
        val equipmentComponentId = getLong(execution, "hydraEquipmentComponentId")
        val equipmentComponentAddress =
            doAction(restApi, equipmentId, equipmentComponentId, prepareEquipmentComponentAddressParams(execution))
        setToExecution(execution, equipmentComponentAddress)
    }

    fun doAction(
        restApi: HttpClient,
        equipmentId: Long,
        equipmentComponentId: Long,
        createEquipmentComponentAddressParams: CreateAddressParams
    ): AddressParams {
        return Address(restApi)
            .create(createEquipmentComponentAddressParams, equipmentId, equipmentComponentId)
    }

    private fun prepareEquipmentComponentAddressParams(
        execution: DelegateExecution
    ): CreateAddressParams {
        return CreateAddressParams(
            n_addr_type_id = getHydraConstant<AddressType>(execution, "hydraEquipmentComponentAddressTypeId"),
            n_par_addr_id = getNullableLong(execution, "hydraEquipmentComponentParAddressId"),
            n_bind_addr_id = getNullableLong(execution, "hydraEquipmentComponentBindAddrId"),
            n_obj_addr_type_id = getHydraConstant<BindAddressType>(
                execution,
                "hydraEquipmentComponentAddressBindTypeId"
            ),
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
        EquipmentComponentAddress: AddressParams
    ) {
        execution.setVariable(
            "hydraEquipmentComponentAddress",
            DataClassHelper.convertDataClassToMap<AddressParams>(
                EquipmentComponentAddress
            )
        )
    }
}
