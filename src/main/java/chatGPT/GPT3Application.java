package chatGPT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class GPT3Application {

    public static void main(String[] args) {
        SpringApplication.run(GPT3Application.class, args);
    }
}
