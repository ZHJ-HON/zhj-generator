package com.zhj.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.zhj.Main;
import com.zhj.generator.MainGenerator;
import com.zhj.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(name = "generate", description = "生成代码", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable {
    /**
     * 作者 （填充字符串）
     */
    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者名称", interactive = true, echo = true)
    private String author = "zhj";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出文本", interactive = true, echo = true)
    private String outputText = "输出结果：";

    /**
     * 是否开启循环
     */
    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig(); // 创建一个动态模板
        BeanUtil.copyProperties(this, mainTemplateConfig); // 复制对象属性
        MainGenerator.doGenerate(mainTemplateConfig); // 调用主生成器
        return 0;
    }
}
