package pl.assecods.nbpfetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NBPFetcherApplication {
    public static void main(String[] args) {

        SpringApplication.run(NBPFetcherApplication.class, args);
    }

}
