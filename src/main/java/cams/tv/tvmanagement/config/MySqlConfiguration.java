package cams.tv.tvmanagement.config;

import net.lecousin.reactive.data.relational.configuration.LcReactiveDataRelationalConfiguration;
import net.lecousin.reactive.data.relational.mysql.MySqlSchemaDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySqlConfiguration extends LcReactiveDataRelationalConfiguration {

    @Bean
    @Override
    public MySqlSchemaDialect schemaDialect() {
        return new MySqlSchemaDialect();
    }
}
