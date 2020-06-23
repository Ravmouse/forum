package ru.vitaly.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Vitaly Vasilyev, date: 03.06.2020, e-mail: rav.energ@rambler.ru
 * @version 1.0
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private LocalDate birth;
    private String email;
    private String login;
    private String password;

    public User() { }

    public User(String name, String surname, LocalDate birth, String email, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User post = (User) o;
        return id != 0 && id == post.id;
    }

    @Override
    public int hashCode() {
        return 33;
    }

    @Override
    public String toString() {
        return String.format("id=%d, name=%s, surname=%s, birth=%s, email=%s, login=%s, password=%s"
                , id, name, surname, birth, email, login, password);
    }
}