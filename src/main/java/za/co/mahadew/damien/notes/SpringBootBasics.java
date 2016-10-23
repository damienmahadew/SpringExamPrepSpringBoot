/**
 * Created by DAMIEN6 on 23/10/2016.
 */
package za.co.mahadew.damien.notes;
/**
 * Spring Boot
 *
 * What is Spring Boot?
 *      Spring apps typically require a lot of setup
 *          -consider working with JPA, you need:
 *              -datasource, transaction manager, entityManagerFactory
 *          -consider a web mvc, you need
 *              -WebapplicationInitializer/web.xml, contextloaderListener, Dispatcher servlet
 *          -an Mvc app using JPA would need all of this
 *      BUT, much of this is predictable,
 *          -spring boot can do most of this setup for you
 *
 *   Spring boot is:
 *      An opinionated runtime for spring projects
 *      supports different project types, like web and batch
 *      handles most low level predictable setup for you
 *   Spring boot is not:
 *      a code generator
 *      an IDE plugin
 *
 *   Opinionated runtime?
 *      Spring boot uses sensible defaults, "opinions", mostly based on the classpath contents
 *      E.g.
 *          -Sets JPA Entity Factory if JPA implementation is on the classpath
 *          -creates default spring MVC setup if Spring MVC is on classpath
 *      Everything can be overridden easily
 *
 *   Hello World Example
 *      -3 files needed
 *          1. pom.xml
 *          2. HelloController
 *          3. Application Class
 *
 *   The maven dependency spring-boot-starter-web has an embedded tomcat
 *
 *   All you need to do is run the jar file - java -jar App.jar
 *   This will start up your tomcat embedded server with your application deployed
 *
 *   Spring Boot apps can also be deployed into an existing app server
 *      -as a familiar WAR file
 *      -pros and cons
 *          -
 *
 *   How to use spring boot?
 *      Add the appropriate spring boot dependencies
 *      easiest is to use a dependency management tool
 *
 *   Spring Boot Parent POM
 *      Parent pom defines key versions of dependencies and maven plugins
 *      	<parent>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-parent</artifactId>
             <version>1.4.1.RELEASE</version>
             <relativePath/>
             </parent>
        -> defines properties for dependencies, e.g. Spring.version = 4.2

 *   COre Spring "Starter" dependencies
 *      Allow an easy way to bring in multiple coordinated dependencies
 *       - including "transitive" dependencies
 *       		<dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-web</artifactId>
                 </dependency>
 *          Since this is a web project - we have "-web" at the end
 *          This dependency resolves all necessary dependencies e.g.
 *              Spring-core
 *              spring-context
 *              spring-beans
 *              spring-web
 *              spring-webmvc
 *              spring-aop
 *              tomcat
 *
 *   Test Dependencies
 *      		<dependency>
                 <groupId>org.springframework.boot</groupId>
                 <artifactId>spring-boot-starter-test</artifactId>
                 <scope>test</scope>
                 </dependency>
 *          Commmon test libraries
 *          e.g. spring-test
 *          junit
 *          mockito
 *
 *  Available starter poms
 *      Coordinated dependencies for common java enterprise frameworks
 *          pick the starters you need in your project
 *      E.g.
 *          spring-boot-starter-jdbc
 *          spring-boot-starter-jpa
 *          spring-boot-starter-batch
 *
 *   @EnableAutoConfiguration
 *      -causes spring boot to automatically create beans it thinks you need
 *      -usually based on classpath contents, can easily override
 *      How it works?
 *          Starter web -> Spring MVC dependency included -> dispatcher servlet registerd
 *          HSQLDB -> HSQLDB dep included -> Embdedded datasource registered
 *          Starter JDBC -> If datasource registered -> JDBC template registered
 *
 *   @SpringBootApplication
 *      The same as
 *          @Configuration
 *          @ComponentScan -- no values passed so it scans the current package
 *          @EnableAutoConfiguration
 *
 *    See {@link za.co.mahadew.damien.SpringExamPrepSpringBootApplication}
 *    for @SpringBootApplication
 *
 *  Spring Boot at Runtime
 *      Spring boot can startup an embedded web server
 *          -you can run a web application from a JAR
 *          -tomcat included in web starter
 *              may exclude tomcat and use jetty
 *              The following must be added to spring-boot-starter-web
 *              <exclusions>
 *                  <exclusion>
 *                      //Tomcat dependency
 *                  </exclusion>
 *              </exclusions>
 *              And add dependency for jetty
 *
 */
