package com.example.recette.service.impl;

import com.example.recette.bean.Image;
import com.example.recette.dao.ImageDao;
import com.example.recette.service.facade.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;
    private int uploadImage() {
        return 0;
    }
    @Override
    public int save(Image image) {
        imageDao.save(image);
        return 1;
    }
}
