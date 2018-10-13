package ru.rest.server.model;


import javax.persistence.*;

@Entity
@Table(name = "desk")
public class Desk {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;

    private String username;

    private String type;

    public Desk(String title, String username, String type) {
        this.title = title;
        this.username = username;
        this.type = type;
    }

    public Desk() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

