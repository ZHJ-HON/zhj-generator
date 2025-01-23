package com.zhj.cli;

import com.zhj.cli.command.ConfigCommand;
import com.zhj.cli.command.GenerateCommand;
import com.zhj.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * 命令行执行器，执行子命令，相当于一个遥控器绑定多个按钮
 */

@Command(name = "zhj", mixinStandardHelpOptions = true) // 命令工具类，开启帮助手册
public class CommandExecutor implements Runnable { // 主命令---一个执行器，相当于调用者

    private final CommandLine commandLine; // 代码块，不用重新创建对象和绑定，节省开销

    {
        commandLine = new CommandLine(this) // 执行子命令
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
     *
     * @param args
     * @return
     */
    public Integer doExecute(String[] args) { // 接收参数，执行命令类
        return commandLine.execute(args);
    }
}

