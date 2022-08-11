package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("노트북");
        item.setPrice(1000000);
        item.setContent("삼성노트북");

        Item newItem = itemRepository.save(item);
        Assert.notNull(newItem,"create() success");
    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<Item> item = itemRepository.findById(id);

        item.ifPresent(i -> {
            System.out.println(i);
        });
    }
}