package com.demo.pgi.controller;

import com.stripe.StripeClient;
import com.stripe.model.Product;
import com.stripe.model.StripeCollection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/api/v1/stripe")
@RequiredArgsConstructor
public class StripeOperationsController {
    private final StripeClient stripeClient;

    @GetMapping("/products")
    public ResponseEntity<StripeCollection<Product>> listProducts() {
        try {
            log.info("Listing products");
            StripeCollection<Product> products = stripeClient.v1()
                    .products()
                    .list();
            log.info("Products list: {}", products);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception while listing products ex: {}", e.toString());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {
        try {
            log.info("Fetching product with id {}", productId);
            Product product = stripeClient.v1()
                    .products()
                    .retrieve(productId);
            log.info("Product: {}", product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception while retrieving product: {} ex: {}", productId, e.toString());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
