package com.zhj;

import com.zhj.cli.CommandExecutor;
import com.zhj.cli.pattern.Command;

public class Main {
    public static void main(String[] args) {
        // args = new String[]{"generate", "-l", "-a", "-o"}; // 测试样例
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}
