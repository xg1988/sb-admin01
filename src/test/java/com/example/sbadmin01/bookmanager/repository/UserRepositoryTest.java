package com.example.sbadmin01.bookmanager.repository;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    /*
    @Autowired
    UserRepository userRepository;

    @Autowired
    BasicBbsRepositoy basicBbsRepositoy;*/

    @Test
    void crud(){

/*
--saveAll
        User user = new User("chosu", "hoho88@naver.com");
        User user2 = new User("yangji", "superyangji@gmail.com");

        userRepository.saveAll(Lists.newArrayList(user,user2));

--findAll
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        users.forEach(System.out::println);

--findAllById
        List<User> users2 = userRepository.findAllById(Lists.newArrayList(1L, 2L, 3L));
        users2.forEach(System.out::println);
        User user = userRepository.getOne(1L); // -> @Transactional로 세션을 유지해줘야 한다 // LazyLoading지원

--findById
        Optional<User> user = userRepository.findById(1L);
        User user1 = userRepository.findById(1L).orElse(null);
        System.out.println(user);
        System.out.println(user1);
--saveAndFlush
        userRepository.save(new User("test_new", "test@test.test"));
        userRepository.flush(); // -> DB 반영 시점을 조절하는 것이다.

        userRepository.saveAndFlush(new User("test_new", "test@test.test"));
-- count
        long count = userRepository.count();
        System.out.println(count);

-- existById
        boolean exists = userRepository.existsById(1L);
        System.out.println(exists);
-- delete
        // delete를 위해서 select쿼리 한번더 실행
        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        // delete 바로 실행
        userRepository.deleteById(1L);

        userRepository.deleteAllById(Lists.newArrayList(1L, 2L));
        // in 조건으로 가져온다.  --> 이것 저것 비교해보면 성능 이슈를 확인 할 수 있다.
        userRepository.deleteAllInBatch(userRepository.findAllById(Lists.newArrayList(1L, 2L)));

-- paging
        Page<User> users = userRepository.findAll(PageRequest.of(1,3));
        users.forEach(System.out::println);
        System.out.println("users.getTotalElements():"+users.getTotalElements());
        System.out.println("users.getTotalPages():"+users.getTotalPages());
        System.out.println("users.getNumberOfElements():"+users.getNumberOfElements());
        System.out.println("users.getSort():"+users.getSort());
        System.out.println("users.getSize():"+users.getSize());
        System.out.println("users.getContent():"+users.getContent());
-- QBE
        // Query By Example QBE
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith()); // contain 등
        Example<User> example = Example.of(new User("ma", "fast@amp.co.kr"), matcher);

        userRepository.findAll(example).forEach(System.out::println);

-- SimpleJpaRepository

*/
 /*
    ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith()); // contain 등
        Example<User> example = Example.of(new User("테스트", "xg1988@ajou.ac.kr"), matcher);

        System.out.println("test start");
        userRepository.save(new User("테스트", "xg1988@ajou.ac.kr"));
        userRepository.findAll(example).forEach(System.out::println);

*/
    }
}