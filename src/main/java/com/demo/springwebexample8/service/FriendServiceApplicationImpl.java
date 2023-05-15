package com.demo.springwebexample8.service;

import com.demo.springwebexample8.dto.*;
import com.demo.springwebexample8.model.Block;
import com.demo.springwebexample8.model.Friend;
import com.demo.springwebexample8.model.Subscription;
import com.demo.springwebexample8.repository.BlockRepository;
import com.demo.springwebexample8.repository.FriendRepository;
import com.demo.springwebexample8.repository.SubscriptionRepository;
import com.demo.springwebexample8.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.validation.constraints.AssertTrue;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FriendServiceApplicationImpl implements FriendServiceApplication {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private BlockRepository blockRepository;

    @Override
    public Mono<ApiSuccessResponseDto> makeFriends(FriendRequestDto dto) {
        return friendRepository.save(createFriend(dto))
                .filter(Objects::nonNull)
                .map(entity -> ApiSuccessResponseDto.builder().success(true).build())
                .switchIfEmpty(Mono.just(ApiSuccessResponseDto.builder().success(false).build()));
    }

    @Override
    @AssertTrue
    public Mono<RetrieveFriendListSuccessResponseDto> getFriendList(String email) {
        return userRepository.findAllFriendsByEmail(email)
                .collectList()
                .map(value -> RetrieveFriendListSuccessResponseDto.builder().success(true)
                        .friends(value.stream().map(item -> Objects.toString(item.getEmail())).collect(Collectors.toList()))
                        .count(value.size())
                        .build());
    }

    @Override
    public Mono<RetrieveFriendListSuccessResponseDto> getCommonFriends(FriendRequestDto dto) {
        return userRepository.findCommonFriendsByEmail(dto.getFriends().get(0), dto.getFriends().get(1))
                .collectList()
                .map(value -> RetrieveFriendListSuccessResponseDto.builder().success(true)
                        .friends(value.stream().map(item -> Objects.toString(item.getEmail())).collect(Collectors.toList()))
                        .count(value.size())
                        .build());
    }

    @Override
    public Mono<ApiSuccessResponseDto> subscribe(RequestDto dto) {
        return subscriptionRepository.save(createSubs(dto))
                .filter(Objects::nonNull)
                .map(entity -> ApiSuccessResponseDto.builder().success(true).build())
                .switchIfEmpty(Mono.just(ApiSuccessResponseDto.builder().success(false).build()));
    }

    @Override
    public Mono<ApiSuccessResponseDto> block(RequestDto dto) {
        return blockRepository.save(createBlock(dto))
                .filter(Objects::nonNull)
                .map(entity -> ApiSuccessResponseDto.builder().success(true).build())
                .switchIfEmpty(Mono.just(ApiSuccessResponseDto.builder().success(false).build()));
    }

    @Override
    public Mono<ReceiveUpdateSuccessResponseDto> receiveUpdates(ReceiveUpdateRequestDto dto) {
        return userRepository.findReceiverByEmail(dto.getSender()).collectList()
                .map(value -> ReceiveUpdateSuccessResponseDto.builder().success(true)
                        .recipients(value.stream().map(item -> Objects.toString(item.getEmail())).collect(Collectors.toList()))
                        .build());
    }

    private Friend createFriend(FriendRequestDto dto) {
        String person1 = dto.getFriends().get(0);
        String person2 = dto.getFriends().get(1);
        return new Friend(person1, person2);
    }

    private Subscription createSubs(RequestDto dto) {
        String requester = dto.getRequester();
        String target = dto.getTarget();
        return new Subscription(requester, target);
    }

    private Block createBlock(RequestDto dto) {
        String requester = dto.getRequester();
        String target = dto.getTarget();
        return new Block(requester, target);
    }
}
