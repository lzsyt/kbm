package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TKnowledgeMap;
import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
public interface TKnowledgeMapMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TKnowledgeMap selectTKnowledgeMapById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tKnowledgeMap 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TKnowledgeMap> selectTKnowledgeMapList(TKnowledgeMap tKnowledgeMap);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tKnowledgeMap 【请填写功能名称】
     * @return 结果
     */
    public int insertTKnowledgeMap(TKnowledgeMap tKnowledgeMap);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tKnowledgeMap 【请填写功能名称】
     * @return 结果
     */
    public int updateTKnowledgeMap(TKnowledgeMap tKnowledgeMap);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTKnowledgeMapById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTKnowledgeMapByIds(String[] ids);
}
