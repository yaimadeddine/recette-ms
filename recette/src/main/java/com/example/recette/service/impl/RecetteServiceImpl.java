package com.example.recette.service.impl;

import com.example.recette.bean.Recette;
import com.example.recette.dao.RecetteDao;
import com.example.recette.service.facade.ImageService;
import com.example.recette.service.facade.RecetteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteServiceImpl implements RecetteService {
    @Autowired
    private ImageService imageService;
    @Autowired
    private RecetteDao recetteDao;

    @Override
    public Recette findByRef(String ref) {
        return recetteDao.findByRef(ref);
    }

    @Override
    public List<Recette> findByUserId(int userId) {
        return recetteDao.findByUserId(userId);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return recetteDao.deleteByRef(ref);
    }

    @Override
    public List<Recette> findAll() {
        return recetteDao.findAll();
    }

    @Override
    public int save(Recette recette) {
        if (recetteDao.findByRef(recette.getRef()) != null) {
            if (recette.getImages() != null) {
                recette.getImages().stream().map(image -> imageService.save(image));
            }
            recetteDao.save(recette);
            return 1;
        }
        return -1;
    }

    @Override
    public int update(Recette recette) {
        if (recetteDao.findByRef(recette.getRef())!=null) {
            Recette recette1 = new Recette();
            recette1.setId(recette.getId());
            recette1.setRef(recette.getRef());
            recette1.setDuree(recette.getDuree());
            recette1.setDescription(recette.getDescription());
            recette1.setUserId(recette.getUserId());
            recette1.setImages(recette.getImages());
            recette1.setDate_publication(recette.getDate_publication());
            recetteDao.save(recette1);
            return 1;
        }
        return -1;
    }
}
