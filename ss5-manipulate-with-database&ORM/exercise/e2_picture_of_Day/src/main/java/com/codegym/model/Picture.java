package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate displayDate;

    @OneToMany(mappedBy = "picture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

}
