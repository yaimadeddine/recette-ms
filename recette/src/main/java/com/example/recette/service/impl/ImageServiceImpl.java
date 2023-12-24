package com.example.recette.service.impl;

import com.example.recette.bean.Image;
import com.example.recette.dao.ImageDao;
import com.example.recette.service.facade.ImageService;
import com.example.recette.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;



    private int uploadImage(MultipartFile file) throws IOException {
        imageDao.save(Image.builder()
                .name(file.getOriginalFilename())
                .imageData(ImageUtil.compressImage(file.getBytes()))
                .build());
        return 1;
    }

    @Override
    public int save(MultipartFile file) throws IOException{
        return uploadImage(file);
    }
}
