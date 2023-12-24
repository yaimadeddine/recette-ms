package com.example.recette.service;

import com.example.recette.bean.Image;
import com.example.recette.dao.ImageDao;
import com.example.recette.service.impl.ImageServiceImpl;
import com.example.recette.util.ImageUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ImageServiceImpTest {

    @Autowired
    private ImageDao imageDao;
    @Autowired
    private ImageServiceImpl imageService;

    @AfterEach
    public void tearDown() {
        imageDao.deleteAll();
    }

    @Test
    public void testSave() throws IOException {
        byte[] imageData = new byte[]{0, 1, 2, 3};
        MultipartFile file = new MockMultipartFile("test.jpg", "test.jpg", "image/jpeg", imageData);
        int result = imageService.save(file);
        assertEquals(1, imageDao.count());
        Image savedImage = imageDao.findAll().get(0);
        assertEquals("test.jpg", savedImage.getName());
        assertEquals(1, result);
    }
}
