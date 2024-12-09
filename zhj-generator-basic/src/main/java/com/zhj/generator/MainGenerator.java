package com.zhj.generator;

import com.zhj.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    // 开始生成
    public static void doGenerate(Object model) throws TemplateException, IOException {
        // 获取项目的根路径
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "zhj-generator-demo-projects" + File.separator + "acm-template";
        // 输出路径
        String outputPath = projectPath;

        // 生成静态文件（复制所有现存目录）
        StaticGenerator.copyFilesByHutool(inputPath, outputPath);

        // 生成动态文件（在原有基础上对需要改变的进行动态覆盖）
        // 模板+源文件生成
        String inputDynamicFilePath = projectPath + File.separator + "zhj-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath,model);
    }

    public static void main(String[] args) throws TemplateException, IOException{
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("zhj");
        mainTemplateConfig.setOutputText("成功输出：");
        mainTemplateConfig.setLoop(false);
        doGenerate(mainTemplateConfig);
    }
}
