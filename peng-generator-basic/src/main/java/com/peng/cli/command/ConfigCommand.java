package com.peng.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.peng.model.ModelTemplateConfig;
import picocli.CommandLine;

import java.lang.reflect.Field;

@CommandLine.Command(name = "config",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{


    @Override
    public void run() {
        // 通过 hutool 的工具类，反射得到数据模型类的所有字段类型
        Field[] fields = ReflectUtil.getFields(ModelTemplateConfig.class);

        for (Field field : fields) {
            System.out.println("字段类型：" + field.getType());
            System.out.println("字段名称：" + field.getName());
        }
    }
}
