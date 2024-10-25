package io.hexlet;

public class User {
    private Long id; // Идентификатор пользователя
    private String name; // Имя пользователя
    private String phone; // Телефон пользователя

    // Конструктор для установки имени и телефона пользователя
    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Геттер и сеттер для id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Геттеры для имени и телефона
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}