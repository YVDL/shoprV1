package com.company.shopr.domain;

import com.company.shopr.enums.GameGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Game extends Article {

    @Column(columnDefinition = "varchar(255) default 'GAME'")
    private String type;

    private String publisher;
    private String minAge;

    @Enumerated(EnumType.STRING)
    private GameGenre gameGenre;
}

