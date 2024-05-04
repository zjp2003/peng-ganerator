package ${basePackage}.cli.command;


import cn.hutool.core.bean.BeanUtil;
import ${basePackage}.generator.file.FileGenerator;
import ${basePackage}.model.DataModel;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "generate",mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {

    <#list modelConfig.models as modelInfo>

        <#if modelInfo.description??>
        /**
         * ${modelInfo.description}
         */
        </#if>
        @CommandLine.Option(names = {<#if modelInfo.addr??>"${modelInfo.addr}",</#if> "--${modelInfo.fileName}"}, <#if modelInfo.description??>description = "${modelInfo.description}"，</#if>arity = "0..1",interactive = true,echo = true)
        private ${modelInfo.type} ${modelInfo.fileName} <#if modelInfo.defaultValue??>= "${modelInfo.defaultValue?c}"</#if>;
    </#list>

    @Override
    public Integer call() throws Exception {
        DataModel dataModel = new DataModel();
        // 复制信息把 GenerateCommand 转成 ModelTemplateConfig
        BeanUtil.copyProperties(this, dataModel);

        // 调用模板生成
        FileGenerator.doGenerate(dataModel);

        return 0;
    }
}