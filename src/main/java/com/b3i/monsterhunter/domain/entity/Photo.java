package com.b3i.monsterhunter.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name ="photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String filename;
    private String contentType;
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "can_id", nullable = false)
    private MonsterCan monsterCan;
}
