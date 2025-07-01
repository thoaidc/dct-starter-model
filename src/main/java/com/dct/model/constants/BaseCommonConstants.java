package com.dct.model.constants;

/**
 * Contains the common configuration constants for the project without security configurations
 * @author thoaidc
 */
public interface BaseCommonConstants {

    // The location where the resource bundle files for i18n messages are stored
    String[] DEFAULT_MESSAGE_SOURCE_BASENAME = { "classpath:i18n/messages" };
    String DEFAULT_MESSAGE_SOURCE_ENCODING = "UTF-8"; // Specifies the charset for i18n messages

    interface Images {
        String[] DEFAULT_VALID_IMAGE_FORMATS = { ".png", ".jpg", ".jpeg", ".gif", ".svg", ".webp", ".webm" };
        String[] COMPRESSIBLE_IMAGE_FORMATS = { ".png", ".jpg", ".jpeg", ".webp" };
        String DEFAULT_IMAGE_FORMAT = ".webp";
        String PNG = "png";
        String WEBP = "webp";
        String JPG = "jpg";
        String JPEG = "jpeg";
    }
}
