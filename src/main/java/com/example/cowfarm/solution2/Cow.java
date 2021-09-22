package com.example.cowfarm.solution2;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"right", "child", "left"})
public class Cow {
    private long id;
    private String name;
    private Cow parent;
    private Cow right;
    private Cow left;
    private Cow child;

    public Cow(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Cow(long id, String name, Cow parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }
}

