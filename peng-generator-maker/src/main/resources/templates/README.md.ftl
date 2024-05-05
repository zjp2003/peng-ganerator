# ${name}

> ${description}
>
> 作者：${author}
>
> 基于 peng 的 [Code生成器](https://github.com/zjp2003/peng-ganerator)制作

可以通过命令行交互输入的方式动态生成想要的项目代码

## 使用说明

执行项目根目录下的脚本文件：
```
generator <命令> <选项参数>
```

示例命令:

```
generator generate <#list modelConfig.models as modelInfo>-${modelInfo.addr} </#list>
```

## 参数说明
<#list modelConfig.models as modelInfo>
    ${modelInfo?index + 1}) ${modelInfo.fileName}
    类型：${modelInfo.type}
    描述：${modelInfo.description}
    默认值：${modelInfo.defaultValue?c}
    缩写：${modelInfo.addr}


</#list>




