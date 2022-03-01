package com.example.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity(name = "user")
public class User implements Serializable {
    public Long getId() {
        return id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public void setId(Long userId) {
        this.id = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String passWord;
    @Column
    private String userName;
    private boolean enabled;
    @Column private Instant created;
}
