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

public class FreeMarkerTest {


    @Test
    public void test() throws IOException, TemplateException {
        // new 出 configuration 对象,参数为 FreeMarker 版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件所在路径
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        // 设置模板文件使用的字符集
        cfg.setDefaultEncoding("UTF-8");
        // 指定数字格式
        cfg.setNumberFormat("0.######");

        // 创建模板对象,加载指定模板
        Template template = cfg.getTemplate("myweb.html.ftl");

        // 数据模型
        HashMap<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear",2023);
        List<Map<String,Object>> menuItems = new ArrayList<>();

        HashMap<String, Object> menuItems1 = new HashMap<>();
        menuItems1.put("url","https://github.com");
        menuItems1.put("label","github");

        HashMap<String, Object> menuItems2 = new HashMap<>();
        menuItems2.put("url","https://baidu.com");
        menuItems2.put("label","baidu");

        menuItems.add(menuItems1);
        menuItems.add(menuItems2);

        dataModel.put("menuItems", menuItems);

        // 调用在根目录下生成此文件
        Writer out = new FileWriter("myweb.html");

        template.process(dataModel,out);

        out.close();
    }
}
