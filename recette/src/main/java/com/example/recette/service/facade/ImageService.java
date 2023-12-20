package com.example.recette.service.facade;

import com.example.recette.bean.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    int save(MultipartFile file) throws IOException;
}
