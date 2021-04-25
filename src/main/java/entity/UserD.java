package entity;


import java.util.Set;

public abstract class UserD {

    public abstract String getUsername();

    public abstract boolean isAccountNonExpired();

    public abstract boolean NonLocked();

    public abstract boolean CredentialsNonExpired();

    public abstract boolean isEnabled();

    public abstract Set<Role> getAuthorities();

    public abstract String getPassword();


    public abstract void setPassword(String encode);

    public abstract void setAge(Integer age);
}
