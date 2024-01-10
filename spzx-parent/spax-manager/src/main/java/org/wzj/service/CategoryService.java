package org.wzj.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.wzj.spzx.model.entity.product.Category;

import java.util.List;

public interface CategoryService {

    //根据parentId获取下级节点
    List<Category> findByParentId(Long parentId);

    //商品导出
    void exportData(HttpServletResponse response);

    //商品导入
    void importData(MultipartFile file);
}
