# springcloud-demo
基于Eureka实现服务的提供与调用

本案例涉及到三个角色：

服务注册中心-----eureka

服务提供者------producer

服务消费者------consumer

## 测试
### 简单调用
依次启动spring-cloud-eureka、spring-cloud-producer、spring-cloud-consumer三个项目

先输入：http://localhost:9000/hello?name=neo 检查spring-cloud-producer服务是否正常

返回：hello neo，this is first messge

说明spring-cloud-producer正常启动，提供的服务也正常。

浏览器中输入：http://localhost:9001/hello/neo

返回：hello neo，this is first messge

说明客户端已经成功的通过feign调用了远程服务hello，并且将结果返回到了浏览器。
