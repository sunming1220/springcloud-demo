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
