package com.example.kdh.controller;

import com.example.kdh.domain.user.User;
import com.example.kdh.util.ServiceMessage;
import com.example.kdh.util.TextUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class ControllerExtension {

    public ControllerExtension() {
    }

    public ServiceMessage createServiceMessage(HttpServletRequest request) {
        ServiceMessage serviceMessage = new ServiceMessage();
        serviceMessage.setLoginMember(getLoginUser(request));

        String realIp = request.getHeader("X-Real-IP");
        if (TextUtils.isEmpty(realIp))
            realIp = request.getRemoteAddr();

        serviceMessage
                .addData("ipAddress", realIp)
                .addData("userAgent", request.getHeader("user-agent"));

        return serviceMessage;
    }

    public User getLoginUser(HttpServletRequest request) {
        Object memberObject = request.getSession().getAttribute("LOGIN_SESSION");
        if (memberObject instanceof User) return (User) memberObject;
        else return null;
    }

    String getRequestParam(HttpServletRequest request, String key) {
        return TextUtils.clear(request.getParameter(key));
    }


}
