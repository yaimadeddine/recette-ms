package com.example.recette.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ref;
    private String description;
    private int duree;
    private Date date_publication;
    private String userRef;
    @OneToMany
    private List<Image> images;
    @ManyToOne
    private TypeRecette typeRecette;
    @OneToMany
    private List<Ingredient> ingredients;
}
