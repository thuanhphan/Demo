package com.demo.springwebexample8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "block")
public class Block {
    @Id
    private int id;

    @Column("blocker")
    private String blocker;
    @Column("blockee")
    private String blockee;

    public Block(String blocker, String blockee) {
        this.blocker = blocker;
        this.blockee = blockee;
    }
}
