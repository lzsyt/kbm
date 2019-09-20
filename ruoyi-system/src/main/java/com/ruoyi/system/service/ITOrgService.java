package com.ruoyi.system.service;

import com.ruoyi.system.domain.TOrg;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
public interface ITOrgService 
{


    public List<TOrg> getChild(List<TOrg> orgs);


    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TOrg selectTOrgById(String id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tOrg 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TOrg> selectTOrgList(TOrg tOrg);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tOrg 【请填写功能名称】
     * @return 结果
     */
    public int insertTOrg(TOrg tOrg);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tOrg 【请填写功能名称】
     * @return 结果
     */
    public int updateTOrg(TOrg tOrg);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTOrgByIds(String ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTOrgById(String id);
}
