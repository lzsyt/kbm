package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TKnowledge;
import java.util.List;

/**
 * 知识库Mapper接口
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
public interface TKnowledgeMapper 
{
    /**
     * 查询知识库
     * 
     * @param id 知识库ID
     * @return 知识库
     */
    public TKnowledge selectTKnowledgeById(String id);

    /**
     * 查询知识库列表
     * 
     * @param tKnowledge 知识库
     * @return 知识库集合
     */
    public List<TKnowledge> selectTKnowledgeList(TKnowledge tKnowledge);

    /**
     * 新增知识库
     * 
     * @param tKnowledge 知识库
     * @return 结果
     */
    public int insertTKnowledge(TKnowledge tKnowledge);

    /**
     * 修改知识库
     * 
     * @param tKnowledge 知识库
     * @return 结果
     */
    public int updateTKnowledge(TKnowledge tKnowledge);

    /**
     * 删除知识库
     * 
     * @param id 知识库ID
     * @return 结果
     */
    public int deleteTKnowledgeById(String id);

    /**
     * 批量删除知识库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTKnowledgeByIds(String[] ids);
}
