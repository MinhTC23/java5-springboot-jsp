package com.example.assignment_java5.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadImageController {

    @GetMapping("/image/{imageId}")

    public ResponseEntity<InputStreamResource> getImage(@PathVariable String imageId) throws IOException {

        String imagePath = "uploads/" + imageId;

        Path imageFilePath = Paths.get(imagePath);

        InputStreamResource imageResource = new InputStreamResource(Files.newInputStream(imageFilePath));

        MediaType mediaType = MediaType.IMAGE_PNG;

        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(imageResource);
    }

    @GetMapping("/banner/{imageId}")

    public ResponseEntity<InputStreamResource> getBanner(@PathVariable String imageId) throws IOException {

        String imagePath = "src/main/webapp/WEB-INF/assets/" + imageId;

        Path imageFilePath = Paths.get(imagePath);

        InputStreamResource imageResource = new InputStreamResource(Files.newInputStream(imageFilePath));

        MediaType mediaType = MediaType.IMAGE_PNG;

        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(imageResource);
    }
}
