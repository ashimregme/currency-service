package pl.assecods.plncalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PlnCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlnCalculatorApplication.class, args);
    }

}
