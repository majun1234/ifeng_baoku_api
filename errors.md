# 错误问题

## 如何获取错误信息

所有的 API 请求只要到达了网关，网关就会返回请求结果信息。

用户需要查看返回结果的头部，即 Header 部分。其中 X-Ca开头的均为网关返回。

在 Header 中获得 X-Ca-Error-Message 可以基本明确报错原因，而 X-Ca-Request-Id 可以用于提供给这边的支持人员，供支持人员搜索日志。

## 客户端错误

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

## 服务器端错误（调用 API）

以下为API服务端错误，如果频繁错误，可联系服务商。

| 错误代码                         | Http状态码 | 语义         | 解决方案                                                     |
| -------------------------------- | ---------- | ------------ | ------------------------------------------------------------ |
| Internal Error                   | 500        | 内部错误     | 建议重试,或者联系服务商                                      |
| Failed To Invoke Backend Service | 500        | 底层服务错误 | API 提供者底层服务错误，建议重试，如果重试多次仍然不可用，可联系 API 服务商解决 |
| Service Unavailable              | 503        | 服务不可用   | 建议重试,或者联系服务商                                      |
| Async Service                    | 504        | 后端服务超时 | 建议重试,或者联系服务商                                      |

## 其他

其他错误参考阿里官网文档：错误代码表

https://help.aliyun.com/document_detail/43906.html?spm=a2c4g.11186623.6.778.87b92d23hm7No8