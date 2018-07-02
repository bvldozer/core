package com.cartenz.core;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

public abstract class BaseSubscriber {

    private List<Subscription> subscriptions = new ArrayList<>();

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void finishSubscriber() {
        for (Subscription sub : subscriptions) {
            sub.unsubscribe();
        }
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
}
