package cams.tv.tvmanagement.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.DialectResolver;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.data.convert.ReadingConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;
import static io.r2dbc.spi.ConnectionFactoryOptions.*;
import static io.r2dbc.spi.ConnectionFactoryOptions.DATABASE;

@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {

//    final private R2dbcDialect dialect;

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(DRIVER, "mysql")
                        .option(HOST, "localhost")
                        .option(PORT, 3306)
                        .option(USER, "root")
                        .option(PASSWORD, "Tweety@305")
                        .option(DATABASE, "cams_tv")
                        .option(MAX_SIZE, 40)
                        .build());
    }



//    @Bean
//    @ConditionalOnMissingBean
//    public R2dbcCustomConversions r2dbcCustomConversions() {
//        List<Object> converters = new ArrayList<>(this.dialect.getConverters());
//        converters.addAll(R2dbcCustomConversions.STORE_CONVERTERS);
//        return new R2dbcCustomConversions(
//                CustomConversions.StoreConversions.of(this.dialect.getSimpleTypeHolder(), converters),
//                Collections.emptyList());
//    }

}
