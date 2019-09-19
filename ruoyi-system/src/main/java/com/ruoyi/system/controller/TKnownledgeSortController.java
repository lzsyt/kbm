package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.system.domain.TOrg;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TKnownledgeSort;
import com.ruoyi.system.service.ITKnownledgeSortService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
@Controller
@RequestMapping("/system/sort")
public class TKnownledgeSortController extends BaseController
{
    private String prefix = "system/sort";

    @Autowired
    private ITKnownledgeSortService tKnownledgeSortService;


    @RequestMapping("get")
    @ResponseBody
    public List<TKnownledgeSort> getOrg(){
        return tKnownledgeSortService.selectTKnownledgeSortList(null);
    }

    @RequiresPermissions("system:sort:view")
    @GetMapping()
    public String sort()
    {
        return prefix + "/sort";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:sort:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TKnownledgeSort tKnownledgeSort)
    {
        startPage();
        List<TKnownledgeSort> list = tKnownledgeSortService.selectTKnownledgeSortList(tKnownledgeSort);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:sort:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TKnownledgeSort tKnownledgeSort)
    {
        List<TKnownledgeSort> list = tKnownledgeSortService.selectTKnownledgeSortList(tKnownledgeSort);
        ExcelUtil<TKnownledgeSort> util = new ExcelUtil<TKnownledgeSort>(TKnownledgeSort.class);
        return util.exportExcel(list, "sort");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @RequiresPermissions("system:sort:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TKnownledgeSort tKnownledgeSort)
    {
        return toAjax(tKnownledgeSortService.insertTKnownledgeSort(tKnownledgeSort));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        TKnownledgeSort tKnownledgeSort = tKnownledgeSortService.selectTKnownledgeSortById(id);
        mmap.put("tKnownledgeSort", tKnownledgeSort);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:sort:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TKnownledgeSort tKnownledgeSort)
    {
        return toAjax(tKnownledgeSortService.updateTKnownledgeSort(tKnownledgeSort));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:sort:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tKnownledgeSortService.deleteTKnownledgeSortByIds(ids));
    }
}
