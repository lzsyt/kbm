package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TKnowledgeMapMapper;
import com.ruoyi.system.domain.TKnowledgeMap;
import com.ruoyi.system.service.ITKnowledgeMapService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
@Service
public class TKnowledgeMapServiceImpl implements ITKnowledgeMapService 
{
    @Autowired
    private TKnowledgeMapMapper tKnowledgeMapMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TKnowledgeMap selectTKnowledgeMapById(Long id)
    {
        return tKnowledgeMapMapper.selectTKnowledgeMapById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tKnowledgeMap 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TKnowledgeMap> selectTKnowledgeMapList(TKnowledgeMap tKnowledgeMap)
    {
        return tKnowledgeMapMapper.selectTKnowledgeMapList(tKnowledgeMap);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tKnowledgeMap 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTKnowledgeMap(TKnowledgeMap tKnowledgeMap)
    {
        return tKnowledgeMapMapper.insertTKnowledgeMap(tKnowledgeMap);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tKnowledgeMap 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTKnowledgeMap(TKnowledgeMap tKnowledgeMap)
    {
        return tKnowledgeMapMapper.updateTKnowledgeMap(tKnowledgeMap);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTKnowledgeMapByIds(String ids)
    {
        return tKnowledgeMapMapper.deleteTKnowledgeMapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTKnowledgeMapById(Long id)
    {
        return tKnowledgeMapMapper.deleteTKnowledgeMapById(id);
    }
}
