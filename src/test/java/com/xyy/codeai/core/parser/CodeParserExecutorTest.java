package com.xyy.codeai.core.parser;

import com.xyy.codeai.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author java_boy
 * @date 2025/8/13 14:54
 */
@SpringBootTest
class CodeParserExecutorTest {

    @Resource
    private CodeParserExecutor codeParserExecutor;

    @Test
    void executeHtmlParser() {
        String htmlContent = """
                随便写一段描述：
                ```html
              <!DOCTY؜PE html>
                <html>
                <head>
                    <title>测试页面</title>
                </head>
                <body>
                    <h1>Hello World!</h1>
                </body>
                </html>
                ```
                随便写一段描述
                """;
        Object result = codeParserExecutor.executeParser(htmlContent, CodeGenTypeEnum.HTML);
        System.out.println(result);

    }


    @Test
    void executeMultiFileParser() {
        String codeContent = """
                创建一个完整的网页：
                ```html
            <!DOCTY؜PE html>
                <html>
                <head>
                    <title>多文件示例</title>
                    <link rel="stylesheet" href="style.css">
                </head>
                <body>
                    <h1>欢迎使用</h1>
                    <script src="script.js"></script>
                </body>
                </html>
                ```
                ```css
                h1 {
                    color: blue;
                    text-align: center;
                }
                ```
                ```js
                console.log('页面加载完成');
                ```
                文件创建完成！
                """;
        Object result = codeParserExecutor.executeParser(codeContent, CodeGenTypeEnum.MULTI_FILE);
        System.out.println(result);
    }
}