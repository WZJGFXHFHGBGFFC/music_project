package org.wzj.service;

import com.github.pagehelper.PageInfo;
import org.wzj.spzx.model.entity.product.ProductSpec;

import java.util.List;

public interface ProductSpecService {
    //商品规格分页查询
    PageInfo<ProductSpec> findByPage(Integer page, Integer limit);

    //商品规格添加
    void save(ProductSpec productSpec);

    //商品规格修改
    void updateById(ProductSpec productSpec);

    //商品规格删除
    void deleteById(Long id);

    //查询商品规格数据
    List<ProductSpec> findAll();
}
