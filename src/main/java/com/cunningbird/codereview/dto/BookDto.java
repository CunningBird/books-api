package com.cunningbird.codereview.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BookDto {

    private UUID id;

    private String name;

    private int cost;
}
