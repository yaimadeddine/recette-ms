package com.example.recette.service.impl;

import com.example.recette.bean.Ingredient;
import com.example.recette.bean.Recette;
import com.example.recette.dao.IngredientDao;
import com.example.recette.service.facade.IngredientService;
import com.example.recette.service.facade.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientDao ingredientDao;


    @Override
    public int deleteByRef(String ref) {
        return ingredientDao.deleteByRef(ref);
    }


    @Override
    public int save(Ingredient ingredient) {
        ingredientDao.save(ingredient);
        return 1;
    }


    @Override
    public int update(Ingredient ingredient) {
        return 0;
    }
}
