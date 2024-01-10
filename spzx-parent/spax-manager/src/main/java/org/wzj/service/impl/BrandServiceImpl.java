package org.wzj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wzj.mapper.BrandMapper;
import org.wzj.service.BrandService;
import org.wzj.spzx.model.entity.product.Brand;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper ;

    //品牌列表查询
    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Brand> brandList = brandMapper.findByPage() ;
        return new PageInfo(brandList);
    }

    //品牌添加
    @Override
    public void save(Brand brand) {
        brandMapper.save(brand) ;
    }

    //品牌修改
    @Override
    public void updateById(Brand brand) {
        brandMapper.updateById(brand) ;
    }

    //品牌删除
    @Override
    public void deleteById(Long id) {
        brandMapper.deleteById(id) ;
    }

    //查询所有品牌
    @Override
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }
}
