package com.example.classes;

import java.util.ArrayList;

public class User {
    public static ArrayList<User> users = new ArrayList<>();
    public static User actualUser = null;
    public Card card = null;
    private String surname;
    private String name;
    private String middleName;
    private final String login;
    private final String password;
    public User(String login, String password){
        this.login = login;
        this.password = password;
        users.add(this);
    }
    public User(String name, String surname, String middleName, String login, String password){
        this(login, password);
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }
    public static User findUser(String login, String password){
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public String getLogin() {
        return login;
    }

    private String getPassword() {
        return password;
    }
}
