package com.demo.springwebexample8.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class FriendRequestDto {

    @NotNull(message = "The friend list is required")
    @Size(min = 2, message = "Please enter 2 valid emails to process")
    private List< @Pattern(regexp = "([a-z])+@([a-z])+\\.com", message = "Please enter a valid email")String> friends;

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
