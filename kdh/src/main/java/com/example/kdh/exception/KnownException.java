package com.example.kdh.exception;

import com.example.kdh.util.GsonUtils;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;

@Getter
@ToString
public class KnownException extends RuntimeException {

    protected int httpStatusCode;
    protected int errorCode;
    protected String errorMessage;

    public KnownException(Throwable t) {
        super(t);
    }

    public KnownException(int httpStatusCode, int errorCode, String errorMessage) {
        this.httpStatusCode = httpStatusCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String toGsonString() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("httpStatusCode", httpStatusCode);
        data.put("errorCode", errorCode);
        data.put("errorMessage", errorMessage);
        data.put("errorTime", new Date());

        return GsonUtils.toString(data);
    }

}
