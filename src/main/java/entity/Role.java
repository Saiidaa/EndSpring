package entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "t_role")
public enum  Role implements GrantedAuthoritiesContainer {

    @Id
    Long;
    private java.lang.Long id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    Role() {

    }

    Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    private String getName() {

    }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
        return null;
    }
}
