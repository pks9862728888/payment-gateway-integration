package com.demo.pgi;

import com.demo.pgi.controller.StripeOperationsController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class PaymentGatewayIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentGatewayIntegrationApplication.class, args);
    }

    @Autowired
    private StripeOperationsController stripeOperationsController;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady(ApplicationReadyEvent event) {
//        stripeOperationsController.listProducts();
//        stripeOperationsController.getProduct("prod_VGfOtu0vuX7Tme");
    }

}
