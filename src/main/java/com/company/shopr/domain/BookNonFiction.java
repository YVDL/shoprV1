package com.company.shopr.domain;

import com.company.shopr.enums.BookSubject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("NON_FICTION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EqualsAndHashCode(callSuper = true)
@Entity
public class BookNonFiction extends Book{

    @Enumerated(EnumType.STRING)
    @Column
    private BookSubject bookSubject;

    @Column(length = 255)
    private String description;
}
