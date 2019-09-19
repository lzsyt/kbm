package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.TKnowledgeMap;
import com.ruoyi.system.service.ITKnowledgeMapService;
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
@RequestMapping("/system/map")
public class TKnowledgeMapController extends BaseController
{
    private String prefix = "system/map";

    @Autowired
    private ITKnowledgeMapService tKnowledgeMapService;

    @RequiresPermissions("system:map:view")
    @GetMapping()
    public String map()
    {
        return prefix + "/map";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:map:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TKnowledgeMap tKnowledgeMap)
    {
        startPage();
        List<TKnowledgeMap> list = tKnowledgeMapService.selectTKnowledgeMapList(tKnowledgeMap);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:map:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TKnowledgeMap tKnowledgeMap)
    {
        List<TKnowledgeMap> list = tKnowledgeMapService.selectTKnowledgeMapList(tKnowledgeMap);
        ExcelUtil<TKnowledgeMap> util = new ExcelUtil<TKnowledgeMap>(TKnowledgeMap.class);
        return util.exportExcel(list, "map");
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
    @RequiresPermissions("system:map:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TKnowledgeMap tKnowledgeMap)
    {
        return toAjax(tKnowledgeMapService.insertTKnowledgeMap(tKnowledgeMap));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TKnowledgeMap tKnowledgeMap = tKnowledgeMapService.selectTKnowledgeMapById(id);
        mmap.put("tKnowledgeMap", tKnowledgeMap);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:map:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TKnowledgeMap tKnowledgeMap)
    {
        return toAjax(tKnowledgeMapService.updateTKnowledgeMap(tKnowledgeMap));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:map:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tKnowledgeMapService.deleteTKnowledgeMapByIds(ids));
    }
}
