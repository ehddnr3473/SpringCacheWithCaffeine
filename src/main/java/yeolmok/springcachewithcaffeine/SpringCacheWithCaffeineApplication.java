package yeolmok.springcachewithcaffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCacheWithCaffeineApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheWithCaffeineApplication.class, args);
    }

}
