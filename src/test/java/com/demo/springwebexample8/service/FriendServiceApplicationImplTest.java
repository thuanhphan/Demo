package com.demo.springwebexample8.service;

import com.demo.springwebexample8.dto.FriendRequestDto;
import com.demo.springwebexample8.dto.ReceiveUpdateRequestDto;
import com.demo.springwebexample8.model.Friend;
import com.demo.springwebexample8.model.User;
import com.demo.springwebexample8.repository.BlockRepository;
import com.demo.springwebexample8.repository.FriendRepository;
import com.demo.springwebexample8.repository.SubscriptionRepository;
import com.demo.springwebexample8.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class FriendServiceApplicationImplTest {

    @Autowired
    public FriendRepository friendRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public SubscriptionRepository subscriptionRepository;
    @Autowired
    public BlockRepository blockRepository;
    @Autowired
    public FriendServiceApplicationImpl friendServiceApplication;

    @Test
    public void shouldReturnCreateFriendsSuccessful() {
        //Setup
        String friend1 = "thu.phan@gmail.com";
        String friend2 = "anh9@gmail.com";
        List<String> friendList = new ArrayList<>();
        friendList.add(friend1);
        friendList.add(friend2);
        FriendRequestDto dto = new FriendRequestDto();
        dto.setFriends(friendList);
        //When
        Mockito.when(friendRepository.save(new Friend(friend1, friend2))).thenReturn(Mono.just(new Friend("thu.phan@gmail.com", "anh9@gmail.com")));
        //Verify
        StepVerifier.create(friendServiceApplication.makeFriends(dto)).assertNext(item -> {
            item.getSuccess().equals(Boolean.TRUE);
        }).verifyComplete();
    }

    @Test
    public void shouldReturnFriendListSuccessful() {
        //Setup
        String email = "thu.phan@gmail.com";
        User user1 = new User("geogre@gmail.com");
        User user2 = new User("kim@gmail.com");
        User user3 = new User("jennifer@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Flux<User> userFlux = Flux.fromIterable(userList);
        //When
        Mockito.when(userRepository.findAllFriendsByEmail(email)).thenReturn(userFlux);
        //Verify
        StepVerifier.create(friendServiceApplication.getFriendList(email)).assertNext(item -> {
            item.getSuccess().equals(Boolean.TRUE);
            item.getFriends().equals(userList);
            item.getCount().equals(userList.size());
        }).verifyComplete();
    }

    @Test
    public void shouldReturnCommonFriendsSuccessful() {
        //Setup
        String email1 = "thu.phan@gmail.com";
        String email2 = "anh9@gmail.com";
        User user = new User();
        user.setEmail("chris@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        Flux<User> userFlux = Flux.fromIterable(userList);
        List<String> str = new ArrayList<>();
        str.add(email1);
        str.add(email2);
        FriendRequestDto dto = new FriendRequestDto();
        dto.setFriends(str);
        //When
        Mockito.when(userRepository.findCommonFriendsByEmail(email1, email2)).thenReturn(userFlux);
        //Verify
        StepVerifier.create(friendServiceApplication.getCommonFriends(dto)).assertNext(item -> {
            item.getSuccess().equals(Boolean.TRUE);
            item.getFriends().equals(userList);
            item.getCount().equals(userList.size());
        });
    }

    @Test
    public void shouldReturnUpdateReceiverSuccessful() {
        //Setup
        String sender = "thu.phan@gmail.com";
        String text = "Hello world!";
        User user1 = new User("geogre@gmail.com");
        User user2 = new User("kim@gmail.com");
        User user3 = new User("jennifer@gmail.com");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        Flux<User> userFlux = Flux.fromIterable(userList);
        ReceiveUpdateRequestDto dto = new ReceiveUpdateRequestDto(sender, text);
        //When
        Mockito.when(userRepository.findReceiverByEmail(sender)).thenReturn(userFlux);
        //Verify
        StepVerifier.create(friendServiceApplication.receiveUpdates(dto)).assertNext(item -> {
            item.getSuccess().equals(Boolean.TRUE);
            item.getRecipients().equals(userList);
        });
    }

    @TestConfiguration
    public static class FriendServiceTestConfiguration {

        @MockBean
        public FriendRepository friendRepository;

        @MockBean
        public UserRepository userRepository;

        @MockBean
        public SubscriptionRepository subscriptionRepository;

        @MockBean
        public BlockRepository blockRepository;

        @Bean
        public FriendServiceApplicationImpl friendServiceApplication() {
            return new FriendServiceApplicationImpl(friendRepository, userRepository, subscriptionRepository, blockRepository);
        }
    }
}
