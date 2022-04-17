package com.example.demo1todoitem.service;

import com.example.demo1todoitem.model.ToDoItem;

public interface ToDoItemService {
    public ToDoItem createToDoItem(ToDoItem toDoItem);

    public ToDoItem updateToDoItem(ToDoItem toDoItem);

    public ToDoItem getToDoItem(Integer id);

    public void deleteToDoItem(Integer id);
}
