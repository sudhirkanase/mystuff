The Spring Framework is a comprehensive, open-source Java platform that provides infrastructural support for building enterprise-level applications. 
It focuses on simplifying the development of Java applications by handling low-level details like dependency injection, 
aspect-oriented programming, and more. 
This allows developers to focus on application-level business logic without getting bogged down in infrastructure concerns.

Benefits of using Spring:
Simplified Development: Spring handles infrastructure, reducing the amount of boilerplate code needed. 
Testability: DI and other features make testing applications easier. 
Flexibility and Maintainability: Spring's design allows for easy configuration and adaptation to different needs. 
Scalability: Spring's features support the development of scalable applications 



Spring boot is module of spring. its build on top of spring

Spring boot required java 8 + version


SpringBoot Starter parent :- for boot dependency management.. it loads the transitively all required dependencies. 
its parent of all spring applications

Spring boot starter web
@SpringBootApplication
AutoConfiguration



@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
}

Dependency Managements

Parent artifact of the all sring boot project
spring-boot-starter-parent
  --> It has all plugin management stuff maven compiler maven surefire plugins maven jar or plugins
 
 parent of starter parent is spring-boot-dependencies
 --> All dependencies and boot versions and dependencies are defined here
 
 
 Same way for 
 spring-boot-starter-web (all web required dependencies are defined here like tomcat, hibernate validator, jackson bind, validator api etc)
   --> spring-boot-starter-parent
    	-->spring-boot-dependencies

    	
What is auto configuration?

Lets say we are developing a spring web application.
	Earlier before boot we need to configure DispatcherServlet in web.xml manually
	whereas in boot application we don't need as its automatically configuared (Auto Configuarion) for us through spring boot start web dependent jars

Spring boot autoconfigure.jar looks for the framework what you have class path and accordingly auto configuration stuff for us

Spring boot starters ensures version of frameworks or dependencies are compatible with each others

Spring VS Spring boot
Spring
Spring is just DI framework and reduce plumbing code but developing spring based application required lot of configuration
Spring helps us write testable but with lots of configuration (XML and java)
Integration with other frameworks also needs a configuration (For eg hibernate we need to configure Session Factory and hbm etc files 
or need to configure dispatcher servlet and view resolver for web mvc application)

In last few days focus is moved from monolithic to microservices. microservices are very small application
 and application can involved with multiple small microservices so 
 we need to start project quickly with zero or minimal set up time
 1) Framework setup
 2) Deployment - configuration
 3) Logging , transaction management
 4) Monitoring 
 5) Web server configuration

To overcome above we have new framework Spring boot
Spring boot
1) Spring boot makes easy to create standalone, deployable and production ready application very quickly..
2) We can take opiniated view of spring platform and third party libray and we can start quickly with minimum configuaration
3) For eg if want to add hibernate to your application. you dont have worry about configuration sessionfactory and datasoruce
Spring boot will do for you

Goals of Spring boot
1) Provide quick start and project with spring
2) Be opiniated but provide options
3) Provide a wide range non functional features like embedded servers, monitoring, swagger, security, health check, actuator
4) Spring boot with spring cloud library ease microservices development

Spring boot is not
1) app server or web server
2) code generation framework
3) doesnot implement any framework like JMS or hibernate


Creating Custome  starter or auto configuration
