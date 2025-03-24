package com.b3i.monsterhunter.service.impl;

import com.b3i.monsterhunter.domain.entity.MonsterCan;
import com.b3i.monsterhunter.domain.entity.Photo;
import com.b3i.monsterhunter.repository.MonsterCanRepository;
import com.b3i.monsterhunter.repository.PhotoRepository;
import com.b3i.monsterhunter.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {
    private final PhotoRepository photoRepository;
    private final MonsterCanRepository monsterCanRepository;

    @Override
    public Photo uploadPhoto(UUID canId, MultipartFile file){
        MonsterCan monsterCan = monsterCanRepository.findById(canId)
                .orElseThrow(() -> new IllegalArgumentException("Can not found"));

        Photo photo = new Photo();
        photo.setFilename(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        try{
            photo.setData(file.getBytes());
        } catch (IOException e){
            throw new RuntimeException("Failed to store file data", e);
        }
        photo.setMonsterCan(monsterCan);
        return photoRepository.save(photo);
    }

    @Override
    public void deletePhoto(UUID canId, UUID photoId){
        Photo photo = photoRepository.findById(photoId)
                .orElseThrow(() -> new IllegalArgumentException("Photo not found"));
        if (!photo.getMonsterCan().getId().equals(canId)){
            throw new IllegalArgumentException("Photo does not belong to the specified can");
        }
        photoRepository.delete(photo);
    }

    @Override
    public Photo getPhoto(UUID canId, UUID photoId){
        Photo photo = photoRepository.findById(photoId)
                .orElseThrow(() -> new IllegalArgumentException("Photo not forund"));
        if (!photo.getMonsterCan().getId().equals(canId)) {
            throw new IllegalArgumentException("Photo does not belong to the specified can");
        }
        return photo;
    }

    @Override
    public List<Photo> getAllPhotos(UUID canId){
        return photoRepository.findByMonsterCanId(canId);
    }
}
