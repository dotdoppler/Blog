# Blog  

## 简介
Blog 是一款使用java开发的，十分简洁的博客系统,目前正在我的[个人网站](http://lyingonthemoon.cc/)上运行。

这个项目是为了学习Spring框架和MongoDB应运而生的，欢迎大家提交 Pull request 和 Issue。
这个项目参考学习了[SpringBlog](https://github.com/Raysmond/SpringBlog)。

Blog 使用了下列的框架和开源项目

- [Spring Framework](https://spring.io/)
- [Spring Boot](http://projects.spring.io/spring-boot/) 
- [Spring Data](http://projects.spring.io/spring-data/)  持久层框架
- [Spring Security](http://projects.spring.io/spring-security/)  用户认证授权
- [Pure](http://purecss.io/)  A set of small, responsive CSS modules that you can use in every web project.
- [Bootstrap](https://getbootstrap.com) 
- [Pegdown](https://github.com/sirthias/pegdown)  Markdown 文本处理
- [ACE Editor](http://ace.c9.io/)
- [Jade](http://jade-lang.com/)-[Jade4j](https://github.com/neuland/jade4j)  HTML 模板引擎
- [Webjars](http://www.webjars.org/) 
- [MongoDB](http://www.mongodb.org/)

目前完成了基本的功能，如文章,标签的发布、展示、管理等。未来会增加文章评论、留言等功能，考虑使用Redis作为web缓存。

## 部署使用

使用前请先安装[MongoDB](http://www.mongodb.org/),http端口为8080,MongoDB端口为27017。

#### 使用Maven
    
将项目clone至本地,在项目路径下，执行 

    mvn package
运行（java 8） 

    java -jar Blog-1.0-SNAPSHOT.jar
   

-----
             
Blog is a very simple blog system that developed by java ,I have put it on my [website](http://lyingonthemoon.cc/).

Blog is powered by following frameworks:

- [Spring Framework](https://spring.io/)
- [Spring Boot](http://projects.spring.io/spring-boot/) 
- [Spring Data](http://projects.spring.io/spring-data/)  Persistence framework
- [Spring Security](http://projects.spring.io/spring-security/)  Authentication and authorization
- [Pure](http://purecss.io/)  A set of small, responsive CSS modules that you can use in every web project.
- [Bootstrap](https://getbootstrap.com) 
- [Pegdown](https://github.com/sirthias/pegdown)  Markdown processor
- [ACE Editor](http://ace.c9.io/) 
- [Jade](http://jade-lang.com/)-[Jade4j](https://github.com/neuland/jade4j)
- [Webjars](http://www.webjars.org/) 
- [MongoDB](http://www.mongodb.org/)


## Deployment

please install [MongoDB](http://www.mongodb.org/) first,http port 8080,MongoDB port 27017.

#### Maven
maven package
    
    mvn package
run it（java 8） 

    java -jar Blog-1.0-SNAPSHOT.jar
         
        




