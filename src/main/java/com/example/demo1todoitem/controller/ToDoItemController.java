package com.example.demo1todoitem.controller;

import com.example.demo1todoitem.model.ToDoItem;
import com.example.demo1todoitem.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

@RestController
@RequestMapping("/v1/items")
public class ToDoItemController {

    @Autowired
    ToDoItemService toDoItemService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ToDoItem> getToDoItem(@PathVariable("id") Integer id) {
        ToDoItem toDoItem = toDoItemService.getToDoItem(id);
        if (toDoItem != null) {
            return new ResponseEntity<>(toDoItem, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteToDoItem(@PathVariable("id") Integer id) {
        if (toDoItemService.getToDoItem(id) != null) {
            toDoItemService.deleteToDoItem(id);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDoItem> createToDoItem(@RequestBody ToDoItem newToDoItem) {
        ToDoItem toDoItem = toDoItemService.createToDoItem(newToDoItem);
        if (toDoItem != null) {
            return new ResponseEntity<>(toDoItem, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
