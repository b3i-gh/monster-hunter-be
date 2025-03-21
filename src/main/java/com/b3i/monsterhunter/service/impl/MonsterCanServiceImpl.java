package com.b3i.monsterhunter.service.impl;

import com.b3i.monsterhunter.domain.entity.MonsterCan;
import com.b3i.monsterhunter.repository.MonsterCanRepository;
import com.b3i.monsterhunter.service.MonsterCanService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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
    public MonsterCan updateCan(MonsterCan monsterCan) {
        if(!monsterCanRepository.existsById(monsterCan.getId())){
            throw new IllegalArgumentException("Can not found");
        }

        // Check if the syncDate on the updated can is after the one saved on the DB
        LocalDateTime deletingCanSyncDate = monsterCan.getSyncDate();
        LocalDateTime savedCanSyncDate = getSyncDateById(monsterCan.getId());
        if(deletingCanSyncDate.isAfter(savedCanSyncDate))
            return monsterCanRepository.save(monsterCan);
        else {
            return monsterCanRepository.findById(monsterCan.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Can not found"));
        }
    }

    // Data is logically deleted when the delete API is called, so the physical deletion from the DB never happens.
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

    @Override
    public LocalDateTime getSyncDateById(UUID id) {
        return monsterCanRepository.getSyncDateById(id);
    }
}
