import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FreeMarker 学习测试
 */
public class FreeMarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        // 去除数字中的逗号，优化观感
        configuration.setNumberFormat("0.#######");

        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        // 创建数据模型, 传递的必定是唯一对象
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2024);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://hyit.edu.cn");
        menuItem1.put("label", "淮阴工学院");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://cas.hyit.edu.cn");
        menuItem2.put("label", "综合服务门户");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);

        // 生成文件
        Writer out = new FileWriter("myweb.html");
        template.process(dataModel, out);

        // 关闭文件
        out.close();
    }
}