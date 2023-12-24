package com.example.recette.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImageTest {

    @Test
    public void testImageProperties() {
        Image image = new Image();
        image.setId(1);
        image.setName("example.jpg");
        byte[] imageData = "ImageDataExample".getBytes();
        image.setImageData(imageData);

        assertEquals(1, image.getId());
        assertEquals("example.jpg", image.getName());
        assertEquals(imageData, image.getImageData());
    }

}
