package com.cuentas.subscription.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cuentas.subscription.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
