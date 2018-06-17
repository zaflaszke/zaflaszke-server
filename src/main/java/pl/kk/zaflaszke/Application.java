package pl.kk.zaflaszke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@PropertySource("classpath:zaflaszke.properties")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
