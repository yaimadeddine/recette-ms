package com.example.recette.dao;

import com.example.recette.bean.Ingredient;
import com.example.recette.bean.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient,Integer> {
    int deleteByRef(String ref);
}
