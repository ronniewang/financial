package wang.ronnie.financial;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

/**
 * Created by ronniewang on 17/7/19.
 */
@Configuration
public class JdbcConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {

        DruidDataSource dataSource = DruidDataSourceBuilder
                .create()
                .build(env, "spring.datasource.druid.");//使用自定义前缀
        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {

        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public SimpleJdbcInsert assertInsert() {

        return new SimpleJdbcInsert(dataSource()).withTableName("assert");
    }
    @Bean
    public SimpleJdbcInsert gameInsert() {

        return new SimpleJdbcInsert(dataSource()).withTableName("game");
    }
}
