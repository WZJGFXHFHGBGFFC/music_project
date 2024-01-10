package org.wzj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzj.mapper.ProductSpecMapper;
import org.wzj.service.ProductSpecService;
import org.wzj.spzx.model.entity.product.ProductSpec;

import java.util.List;

@Service
public class ProductSpecServiceImpl implements ProductSpecService {

    @Autowired
    private ProductSpecMapper productSpecMapper ;

    //商品规格分页查询
    @Override
    public PageInfo<ProductSpec> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page , limit) ;
        List<ProductSpec> productSpecList = productSpecMapper.findByPage() ;
        return new PageInfo<>(productSpecList);
    }

    //商品规格添加
    @Override
    public void save(ProductSpec productSpec) {
        productSpecMapper.save(productSpec) ;
    }

    //商品规格修改
    @Override
    public void updateById(ProductSpec productSpec) {
        productSpecMapper.updateById(productSpec);
    }

    //商品规格删除
    @Override
    public void deleteById(Long id) {
        productSpecMapper.deleteById(id);
    }

    //查询商品规格数据
    @Override
    public List<ProductSpec> findAll() {
        return productSpecMapper.findAll();
    }

}
