package com.demo.springwebexample8.service;

import com.demo.springwebexample8.dto.*;
import reactor.core.publisher.Mono;

public interface FriendServiceApplication {
    Mono<ApiSuccessResponseDto> makeFriends(FriendRequestDto dto);

    Mono<RetrieveFriendListSuccessResponseDto> getFriendList(String email);

    Mono<RetrieveFriendListSuccessResponseDto> getCommonFriends(FriendRequestDto dto);

    Mono<ApiSuccessResponseDto> subscribe(RequestDto dto);

    Mono<ApiSuccessResponseDto> block(RequestDto dto);

    Mono<ReceiveUpdateSuccessResponseDto> receiveUpdates(ReceiveUpdateRequestDto dto);

}
