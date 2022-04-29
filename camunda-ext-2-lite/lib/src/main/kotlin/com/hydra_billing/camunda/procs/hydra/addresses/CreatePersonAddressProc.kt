package com.hydra_billing.camunda.procs.hydra.addresses

import com.hydra_billing.camunda.api.hydra.common_types.AddressState
import com.hydra_billing.camunda.api.hydra.common_types.AddressType
import com.hydra_billing.camunda.api.hydra.common_types.BindAddressType
import com.hydra_billing.camunda.api.hydra.rest.v2.subjects.persons.PersonAddress
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
 * This delegate is designed to create a Person address via Hydra REST API.
 *
 * This delegate is using the following execution variables:
 * - <code>hydraPersonId</code> - Person ID (*required*) /Long/
 * - <code>hydraPersonAddressTypeId</code> - Person address type ID (*required*) /
 * [com.hydra_billing.camunda.api.hydra.common_types.AddressType]/
 * - <code>hydraPersonAddressBindTypeId</code> - Person address bind type ID (*required*) /
 * [com.hydra_billing.camunda.api.hydra.common_types.BindAddressType]/
 * - <code>hydraPersonAddressStateId</code> - Person address state ID (*required*) /
 * [com.hydra_billing.camunda.api.hydra.common_types.AddressState]/
 * - <code>hydraPersonAddressRaw</code> - Person raw address (non-standard address) /String?/
 * - <code>hydraPersonAddressCode</code> - Person address (e.g. phone number, email) /String?/
 * - <code>hydraPersonAddressFloorNo</code> - Person address floor /Long?/
 * - <code>hydraPersonAddressRegionId</code> - Person address region ID /Long?/
 * - <code>hydraPersonAddressBeginDate</code> - Person address begin date /String?/
 * - <code>hydraPersonAddressEndDate</code> - Person address end date /String?/
 * - <code>hydraPersonAddressRem</code> - Person address comment /String?/
 * - <code>hydraPersonAddressIsMain</code> - Person address main flag /String?/
 * - <code>hydraPersonAddressIntercom</code> - Person address intercom code /String?/
 * - <code>hydraPersonAddressEntrance</code> - Person address entrance /String?/
 * - <code>hydraPersonAddressFlat</code> - Person address flat /String?/
 *
 * The result of this delegate execution is the created Person address and the following variables
 * stored in the Camunda execution:
 * - <code>hydraPersonAddress</code> - Created Person address /PersonAddress.Address/
 */
class CreatePersonAddressProc : BaseProc() {

    override fun perform(execution: DelegateExecution) {
        val restApi = LoginHelper.getRestApiClient()
        val personId = getLong(execution, "hydraPersonId")
        val baseSubjectAddress = doAction(restApi, personId, preparePersonAddressParams(execution))
        setToExecution(execution, baseSubjectAddress)
    }

    fun doAction(
        restApi: HttpClient,
        personId: Long,
        createPersonAddressParams: PersonAddress.CreateParams
    ): PersonAddress.Address {
        return PersonAddress(restApi).create(createPersonAddressParams, personId)
    }

    private fun preparePersonAddressParams(execution: DelegateExecution): PersonAddress.CreateParams {
        return PersonAddress.CreateParams(
            n_addr_type_id = getHydraConstant<AddressType>(execution, "hydraPersonAddressTypeId"),
            n_subj_addr_type_id = getHydraConstant<BindAddressType>(execution, "hydraPersonAddressBindTypeId"),
            vc_address = getNullableString(execution, "hydraPersonAddressRaw"),
            vc_code = getNullableString(execution, "hydraPersonAddressCode"),
            n_addr_state_id = getHydraConstant<AddressState>(execution, "hydraPersonAddressStateId"),
            n_floor_no = getNullableLong(execution, "hydraPersonAddressFloorNo"),
            n_region_id = getNullableLong(execution, "hydraPersonAddressRegionId"),
            d_begin = getNullableString(execution, "hydraPersonAddressBeginDate"),
            d_end = getNullableString(execution, "hydraPersonAddressEndDate"),
            vc_rem = getNullableString(execution, "hydraPersonAddressRem"),
            c_fl_main = getNullableString(execution, "hydraPersonAddressIsMain"),
            vc_intercom_code = getNullableString(execution, "hydraPersonAddressIntercom"),
            vc_entrance_no = getNullableString(execution, "hydraPersonAddressEntrance"),
            vc_flat = getNullableString(execution, "hydraPersonAddressFlat")
        )
    }

    private fun setToExecution(execution: DelegateExecution, personAddress: PersonAddress.Address) {
        execution.setVariable(
            "hydraPersonAddress",
            DataClassHelper.convertDataClassToMap<PersonAddress.Address>(
                personAddress
            )
        )
    }
}
