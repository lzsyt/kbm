package com.ruoyi.system.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ruoyi.system.domain.TKnownledgeSort;
import com.ruoyi.system.domain.TOrg;
import com.ruoyi.system.service.ITKnownledgeSortService;
import com.ruoyi.system.service.ITOrgService;
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
import com.ruoyi.system.domain.TKnowledge;
import com.ruoyi.system.service.ITKnowledgeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 知识库Controller
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
@Controller
@RequestMapping("/system/knowledge")
public class TKnowledgeController extends BaseController
{
    private String prefix = "system/knowledge";

    @Autowired
    private ITKnowledgeService tKnowledgeService;
    @Autowired
    private ITOrgService tOrgService;
    @Autowired
    private ITKnownledgeSortService tKnownledgeSortService;

    @RequiresPermissions("system:knowledge:view")
    @GetMapping()
    public String knowledge()
    {
        return prefix + "/knowledge";
    }

    /**
     * 查询知识库列表
     */
    @RequiresPermissions("system:knowledge:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TKnowledge tKnowledge, ModelMap modelMap) {
        modelMap.put("orgs", tKnownledgeSortService.selectTKnownledgeSortList(null));
        modelMap.put("sorts", tOrgService.getChild(tOrgService.selectTOrgList(null)));
        startPage();
        List<TKnowledge> list = tKnowledgeService.selectTKnowledgeList(tKnowledge);
        return getDataTable(list);
    }

    /**
     * 导出知识库列表
     */
    @RequiresPermissions("system:knowledge:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TKnowledge tKnowledge)
    {
        List<TKnowledge> list = tKnowledgeService.selectTKnowledgeList(tKnowledge);
        ExcelUtil<TKnowledge> util = new ExcelUtil<TKnowledge>(TKnowledge.class);
        return util.exportExcel(list, "knowledge");
    }

    /**
     * 新增知识库
     */
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        modelMap.put("orgs", tKnownledgeSortService.selectTKnownledgeSortList(null));
        modelMap.put("sorts", tOrgService.getChild(tOrgService.selectTOrgList(null)));
        return prefix + "/add";
    }

    /**
     * 新增保存知识库
     */
    @RequiresPermissions("system:knowledge:add")
    @Log(title = "知识库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TKnowledge tKnowledge, MultipartFile[] file) {
        return toAjax(tKnowledgeService.insertTKnowledge(tKnowledge,file));
    }

    /**
     * 修改知识库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        TKnowledge tKnowledge = tKnowledgeService.selectTKnowledgeById(id);
        mmap.put("tKnowledge", tKnowledge);
        String[] image = tKnowledge.getImagePath().split(",");
        List<String> imgList = new ArrayList<>(Arrays.asList(image));
        mmap.put("imgList", imgList);
        mmap.put("orgs", tKnownledgeSortService.selectTKnownledgeSortList(null));
        mmap.put("sorts", tOrgService.getChild(tOrgService.selectTOrgList(null)));
        return prefix + "/edit";
    }

    /**
     * 修改保存知识库
     */
    @RequiresPermissions("system:knowledge:edit")
    @Log(title = "知识库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TKnowledge tKnowledge, MultipartFile[] file) {

        return toAjax(tKnowledgeService.updateTKnowledge(tKnowledge,file));
    }

    /**
     * 删除知识库
     */
    @RequiresPermissions("system:knowledge:remove")
    @Log(title = "知识库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tKnowledgeService.deleteTKnowledgeByIds(ids));
    }
}
