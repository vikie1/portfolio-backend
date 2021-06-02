package io.github.vikie1.portfolio.projects.todolist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServTodo {
    
    @Autowired
    JPAForToDo jpaForToDo;

    //get all todo items on the list
    public List<ToDoList> getToDos() {
        List<ToDoList> lists = new ArrayList<>();
        jpaForToDo.findAll().forEach(lists :: add);
        return lists;
    }

    //add a todo item in the list
    public void addToDos(ToDoList toDoList) {
        jpaForToDo.save(toDoList);
    }

    //delete a todo item on the list after you are done
    public void deleteToDo(String id) {
        jpaForToDo.deleteById(id);
    }

    //get a todo item using an id
    public List<ToDoList> getAToDo(String id) {
        List<ToDoList> toDoLists = new ArrayList<>();
        toDoLists.add(jpaForToDo.findById(id).orElse(null));
        return toDoLists;
    }
}
