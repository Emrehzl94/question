package question.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import question.service.beans.DataSource;

@Configuration
@ComponentScan(basePackages="question.service.beans")
public class ApplicationConfig {

	@Bean(name="myds")
	public DataSource getDataSource(){
		DataSource ds=new DataSource();
		ds.setUrl("localhost:1527/bank");
		ds.setUsername("admin");
		ds.setPassword("123");
		return ds;
	}
}
