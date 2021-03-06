package com.example.kdh.domain;

import com.example.kdh.config.ErrorCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class EntityExtension implements ErrorCode {

    public static <T> T create(Class<T> classOfT, Object source, String... excludeFields) {
        Field[] fields = classOfT.getDeclaredFields();
        List<Field> sourceFields = Arrays.asList(source.getClass().getDeclaredFields());
        List<String> sourceFieldNames = new ArrayList<>();

        for (Field field : sourceFields) {
            field.setAccessible(true);
            sourceFieldNames.add(field.getName());
        }

        List<String> excludeFieldList = excludeFields != null ? Arrays.asList(excludeFields) : new ArrayList<>();

        T objectOfT;

        try {
            Constructor<T> constructor = classOfT.getDeclaredConstructor();
            constructor.setAccessible(true);
            objectOfT = constructor.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        for (Field field : fields) {
            field.setAccessible(true);

            if (excludeFieldList.contains(field.getName())) continue;
            if (field.getName().equals("createdDateTime")) continue;
            if (field.getName().equals("modifiedDateTime")) continue;

            int index = sourceFieldNames.indexOf(field.getName());
            if (index != -1) {
                Field sourceField = sourceFields.get(index);
                sourceField.setAccessible(true);

                try {
                    field.set(objectOfT, sourceField.get(source));
                } catch (Exception e) {
                    log.warn("Field Setter is not exist. ClassName = {}, FieldName = {}", source.getClass().toString(), sourceField.getName());
                }
            }
        }

        return objectOfT;
    }

    @CreatedDate
    private LocalDateTime createdDateTime;

    @LastModifiedDate
    private LocalDateTime modifiedDateTime;

    public <T> T toDto() {
        try {
            Class thisClassType = this.getClass();
            String dtoClassName = thisClassType.getName() + "Dto";
            Type type = Class.forName(dtoClassName);
            return new ModelMapper().map(this, type);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("???????????? ?????? ????????? ?????????.");
        }
    }

    public void update(Object source) {
        update(source, (String[]) null);
    }

    public void update(Object source, String... excludeFields) {
        Field[] fields = this.getClass().getDeclaredFields();
        Field[] sourceFields = source.getClass().getDeclaredFields();
        List<String> excludeFieldList = excludeFields != null ? Arrays.asList(excludeFields) : new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);

            if (excludeFieldList.contains(field.getName())) continue;
            if (field.getName().equals("createdDateTime")) continue;
            if (field.getName().equals("modifiedDateTime")) continue;

            fieldSetter(source, sourceFields, field);
        }
    }

    private void fieldSetter(Object source, Field[] sourceFields, Field field) {
        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);

            if (!(sourceField.getName().equals(field.getName()))) continue;

            try {
                field.set(this, sourceField.get(source));
            } catch (Exception e) {
                log.warn("Field Setter is not exist. ClassName = {}, FieldName = {}", source.getClass().toString(), sourceField.getName());
            }
            break;
        }
    }

}
