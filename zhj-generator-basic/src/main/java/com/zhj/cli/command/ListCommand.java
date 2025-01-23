package com.zhj.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine;

import java.io.File;
import java.util.List;

@CommandLine.Command(name = "list", description = "生成文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable {

    /**
     * 注意：在不同目录下打开，其根路径也不同！！！
     */
    public void run() {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "zhj-generator/zhj-generator-demo-projects/acm-template").getAbsolutePath();
        // 打印输入路径
        System.out.println(inputPath);
        // 遍历文件列表
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }

}


