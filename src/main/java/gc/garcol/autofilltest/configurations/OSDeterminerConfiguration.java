package gc.garcol.autofilltest.configurations;

import gc.garcol.autofilltest.utils.NightWatchUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author thai-van
 **/
@Configuration
public class OSDeterminerConfiguration {

    @Value("${gc.garcol.OSName}")
    private String OSName;

    @Bean
    NightWatchUtil initNightWatchUtil() {
        return NightWatchUtil.valueOf(OSName);
    }

}
