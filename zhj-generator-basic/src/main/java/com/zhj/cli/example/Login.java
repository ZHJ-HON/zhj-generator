package com.zhj.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    // 设置arity参数，支持传入0到1个参数，防止误解析为选项
    // 可选交互式，不一定触发交互逻辑，便于复制粘贴
    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true, prompt = "请输入密码：")  // 设置为true。开启交互
    String password;

    @Option(names = {"-cp", "--checkPassword"}, arity = "0..1", description = "Check Password", interactive = true, prompt = "请检查密码：")
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p", "123", "-cp"); // 交互式输入（检查密码）
    }
}
