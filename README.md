# demo-spring-boot-starter #
一个简单的springboot starter demo

# 实现 #
1. 因为代码量很少，基本上所有的知识点都已经写在类注释里面，请自行查看。
2. 值得注意的地方是：需要在resources目录下新建一个META-INF文件夹，然后新建一个spring.factories文件
3. 项目完成后就可以使用命令：mvn install 然后将项目安装到本地仓库，其他项目使用时候，就直接通过pom引入就行了。


# 测试 #
本例的测试使用项目：demo—spring-boot-starter-test
1. 引入jar包：
```
<dependency>
    <groupId>com.zsk</groupId>
    <artifactId>demo-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```
2. application.yml配置。
```
demo:
  isOpen: true
  implType: B
  userName: zsk
  workType: java开发
```
3. 然后启动项目，就能直接调用该项目中的方法了。具体信息直接看源码吧。代码东西很少，没必要啰嗦了。
