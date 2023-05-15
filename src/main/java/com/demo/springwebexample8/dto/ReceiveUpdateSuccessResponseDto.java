package com.demo.springwebexample8.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReceiveUpdateSuccessResponseDto {
    private Boolean success;
    private List<String> recipients;

}
