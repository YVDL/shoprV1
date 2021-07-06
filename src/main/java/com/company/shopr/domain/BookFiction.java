package com.company.shopr.domain;

import com.company.shopr.enums.BookGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("FICTION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EqualsAndHashCode(callSuper = true)
@Entity
public class BookFiction extends Book{

    @Enumerated(EnumType.STRING)
    @Column
    private BookGenre bookGenre;

    @Column(length = 255)
    private String description;
}
