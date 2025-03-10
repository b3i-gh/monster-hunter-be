package com.b3i.monsterhunter.service.impl;

import com.b3i.monsterhunter.domain.entity.MonsterCan;
import com.b3i.monsterhunter.repository.MonsterCanRepository;
import com.b3i.monsterhunter.service.MonsterCanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MonsterCanServiceImpl implements MonsterCanService {

    private final MonsterCanRepository monsterCanRepository;

    @Override
    public List<MonsterCan> listCans() {
        return monsterCanRepository.findAll();
    }

    @Override
    @Transactional
    public MonsterCan createCan(MonsterCan monsterCan) {
        if(monsterCanRepository.existsByNameIgnoreCase(monsterCan.getName())){
            throw new IllegalArgumentException("Can already exists");
        } else {
            return monsterCanRepository.save(monsterCan);
        }
    }

    @Override
    @Transactional
    public void deleteCan(UUID id) {
        if(!monsterCanRepository.existsById(id)){
            throw new IllegalArgumentException("Can not found");
        }
        monsterCanRepository.deleteById(id);
    }

    @Override
    public MonsterCan getCanByName(String name) {
        return monsterCanRepository.findByName(name);
    }
}
