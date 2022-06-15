package com.vestra.pp3bootstrap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public void setPassword(String pass) {
        this.password = pass;
    }

    public User() {

    }
    public User(String name, int age, String email, String password, Set<Role> roles){
        this(name, age, email, password);
        this.roles = roles;
    }

    public User(String name, String lastName, int age, String email,  String password) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public User(String name, int age, String email, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public Set<Role> setOneRole(Role r) {
        if(roles == null) {
            roles = new HashSet<>();
        }
        roles.add(r);
        return roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", roles=" + roles +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && id.equals(user.id) && name.equals(user.name) && email.equals(user.email) && password.equals(user.password) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, age, password, roles);
    } */
}
