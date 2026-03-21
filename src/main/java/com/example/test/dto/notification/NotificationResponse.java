package com.example.test.dto.notification;

import lombok.*;
import com.example.test.entity.Order;
import com.example.test.entity.Product;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NotificationResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Boolean read;
    private Boolean deliver;
    private Order order;
    private Product product;
    private Long type;
}
