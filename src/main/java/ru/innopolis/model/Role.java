package ru.innopolis.model;


import javax.persistence.*;

@Entity
@Table(name = "spitter")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String role_spitter;

    public Role() {
    }

    public Role(String username, String password, String role_spitter) {
        this.username = username;
        this.password = password;
        this.role_spitter = role_spitter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole_spitter() {
        return role_spitter;
    }

    public void setRole_spitter(String role_spitter) {
        this.role_spitter = role_spitter;
    }
}
