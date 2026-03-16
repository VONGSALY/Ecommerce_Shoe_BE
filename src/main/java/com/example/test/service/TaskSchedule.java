package com.example.test.service;

import lombok.AllArgsConstructor;
import com.example.test.entity.Attribute;
import com.example.test.entity.Notification;
import com.example.test.entity.Product;
import com.example.test.repository.AttributeRepository;
import com.example.test.repository.NotificationRepository;
import com.example.test.repository.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@AllArgsConstructor
@Service
public class TaskSchedule {
    private final ProductRepository productRepository;
    private final AttributeRepository attributeRepository;
    private final NotificationRepository notificationRepository;
    @Scheduled(cron = "0 40 13 ? * * ")
    public void scanProduct(){
        List<Product> products = productRepository.findAll();
        for(Product p: products){
            Collection<Attribute> attributes = attributeRepository.findAllByProductId(p.getId());
            for(Attribute a: attributes){
                Notification notification = null;
                if(a.getStock() <= 1){
                    notification = new Notification();
                    notification.setRead(false);
                    notification.setDeliver(false);
                    notification.setType(3L);
                    notification.setContent(String.format("Sản phẩm %s size %d sắp hết, kiểm tra ngay nào", a.getName(), a.getSize()));
                    notification.setProductId(p.getId());
                    notificationRepository.save(notification);
                }
            }
        }
    }
}
