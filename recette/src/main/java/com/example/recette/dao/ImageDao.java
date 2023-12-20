package com.example.recette.dao;

import com.example.recette.bean.Image;
import com.example.recette.bean.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao extends JpaRepository<Image,Integer> {
    List<Image> findAllByRecette(Recette recette);
    Image findByName(String name);
}
