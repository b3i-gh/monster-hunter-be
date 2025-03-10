package com.b3i.monsterhunter.domain.entity;

import com.b3i.monsterhunter.domain.Lang;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name ="monster_cans")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MonsterCan {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private Long cc;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Lang lang;

    @Column(nullable = false)
    private LocalDate creationDate;

    @PrePersist
    protected void onCreate(){
        this.creationDate = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonsterCan that = (MonsterCan) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cc, that.cc) && lang == that.lang && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cc, lang, creationDate);
    }
}
