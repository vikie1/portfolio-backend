package io.github.vikie1.portfolio.projects.todolist;

import org.springframework.data.repository.CrudRepository;

public interface JPAForToDo extends CrudRepository<ToDoList, String>{
    
}
