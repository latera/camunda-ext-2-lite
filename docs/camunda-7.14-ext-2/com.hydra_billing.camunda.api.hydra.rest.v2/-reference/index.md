//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2](../index.md)/[Reference](index.md)

# Reference

[jvm]\
class [Reference](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) : [Logged](../../com.hydra_billing.camunda.Logger/-logged/index.md) |
| [ListResponse](-list-response/index.md) | [jvm]<br>data class [ListResponse](-list-response/index.md)(**references**: Array<[Reference.Reference](-reference/index.md)>) |
| [Reference](-reference/index.md) | [jvm]<br>data class [Reference](-reference/index.md)(**n_ref_id**: Long, **n_par_ref_id**: Long?, **n_ref_type_id**: Long, **n_ref_base_id**: Long?, **n_firm_id**: Long?, **vc_name**: String, **vc_code**: String, **vc_value**: String?, **vc_value_2**: String?, **vc_value_3**: String?, **c_value**: String?, **c_value_2**: String?, **c_value_3**: String?, **d_value**: String?, **d_value_2**: String?, **d_value_3**: String?, **n_value**: Long?, **n_value_2**: Long?, **n_value_3**: Long?, **c_fl_editable**: String, **c_fl_manual**: String, **n_lang_id**: [Language](../../com.hydra_billing.camunda.api.hydra.common_types/-language/index.md)) |
| [Response](-response/index.md) | [jvm]<br>data class [Response](-response/index.md)(**reference**: [Reference.Reference](-reference/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getByCode](get-by-code.md) | [jvm]<br>fun [getByCode](get-by-code.md)(code: String): [Reference.Reference](-reference/index.md) |
| [listByTypeCode](list-by-type-code.md) | [jvm]<br>fun [listByTypeCode](list-by-type-code.md)(code: String): Array<[Reference.Reference](-reference/index.md)> |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
