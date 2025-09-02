package com.dct.model.dto.auth;

import java.util.HashSet;
import java.util.Set;

/**
 * User information after successful authentication, used to generate the access token
 * Used in JwtProvider (Self-Defined)
 *
 * @author thoaidc
 */
@SuppressWarnings("unused")
public class BaseTokenDTO {
    private Integer userId;
    private String username;
    private Boolean isRememberMe = false;
    private Set<String> authorities = new HashSet<>();

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final BaseTokenDTO instance = new BaseTokenDTO();

        public Builder username(String username) {
            instance.username = username;
            return this;
        }

        public Builder userId(Integer userId) {
            instance.userId = userId;
            return this;
        }

        public Builder authorities(Set<String> authorities) {
            instance.authorities = authorities;
            return this;
        }

        public Builder rememberMe(boolean rememberMe) {
            instance.isRememberMe = rememberMe;
            return this;
        }

        public BaseTokenDTO build() {
            return instance;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getRememberMe() {
        return isRememberMe;
    }

    public Boolean isRememberMe() {
        return isRememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        isRememberMe = rememberMe;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
