package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.entity.product.ProductSpec;

import java.util.List;

@Mapper
public interface ProductSpecMapper {
    //商品规格分页查询
    public abstract List<ProductSpec> findByPage();

    //商品规格添加
    void save(ProductSpec productSpec);

    //商品规格修改
    void updateById(ProductSpec productSpec);

    //商品规格删除
    void deleteById(Long id);

    //查询商品规格数据
    List<ProductSpec> findAll();
}
