package ru.innopolis.model;

import javax.persistence.*;

/**
 * Модель User
 *
 * Два поля:
 *  @user_id - id листа покупок
 *  @username - имя листа покупок
 */
@Entity
@Table(name = "sl_user")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer user_id;

    @Column
    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
