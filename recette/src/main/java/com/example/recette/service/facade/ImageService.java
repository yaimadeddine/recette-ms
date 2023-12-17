package com.example.recette.service.facade;

import com.example.recette.bean.Image;

public interface ImageService {
    int uploadImage();
    int save(Image image);
}
