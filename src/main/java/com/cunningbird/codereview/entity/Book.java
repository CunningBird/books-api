package com.cunningbird.codereview.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data // TODO maybe record
public class Book {

    @Id
    private UUID id;

    private String name;

    private int cost;
}
