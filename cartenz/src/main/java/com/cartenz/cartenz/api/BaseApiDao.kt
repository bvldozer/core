package com.cartenz.kotlin_core.api

open class BaseApiDao<T> {
    var data: T? = null
    var code: Int = 0
    var message: String? = null
    var errors: List<Errors>? = null

    class Errors {
        var code: Int = 0
        var itemCode: Int = 0
    }
}