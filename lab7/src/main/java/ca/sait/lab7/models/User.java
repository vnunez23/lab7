package ca.sait.lab7.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Represents a user
 * @author Victor Nunez
 */
@Entity
@Table (name = "user")
@NamedQueries({
    @NamedQuery (name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery (name = "User.softDelete", query = "UPDATE User SET active = 0 WHERE email = :email")
})

public class User implements Serializable {
    @Id
    @Basic
    @Column
    private String email;
    @Column
    private boolean active;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String password;
    
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    private Role role;
    
    public User() {
        
    }
    
    public User(String email, boolean active, String firstName, String lastName, String password, Role role) {
        this.email = email;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
