package org.wzj.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wzj.spzx.model.entity.product.Category;
import java.util.List;

@Mapper
public interface CategoryMapper {
    // 根据分类id查询它下面的所有的子分类数据
    List<Category> selectByParentId(Long parentId);

    // 查询该分类下子分类的数量
    int countByParentId(Long id);

    List<Category> selectAll();

    //保存excel导入的数据
    void batchInsert(List cachedDataList);
}
