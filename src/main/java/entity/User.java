package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "t_user")

public class User extends UserD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    @Size(min=2, message = "not less than 2")
    private Long id;
    @Size(min=2, message = "not less than 2")
    private String password;
    @Transient
    private String passwordCon;
    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean NonLocked() {
        return true;
    }

    @Override
    public boolean CredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Set<Role> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String encode) {

    }


    public String getPasswordCon() {
        return passwordCon;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
