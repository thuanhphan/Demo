package com.demo.springwebexample8.dto;

import com.demo.springwebexample8.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RetrieveFriendListSuccessResponseDto {
    private Boolean success;
    private List<String> friends;
    private Integer count;


}
