package com.sjl.api;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

/**
 * @author songjilong
 * @date 2020/7/5 22:00
 */
public class Main {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("F:\\Desktop\\project\\book-manage\\springboot-demo");
        // 项目名称
        config.setProjectName("springboot-demo");
        // 声明该API的版本
        config.setApiVersion("V1.4");
        // 生成API 文档所在目录
        config.setDocsPath("F:\\Desktop\\project\\book-manage\\springboot-demo\\src\\main\\resources\\api");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 执行生成文档
        Docs.buildHtmlDocs(config);
    }
}
