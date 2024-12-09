package com.zhj.model;

import lombok.Data;

/**
 * 静态模板配置
 */
@Data
public class MainTemplateConfig {

    // 1.在代码开头增加作者注释（@Author）
    // 2.修改程序输出的信息提示
    // 3.将循环次数改为可选（开关）
    /**
     * 作者 （填充字符串）
     */
    private String author = "zhj";

    /**
     * 输出信息
     */
    private String outputText = "输出结果：";

    /**
     * 是否开启循环
     */
    private boolean loop;

}
