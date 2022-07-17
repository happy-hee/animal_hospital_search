package com.example.kdh.util;


import com.example.kdh.config.ErrorCode;
import com.example.kdh.domain.user.User;

public class ServiceMessage extends DataMessage implements ErrorCode {

    public ServiceMessage setLoginMember(User user) {
        addData("loginUser", user);
        return this;
    }

    public User getLoginMember() {
        return getObject("loginUser", User.class);
    }

    @Override
    public ServiceMessage addData(String key, Object object) {
        super.addData(key, object);
        return this;
    }

    public ServiceMessage setResult(Object object) {
        put("result", object);
        return this;
    }

    public Object getResult() {
        return get("result");
    }

}
