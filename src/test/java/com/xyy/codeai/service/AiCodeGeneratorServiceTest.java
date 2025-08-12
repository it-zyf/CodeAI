package com.xyy.codeai.service;

import com.xyy.codeai.model.HtmlCodeResult;
import com.xyy.codeai.model.MultiFileCodeResult;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zyf
 * @date 2025/8/7 17:40
 */
@SpringBootTest
class AiCodeGeneratorServiceTest {

    @Resource
    private AiCodeGeneratorService aiCodeGeneratorService;

    @Test
    void generateHtmlCode() {
        HtmlCodeResult html = aiCodeGeneratorService.generateHtmlCode("生成一个简单的 HTML 页面");
        System.out.println(html);
    }

    @Test
    void generateMultiFileCode() {
        MultiFileCodeResult multiHtml = aiCodeGeneratorService.generateMultiFileCode("做一个程序员留言板");
        System.out.println(multiHtml);

    }
}