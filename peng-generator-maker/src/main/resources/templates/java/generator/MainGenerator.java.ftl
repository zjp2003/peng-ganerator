package ${basePackage}.generator;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成模板文件（动态 + 静态）
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {

        String inputRoodPath = "${fileConfig.inputRootPath}";
        String outputRoodPath = "${fileConfig.outputRootPath}";

        String inputPath;
        String outputPath;

        // 静态文件生成
<#list fileConfig.files as fileInfo>
        inputPath = new File(inputRoodPath,"${fileInfo.inputPath}").getAbsolutePath();
        outputPath = new File(outputRoodPath,"${fileInfo.outputPath}").getAbsolutePath();;
    <#if fileInfo.generateType == "static">
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);
    <#else >
        DynamicGenerator.doGenerate(inputPath, outputPath,model);
    </#if>

</#list>
    }
}
