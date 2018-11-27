package com.entities;

import com.db.annotations.Column;
import com.db.annotations.Entity;
import com.db.annotations.PrimaryKey;

@Entity(name = "rooms")
public class Room {
    @PrimaryKey(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return String.format("%d | %s",
                getId(), getName());
    }
}
