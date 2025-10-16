package ru.task8.layouts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Layout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mapping;
    private String creator;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMapping() { return mapping; }
    public void setMapping(String mapping) { this.mapping = mapping; }

    public String getCreator() { return creator; }
    public void setCreator(String creator) { this.creator = creator; }
}
