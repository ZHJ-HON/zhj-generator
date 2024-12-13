package com.zhj.cli.pattern;

// 命令模式五要素
// 命令（一个抽象类或接口）---（遥控器操作按钮的制作规范）
// 具体命令（遥控器的操作按钮）
// 接受者（被遥控设备）
// 调用者（遥控器）
// 客户端（人）
public interface Command {
    void execute();
}
