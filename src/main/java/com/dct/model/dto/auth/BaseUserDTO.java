package com.dct.model.dto.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class BaseUserDTO extends User {
    private Integer id;
    private Integer shopId;
    private String shopName;
    private String username;
    private Set<String> userAuthorities = new HashSet<>();

    public BaseUserDTO() {
        super("username", "password", List.of());
    }

    public BaseUserDTO(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static Builder userBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Integer id;
        private Integer shopId;
        private String shopName;
        private String username;
        private Set<String> userAuthorities = new HashSet<>();

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withShopId(Integer shopId) {
            this.shopId = shopId;
            return this;
        }

        public Builder withShopName(String shopName) {
            this.shopName = shopName;
            return this;
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withAuthorities(Set<String> authorities) {
            this.userAuthorities = authorities;
            return this;
        }

        public Builder withAuthorities(Collection<? extends GrantedAuthority> authorities) {
            this.userAuthorities = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
            return this;
        }

        public BaseUserDTO build() {
            Collection<GrantedAuthority> authorities = this.userAuthorities.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            BaseUserDTO userDTO = new BaseUserDTO(this.username, this.username, authorities);
            userDTO.setId(this.id);
            userDTO.setShopId(this.shopId);
            userDTO.setShopName(this.shopName);
            userDTO.setUsername(this.username);
            userDTO.setUserAuthorities(this.userAuthorities);
            return userDTO;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Set<String> getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(Set<String> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    public boolean hasAuthority(String authority) {
        return Optional.ofNullable(userAuthorities).orElseGet(HashSet::new).contains(authority);
    }

    public boolean hasAuthorities(Collection<String> authorities) {
        return Optional.ofNullable(userAuthorities).orElseGet(HashSet::new).containsAll(authorities);
    }
}
