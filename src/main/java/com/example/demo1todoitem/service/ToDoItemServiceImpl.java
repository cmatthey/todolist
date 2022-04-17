package com.example.demo1todoitem.service;

import com.example.demo1todoitem.model.ToDoItem;
import com.example.demo1todoitem.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ToDoItemServiceImpl implements ToDoItemService {
    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public ToDoItem createToDoItem(ToDoItem toDoItem) {
        return (ToDoItem) toDoItemRepository.save(toDoItem);
    }

    @Override
    public ToDoItem updateToDoItem(ToDoItem toDoItem) {
        return (ToDoItem) toDoItemRepository.save(toDoItem);
    }

    @Override
    public ToDoItem getToDoItem(Integer id) {
        // https://stackoverflow.com/questions/49967316/crud-repository-findbyid-different-return-value
        return toDoItemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteToDoItem(Integer id) {
        toDoItemRepository.deleteById(id);
    }
}
