package com.sungwony.book.springboot.domain.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void 이메일로_유저를_조회한다(){
        //given
        String email = "test@google.com";
        String email2 = "test2@google.com";
        User user = User.builder()
                        .name("sungwon")
                        .email(email)
                        .picture("no_picture")
                        .role(Role.USER)
                        .build();

        //when
        userRepository.save(user);
        User findUser = userRepository.findByEmail(email).orElse(null);
        User findUser2 = userRepository.findByEmail(email2).orElse(null);

        //then
        assertThat(findUser.getId()).isEqualTo(user.getId());
        assertThat(findUser.getName()).isEqualTo(user.getName());
        assertThat(findUser2).isNull();
    }
}
