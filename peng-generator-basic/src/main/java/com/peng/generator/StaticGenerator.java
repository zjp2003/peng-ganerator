package com.peng.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * 静态文件生成器
 */
public class StaticGenerator {
        public static void main(String[] args) {
            // 获取当前项目的根目录
            String propertyPath = System.getProperty("user.dir");
            // 输入路径
            // File.separator  系统文件分隔符
            String inputPath = propertyPath + File.separator + "peng-genertor-demo-projects"+ File.separator+"acm-template";
            // 输出路径
            String outputPath = propertyPath;

            copyFilesByRecursive(inputPath,outputPath);
        }

    /**
     * 拷贝模板文件
     * @param inputPath 输入目标文件地址
     * @param outputPath 输出结果文件路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath,outputPath,false);
    }

    /**
     * 递归拷贝目标文件
     * @param inputPath 输入目标文件地址
     * @param outputPath 输出结果文件路径
     */
    public static void copyFilesByRecursive(String inputPath, String outputPath){
        // 找到目标和结果文件
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try{
            // 复制文件方法
            copyFileByRecursive(inputFile,outputFile);
        }catch (Exception e){
            System.out.println("文件复制失败");
            e.printStackTrace();
        }
    }

    /**
     * 实现复制文件
     * @param inputFile
     * @param outputFile
     */
    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {

        // 判断是否是文件 inputFile.isDirectory()
        if (inputFile.isDirectory()){ // 目录
            // 输出目录名
            System.out.println(inputFile.getName());
            // 创建新的文件
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 判断是否是一个文件，创建目标目录
            if (!destOutputFile.exists()){
                // 创建多级目录
                destOutputFile.mkdirs();
            }
            // 获取目标目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 判断是否有目录或者文件，无子文件直接结束
            if (ArrayUtil.isEmpty(files)){
                return;
            }
            for (File file : files) {
                // 递归创建
                copyFileByRecursive(file,destOutputFile);
            }
        }else { // 文件
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(),destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }

}
