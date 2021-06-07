package io.github.vikie1.portfolio.projects.todolist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDoList {

    // Constructor for creating lists
    public ToDoList(String name, String time, String username) {
        super();
        this.time = time;
        this.name = name;
        this.username = username;
    }

    /**
     * @return the username
     */
    public String getusername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setusername(String username) {
        this.username = username;
    }

    // Constructor for reading lists
    public ToDoList() {
    }

    private String name;

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String time;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }
}
