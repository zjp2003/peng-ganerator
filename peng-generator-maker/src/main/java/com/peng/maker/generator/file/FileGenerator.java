package com.peng.maker.generator.file;

import com.peng.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) throws TemplateException, IOException {
        DataModel data = new DataModel();
        data.setAuthor("peng");
        data.setLoop(false);
        data.setOutputText("输出结果: ");

        doGenerate(data);
    }

    /**
     * 生成模板文件（动态 + 静态）
     * @param model
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {

        // 静态文件生成

        String projectPath = System.getProperty("user.dir");
        // 整个项目根路径
        File parentPath = new File(projectPath).getParentFile();

        String inputPath = new File(parentPath,"peng-genertor-demo-projects/acm-template").getAbsolutePath();
        // String inputPath = projectPath + File.separator + "peng-genertor-demo-projects"+ File.separator + "acm-template";
        String outputPath = projectPath;

        StaticFileGenerator.copyFilesByHutool(inputPath,outputPath);

        // 动态文件生成
        // String dynamicInputPath = projectPath + File.separator + "peng-generator-basic" + File.separator +"src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/peng/acm/MainTemplate.java";

        DynamicFileGenerator.doGenerate(dynamicInputPath, dynamicOutputPath,model);
    }
}
