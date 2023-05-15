package com.demo.springwebexample8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestDto {
    @Pattern(regexp = "([a-z])+@([a-z])+\\.com", message = "Please enter a valid email")
    @NotNull(message = "The email of a requester is required")
    private String requester;
    @Pattern(regexp = "([a-z])+@([a-z])+\\.com", message = "Please enter a valid email")
    @NotNull(message = "The email of a target is required")
    private String target;
}
