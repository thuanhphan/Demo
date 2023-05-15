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
@Table(value = "subscription")
public class Subscription {
    @Id
    private int id;

    @Column("requester")
    private String requester;
    @Column("target")
    private String target;

    public Subscription(String requester, String target) {
        this.requester = requester;
        this.target = target;
    }
}
