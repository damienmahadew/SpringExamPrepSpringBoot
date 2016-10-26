package za.co.mahadew.damien.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by DAMIEN6 on 26/10/2016.
 */
@Configuration
public class ApplicationConfig {

//    @Bean
//    @ConditionalOnBean(name = {"datasource"})  //match on bean name
//    @ConditionalOnBean(type = {DataSource.class}) //or match on bean type
//    Many others -- @ConditionalOnClass, @ConditionalOnProperty, @ConditionalOnMissingBean, @ConditionalOnMissingProperty
//    @Profile is a special case of @Conditional

//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }


}
