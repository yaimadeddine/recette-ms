package com.example.recette.service.impl;

import com.example.recette.bean.Image;
import com.example.recette.bean.Recette;
import com.example.recette.dao.RecetteDao;
import com.example.recette.required.UserRequired;
import com.example.recette.service.facade.*;
import com.example.recette.util.ImageUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecetteServiceImpl implements RecetteService {
    @Autowired
    private UserRequired userRequired;
    @Autowired
    private ImageService imageService;
    @Autowired
    private RecetteDao recetteDao;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private EtapeService etapeService;
    @Autowired
    private TypeRecetteService typeRecetteService;

    @Override
    public Recette findByRef(String ref) {
        return recetteDao.findByRef(ref);
    }

    @Override
    public List<Recette> findByUserRef(String userRef) {
        return recetteDao.findByUserRef(userRef);
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
//            if (recette.getImages() != null) {
//                recette.getImages().stream().forEach(image -> imageService.save(image));
//            }
            if (recette.getIngredients() != null) {
                recette.getIngredients().stream().map(ingredient -> ingredientService.save(ingredient));
            }
            if (recette.getEtapes() != null) {
                recette.getEtapes().forEach(etape -> etapeService.save(etape));
            }

            if (userRequired.findByRef(recette.getUserRef()) != null) {
                recetteDao.save(recette);
            }
            return 1;
        }
        return -1;
    }
@Override
    public int save1(Recette recette, List<MultipartFile> imageFiles) {
        if (recetteDao.findByRef(recette.getRef()) != null) {
            if (imageFiles != null) {
                List<Image> images = imageFiles.stream()
                        .map(file -> {
                            try {
                                return Image.builder()
                                        .name(file.getOriginalFilename())
                                        .imageData(ImageUtil.compressImage(file.getBytes()))
                                        .build();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        })
                        .collect(Collectors.toList());

                recette.setImages(images);
            }

            if (recette.getIngredients() != null) {
                recette.getIngredients().forEach(ingredient -> ingredientService.save(ingredient));
            }
            if (recette.getEtapes() != null) {
                recette.getEtapes().forEach(etape -> etapeService.save(etape));
            }

            if (userRequired.findByRef(recette.getUserRef()) != null) {
                recetteDao.save(recette);
            }
            return 1;
        }
        return -1;
    }


    @Override
    public int update(Recette recette) {
        if (recetteDao.findByRef(recette.getRef()) != null) {
            Recette r = new Recette();
            r.setId(recette.getId());
            r.setRef(recette.getRef());
            r.setDuree(recette.getDuree());
            r.setDescription(recette.getDescription());
            r.setUserRef(recette.getUserRef());
            r.setImages(recette.getImages());
            r.setDate_publication(recette.getDate_publication());
            r.setIngredients(recette.getIngredients());
            r.setEtapes(recette.getEtapes());

            r.setTypeRecette(recette.getTypeRecette());
            recetteDao.save(r);
            return 1;
        }
        return -1;
    }

    @Override
    public List<Recette> findAllByTypeRecetteRef(String ref) {
        if (typeRecetteService.findByRef(ref) != null) {
            return recetteDao.findAllByTypeRecetteRef(ref);
        } else return null;
    }


}
