package za.co.mahadew.damien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by DAMIEN6 on 24/10/2016.
 */
@ComponentScan
@EnableAutoConfiguration
public class SpringExamPrepSpringBootApplicationWithWar extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringExamPrepSpringBootApplicationWithWar.class);
    }

    public static void main(String[] args) {
//        The line below is used to override the default application.properties name
        System.setProperty("spring.config.name", "myserver");
//        Starts running the main class - starts up the Dispatcher servlet
        SpringApplication.run(SpringExamPrepSpringBootApplicationWithWar.class, args);
    }

    /**
     * @Conditional Annotation
     * only create if bean exists (or does not)
     */

}
