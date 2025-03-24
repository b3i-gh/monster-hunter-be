package com.b3i.monsterhunter.repository;

import com.b3i.monsterhunter.domain.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, UUID> {
    List<Photo> findByMonsterCanId(UUID canId);
}
