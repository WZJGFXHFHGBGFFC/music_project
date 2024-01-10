package org.wzj.service;

import com.github.pagehelper.PageInfo;
import org.wzj.spzx.model.dto.product.ProductDto;
import org.wzj.spzx.model.entity.product.Product;

public interface ProductService {
    //商品管理查询
    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    //保存商品数据
    void save(Product product);

    //查询商品详情
    Product getById(Long id);

    //保存修改数据
    void updateById(Product product);

    //删除商品
    void deleteById(Long id);

    //商品审核
    void updateAuditStatus(Long id, Integer auditStatus);

    //商品上下架
    void updateStatus(Long id, Integer status);
}
