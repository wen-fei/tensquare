## 十次方
微服务练手项目，一个程序员专属社交平台，包括头条、问答、活动、吐槽、招聘六大频道。
![front](https://github.com/wen-fei/tensquare/blob/master/sources/images/front.jpg)
### 技术路线
前后端分离
- 前端：常见前端库 + 模板引擎 + node.js
- 后端：
    - Spring全家桶：SpringBoot、SpringCloud、SpringMVC、SpringData
    - 数据存储：MySQL、MongoDB、ElasticSearch(Head、ik)
    - 中间件：RabbitMQ、Redis
    - 安全：JWT
    - 微服务相关：
        - 服务发现[Eureka](https://github.com/Netflix/eureka)
        - 服务调用[Feign](https://github.com/OpenFeign/feign)
        - 熔断器[Hystrix](https://github.com/Netflix/Hystrix)
        - 服务网关[Zuul](https://github.com/Netflix/zuul)
        - 集中配置[SpringCloudConfig](https://springcloud.cc/spring-cloud-config.html)
        - 消息总线[SpringCloudBus](https://spring.io/projects/spring-cloud-bus)
    - 部署：
        - Docker化：Dockerfile([如何编写Dockerfile](https://juejin.im/post/5a1bd8a36fb9a0450f21a966))、[Docker私有仓库](https://yeasy.gitbooks.io/docker_practice/repository/registry.html)、DockerMaven
        - 持续集成(CI)，自主Git服务[Gogs](https://gitee.com/Unknown/gogs)搭建 + [Jenkins](http://jenkins-ci.org/)搭建
    - 容器监控与可视化：
        - [Rancher](https://www.cnrancher.com/)
        - [influxDB](https://github.com/influxdata/influxdb)
        - [cAdvisor](https://github.com/google/cadvisor)
        - [Grafana](https://github.com/grafana/grafana)
        
所有版本参考具体代码pom文件。
    
### API
![API](https://github.com/wen-fei/tensquare/blob/master/sources/images/API.png)
参考sources/文档

### 数据库设计

参考sources/数据库

### 前端原型

参考sources/前端

### 免责声明

此项目参考[itcast](http://www.itheima.com/)，仅供学习参考，不做商业利益。

