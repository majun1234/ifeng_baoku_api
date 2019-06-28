# 宝库库存接口

### 1 简介

#### 	1.1 功能概述

宝库开放接口为您提供宝库相关数据操作接口。

#### 	1.2 应用场景

宝库用户可以通过对接开放接口，实现自己的业务逻辑。

#### 	1.3 其他

本篇列出接口为：宝库库存查询接口。

接口的相应都是JSON格式。

每个接口都有可能抛出异常。

### 2 业务流程

宝库开放接口，使用阿里api网关功能，安全可靠，性能强大，当每次调用接口的时候，会通过阿里api网关对请求进行权限鉴定，流量控制。

第一步：客户端发起请求

第二步：请求通过阿里api网关校验

第三步：请求调用宝库开放接口服务器，业务处理后返回给客户端

### 3 环境准备

​	

### 4 资料准备

#### 	4.1 应用（APP）

您需要创建应用（APP）作为您调用 API 的身份，每个 APP 有一对 AppKey 和 AppSecret 密钥对，AppKey 需要在请求时作为参数在 Header 传入，AppSecret 需要用于计算请求签名。

1. 在 API 网关，您需要创建应用（APP）作为请求者的身份。APP 创建时，系统会自动分配一对 AppKey 和 AppSecret。在您请求 API 时，需要用到密钥。详细加密签名的计算传递方式，请查看文档——[请求签名说明文档](https://help.aliyun.com/document_detail/29475.html)。
2. AppKey 和 AppSecret 密钥对，具备该 APP 的全部权限，需要妥善保管。如果发生泄漏，您可以在 API 网关的控制台进行重置。
3. 您可以拥有多个 APP，可以根据您的业务需求分别被授权不同的 API。注意，API 的授权对象是 APP 而不是阿里云用户账号。
4. 您可以在 API 网关控制台完成对 APP 的创建、修改、删除、查看详情、密钥管理、查看已授权等管理操作。

#### 	4.2 资料准备-创建阿里云API网关APP

​	宝库开放接口，使用阿里云的api网关技术，所以需要创建APP来完成接口调用。

​	注册阿里云账号后，登录阿里云后台（https://www.aliyun.com）。

​	登录后，右上角搜索处，搜索“apigateway 控制台”，进入API网关界面（https://www.aliyun.com/product/apigateway）。点击“立即开通”，跳转到云产品开通页，阅读《API网关服务协议》，同意后，勾选“我已阅读并同意”。点击“立即开通”。页面提示“恭喜，开通成功”后，即完成阿里api网关功能的开通。

进入API网关控制台。左侧导航栏，点开“调用API”，点击“应用管理”，跳转至应用管理界面后，点击右上角“创建APP”，输入名称和备注后，成功创建一个APP，来调用宝库开放接口。、

​	创建成功后，在列表中，选中创建的APP，进入基本信息界面，就会看见AppKey和AppSecret。

#### 	4.3 资料准备-获取宝库开放接口授权

​	登录宝库系统，打开api管理界面，输入必填信息(AppId为阿里云Api网关功能创建的APP的AppKey，绑定IP地址为您对接宝库接口项目所在服务器ip地址，最多可以填写十个，每个之间用 ‘;’ 分隔)。

​	点击“授权并绑定”后，等待宝库接口授权。

​	授权成功后，可通过阿里云的API网关控制台，左侧的调用API-应用管理-已授权的API列表，查看已授权的接口。若已授权成功，会显示相应已授权的接口。

​	到此，您已成功获取宝库开放接口的授权。接下来就可以对接宝库开放接口了。

### 5 接口描述

#### 5.1 API列表

<div>
    <table>
        <tr>
            <th >API名称</th>
            <th >认证方式</th>
            <th >描述</th>
        </tr>
        <tr>
            <td>获取bk用户持仓</td>
            <td>APP</td>
            <td>宝库用户持仓查询接口</td>
         </tr>
     </table>
</div>

#### 5.2 公共入参

公共请求参数是指每个接口都需要使用到的请求参数。

| 参数名称  | 位置   | 必须 | 描述                                                         |
| --------- | ------ | ---- | ------------------------------------------------------------ |
| appKey    | Header | 是   | Appkey，调用API的身份标识，可以到阿里云[API网关控制台](https://apigateway.console.aliyun.com/#/apps/list)申请 |
| appSecret | Header | 是   | AppSecret，调用api的身份确认标识，可以到API网关控制台申请    |

#### 5.3 API名称：获取bk用户持仓

##### *5.3.1 描述*

宝库用户持仓查询接口

##### *5.3.2 请求信息*

HTTP协议：HTTP,HTTPS

调用地址：150ad3f45707481489016d398f6b9b1d-cn-beijing.alicloudapi.com/store

方法：GET

<br />

##### *5.3.3 请求参数*

<div>
<table>
<tr>
<th style="width: 20%;">名称</th>
<th style="width: 10%;">位置</th>
<th style="width: 10%;">类型</th>
<th style="width: 10%;">必填</th>
<th style="width: 30%;">描述</th>
</tr>
<tr>
<td>userCode</td>
<td>QUERY</td>
<td>STRING</td>
<td>是</td>
<td>在宝库中的用户code</td>
</tr>
</table>
</div>

<br />

##### *5.3.4返回信息*

###### 	返回参数类型

​		JSON格式

###### 	返回结果示例

```
{
    "header": {
        "serviceName": "/api/store",
        "sender": null,
        "createTime": "2019-06-03T07:04:04.896+0000",
        "provider": "bigdepots-api",
        "statusCode": 2000,
        "message": "请求成功",
        "id": "9074459b-ba22-4bb9-a0b6-90ee1a09c3fa"
    },
    "body": {
        "list": [
            {
                "goodsName": "测试商品1",
                "goodsCode": "100001",
                "availableCount": 10000,
                "frozenCount": 10
            },
            {
                "goodsName": "测试商品2",
                "goodsCode": "100002",
                "availableCount": 9999,
                "frozenCount": 1
            }
        ]
    }
}
```

###### 	异常返回示例

```
{
    "header": {
        "serviceName": "/api/store",
        "sender": null,
        "createTime": "2019-06-03T07:07:38.574+0000",
        "provider": "bigdepots-api",
        "statusCode": 5005,
        "message": "数据错误",
        "id": "dd1e769f-2203-423c-b141-81f30a86216b"
    },
    "body": null
}
```



#### 5.4 <span id='pubError'>公共错误</span>

##### 5.4.1 如何获取公共错误

所有的 API 请求只要到达了网关，网关就会返回请求结果信息。

用户需要查看返回结果的头部，即 Header 部分。返回参数如示例：

```
//请求唯一ID，请求一旦进入API网关应用后，API网关就会生成请求ID并通过响应头返回给客户端，建议客户端与后端服务都记录此请求ID，可用于问题排查与跟踪
X-Ca-Request-Id: 7AD052CB-EE8B-4DFD-BBAF-EFB340E0A5AF

//API网关返回的错误消息，当请求出现错误时API网关会通过响应头将错误消息返回给客户端
X-Ca-Error-Message: Invalid Url

//当打开Debug模式后会返回Debug信息，此信息后期可能会有变更，仅用做联调阶段参考
X-Ca-Debug-Info: {"ServiceLatency":0,"TotalLatency":2}
```

在 Header 中获得 X-Ca-Error-Message 可以基本明确报错原因，而 X-Ca-Request-Id 可以用于提供给这边的支持人员，供支持人员搜索日志。

#### 5.5公共错误码

##### 5.5.1 客户端错误

| 错误代码                                  | Http 状态码 | 语义                 | 解决方案                                                     |
| ----------------------------------------- | ----------- | -------------------- | ------------------------------------------------------------ |
| Throttled by USER Flow Control            | 403         | 因用户流控被限制     | 调用频率过高导致被流控，可以联系 API 服务商协商放宽限制。    |
| Throttled by APP Flow Control             | 403         | 因APP流控被限制      | 调用频率过高导致被流控，可以联系 API 服务商协商放宽限制。    |
| Throttled by API Flow Control             | 403         | 因 API 流控被限制    | 调用频率过高导致被流控，可以联系 API 服务商协商放宽限制。    |
| Throttled by DOMAIN Flow Control          | 403         | 因二级域名流控被限制 | 直接访问二级域名调用 API，每天被访问次数上限1000次。         |
| TThrottled by GROUP Flow Control          | 403         | 因分组流控被限制     | 调用频率过高导致被流控，可以联系 API 服务商协商放宽限制。    |
| Quota Exhausted                           | 403         | 调用次数已用完       | 购买的次数已用完。                                           |
| Quota Expired                             | 403         | 购买次数已过期       | 购买的次数已经过期。                                         |
| User Arrears                              | 403         | 用户已欠费           | 请尽快充值续费。                                             |
| Empty Request Body                        | 400         | body 为空            | 请检查请求 Body 内容。                                       |
| Invalid Request Body                      | 400         | body 无效            | 请检查请求 Body。                                            |
| Invalid Param Location                    | 400         | 参数位置错误         | 请求参数位置错误。                                           |
| Unsupported Multipart                     | 400         | 不支持上传           | 不支持上传文件。                                             |
| Invalid Url                               | 400         | Url 无效             | 请求的 Method、Path 或者环境不对。请参照错误说明 Invalid Url。 |
| Invalid Domain                            | 400         | 域名无效             | 请求域名无效，根据域名找不到 API。请联系 API 服务商。        |
| Invalid HttpMethod                        | 400         | HttpMethod 无效      | 输入的 Method 不合法。                                       |
| Invalid AppKey                            | 400         | AppKey 无效或不存在  | 请检查传入的 AppKey。注意左右空格的影响。                    |
| Invalid AppSecret                         | 400         | APP 的Secret 错误    | 检查传入的 AppSecret。注意左右空格的影响。                   |
| Timestamp Expired                         | 400         | 时间戳过时           | 请核对请求系统时间是否为标准时间。                           |
| Invalid Timestamp                         | 400         | 时间戳不合法         | 请参照 请求签名说明文档。                                    |
| Empty Signature                           | 404         | 签名为空             | 请传入签名字符串，请参照 请求签名说明文档。                  |
| Invalid Signature, Server StringToSign:%s | 400         | 签名无效             | 签名无效，参照 Invalid Signature 错误说明                    |
| Invalid Content-MD5                       | 400         | Content-MD5 值不合法 | 请求 Body 为空，但传入了 MD5 值，或 MD5 值计算错误。请参照 请求签名说明文档。 |
| Unauthorized                              | 403         | 未被授权             | APP 未获得要调用的 API 的授权。请参照错误说明 Unauthorized。 |
| Nonce Used                                | 400         | SignatureNonce       | 已被使用                                                     |
| API Not Found                             | 400         | 找不到 API           | 传入的APIdi地址或者HttpMethod不正确，或已下线。              |

##### 5.5.2 服务器端错误（调用 API）

以下为API服务端错误，如果频繁错误，可联系服务商。

| 错误代码                         | Http状态码 | 语义         | 解决方案                                                     |
| -------------------------------- | ---------- | ------------ | ------------------------------------------------------------ |
| Internal Error                   | 500        | 内部错误     | 建议重试,或者联系服务商                                      |
| Failed To Invoke Backend Service | 500        | 底层服务错误 | API 提供者底层服务错误，建议重试，如果重试多次仍然不可用，可联系 API 服务商解决 |
| Service Unavailable              | 503        | 服务不可用   | 建议重试,或者联系服务商                                      |
| Async Service                    | 504        | 后端服务超时 | 建议重试,或者联系服务商                                      |



### 6  API网关Java-SDK使用指南

#### 6.1 SDK简介

欢迎使用API网关开发者工具套件(SDK)。API网关SDK是根据您自定义的所有API接口，自动生成的Java调用代码，让您无需复杂编程即可访问阿里云的API网关服务。这里向您介绍如何使用API网关SDK。

#### 6.2 SDK使用

##### 6.2.1 环境准备

1. 阿里云API网关Java SDK适用于`JDK 1.6`及以上版本
2. 您需要准备一对授权密钥供SDK生成鉴权和签名信息，即 [AppKey和AppSecret](https://help.aliyun.com/document_detail/29488.html?spm=5176.product29462.6.552.HqvvXr)

 **重要提示：`AppKey`和`AppSecret`是网关认证用户请求的密钥，这两个配置如果保存在客户端，请妥善加密。** 

3. 在pom.xml中添加如下依赖：

```
		<dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.6</version>
        </dependency>

        <dependency>
            <groupId>com.aliyun.api.gateway</groupId>
            <artifactId>sdk-core-java</artifactId>
            <version>1.1.0</version>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.52</version>
        </dependency>
```

##### 6.2.2 引入SDK的api接口调用类

1. 把sdk文件夹中所有Group的通道类`HttpApiClient_*.java`、`HttpsApiClient_*.java`文件复制到您的项目文件夹中；
2. 修正这些类文件的package；

##### 6.2.3 初始化通信通道类

要提交请求至阿里云API网关，您首选要将所有的通道类初始化。您可以参考`Demo_*.java`中的示例代码，使用对应的`ClientBuilderParams`类来初始化所有通道：

```
HttpClientBuilderParams httpParam = new HttpClientBuilderParams();
httpParam.setAppKey("");
httpParam.setAppSecret("");
HttpApiClient_chuxiang.getInstance().init(httpParam);
```

> #### 注意####

- `HttpClientBuilderParams ` 里面有很多构造参数，主要是对ApacheHttpClient开源组件的包装，具体参数含义可以自行搜索这个开源组件的参数说明（官方文档：https://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/index.html）。

##### 6.2.4 调用API接口

​	SDK是根据您在API网关自定义的参数进行生成的，每个API都被封装成了method，您可以参照Demo中的示例代码进行调用。
​	另外，SDK为您封装了单例模式的调用方法，您可以使用`HttpClient_{{group}}.getInstance()`方法来获得通道类对象。
​	每个API同时提供同步和异步的调用方法，下面是调用示例：

```
//异步调用示例
public void test06_HttpCommon() throws Exception {
	HttpClient_UnitTest.getInstance().getUser(userId , new ApiCallback() {
		@Override
		public void onFailure(ApiRequest request, Exception e) {
			e.printStackTrace();
		}

		@Override
		public void onResponse(ApiRequest request, ApiResponse response) {
			try {
				System.out.println(response.getCode());
				System.out.println(response.getMessage());
				System.out.println(response.getFirstHeaderValue("x-ca-request-id"));
			}catch (Exception ex){
				ex.printStackTrace();
			}
		}
	});
}

//同步调用示例
public void test06_HttpGetUser(int userId) throws Exception {
	ApiResponse response = HttpClient_UnitTest.getInstance().getUser_syncMode(userId);
	System.out.println(response.getCode());
	System.out.println(response.getMessage());
	System.out.println(response.getFirstHeaderValue("x-ca-request-id"));
}
```

> #### 注意####

- 您必须先`init()`初始化后，才可以调用`getInstance()`方法，否则会抛出异常。
- 建议使用异步调用，在整个等待应答期间，主线程不会被hang住。



