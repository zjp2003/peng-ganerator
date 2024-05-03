package com.peng.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {

    @Option(names = {"-u","--user"},description = "User name")
    String user;

    /**
     * names 交互方式
     * description 描述
     * interactive 是否交互
     * echo 控制参数是否显示
     * prompt 提示词
     * arity = "0..1"（ 0 到 1 个参数） 可以选择填参数也可以交互式输入
     * defaultValue 默认值
     */
    @Option(names = {"-p","--password"},description = "Passphrase",interactive = true,arity = "0..1", prompt = "请输入密码")
    String password;


    @Override
    public Integer call() throws Exception {
        System.out.println("password = " + password);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u","-p");
    }
}
