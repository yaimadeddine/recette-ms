package com.example.recette.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String url;
    @Lob
    private byte[] imageData;
    @ManyToOne
    private Recette recette;
}
