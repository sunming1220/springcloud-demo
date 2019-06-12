# springcloud-demo
## Eureka
基于Eureka实现服务的提供与调用

本案例涉及到三个角色：

服务注册中心-----eureka

服务提供者------producer

服务消费者------consumer

## 测试
### 简单调用
依次启动eureka、producer、consumer三个项目

先输入：http://localhost:9000/hello?name=sunming 检查spring-cloud-producer服务是否正常

返回：hello sunming ，this is first messge

说明spring-cloud-producer正常启动，提供的服务也正常。

浏览器中输入：http://localhost:9001/hello/sunming 

返回：hello sunming ，this is first messge

说明客户端已经成功的通过feign调用了远程服务hello，并且将结果返回到了浏览器。

### 注意：
在搭建过程中注意springboot与springcloud版本对应

## 熔断器
## 测试
   依次启动eureka、producer、consumer三个项目。
   
   浏览器中输入：http://localhost:9001/hello/sunming
   
   返回：hello sunming，this is first messge
   
   说明加入熔断相关信息后，不影响正常的访问。接下来我们手动停止spring-cloud-producer项目再次测试：
   
   浏览器中输入：http://localhost:9001/hello/sunming
   
   返回：hello sunming, this messge send failed
   
   根据返回结果说明熔断成功。

## 配置中心
### 测试

config-server:服务端
config-client:客户端
启动服务端后访问
http://localhost:8001/config/dev

http://localhost:8001/config-dev.properties

启动客户端后访问
http://localhost:8002/hello

### 配置中心服务化和高可用
客户端都是直接调用配置中心的server端来获取配置文件信息。
这样就存在了一个问题，客户端和服务端的耦合性太高，如果server端要做集群，客户端只能通过原始的方式来路由，server端改变IP地址的时候，客户端也需要修改配置，不符合springcloud服务治理的理念。springcloud提供了这样的解决方案，我们只需要将server端当做一个服务注册到eureka中，
client端去eureka中去获取配置中心server端的服务既可。

在producer和consumer中加入了配置中心