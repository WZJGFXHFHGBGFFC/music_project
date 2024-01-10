package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.entity.product.ProductDetails;

@Mapper
public interface ProductDetailsMapper {
    // 保存商品详情数据
    void save(ProductDetails productDetails);

    // 根据商品的id查询商品详情数据
    ProductDetails selectByProductId(Long id);

    // 修改商品的详情数据
    void updateById(ProductDetails productDetails);

    // 根据商品的id删除商品的详情数据
    void deleteByProductId(Long id);
}
