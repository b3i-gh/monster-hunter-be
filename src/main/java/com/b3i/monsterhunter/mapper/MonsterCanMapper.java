package com.b3i.monsterhunter.mapper;

import com.b3i.monsterhunter.domain.dto.MonsterCanDto;
import com.b3i.monsterhunter.domain.entity.MonsterCan;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface MonsterCanMapper {

    MonsterCanDto toDto(MonsterCan monsterCan);
    MonsterCan toEntity(MonsterCanDto monsterCanDto);
}
