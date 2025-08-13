package com.xyy.codeai.core.server;

import com.xyy.codeai.model.HtmlCodeResult;
import com.xyy.codeai.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zyf
 * @date 2025/8/13 17:11
 */
@SpringBootTest
class CodeFileSaverExecutorTest {

    @Resource
    private CodeFileSaverExecutor codeFileSaverExecutor;

    @Test
    void executeSaver() {
        HtmlCodeResult htmlCodeResult = new HtmlCodeResult();
        htmlCodeResult.setHtmlCode("test");
        File file = codeFileSaverExecutor.executeSaver(htmlCodeResult, CodeGenTypeEnum.HTML);
    }
}