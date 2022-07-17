package com.example.kdh.domain;

import com.example.kdh.exception.InternalServerErrorException;
import com.example.kdh.util.GsonUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Slf4j
@Getter
public abstract class DtoExtension {

    public <T> T toEntity(Class<T> destination) {
        Constructor<T> constructor;
        T instance;
        final Logger logger = LoggerFactory.getLogger(DtoExtension.class);

        try {
            constructor = destination.getDeclaredConstructor();
            instance = constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            logger.error("생성자가 존재하지 않거나 인스턴스를 생성 할 수 없습니다.", e);
            throw new InternalServerErrorException(9999, "생성자가 존재하지 않거나 인스턴스를 생성 할 수 없습니다.");
        }
        Field[] sourceFields = this.getClass().getDeclaredFields();
        Field[] newFields = destination.getDeclaredFields();
        for (Field field : sourceFields) {
            if (field.getName().toUpperCase().contains("SRL")) continue;
            else if (field.getName().toUpperCase().contains("IDX")) continue;
            field.setAccessible(true);
            for (Field sourceField : newFields) {
                sourceField.setAccessible(true);
                if (!(sourceField.getName().equals(field.getName()))) continue;
                try {
                    field.set(instance, sourceField.get(this));
                } catch (Exception e) {
                    logger.warn("Field Setter is not exist. ClassName = {}, FieldName = {}", this.getClass().toString(), sourceField.getName());
                }
                break;
            }
        }
        return instance;
    }

    @Override
    public String toString() {
        return GsonUtils.toString(this);
    }

}