package com.demo.springwebexample8.dto;

import java.util.List;

public class FriendRequestDto {
    private List<String> friends;

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
