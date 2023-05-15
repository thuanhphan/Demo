package com.demo.springwebexample8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReceiveUpdateRequestDto {
    @Pattern(regexp = "([a-z])+@([a-z])+\\.com", message = "Please enter a valid email")
    private String sender;
    private String text;
}
