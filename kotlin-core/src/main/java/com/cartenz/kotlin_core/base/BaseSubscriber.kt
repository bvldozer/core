package com.cartenz.kotlin_core.base

import rx.Subscription
import java.util.*

public class BaseSubscriber {

    companion object {
        private val subscriptions = ArrayList<Subscription>()

        fun addSubscription(subscription: Subscription) {
            subscriptions.add(subscription)
        }

        fun finishSubscriber() {
            for (sub in subscriptions) {
                sub.unsubscribe()
            }
            subscriptions.clear()
        }

        fun getSubscriptions(): List<Subscription> {
            return subscriptions
        }
    }
}