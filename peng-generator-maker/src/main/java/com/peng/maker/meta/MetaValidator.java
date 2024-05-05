package com.peng.maker.meta;

import com.peng.maker.meta.Meta.ModelConfig.ModelInfo;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import com.peng.maker.meta.Meta.FileConfig.FileInfo;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.peng.maker.meta.Meta.ModelConfig;
import com.peng.maker.meta.Meta.FileConfig;
import com.peng.maker.meta.enums.FileGenerateTypeEnum;
import com.peng.maker.meta.enums.FileTypeEnum;
import com.peng.maker.meta.enums.ModelTypeEnum;

/**
 * 校验类
 */
public class MetaValidator {

    public static void doValidator(Meta meta) {

        validAndFileMetaRoot(meta);

        validAndFileConfig(meta);

        validAndModelConfig(meta);

    }

    private static void validAndModelConfig(Meta meta) {
        // modelConfig 校验和默认值
        ModelConfig modelConfig = meta.getModelConfig();
        if (modelConfig == null) {
            return;
        }
        List<ModelInfo> models = modelConfig.getModels();
        if (CollUtil.isEmpty(models)) {
            return;
        }
        for (ModelInfo modelInfo : models) {

            String fileName = modelInfo.getFileName();
            if (StrUtil.isBlank(fileName)) {
                throw new MetaException("未填写 fileName");
            }

            String modelInfoType = modelInfo.getType();
            if (StrUtil.isBlank(modelInfoType)) {
                modelInfo.setType(ModelTypeEnum.STRING.getValue());
            }
        }
    }

    private static void validAndFileConfig(Meta meta) {
        // fileConfig 校验和默认值
        FileConfig fileConfig = meta.getFileConfig();

        if (fileConfig == null) {
            return;
        }
        // sourceRootPath 必填
        String sourceRootPath = fileConfig.getSourceRootPath();
        if (StrUtil.isBlank(sourceRootPath)) {
            throw new MetaException("未填写 sourceRootPath");
        }

        // inputRootPath: .source + sourceRootPath的最后一层路径
        String defaultInputRootPath = ".source/" +
                FileUtil.getLastPathEle(Paths.get(sourceRootPath)).getFileName().toString();

        String inputRootPath = StrUtil.blankToDefault(fileConfig.getInputRootPath(),defaultInputRootPath);
        fileConfig.setInputRootPath(inputRootPath);


        String outputRootPath = StrUtil.blankToDefault(fileConfig.getOutputRootPath(),"generated") ;
        fileConfig.setOutputRootPath(outputRootPath);


        String fileConfigType = StrUtil.blankToDefault(fileConfig.getType(), FileTypeEnum.DIR.getValue()) ;
        fileConfig.setType(fileConfigType);


        List<FileInfo> fileInfoList = fileConfig.getFiles();
        if (CollUtil.isEmpty(fileInfoList)) {
            return;
        }
        for (FileInfo fileInfo : fileInfoList) {
            String inputPath = fileInfo.getInputPath();
            if (StrUtil.isBlank(inputPath)) {
                throw new MetaException("未填写 inputPath");
            }

            String outputPath = StrUtil.blankToDefault(fileInfo.getOutputPath(),inputPath) ;
            fileInfo.setOutputPath(outputPath);

            // type: 默认 inputPath 有文件后缀（比如 .java）默认为 file，否则为 dir
            String type = fileInfo.getType();
            if (StrUtil.isBlank(type)) {
                // 无文件后缀
                if (StrUtil.isBlank(FileUtil.getSuffix(type))) {
                    fileInfo.setType(FileTypeEnum.DIR.getValue());
                } else {
                    fileInfo.setType(FileTypeEnum.FILE.getValue());
                }
            }

            // generateType：文件结尾不为 ftl generateType 为 static 否则为 dynamic
            String generateType = fileInfo.getGenerateType();
            if (StrUtil.isBlank(generateType)) {
                // 文件结尾不为 ftl generateType 为 static 否则为 dynamic
                if (inputPath.endsWith(".ftl")) {
                    fileInfo.setGenerateType(FileGenerateTypeEnum.DYNAMIC.getValue());
                } else {
                    fileInfo.setGenerateType(FileGenerateTypeEnum.STATIC.getValue());
                }
            }
        }
    }

    private static void validAndFileMetaRoot(Meta meta) {
        // 基础信息校验和默认值,使用hutool工具类判断是否为空，设置默认值
        String name = StrUtil.blankToDefault(meta.getName(), "my-generator");
        String description = StrUtil.blankToDefault(meta.getDescription(), "我的模板生成器");
        String basePackage = StrUtil.blankToDefault(meta.getBasePackage(), "com.peng");
        String version = StrUtil.blankToDefault(meta.getVersion(), "1.0");
        String author = StrUtil.blankToDefault(meta.getAuthor(), "peng");
        String createTime = StrUtil.blankToDefault(meta.getCreateTime(), DateUtil.now());

        // 重新赋值
        meta.setName(name);
        meta.setDescription(description);
        meta.setBasePackage(basePackage);
        meta.setVersion(version);
        meta.setName(author);
        meta.setCreateTime(createTime);

    }
}
