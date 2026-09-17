package com.demo.pgi.config;

import com.stripe.StripeClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class StripeConfig {

    @Value("${stripe.api.key}")
    public String stripeApiKey;

    @Bean
    public StripeClient stripeClient() {
        log.info("Creating Stripe Client");
        return StripeClient.builder()
                .setMaxNetworkRetries(3)
                .setConnectTimeout(30 * 1000)
                .setReadTimeout(80 * 1000)
                .setApiKey(stripeApiKey)
                .build();
    }
}
