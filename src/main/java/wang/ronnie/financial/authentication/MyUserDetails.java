package wang.ronnie.financial.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ronniewang on 17/7/19.
 */
public class MyUserDetails implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        GrantedAuthority grantedAuthority = (GrantedAuthority) () -> "admin";
        return Arrays.asList(grantedAuthority);
    }

    @Override
    public String getPassword() {

        return "1";
    }

    @Override
    public String getUsername() {

        return "1";
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {

        return true;
    }

    @Override
    public boolean isEnabled() {

        return true;
    }
}
