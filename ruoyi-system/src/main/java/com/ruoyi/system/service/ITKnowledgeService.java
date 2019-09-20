package com.ruoyi.system.service;

import com.ruoyi.system.domain.TKnowledge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
public interface ITKnowledgeService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TKnowledge selectTKnowledgeById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tKnowledge 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TKnowledge> selectTKnowledgeList(TKnowledge tKnowledge);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tKnowledge 【请填写功能名称】
     * @param file
     * @return 结果
     */
    public int insertTKnowledge(TKnowledge tKnowledge, MultipartFile[] file);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tKnowledge 【请填写功能名称】
     * @param file
     * @return 结果
     */
    public int updateTKnowledge(TKnowledge tKnowledge, MultipartFile[] file);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTKnowledgeByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTKnowledgeById(String id);
}
