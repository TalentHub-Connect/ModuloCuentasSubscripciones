package com.cuentas.subscription.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cuentas.subscription.model.Subscription;
import com.cuentas.subscription.service.SubscriptionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
        return ResponseEntity.ok(subscriptionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable int id) {
        Optional<Subscription> subscription = subscriptionService.findById(id);
        return subscription.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(subscriptionService.save(subscription));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscription> updateSubscription(@PathVariable int id, @RequestBody Subscription subscription) {
        if (subscriptionService.findById(id).isPresent()) {
            subscription.setId(id);
            return ResponseEntity.ok(subscriptionService.update(subscription));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable int id) {
        if (subscriptionService.findById(id).isPresent()) {
            subscriptionService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
