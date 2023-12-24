package com.example.recette.service.facade;

import com.example.recette.bean.Ingredient;
import com.example.recette.bean.Recette;

import java.util.List;

public interface IngredientService {
    int deleteByRef(String ref);

    int save(Ingredient ingredient);


    int update(Ingredient ingredient);
}
