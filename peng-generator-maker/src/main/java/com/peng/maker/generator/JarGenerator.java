package com.peng.maker.generator;

import java.io.*;

/**
 * jar包
 */
public class JarGenerator {

    public static void doGenerator(String projectDir) throws IOException, InterruptedException {
        // 调用 Process 类执行 maven 打包命令
        String winMavenCommand = "mvn.cmd clean package -DskipTests=true";
        String otherMavenCommand = "mvn clean package -DskipTests=true";

        String mavenCommand = winMavenCommand;
        // 将字符串拆分
        ProcessBuilder processBuilder = new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        // 读取命令输出
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        int exitCode = process.waitFor();
        System.out.println("命令执行结束，退出码："+exitCode);
    }
}
