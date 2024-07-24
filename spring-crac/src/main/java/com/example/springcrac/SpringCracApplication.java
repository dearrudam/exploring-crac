package com.example.springcrac;

import org.crac.Context;
import org.crac.Core;
import org.crac.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;

@SpringBootApplication
public class SpringCracApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCracApplication.class, args);

        var resource = new Resource() {

            @Override
            public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
                System.out.println("CRAC - beforeCheckpoint");
            }

            @Override
            public void afterRestore(Context<? extends Resource> context) throws Exception {
                System.out.println("CRAC - afterRestore");
            }
        };

        Core.getGlobalContext().register(resource);

    }

}
