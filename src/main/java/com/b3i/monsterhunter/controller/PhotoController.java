package com.b3i.monsterhunter.controller;

import com.b3i.monsterhunter.domain.entity.Photo;
import com.b3i.monsterhunter.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cans/{canId}/photos")
@RequiredArgsConstructor
@ControllerAdvice
public class PhotoController {
    private final PhotoService photoService;

    @PostMapping
    public ResponseEntity<Photo> uploadPhoto(@PathVariable UUID canId, @RequestParam("file") MultipartFile file){
        Photo photo = photoService.uploadPhoto(canId, file);
        return new ResponseEntity<>(photo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{photoId}")
    public ResponseEntity<Void> deletePhoto(@PathVariable UUID canId, @PathVariable UUID photoId){
        photoService.deletePhoto(canId, photoId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{photoId}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable UUID canId, @PathVariable UUID photoId) {
        Photo photo = photoService.getPhoto(canId, photoId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, photo.getContentType())
                .body(photo.getData());
    }

    @GetMapping
    public ResponseEntity<List<Photo>> getAllPhotos(@PathVariable UUID canId){
        List<Photo> photos =  photoService.getAllPhotos(canId);
        return new ResponseEntity<>(photos, HttpStatus.OK);
    }
}
