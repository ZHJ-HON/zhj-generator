package com.zhj.cli.command;

import com.zhj.model.MainTemplateConfig;
import cn.hutool.core.util.ReflectUtil;
import picocli.CommandLine;
import java.lang.reflect.Field;

// 输出允许用户传入的动态参数
// 反射机制---在程序运行时动态打印出对象的属性
@CommandLine.Command(name = "config", description = "配置信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {
    @Override
    public void run() {
        Field[] files = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field file : files) {
            System.out.println("字段类型" + file.getType());
            System.out.println("字段名称" + file.getName());
        }
    }
}
