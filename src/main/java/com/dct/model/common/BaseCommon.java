package com.dct.model.common;

import com.dct.model.constants.BaseCommonConstants;
import com.dct.model.constants.BaseDatetimeConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Field;
import java.text.Normalizer;
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

    public static String normalizeName(String input) {
        String result = Objects.nonNull(input) ? input.trim().toLowerCase() : "";

        // Replace special characters
        for (Map.Entry<String, String> entry : BaseCommonConstants.EXTRA_CHAR_MAP.entrySet()) {
            result = result.replace(entry.getKey(), entry.getValue());
        }

        // Unicode standardization -> remove accents
        result = Normalizer.normalize(result, Normalizer.Form.NFD);
        result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        // Keep only a-z0-9 characters
        return result.replaceAll("[^a-z0-9]", "");
    }

    public static String convertDateTimeSearch(String datetime) {
        if (!StringUtils.hasText(datetime)) {
            return null;
        }

        ZoneId zoneId = ZoneId.of(BaseDatetimeConstants.ZoneID.ASIA_HO_CHI_MINH);
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy")
                .optionalStart().appendPattern("-MM").optionalEnd()
                .optionalStart().appendPattern("/MM").optionalEnd()
                .optionalStart().appendPattern("-dd").optionalEnd()
                .optionalStart().appendPattern("/dd").optionalEnd()
                .optionalStart().appendLiteral(' ').appendPattern("HH:mm").optionalEnd()
                .optionalStart().appendPattern(":ss").optionalEnd()
                .toFormatter();
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
