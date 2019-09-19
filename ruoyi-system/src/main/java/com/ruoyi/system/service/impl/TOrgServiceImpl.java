package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TOrgMapper;
import com.ruoyi.system.domain.TOrg;
import com.ruoyi.system.service.ITOrgService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
@Service
public class TOrgServiceImpl implements ITOrgService 
{
    @Autowired
    private TOrgMapper tOrgMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TOrg selectTOrgById(String id)
    {
        return tOrgMapper.selectTOrgById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tOrg 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TOrg> selectTOrgList(TOrg tOrg)
    {
        return tOrgMapper.selectTOrgList(tOrg);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tOrg 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTOrg(TOrg tOrg)
    {
        return tOrgMapper.insertTOrg(tOrg);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tOrg 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTOrg(TOrg tOrg)
    {
        return tOrgMapper.updateTOrg(tOrg);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTOrgByIds(String ids)
    {
        return tOrgMapper.deleteTOrgByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTOrgById(String id)
    {
        return tOrgMapper.deleteTOrgById(id);
    }
}
