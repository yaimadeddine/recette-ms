package com.example.recette.service.facade;

import com.example.recette.bean.Recette;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RecetteService {
    Recette findByRef(String ref);
    List<Recette> findByUserRef(String userRef);
    int deleteByRef(String ref);
    List<Recette> findAll();
    int save(Recette recette);
    int save1(Recette recette,List<MultipartFile> imageFiles);
    int update(Recette recette);
    List<Recette> findAllByTypeRecetteRef(String ref);

}
