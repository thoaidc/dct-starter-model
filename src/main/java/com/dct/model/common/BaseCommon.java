package com.dct.model.common;

import com.dct.model.constants.BaseDatetimeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("unused")
public class BaseCommon {
    private static final Logger log = LoggerFactory.getLogger(BaseCommon.class);

    public static String convertDateTimeSearch(String datetime) {
        if (!StringUtils.hasText(datetime)) {
            return null;
        }

        ZoneId zoneId = ZoneId.of(BaseDatetimeConstants.ZoneID.ASIA_HO_CHI_MINH);
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy[-/MM]-dd")
                .optionalStart()
                .appendLiteral(' ')
                .appendPattern("HH:mm")
                .optionalStart()
                .appendPattern(":ss")
                .optionalEnd()
                .optionalEnd()
                .toFormatter()
                .withZone(zoneId);

        try {
            DateTimeFormatter formatterTarget = DateTimeFormatter.ofPattern(BaseDatetimeConstants.Formatter.DEFAULT);
            LocalDateTime localDateTime = LocalDateTime.parse(datetime, formatter).atZone(zoneId).toLocalDateTime();
            return formatterTarget.withZone(zoneId).format(localDateTime);
        } catch (DateTimeParseException e) {
            log.error("[ERROR_CONVERT_FROM_DATE_REQUEST] - datetime = {} from request: {}", datetime, e.getMessage());
            return null;
        }
    }

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
