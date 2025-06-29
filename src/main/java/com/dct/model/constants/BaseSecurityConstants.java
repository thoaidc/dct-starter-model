package com.dct.model.constants;

@SuppressWarnings("unused")
public interface BaseSecurityConstants {

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
        String HTTP_ONLY_COOKIE_ACCESS_TOKEN = "dct_access_token";
    }

    interface HEADER {
        // The request header storing the JWT token, used in cases where the token is not found in the HTTP-only cookies
        String AUTHORIZATION_HEADER = "Authorization";
        String AUTHORIZATION_GATEWAY_HEADER = "Authorization-Gateway";
        String TOKEN_TYPE = "Bearer "; // JWT token type
    }
}
