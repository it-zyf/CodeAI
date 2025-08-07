package com.xyy.codeai.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

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
        String html = aiCodeGeneratorService.generateHtmlCode("生成一个简单的 HTML 页面");
        System.out.println(html);
    }

    @Test
    void generateMultiFileCode() {
        String multiHtml = aiCodeGeneratorService.generateMultiFileCode("做一个程序员留言板");
        System.out.println(multiHtml);

    }
}