package be.totaboda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"be.totaboda"})
public class Digibooky {
    public static void main(String[] args) {
        SpringApplication.run(Digibooky.class, args);
    }
}
