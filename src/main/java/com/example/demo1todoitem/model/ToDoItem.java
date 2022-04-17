package com.example.demo1todoitem.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="todoitem")
@Data
public class ToDoItem {
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name", nullable = false)
    private String name;
}
