package io.github.vikie1.portfolio.projects.todolist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDoList {

    // Constructor for creating lists
    public ToDoList(String name, String time, String user) {
        super();
        this.time = time;
        this.name = name;
        this.user = user;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    // Constructor for reading lists
    public ToDoList() {
    }

    private String name;

    @Id
    @GeneratedValue
    private Long id;

    private String user;

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
