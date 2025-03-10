package com.b3i.monsterhunter.controller;

import com.b3i.monsterhunter.domain.dto.MonsterCanDto;
import com.b3i.monsterhunter.domain.entity.MonsterCan;
import com.b3i.monsterhunter.mapper.MonsterCanMapper;
import com.b3i.monsterhunter.service.MonsterCanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cans")
@RequiredArgsConstructor
public class MonsterCanController {

    private final MonsterCanService monsterCanService;
    private final MonsterCanMapper monsterCanMapper;

    @GetMapping
    public ResponseEntity<List<MonsterCanDto>> getAllCans(){
        List<MonsterCanDto> cans = monsterCanService.listCans()
                .stream()
                .map(monsterCanMapper::toDto)
                .toList();
        return ResponseEntity.ok(cans);
    }

    @PostMapping
    public ResponseEntity<MonsterCanDto> createCan(@RequestBody MonsterCanDto monsterCanDto){
        MonsterCan monsterCan = monsterCanMapper.toEntity(monsterCanDto);
        MonsterCan savedMonsterCan = monsterCanService.createCan(monsterCan);
        return new ResponseEntity<>(
                monsterCanMapper.toDto(savedMonsterCan),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCan(@PathVariable UUID id){
        System.out.println("id: " + id);
        monsterCanService.deleteCan(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<MonsterCanDto> getCanByName(@PathVariable String name){
        MonsterCan can = monsterCanService.getCanByName(name);
        return ResponseEntity.ok(monsterCanMapper.toDto(can));
    }
}
