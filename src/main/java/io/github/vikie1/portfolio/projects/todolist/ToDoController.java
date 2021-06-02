package io.github.vikie1.portfolio.projects.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ToDoController {
    
    @Autowired
    ServTodo servTodo;

    //this method returns all the items in the todo list
    @RequestMapping(value="/api/project/todolist", method=RequestMethod.GET)
    public List<ToDoList> outToDoList() {
        return servTodo.getToDos();
    }

    //this method adds/update a todo item in the list
    @RequestMapping(value="/api/project/todolist", method=RequestMethod.POST)
    public void addOrUpdateToDoList(@RequestBody ToDoList toDoList) {
        servTodo.addToDos(toDoList);
    }
    
    //delete a to do and update it as progress
    @RequestMapping(value="/api/project/todolist/{id}", method=RequestMethod.DELETE)//DONT USE THIS FOR NOW
    public void requestMethodName(@PathVariable String id) {
        servTodo.deleteToDo(id);
    }
    

}
