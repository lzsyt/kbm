package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TKnownledgeSortMapper;
import com.ruoyi.system.domain.TKnownledgeSort;
import com.ruoyi.system.service.ITKnownledgeSortService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
@Service
public class TKnownledgeSortServiceImpl implements ITKnownledgeSortService 
{
    @Autowired
    private TKnownledgeSortMapper tKnownledgeSortMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TKnownledgeSort selectTKnownledgeSortById(Integer id)
    {
        return tKnownledgeSortMapper.selectTKnownledgeSortById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tKnownledgeSort 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TKnownledgeSort> selectTKnownledgeSortList(TKnownledgeSort tKnownledgeSort)
    {
        return tKnownledgeSortMapper.selectTKnownledgeSortList(tKnownledgeSort);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tKnownledgeSort 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTKnownledgeSort(TKnownledgeSort tKnownledgeSort)
    {
        return tKnownledgeSortMapper.insertTKnownledgeSort(tKnownledgeSort);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tKnownledgeSort 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTKnownledgeSort(TKnownledgeSort tKnownledgeSort)
    {
        return tKnownledgeSortMapper.updateTKnownledgeSort(tKnownledgeSort);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTKnownledgeSortByIds(String ids)
    {
        return tKnownledgeSortMapper.deleteTKnownledgeSortByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTKnownledgeSortById(Integer id)
    {
        return tKnownledgeSortMapper.deleteTKnownledgeSortById(id);
    }
}
