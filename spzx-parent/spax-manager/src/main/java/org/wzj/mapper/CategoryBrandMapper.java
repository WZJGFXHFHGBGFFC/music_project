package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.dto.product.CategoryBrandDto;
import org.wzj.spzx.model.entity.product.Brand;
import org.wzj.spzx.model.entity.product.CategoryBrand;

import java.util.List;

@Mapper
public interface CategoryBrandMapper {
    //分类品牌分页查询
    List<CategoryBrand> findByPage(CategoryBrandDto categoryBrandDto);

    //分类品牌删除
    void deleteById(Long id);

    //分类品牌修改
    void updateById(CategoryBrand categoryBrand);

    //分类品牌添加
    void save(CategoryBrand categoryBrand);

    //商品管理加载品牌数据
    List<Brand> findBrandByCategoryId(Long categoryId);
}
