package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Movie {
    private final long id;
    private String name;
    private Integer productionYear;
    private LocalDateTime createdAt;
}
