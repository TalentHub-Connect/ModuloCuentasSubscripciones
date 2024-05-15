package com.cuentas.subscription.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cuentas.subscription.model.Subscription;
import com.cuentas.subscription.repository.SubscriptionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> findById(int id) {
        return subscriptionRepository.findById(id);
    }

    public Subscription save(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription update(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public void deleteById(int id) {
        subscriptionRepository.deleteById(id);
    }
}
