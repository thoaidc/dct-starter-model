package com.dct.model.dto.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@SuppressWarnings("unused")
public class UserDTO extends User {

    private final Integer id;

    public UserDTO(Integer id,
                   String username,
                   String password,
                   boolean enabled,
                   boolean accountNonExpired,
                   boolean credentialsNonExpired,
                   boolean accountNonLocked,
                   Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static Builder userBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final UserBuilder userBuilder = User.builder();
        private Integer id;

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withUsername(String username) {
            userBuilder.username(username);
            return this;
        }

        public Builder withPassword(String password) {
            userBuilder.password(password);
            return this;
        }

        public Builder withEnabled(boolean enabled) {
            userBuilder.disabled(!enabled);
            return this;
        }

        public Builder withAccountNonExpired(boolean accountNonExpired) {
            userBuilder.accountExpired(!accountNonExpired);
            return this;
        }

        public Builder withCredentialsNonExpired(boolean credentialsNonExpired) {
            userBuilder.credentialsExpired(!credentialsNonExpired);
            return this;
        }

        public Builder withAccountNonLocked(boolean accountNonLocked) {
            userBuilder.accountLocked(!accountNonLocked);
            return this;
        }

        public Builder withAuthorities(Collection<? extends GrantedAuthority> authorities) {
            userBuilder.authorities(authorities);
            return this;
        }

        public UserDTO build() {
            User user = (User) userBuilder.build();

            return new UserDTO(
                this.id,
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired(),
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                user.getAuthorities()
            );
        }
    }
}
