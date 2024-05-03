package com.peng.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
// some exports omitted for the sake of brevity

/**
 * mixinStandardHelpOptions 帮助手册
 */
@Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    // Option 解析选项
    @Option(names = {"-s", "--font-size"}, description = "Font size")
    int fontSize = 19;

    // Parameters 解析参数
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = {"Hello,", "picocli"};

    @Override
    public void run() {
        // The business logic of the command goes here...
        // In this case, code for generation of ASCII art graphics
        // (omitted for the sake of brevity).
        System.out.println("fontSize: " + fontSize);
        System.out.println("words: " + String.join(",",words));
    }

    public static void main(String[] args) {
        //  CommandLine 命令行工具
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}