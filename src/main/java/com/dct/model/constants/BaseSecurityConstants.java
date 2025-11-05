package com.dct.model.constants;

import org.springframework.http.HttpMethod;

@SuppressWarnings("unused")
public interface BaseSecurityConstants {
    // The encryption complexity in PasswordEncoder's algorithm (between 4 and 31)
    // Higher values mean the password is harder to attack, but too high will reduce performance
    int DEFAULT_BCRYPT_COST_FACTOR = 12;

    interface JWT {
        long DEFAULT_ACCESS_TOKEN_VALIDITY = 5 * 60 * 1000L; // 5 minutes
        long DEFAULT_REFRESH_TOKEN_VALIDITY = 3 * 60 * 60 * 1000L; // 3 hours
        long DEFAULT_REFRESH_TOKEN_VALIDITY_FOR_REMEMBER = 7 * 24 * 60 * 60 * 1000L; // 7 days
    }

    /**
     * The corresponding keys to store information in the payload of a JWT token <p>
     */
    interface TOKEN_PAYLOAD {
        String USER_ID = "userId";
        String USERNAME = "username";
        String AUTHORITIES = "authorities";
    }

    interface COOKIES {
        // The key of the cookie storing the JWT token, which is HTTP-only
        // This cookie is automatically sent with requests by browser but cannot be accessed by JavaScript
        String HTTP_ONLY_TOKEN = "dct_refresh_token";
        int COOKIE_EXPIRED = 0;
        String SECURITY_ATTRIBUTE = "SameSite";
        String SECURITY_MODE = "Strict";
    }

    interface HEADER {
        // The request header storing the JWT token, used in cases where the token is not found in the HTTP-only cookies
        String AUTHORIZATION_HEADER = "Authorization";
        String AUTHORIZATION_GATEWAY_HEADER = "Authorization-Gateway";
        String AUTHORIZATION_WEBSOCKET = "token";
        String TOKEN_TYPE = "Bearer "; // JWT token type
        String USER_ID = "X-User-ID";
        String USER_NAME = "X-User-Name";
        String USER_AUTHORITIES = "X-User-Authorities";
        String USER_AGENT = "User-Agent";
        String X_FORWARDED_FOR = "X-Forwarded-For";
        String X_REAL_IP = "X-Real-IP";
        String X_CSRF_TOKEN = "X-CSRF-Token";
        String X_REQUESTED_WITH = "X-Requested-With";
        String X_APP_VERSION = "X-App-Version";
        String X_DEVICE_ID = "X-Device-ID";
    }

    /**
     * The paths for security configuration <p>
     * Requests matching the patterns below will have their own specific security rules applied <p>
     * Requests not listed will require authentication by default
     */
    interface REQUEST_MATCHERS {
        String[] DEFAULT_PUBLIC_API_PATTERNS = {
            "/**.html",
            "/**.css",
            "/**.js",
            "/**.ico",
            "/i18n/**",
            "/api/p/**"
        };
    }

    /**
     * The configurations applied in the CORS filter
     */
    interface CORS {
        String DEFAULT_APPLY_FOR = "/**"; // CORS filter is applied to all requests
        String[] DEFAULT_ALLOWED_HEADERS = {
            "Content-Type",     // Content format
            "Authorization",    // Authentication token
            "Accept",           // Client-expected content
            "Origin",           // Origin of the request
            "X-CSRF-Token",     // Anti-CSRF token
            "X-Requested-With", // Ajax request markup
            "Access-Control-Allow-Origin", // Server response header
            "X-App-Version",    // Application version (optional)
            "X-Device-ID"       // Device ID (optional)
        };

        String[] DEFAULT_ALLOWED_REQUEST_METHODS = {
            HttpMethod.GET.name(),
            HttpMethod.PUT.name(),
            HttpMethod.POST.name(),
            HttpMethod.PATCH.name(),
            HttpMethod.DELETE.name(),
            HttpMethod.OPTIONS.name()
        };

        String[] DEFAULT_ALLOWED_ORIGIN_PATTERNS = {"*"}; // The list of domains allowed to access the resources. * means all
        boolean DEFAULT_ALLOW_CREDENTIALS = true; // Allow sending cookies or authentication information
        long DEFAULT_MAX_AGE = 3600;
    }

    String PUBLIC_REQUEST_CONFIG = "gateway_public_request_config";

    interface Role {
        String DEFAULT = "ROLE_DEFAULT";
        String SUPER_ADMIN = "ROLE_ADMIN";
    }
}
