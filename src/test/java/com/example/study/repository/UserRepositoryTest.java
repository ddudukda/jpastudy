package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends StudyApplicationTests {

    // DI = Dependency Injection
    @Autowired private UserRepository userRepository;

    @Test
    public void create (){
        User user = new User();
        user.setAccount("dadak");
        user.setEmail("dadak@mail.com");
        user.setPhoneNumber("010-1223-3331");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("dadak");

        User newUser = userRepository.save(user);

        System.out.println("newUser: " + newUser);
        System.out.println(newUser.getId());

    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
            System.out.println("email: " + selectUser.getEmail());
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser -> {
            selectUser.setAccount("abc");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update");
            userRepository.save(selectUser);
        });


    }

    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(1L);

        //Assert.assertTrue(user.isPresent());  -> true

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);
        if(deleteUser.isPresent()){
            System.out.println("deleteUser: "+deleteUser.get());
        }else{
            System.out.println("User delete -> 데이터 없음");
        }

        // Assert.assertFalse(deleteUser.isPresent());  -> false

    }
}