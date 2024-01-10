package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.entity.product.Brand;

import java.util.List;

@Mapper
public interface BrandMapper {

    //品牌列表查询
    public abstract List<Brand> findByPage();

    //品牌添加
    void save(Brand brand);

    //品牌修改
    void updateById(Brand brand);

    //品牌删除
    void deleteById(Long id);

    //查询所有品牌
    List<Brand> findAll();
}