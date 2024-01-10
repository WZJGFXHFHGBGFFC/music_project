package org.wzj.service;

import com.github.pagehelper.PageInfo;
import org.wzj.spzx.model.entity.product.Brand;

import java.util.List;

public interface BrandService {
    //品牌列表查询
    PageInfo<Brand> findByPage(Integer page, Integer limit);

    //品牌添加
    void save(Brand brand);

    //品牌修改
    void updateById(Brand brand);

    //品牌删除
    void deleteById(Long id);

    //查询所有品牌
    List<Brand> findAll();
}
