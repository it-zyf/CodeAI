package com.xyy.codeai.core.parser;

import com.xyy.codeai.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 代码解析执行器
 * 根据代码生成类型执行相应的解析逻辑
 *
 * @author java_boy
 */
@Service
public class CodeParserExecutor {

    @Resource
    private List<CodeParser> codeParsers;

    /**
     * 执行代码解析
     *
     * @param codeContent 代码内容
     * @param codeGenType 代码生成类型
     * @return 解析结果（HtmlCodeResult 或 MultiFileCodeResult）
     */
    public Object executeParser(String codeContent, CodeGenTypeEnum codeGenType) {
        return codeParsers.stream().filter(codeParser -> Objects.equals(codeParser.getType(), codeGenType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("未找到对应支付方式"))
                .parseCode(codeContent);
    }
}
