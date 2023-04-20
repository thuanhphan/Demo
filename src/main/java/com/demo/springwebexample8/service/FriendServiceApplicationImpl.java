package com.demo.springwebexample8.service;

import com.demo.springwebexample8.dto.FriendRequestDto;
import com.demo.springwebexample8.model.Friend;
import com.demo.springwebexample8.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FriendServiceApplicationImpl implements FriendServiceApplication {

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public Mono<Friend> createFriendship(FriendRequestDto dto) {
        return friendRepository.save(createFriend(dto));
    }

    @Override
    public Flux<String> getFriendList(String email) {
        return friendRepository.findFriendListByEmail(email);
    }

    private Friend createFriend(FriendRequestDto dto) {
        String person1 = dto.getFriends().get(0);
        String person2 = dto.getFriends().get(1);
        return new Friend(person1, person2);
    }
}
