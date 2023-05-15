package com.demo.springwebexample8.model;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("public.user")
public class User {
    @Pattern(regexp = "([a-z])+@([a-z])+\\.com", message = "Please enter a valid email")
    @NotNull(message = "Email must not be null")
    @Column("email")
    private String email;
}
