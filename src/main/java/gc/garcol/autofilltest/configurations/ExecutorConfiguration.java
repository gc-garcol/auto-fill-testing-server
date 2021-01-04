package gc.garcol.autofilltest.configurations;

import gc.garcol.autofilltest.core.CustomFuture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author thai-van
 **/
@Configuration
public class ExecutorConfiguration {

    @Bean
    ExecutorService initThreadPool() {
        return Executors.newFixedThreadPool(1);
    }

    @Bean
    CustomFuture initCustomFuture() {
        return new CustomFuture();
    }

}
