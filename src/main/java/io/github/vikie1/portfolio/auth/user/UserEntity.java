package io.github.vikie1.portfolio.auth.user;

import io.github.vikie1.portfolio.auth.role.RoleEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(nullable = false)
    private String username;
    private String password;
    private boolean enabled;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name= "users_roles",
            joinColumns={@JoinColumn(name= "USER_ID")},
            inverseJoinColumns={@JoinColumn(name= "ROLE_ID")})
    private List<RoleEntity> roles = new ArrayList<>();
    public UserEntity(){}
    public UserEntity(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void addRole(RoleEntity role){
        roles.add(role);
    }
}
