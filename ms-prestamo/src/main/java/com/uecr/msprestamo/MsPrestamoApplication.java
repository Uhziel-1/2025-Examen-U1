package com.uecr.msprestamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsPrestamoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPrestamoApplication.class, args);
    }

}
