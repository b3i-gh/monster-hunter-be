package com.b3i.monsterhunter.domain.entity;

import com.b3i.monsterhunter.domain.Lang;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private String name;

    private Long cc;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Lang lang;

    @Column(nullable = false)
    private LocalDate creationDate;

    @Column()
    private LocalDateTime syncDate;

    @Column()
    private Boolean sugarFree = false;

    @Column()
    private Boolean deleted = false;

    @PrePersist
    protected void onCreate(){
        this.creationDate = LocalDate.now();
        this.syncDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        this.syncDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonsterCan that = (MonsterCan) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cc, that.cc) && lang == that.lang && Objects.equals(creationDate, that.creationDate) && Objects.equals(syncDate, that.syncDate) && Objects.equals(sugarFree, that.sugarFree) && Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cc, lang, creationDate, syncDate, sugarFree, deleted);
    }
}
