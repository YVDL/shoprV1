package com.company.shopr.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorColumn(name ="type")
@Entity
public abstract class Book extends Article{

    @Column
    private String Author;

    //    @Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3") //TODO: REGEX aanpassen
    @Column
    private String isbn;

    @Column
    private int pages;

    @Column
    private String description;

}
