package org.example;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
    
    @Data
    @Accessors(chain = true)
    @Component
    @ConfigurationProperties("reproducer.props")
    static class Reproducer {
        /**
         * prop 1 is a string setting
         */
        String prop1;

        /**
         * number 2 is a number setting
         */
        int number2;

        /**
         * This setting which controls the speed of execution
         */
        Pace pace;

        enum Pace { slow, fast, turbo }
    }
}
