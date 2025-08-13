package com.xyy.codeai.core.parser;

import com.xyy.codeai.model.enums.CodeGenTypeEnum;

/**
 * 代码解析器策略接口
 * 
 * @author yupi
 */
public interface CodeParser{

    /**
     * 解析代码内容
     * 
     * @param codeContent 原始代码内容
     * @return 解析后的结果对象
     */
    Object parseCode(String codeContent);


    /**
     * 获取解析器
     * @return
     */
    CodeGenTypeEnum getType();

}
