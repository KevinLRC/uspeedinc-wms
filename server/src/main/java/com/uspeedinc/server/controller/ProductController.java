package com.uspeedinc.server.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uspeedinc.server.common.Result;
import com.uspeedinc.server.entity.Product;
import com.uspeedinc.server.mapper.ProductMapper;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String keyword) {
        System.out.println("pageNum=" + pageNum + "pageSize=" + pageSize + "keyword=" + keyword);
        LambdaQueryWrapper<Product> wrapper = Wrappers.lambdaQuery();
        if (StrUtil.isNotBlank(keyword)) {
            wrapper.like(Product::getSkuNo, keyword);
        }

        Page<Product> productPage = productMapper.selectPage(new Page<>(pageNum, pageSize),
                wrapper);
        System.out.println(productPage);
        return Result.success(productPage);
    }

    @PutMapping
    public Result update(@RequestBody Product product) {
        productMapper.updateById(product);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        productMapper.deleteById(id);
        return Result.success();
    }


}
