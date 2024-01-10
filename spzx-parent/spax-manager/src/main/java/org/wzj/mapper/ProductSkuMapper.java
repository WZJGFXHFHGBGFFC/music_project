package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.entity.product.ProductSku;

import java.util.List;

@Mapper
public interface ProductSkuMapper {
    // 保存商品sku数据
    void save(ProductSku productSku);

    // 根据商品的id查询sku数据
    List<ProductSku> selectByProductId(Long id);

    // 修改商品的sku数据
    void updateById(ProductSku productSku);

    // 根据商品id删除商品的sku数据
    void deleteByProductId(Long id);
}
