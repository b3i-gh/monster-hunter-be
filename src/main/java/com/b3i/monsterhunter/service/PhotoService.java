package com.b3i.monsterhunter.service;

import com.b3i.monsterhunter.domain.entity.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface PhotoService {
    Photo uploadPhoto(UUID canId, MultipartFile file);
    void deletePhoto(UUID canId, UUID photoId);
    Photo getPhoto(UUID canId, UUID photoId);
    List<Photo> getAllPhotos(UUID canId);
}
