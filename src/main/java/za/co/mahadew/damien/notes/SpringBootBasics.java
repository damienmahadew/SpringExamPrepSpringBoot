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
 *   Why run a web application outside of a container
 *      -no separation of container config and app config
 *          they depend on each other anyway
 *      -apps mostly target to a specific container
 *      -easier debugging and profiling
 *      -easier hot code replacement
 *      -no special ide support
 *      -familiar model for non-java develoeprs
 *      recommended for cloud native applications
 *
 *   Packaging
 *      -Spring boot creates a single archive
 *          -jar or war
 *          - can also include the application
 *     - can be executed with java -jar yourapp.war
 *     -gradle/maven plugins available
 *
 *     add boot maven plugin to pom.xml
 *      <build>
 *          <plugins>
 *              <plugin>
 *                  <groupId>org.springframework.boot</groupId>
 *                  <artifactId>spring-boot-maven-plugin</artifactId>
 *              </plugin>
 *          </plugins>
 *      </build>
 *
 *
 *      mvn package -> procudes jar + jar.original
 *      jar.original contains only your code
 *      jar contains application server
 *
 *
 *  Spring Boot inside a servlet container
 *      -spring boot can also run in any Servlet 3.x container
 *          -e.g. Tomcat 7+, Jetty 8+
 *          -only small changes required
 *              -change artifact to type WAR
 *              -extend SpringBootServletInitializer
 *              -override configure method
 *          -still no web.xml
 *
 *  Spring boot war file
 *      -hybrid WAR file
 *      -can still be executed with embedded tomcat (java -jar app.war)
 *      -traditional WAR file is produced as well
 *          -without tomcat
 *          -just drop it in your application server web app directory
 *          - need to change the <packagin>war</packagin> in maven pom file
 *  Your Choice:
 *      There is no force to go to containerless
 *          embedded container is just one feature of spring
 *       traditional WAR also benefits a lot from Spring boot
 *          automatic spring mvc setup, including dispatcher servlet
 *          sensible defualts based on the classpath content
 *          embedded container can be used during development
 *
 *  Externalized properties
 *      file : application.properties
 *
 *      Developers commonly externalize properties to files
 *          easily consumable via spring PropertySource
 *          but developers name /locate their files in different ways
 *      Spring boot automatically looks for application.properties
 *      in the classpath root
 *
 *      e.g.
 *      database.host=localhost
 *
 *      Starter POM's declare the properties to be used
 *
 *    Options
 *      You can override the location of this file
 *          e.g. change it to myserver.properties
 *          see {@link za.co.mahadew.damien.SpringExamPrepSpringBootApplicationWithWar}
 *
 *    YAML
 *      Spring boot also supports YAML configuration
 *          more concise, indented text format (similar to JSON)
 *      By default it looks for application.yml
 *      e.g
 *          database:
 *              host: localhost
 *              user: admin
 *      ** Do not use tabs
 *
 *      see application.properties for examples
 *
 *
 *  Web Application Convenience
 *      Boot automatically configures Spring MVC Dispatcher servlet and @EnableWebMvc defaults
 *          when spring-webmvc.jar is on classpath
 *      Static resources reserved from classpath
 *          /static /public /resources or /META-INF/resources
 *      Templates served from /templates
 *          when velocity, freemarker, thymeleaf or Groovy on classpath
 *      Provides default /error mapping
 *          easily overriden
 *
 *   Summary
 *      Spring boot speeds up spring application development
 *      You always have full control and insight
 *      nothing is generated
 *      no special runtime requirements
 *      no servlet container needed
 *          ideal for micorservices
 *
 *
 *
 *
 */
