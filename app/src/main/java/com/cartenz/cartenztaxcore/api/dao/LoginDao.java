package com.cartenz.cartenztaxcore.api.dao;

import com.cartenz.core.api.BaseApiDao;
import com.google.gson.JsonArray;


public class LoginDao extends BaseApiDao<LoginDao.DataDao> {

    public static class DataDao {
        public int systemId;
        public int userId;
        public String userName;
        public String fullName;
        public String email;
        public JsonArray roles;
        public JsonArray profiles;
        public JsonArray authorizations;
        public boolean superAdministrator;
        public boolean administrator;
        public String uuid;
        public boolean lockedOut;
        public boolean deleted;
        public boolean active;
        public String token;
    }
}
