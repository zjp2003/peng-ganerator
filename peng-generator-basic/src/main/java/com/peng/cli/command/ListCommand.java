package com.peng.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

/**
 * 遍历所有文件
 */
@CommandLine.Command(name = "list",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{


    @Override
    public void run() {
        String property = System.getProperty("user.dir");
        // 得到项目根文件
        File parentFile = new File(property).getParentFile();

        String inputPath = new File(parentFile, "peng-genertor-demo-projects/acm-template").getAbsolutePath();
        // 遍历该路径下的所有文件列表
        List<File> files = FileUtil.loopFiles(inputPath);

        for (File file : files) {
            // 输出文件信息
            System.out.println(file);
        }
    }
}
