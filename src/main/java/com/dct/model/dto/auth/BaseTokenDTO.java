package com.dct.model.dto.auth;

import com.dct.model.annotation.JwtIgnore;

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
    @JwtIgnore
    private Integer userId;
    @JwtIgnore
    private String username;
    @JwtIgnore
    private Boolean isRememberMe;
    @JwtIgnore
    private Set<String> authorities;

    public BaseTokenDTO(Integer userId, String username, Boolean isRememberMe, Set<String> authorities) {
        this.userId = userId;
        this.username = username;
        this.isRememberMe = isRememberMe;
        this.authorities = authorities;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Integer userId;
        private String username;
        private Boolean isRememberMe = false;
        private Set<String> authorities = new HashSet<>();

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder authorities(Set<String> authorities) {
            this.authorities = authorities;
            return this;
        }

        public Builder rememberMe(boolean rememberMe) {
            this.isRememberMe = rememberMe;
            return this;
        }

        public BaseTokenDTO build() {
            return new BaseTokenDTO(userId, username, isRememberMe, authorities);
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
