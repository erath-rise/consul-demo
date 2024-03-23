package com.example.service.impl;

import com.example.pojo.Order;
import com.example.pojo.Product;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class OrderServiceImpl extends OrderService {
    @Autowired
    private RestTemplate restTemplate;

    /*
     *  根据主键查询订单
     *
     * @param id
     * @return
     * */
    public Order selectOrderById(Integer id) {
        return new Order(id, "order-001", "China", 22788D,
                selectProductListByLoadBalancerAnnotation());
    }

    private List<Product> selectProductListByLoadBalancerAnnotation() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://service-provider/product/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        return response.getBody();
    }
}
