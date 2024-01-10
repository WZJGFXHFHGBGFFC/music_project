package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.dto.product.ProductDto;
import org.wzj.spzx.model.entity.product.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    //商品管理查询
    List<Product> findByPage(ProductDto productDto);

    // 保存商品数据
    void save(Product product);

    // 根据id查询商品数据
    Product selectById(Long id);

    // 修改商品基本数据
    void updateById(Product product);

    // 根据id删除商品基本数据
    void deleteById(Long id);
}
