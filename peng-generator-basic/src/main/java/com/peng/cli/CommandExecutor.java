package com.peng.cli;

import com.peng.cli.command.ConfigCommand;
import com.peng.cli.command.GenerateCommand;
import com.peng.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * 客户端，实际执行命令的
 */
@Command(name = "peng",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }


    @Override
    public void run() {
        // 不输入子命令时，给出提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public Integer doExecutor(String[] args){
        return commandLine.execute(args);
    }
}
