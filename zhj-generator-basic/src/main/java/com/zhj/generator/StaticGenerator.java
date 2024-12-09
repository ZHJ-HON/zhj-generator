package com.zhj.generator;
import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态文件生成器 此处专指无需做任何更改，只需复制的文件
 */
public class StaticGenerator {
    /**
     * 拷贝文件（Hutool工具库实现，会将输入目录完整拷贝到输出目录下）
     *
     * @param inputPath  输入路径
     * @param outputPath 输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        // 输入路径：ACM 示例代码模板目录, 注意不同系统的文件分隔符可能不同
        String inputPath = projectPath + File.separator + "zhj-generator-demo-projects" + File.separator + "acm-template";
        // 输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
        //执行复制
        copyFilesByHutool(inputPath, outputPath);
    }
}




