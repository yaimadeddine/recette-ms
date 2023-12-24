package com.example.recette.dao;

import com.example.recette.bean.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapeDao  extends JpaRepository<Etape,Integer> {
    int deleteByRef(String ref);

}