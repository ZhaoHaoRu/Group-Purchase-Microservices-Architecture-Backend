
# 微服务架构
* 启动的各个端口
  ![port](assert/port.png)
* 启动时需要将JDK换成1.8
* 启动eureka-server,访问`http://localhost:8761/`打开注册中心


## 测试接口问题
* 有的时候不行，有的时候就行了
- [x] createGroup(太慢了，911ms)
- [ ] endGroup(返回200 OK, 但是数据库没有改)
- [x] recommend