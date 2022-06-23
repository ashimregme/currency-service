package pl.assecods.nlbfetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NlbFetcherApplication {
    public static void main(String[] args) {

        SpringApplication.run(NlbFetcherApplication.class, args);
    }

}
