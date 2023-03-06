package cams.tv.tvmanagement;


import cams.tv.tvmanagement.config.MySqlConfiguration;
import net.lecousin.reactive.data.relational.LcReactiveDataRelationalInitializer;
import net.lecousin.reactive.data.relational.repository.LcR2dbcRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(repositoryFactoryBeanClass = LcR2dbcRepositoryFactoryBean.class)
@Import(MySqlConfiguration.class) // here you can change depending on the database you are using
public class TvManagementApplication {

	public static void main(String[] args) {

		LcReactiveDataRelationalInitializer.init();
		SpringApplication.run(TvManagementApplication.class, args);
	}


}
