package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = {"user","item"})   // 서로 참조할 때 제외시켜주지 않음 오버플로우 발생
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    // N : 1  -> 본인(현재 클래스)을 기준으로 잡기
    @ManyToOne
    private User user;  // user_id

    // N : 1
    @ManyToOne
    private Item item; // item_id
}
