package be.iccbxl.pid.reservationsspringboot.config;


import be.iccbxl.pid.reservationsspringboot.model.Role;
import be.iccbxl.pid.reservationsspringboot.model.User;
import be.iccbxl.pid.reservationsspringboot.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(),
                getGrantedAuthorities(user.getRoles()));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole()));
        }

        return authorities;
    }

}