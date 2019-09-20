package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.*;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TKnowledgeMapper;
import com.ruoyi.system.domain.TKnowledge;
import com.ruoyi.system.service.ITKnowledgeService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.web.multipart.MultipartFile;

/**
 * 知识库Service业务层处理
 * 
 * @author ruoyi
 * @date 2019-09-19
 */
@Service
public class TKnowledgeServiceImpl implements ITKnowledgeService 
{
    @Autowired
    private TKnowledgeMapper tKnowledgeMapper;


    private static final String[] VDOTYPE = {"mp4","avi"};
    private static final String[] DOCTYPE = {"doc","docx","ppt"};
    private static final String[] IMATYPE = {"jpg","png","gif"};
    private static final String FILEBASEPATH = "res/kbm/";

    //判断是否为图片
    private boolean isImg(String suffix){
        boolean flag = false;
        for (int i = 0; i < IMATYPE.length; i++) {
            if (IMATYPE[i].equalsIgnoreCase(suffix)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    //判断是否为文档
    private boolean isDoc(String suffix){
        boolean flag = false;
        for (int i = 0; i < DOCTYPE.length; i++) {
            if (DOCTYPE[i].equalsIgnoreCase(suffix)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    //判断是否为视频
    private boolean isVdo(String suffix){
        boolean flag = false;
        for (int i = 0; i < VDOTYPE.length; i++) {
            if (VDOTYPE[i].equalsIgnoreCase(suffix)){
                flag = true;
                break;
            }
        }
        return flag;
    }


    private Map<String, String> getFilePathAndFileUpload(MultipartFile[] file) throws IOException {
        Map<String, String> filePathMap = new HashMap<>();
        //遍历文件
        for (int i = 0; i < file.length; i++) {
            //获取文件类型
            String suffix = file[i].getOriginalFilename().substring(file[i].getOriginalFilename().lastIndexOf(".") + 1);

            if (isImg(suffix)){                 //判断是否为图片
                setImgPath(file[i], filePathMap);
            }else if (isDoc(suffix)){           //判断是否为文档
                setDocPath(file[i], filePathMap);
            }else if (isVdo(suffix)){           //判断是否为视频
                setVdoPath(file[i], filePathMap);
            }else {
                System.out.println("文件格式不符合要求");
            }
        }
        return filePathMap;
    }

    private void setDocPath(MultipartFile file, Map<String, String> filePathMap) throws IOException {
        filePathMap.put("doc", FileUploadUtils.upload(FILEBASEPATH, file));
    }

    private void setVdoPath(MultipartFile file, Map<String, String> filePathMap) throws IOException {
        filePathMap.put("vdo", FileUploadUtils.upload(FILEBASEPATH, file));
    }

    private void setImgPath(MultipartFile file, Map<String, String> filePathMap) throws IOException {
        if (StringUtils.isEmpty(filePathMap.get("img"))){
            filePathMap.put("img", FileUploadUtils.upload(FILEBASEPATH, file));
        }else{
            filePathMap.put(filePathMap.get("img"), "," + FileUploadUtils.upload(FILEBASEPATH, file));
        }
    }

    private void setFilePath(TKnowledge tKnowledge, MultipartFile[] file) {
        Map<String, String> map = null;
        try {
            map = getFilePathAndFileUpload(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tKnowledge.setImagePath(map.get("img"));
        tKnowledge.setDocPath(map.get("doc"));
        tKnowledge.setVideoPath(map.get("vdo"));
    }

    /**
     * 查询知识库
     * 
     * @param id 知识库ID
     * @return 知识库
     */
    @Override
    public TKnowledge selectTKnowledgeById(String id)
    {
        return tKnowledgeMapper.selectTKnowledgeById(id);
    }

    /**
     * 查询知识库列表
     * 
     * @param tKnowledge 知识库
     * @return 知识库
     */
    @Override
    public List<TKnowledge> selectTKnowledgeList(TKnowledge tKnowledge)
    {
        return tKnowledgeMapper.selectTKnowledgeList(tKnowledge);
    }

    /**
     * 新增知识库
     * 
     * @param tKnowledge 知识库
     * @param file  文件上传
     * @return 结果
     */
    @Override
    public int insertTKnowledge(TKnowledge tKnowledge, MultipartFile[] file)
    {
        tKnowledge.setId(String.valueOf(System.currentTimeMillis()));
        setFilePath(tKnowledge, file);
        return tKnowledgeMapper.insertTKnowledge(tKnowledge);
    }

    /**
     * 修改知识库
     * 
     * @param tKnowledge 知识库
     * @param file 文件上传
     * @return 结果
     */
    @Override
    public int updateTKnowledge(TKnowledge tKnowledge, MultipartFile[] file)
    {
        setFilePath(tKnowledge, file);
        return tKnowledgeMapper.updateTKnowledge(tKnowledge);
    }



    /**
     * 删除知识库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTKnowledgeByIds(String ids)
    {
        return tKnowledgeMapper.deleteTKnowledgeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除知识库信息
     * 
     * @param id 知识库ID
     * @return 结果
     */
    public int deleteTKnowledgeById(String id)
    {
        return tKnowledgeMapper.deleteTKnowledgeById(id);
    }
}
