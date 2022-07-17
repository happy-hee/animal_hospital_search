package com.example.kdh.util;

public class ApiResult {

    public static DataMessage ok() {
        DataMessage message = new DataMessage();
        message.addData("result", true);

        return message;
    }

    public static DataMessage create() {
        return new DataMessage();
    }

}
