package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 t_knowledge_map
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
public class TKnowledgeMap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String knowledgeId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String numIid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setKnowledgeId(String knowledgeId) 
    {
        this.knowledgeId = knowledgeId;
    }

    public String getKnowledgeId() 
    {
        return knowledgeId;
    }
    public void setNumIid(String numIid) 
    {
        this.numIid = numIid;
    }

    public String getNumIid() 
    {
        return numIid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("knowledgeId", getKnowledgeId())
            .append("numIid", getNumIid())
            .toString();
    }
}
