package com.demo.springwebexample8.controller;

import com.demo.springwebexample8.dto.*;
import com.demo.springwebexample8.service.FriendServiceApplicationImpl;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebFluxTest(FriendController.class)
public class FriendControllerTest {

    @MockBean
    public FriendServiceApplicationImpl friendServiceApplication;

    @Autowired
    WebTestClient webTestClient;

    @Test
    public void shouldReturnCreateFriendsSuccessful() throws FileNotFoundException {
        //Setup
        String friend1 = "thu.phan@gmail.com";
        String friend2 = "anh9@gmail.com";
        List<String> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        FriendRequestDto dto = new FriendRequestDto();
        dto.setFriends(friendList);
        //When
        Mockito.when(friendServiceApplication.makeFriends(dto)).thenReturn(Mono.just(new ApiSuccessResponseDto(Boolean.TRUE)));
        //Verify
        var resource = new InputStreamResource(new FileInputStream("src/test/java/com/demo/springwebexample8/controller/CreateFriendRequest"));
        webTestClient.method(HttpMethod.POST).uri("/api/makeFriends").body(BodyInserters.fromResource(resource)).header("Accept", "application/json").header("Content-type", "application/json").exchange().expectStatus().isOk().expectBody(ApiSuccessResponseDto.class).returnResult();
    }

    @Test
    public void shouldReturnFriendListSuccessful() throws FileNotFoundException {
        //Setup
        String email = "thu.phan@gmail.com";
        String friend1 = "chris@gmail.com";
        String friend2 = "jennifer@gmail.com";
        List<String> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        RetrieveFriendListSuccessResponseDto dto = new RetrieveFriendListSuccessResponseDto(Boolean.TRUE, friendList, friendList.size());
        //When
        Mockito.when(friendServiceApplication.getFriendList(email)).thenReturn(Mono.just(dto));
        //Verify
        var resource = new InputStreamResource(new FileInputStream("src/test/java/com/demo/springwebexample8/controller/GetFriendsRequest"));
        webTestClient.method(HttpMethod.POST).uri("/api/getFriends").body(BodyInserters.fromResource(resource)).header("Accept", "application/json").header("Content-type", "application/json").exchange().expectStatus().isOk().expectBody(RetrieveFriendListSuccessResponseDto.class).returnResult();
    }

    @Test
    public void shouldReturnCommonFriendsSuccessful() throws FileNotFoundException {
        //Setup
        String email1 = "kim.phan@gmail.com";
        String email2 = "geogre.phan@gmail.com";
        String friend1 = "chris@gmail.com";
        String friend2 = "jennifer@gmail.com";
        List<String> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        List<String> friendListReq = new ArrayList<>();
        friendListReq.add(email1);
        friendListReq.add(email2);
        FriendRequestDto friendRequestDto = new FriendRequestDto();
        friendRequestDto.setFriends(friendList);
        RetrieveFriendListSuccessResponseDto retrieveFriendListSuccessResponseDto = new RetrieveFriendListSuccessResponseDto(Boolean.TRUE, friendList, friendList.size());
        //When
        Mockito.when(friendServiceApplication.getCommonFriends(friendRequestDto)).thenReturn(Mono.just(retrieveFriendListSuccessResponseDto));
        //Verify
        var resource = new InputStreamResource(new FileInputStream("src/test/java/com/demo/springwebexample8/controller/GetCommonFriendsRequest"));
        webTestClient.method(HttpMethod.POST).uri("/api/getCommonFriends").body(BodyInserters.fromResource(resource)).header("Accept", "application/json").header("Content-type", "application/json").exchange().expectStatus().isOk().expectBody(RetrieveFriendListSuccessResponseDto.class).returnResult();
    }

    @Test
    public void shouldReturnUpdatedEmailSuccessful() throws FileNotFoundException {
        //Setup
        String sender = "kim@gmail.com";
        String text = "Hello world!";
        ReceiveUpdateRequestDto receiveUpdateRequestDto = new ReceiveUpdateRequestDto(sender, text);
        String recipient1 = "chris@gmail.com";
        String recipient2 = "jennifer@gmail.com";
        List<String> recipients = new ArrayList<>();
        recipients.add(recipient1);
        recipients.add(recipient2);
        ReceiveUpdateSuccessResponseDto receiveUpdateSuccessResponseDto = new ReceiveUpdateSuccessResponseDto(Boolean.TRUE, recipients);
        //When
        Mockito.when(friendServiceApplication.receiveUpdates(receiveUpdateRequestDto)).thenReturn(Mono.just(receiveUpdateSuccessResponseDto));
        //Verify
        var resource = new InputStreamResource(new FileInputStream("src/test/java/com/demo/springwebexample8/controller/RetrieveUpdatedEmailRequest"));
        webTestClient.method(HttpMethod.POST).uri("/api/getEmailReceivers").body(BodyInserters.fromResource(resource)).header("Accept", "application/json").header("Content-type", "application/json").exchange().expectStatus().isOk().expectBody(ReceiveUpdateSuccessResponseDto.class).returnResult();
    }

}
