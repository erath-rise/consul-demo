package com.example.service;

import com.example.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

/*

 */
@Service
public class ProductServiceImpl extends ProductService {
    /*
     * 查询商品列表
     *
     * @return 商品列表
     * */
    @Override
    public List<Product> selectProductList() {
        return Arrays.asList(
            new Product(1, "华为手机", 2, 5888.0),
            new Product(2, "联想笔记本", 1, 6888.0),
            new Product(3, "小米平板", 3, 1999.0)
        );

    }
}
