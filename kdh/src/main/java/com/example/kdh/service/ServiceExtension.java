package com.example.kdh.service;

import com.example.kdh.domain.EntityExtension;
import com.example.kdh.util.ServiceMessage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ServiceExtension {

    public <T> List<T> toDtoList(List<? extends EntityExtension> entityList) {
        if (entityList == null) return new ArrayList<>();
        List<T> dtoList = new ArrayList<>();
        for (EntityExtension anEntityList : entityList) {
            dtoList.add(anEntityList.toDto());
        }
        return dtoList;
    }

    public ServiceMessage createResultMessage() {
        return new ServiceMessage();
    }

    public ServiceMessage successResultMessage() {
        return createResultMessage().addData("result", "success");
    }

}
