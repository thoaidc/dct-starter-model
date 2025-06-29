package com.dct.model.common;

import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("unused")
public class BaseCommon {

    public static <T> Map<String, Class<?>> getObjectFields(Class<T> mappingClass) {
        Map<String, Class<?>> fieldMap = new HashMap<>();

        for (Field field : mappingClass.getDeclaredFields()) {
            fieldMap.put(field.getName(), field.getType());
        }

        return fieldMap;
    }

    public static boolean invalidUploadFile(MultipartFile file) {
        return file == null || file.isEmpty() || !Objects.nonNull(file.getOriginalFilename());
    }

    public static boolean invalidUploadFiles(MultipartFile[] files) {
        if (files == null || files.length == 0)
            return true;

        for (MultipartFile file : files) {
            if (invalidUploadFile(file))
                return true;
        }

        return false;
    }
}
