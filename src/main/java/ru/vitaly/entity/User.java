package ru.vitaly.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Vitaly Vasilyev, e-mail: rav.energ@rambler.ru
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
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

    public User(String name, String surname, LocalDate birth, String email, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.email = email;
        this.login = login;
        this.password = password;
    }
}