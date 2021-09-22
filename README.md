# cloud-et

参考网上教程做的Spring Cloud微服务例子。

## 组件
* `cloud-et-bean` 公用Bean
* `cloud-et-common` 公用工具
* `cloud-et-eureka` Eureka注册中心（弃用，改成用Consul）
* `cloud-et-gateway` Spring Gateway网关
* `cloud-et-services` 所有业务的微服务
  * `cloud-et-feign-client` 基于OpenFeign的Customer
  * `cloud-et-resttemplate` 使用RESTful的方式调用服务
  * `cloud-et-user-service` 真正提供服务的Provider
* `cloud-et-zuul` Zuul服务网关（弃用，改成用Gateway）

## 配置
| 组件名 | 微服务名称 | 监听端口 |
| --- | --- | --- |
| cloud-et-eureka | eureka-server | 7001 |
| cloud-et-gateway | gateway | 8900 |
| cloud-et-feign-client | order-service | 8081 |
| cloud-et-resttemplate-client | goods-service | 8083 | 
| cloud-et-user-service | user-service | 8080 |
| cloud-et-zuul | zuul | 9002 |
| 外置应用 | consul | 7500 |


