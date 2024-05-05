package com.peng.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.peng.maker.generator.JarGenerator;
import com.peng.maker.generator.ScriptGenerator;
import com.peng.maker.generator.file.DynamicFileGenerator;
import com.peng.maker.meta.Meta;
import com.peng.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator extends GenerateTemplate{

    @Override
    protected void buildeDist(String outputPath, String shellOutputPath, String jarPath, String sourceCopyDestPath) {
        System.out.println("不生成 dist");
    }

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        /*Meta meteObject = MetaManager.getMeteObject();
        System.out.println(meteObject);

        // 输出根路径
        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generated" + File.separator + meteObject.getName();
        // 判断是否存在 不存在则创建
        if (!FileUtil.exist(outputPath)){
            FileUtil.mkdir(outputPath);
        }
        // 从原始模板文件路径复制到生成的代码中
        String sourceRootPath = meteObject.getFileConfig().getSourceRootPath();
        String sourceCopyDestPath = outputPath + File.separator + ".source";
        FileUtil.copy(sourceRootPath,sourceCopyDestPath,false);

        // 读取 resources 目录
        ClassPathResource classPathResource = new ClassPathResource("");
        // 输入路径的绝对路径
        String inputResourcePath = classPathResource.getAbsolutePath();

        // java包路径
        String outputBasePackage = meteObject.getBasePackage();
        String outputBasePackagePath =  StrUtil.join("/",StrUtil.split(outputBasePackage,"."));

        String outputBaseJavaPackagePath = outputPath + File.separator + "src/main/java/"+ outputBasePackagePath ;

        String inputFilePath;
        String outputFilePath;

        // model.DataModel
        inputFilePath = inputResourcePath + File.separator + "templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/model/DataModel.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.GenerateCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.ConfigCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.ListCommand
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // cli.command.CommandExecutor
        inputFilePath = inputResourcePath + File.separator + "templates/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // Main
        inputFilePath = inputResourcePath + File.separator + "templates/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/Main.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // generator/DynamicGenerator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/DynamicGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/generator/DynamicGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // generator/MainGenerator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/MainGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/generator/MainGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // generator/StaticGenerator
        inputFilePath = inputResourcePath + File.separator + "templates/java/generator/StaticGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath + "/generator/StaticGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // pom.xml
        inputFilePath = inputResourcePath + File.separator + "templates/pom.xml.ftl";
        outputFilePath = outputPath+ File.separator + "/pom.xml";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // 生成 README.md 项目介绍文件
        inputFilePath = inputResourcePath + File.separator + "templates/README.md.ftl";
        outputFilePath = outputPath+ File.separator + "/README.md";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meteObject);

        // 构建 jar 包
        JarGenerator.doGenerator(outputPath);

        // 封装脚本
        String shellOutputPath = outputPath + File.separator + "generator";
        String jarName = String.format("%s-%s-jar-with-dependencies.jar", meteObject.getName(), meteObject.getVersion());
        String jarPath = "target/"+jarName;
        ScriptGenerator.doGenerator(shellOutputPath,jarPath);

        // 生成精简版的程序（产物包）
        String distOutputPath = outputPath + "-dest";
        // 拷贝 jar 包
        String targetPath = distOutputPath + File.separator + "target";
        FileUtil.mkdir(targetPath);
        String jarAbsolutePath = outputPath + File.separator + jarPath;
        FileUtil.copy(jarAbsolutePath,targetPath,true);
        // 拷贝 脚本
        FileUtil.copy(shellOutputPath,distOutputPath,true);
        FileUtil.copy(shellOutputPath + ".bat",distOutputPath,true);
        // 拷贝 原始模板
        FileUtil.copy(sourceCopyDestPath,distOutputPath,true);*/
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();

    }
}
