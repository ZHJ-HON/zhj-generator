package com.zhj;

import com.zhj.cli.CommandExecutor;
import com.zhj.cli.pattern.Command;

/**
 * 命令执行器
 */
public class Main {
    public static void main(String[] args) {
        // args = new String[]{"generate", "-l", "-a", "-o"}; // 测试样例
        // args = new String[]{"list"}; // 测试样例
        // args = new String[]{"config"}; // 测试样例
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
