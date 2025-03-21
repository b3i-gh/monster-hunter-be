package com.b3i.monsterhunter.repository;

import com.b3i.monsterhunter.domain.entity.MonsterCan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface MonsterCanRepository extends JpaRepository<MonsterCan, UUID> {
    boolean existsByNameIgnoreCase(String name);
    MonsterCan findByName(String name);
    @Query("SELECT syncDate FROM MonsterCan WHERE id = :id")
    LocalDateTime getSyncDateById(@Param("id") UUID id);
}
