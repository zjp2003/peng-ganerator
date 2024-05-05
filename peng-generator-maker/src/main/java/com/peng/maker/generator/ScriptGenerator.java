package com.peng.maker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class ScriptGenerator {

    /**
     * 脚本生成
     * @param outputPath
     * @param jarPath
     */
    public static void doGenerator(String outputPath,String jarPath){
        StringBuilder sb = new StringBuilder();

        // linux 端脚本
        sb.append("#! /bin/bash").append("\n");
        sb.append(String.format("java -jar %s \"$@\"",jarPath)).append("\n");
        // 设置编码，和输出路径
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8),outputPath);
        // 添加可执行权限
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
        try {
            Files.setPosixFilePermissions(Paths.get(outputPath),permissions);
        } catch (Exception e) {

        }


        // windows端脚本
        // @echo off
        //java -jar target/peng-generator-basic-1.0-SNAPSHOT-jar-with-dependencies.jar %*
        sb = new StringBuilder();
        sb.append("@echo off").append("\n");
        sb.append(String.format("java -jar %s %%*",jarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8),outputPath  + ".bat");
    }
}
