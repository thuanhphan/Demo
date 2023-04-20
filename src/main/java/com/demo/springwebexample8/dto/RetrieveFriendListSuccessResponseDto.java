package com.demo.springwebexample8.dto;

import java.util.List;

public class RetrieveFriendListSuccessResponseDto {
    private Boolean success;
    private List<String> friends;
    private Integer count;

    public Boolean getSuccess() {
        return true;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Integer getCount() {
        if (getCount() == null) {
            new RetrieveFriendListSuccessResponseDto();
        }
        return friends.size();
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
