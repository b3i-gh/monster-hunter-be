package com.b3i.monsterhunter.service;

import com.b3i.monsterhunter.domain.entity.MonsterCan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface MonsterCanService {
    List<MonsterCan> listCans();
    MonsterCan createCan(MonsterCan monsterCan);
    void deleteCan(UUID id);
    MonsterCan getCanByName(String name);
}
