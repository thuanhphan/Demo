package com.demo.springwebexample8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "friend")
public class Friend {
    @Id
    private int id;

    @Column("person1")
    private String personOne;
    @Column("person2")
    private String personTwo;

    public Friend(String personOne, String personTwo) {
        this.personOne = personOne;
        this.personTwo = personTwo;
    }
}
