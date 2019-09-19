package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TKnowledgeMapper;
import com.ruoyi.system.domain.TKnowledge;
import com.ruoyi.system.service.ITKnowledgeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
@Service
public class TKnowledgeServiceImpl implements ITKnowledgeService 
{
    @Autowired
    private TKnowledgeMapper tKnowledgeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TKnowledge selectTKnowledgeById(String id)
    {
        return tKnowledgeMapper.selectTKnowledgeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tKnowledge 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TKnowledge> selectTKnowledgeList(TKnowledge tKnowledge)
    {
        return tKnowledgeMapper.selectTKnowledgeList(tKnowledge);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tKnowledge 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTKnowledge(TKnowledge tKnowledge)
    {
        return tKnowledgeMapper.insertTKnowledge(tKnowledge);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tKnowledge 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTKnowledge(TKnowledge tKnowledge)
    {
        return tKnowledgeMapper.updateTKnowledge(tKnowledge);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTKnowledgeByIds(String ids)
    {
        return tKnowledgeMapper.deleteTKnowledgeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTKnowledgeById(String id)
    {
        return tKnowledgeMapper.deleteTKnowledgeById(id);
    }
}
