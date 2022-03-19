package com.uspeedinc.server.controller;

import com.uspeedinc.server.common.Result;
import com.uspeedinc.server.entity.Product;
import com.uspeedinc.server.mapper.ProductMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Product detail
 *
 * @author kevinliu
 * @date 3/19/22 12:11 AM
 * @since v1.0.0
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductMapper productMapper;

    @PostMapping
    public Result save(@RequestBody Product product) {
        productMapper.insert(product);
        return Result.success();
    }

}
