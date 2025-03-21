package com.b3i.monsterhunter.service;

import com.b3i.monsterhunter.domain.entity.MonsterCan;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MonsterCanService {
    List<MonsterCan> listCans();
    MonsterCan createCan(MonsterCan monsterCan);
    MonsterCan updateCan(MonsterCan monsterCan);
    void deleteCan(UUID id);
    MonsterCan getCanByName(String name);
    LocalDateTime getSyncDateById(UUID id);
}
