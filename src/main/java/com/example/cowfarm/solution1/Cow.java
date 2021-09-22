package com.example.cowfarm.solution1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "id")
@ToString
public class Cow {

    private long id;
    private String name;
    private Cow parent;

    public Cow(long id, String name, Cow parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }
}
