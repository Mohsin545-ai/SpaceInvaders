package com.zetcode.login;
public class User {
    private String name;
    private String password;

    public User() {
        // empty constructor
    }

    public User(String firstname, String lastname) {
        this.name = firstname;
        this.password = lastname;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
