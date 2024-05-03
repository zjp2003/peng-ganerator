package com.peng.cli.command;


import cn.hutool.core.bean.BeanUtil;
import com.peng.generator.MainGenerator;
import com.peng.model.ModelTemplateConfig;
import freemarker.template.TemplateException;
import lombok.Data;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "generate",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    /**
     * 作者
     */
    @CommandLine.Option(names = {"-a", "--author"}, description = "作者信息",arity = "0..1",interactive = true,echo = true)
    private String author = "peng";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o", "--outputText"}, description = "输出信息",arity = "0..1",interactive = true,echo = true)
    private String outputText = "sum = ";

    /**
     * 是否循环
     */
    @CommandLine.Option(names = {"-l", "--loop"}, description = "是否循环",arity = "0..1",interactive = true,echo = true)
    private boolean loop = true;


    @Override
    public Integer call() throws Exception {
        ModelTemplateConfig modelTemplateConfig = new ModelTemplateConfig();
        // 复制信息把 GenerateCommand 转成 ModelTemplateConfig
        BeanUtil.copyProperties(this, modelTemplateConfig);

        // 调用模板生成
        MainGenerator.doGenerate(modelTemplateConfig);

        return 0;
    }
}
