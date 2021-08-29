package be.icc.pid.reservationsSpringBoot.model;



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String login;
    private boolean enabled;
    private String password;
    private User user;
    private List<GrantedAuthority> authorities;


    public MyUserDetails() {

    }

    public MyUserDetails(String login) {
        this.login = login;
    }

    public MyUserDetails(User user) {

        this.login = user.getLogin();
        this.enabled = user.getEnabled();
        this.password = user.getPassword();
        this.user = user;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<>();
        this.user.getRole().forEach(role -> {
            GrantedAuthority auhority = new
                    SimpleGrantedAuthority("ROLE_" + role.getRole());
            auths.add(auhority);
        });
        return auths;
    }



    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
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
        return this.enabled;
    }
}


