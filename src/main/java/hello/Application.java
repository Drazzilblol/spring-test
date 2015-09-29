package hello;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import dao.PostDao;
import dao.impl.PostDAOImpl;
import model.Post;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import service.PostService;
import service.impl.PostServiceImpl;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"dao", "service", "controllers"})
public class Application extends WebMvcConfigurerAdapter {


  public static void main(String[] args) {


    ApplicationContext ctx = new SpringApplication(Application.class).run(args);

    System.out.println("Spring boot run!");


  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
  }

  @Bean
  public DataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/test_database");
    dataSource.setUsername("test_user");
    dataSource.setPassword("qwerty");
    return dataSource;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dsItems) {
    return new JdbcTemplate(dsItems);
  }

}
