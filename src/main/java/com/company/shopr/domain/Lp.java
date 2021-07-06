package com.company.shopr.domain;

import com.company.shopr.enums.LpGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("LP")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity


public class Lp extends Article{

    private String producer;

    @Enumerated(EnumType.STRING)
    private LpGenre lpGenre;
    private String performer;
    @Column(columnDefinition = "varchar(255) default 'LP'")
    private String type;
}