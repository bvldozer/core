package com.cartenz.kotlinapp.api.dao

import com.cartenz.kotlin_core.api.BaseApiDao
import com.google.gson.JsonArray

class LoginDao : BaseApiDao<LoginDao.DataDao>() {

    class DataDao {
        var systemId: Int = 0
        var userId: Int = 0
        var userName: String? = null
        var fullName: String? = null
        var email: String? = null
        var roles: JsonArray? = null
        var profiles: JsonArray? = null
        var authorizations: JsonArray? = null
        var superAdministrator: Boolean = false
        var administrator: Boolean = false
        var uuid: String? = null
        var lockedOut: Boolean = false
        var deleted: Boolean = false
        var active: Boolean = false
        var token: String? = null
    }
}
