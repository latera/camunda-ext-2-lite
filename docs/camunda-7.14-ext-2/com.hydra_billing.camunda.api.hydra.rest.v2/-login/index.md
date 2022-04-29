//[camunda-7.14-ext-2](../../../index.md)/[com.hydra_billing.camunda.api.hydra.rest.v2](../index.md)/[Login](index.md)

# Login

[jvm]\
class [Login](index.md)(**client**: HttpClient)

## Types

| Name | Summary |
|---|---|
| [LoginParams](-login-params/index.md) | [jvm]<br>data class [LoginParams](-login-params/index.md)(**login**: String, **password**: String, **appCode**: String?) |
| [LoginResponse](-login-response/index.md) | [jvm]<br>data class [LoginResponse](-login-response/index.md)(**session**: [Login.Session](-session/index.md), **navigation**: [Login.Navigation](-navigation/index.md)) |
| [Navigation](-navigation/index.md) | [jvm]<br>data class [Navigation](-navigation/index.md)(**self**: String) |
| [Session](-session/index.md) | [jvm]<br>data class [Session](-session/index.md)(**token**: String) |

## Functions

| Name | Summary |
|---|---|
| [login](login.md) | [jvm]<br>fun [login](login.md)(params: [Login.LoginParams](-login-params/index.md)): [Login.Session](-session/index.md) |

## Properties

| Name | Summary |
|---|---|
| [client](client.md) | [jvm]<br>val [client](client.md): HttpClient |
