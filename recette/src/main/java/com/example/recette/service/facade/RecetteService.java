package com.example.recette.service.facade;

import com.example.recette.bean.Recette;

import java.util.List;

public interface RecetteService {
    Recette findByRef(String ref);
    List<Recette> findByUserId(int userId);
    int deleteByRef(String ref);
    List<Recette> findAll();
    int save(Recette recette);
    int update(Recette recette);
}
