package com.xyy.codeai.core.server;

import com.xyy.codeai.exception.BusinessException;
import com.xyy.codeai.exception.ErrorCode;
import com.xyy.codeai.model.HtmlCodeResult;
import com.xyy.codeai.model.MultiFileCodeResult;
import com.xyy.codeai.model.enums.CodeGenTypeEnum;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * 代码文件保存执行器
 * 根据代码生成类型执行相应的保存逻辑
 *
 * @author yupi
 */
@Service
public class CodeFileSaverExecutor {

    private static final Map<CodeGenTypeEnum, Function<Object, File>> REGISTER_MAP = new HashMap<>();

    private static final HtmlCodeFileSaverTemplate htmlCodeFileSaver = new HtmlCodeFileSaverTemplate();

    private static final MultiFileCodeFileSaverTemplate multiFileCodeFileSaver = new MultiFileCodeFileSaverTemplate();


    @PostConstruct
    public void register() {
        REGISTER_MAP.put(CodeGenTypeEnum.HTML, codeResult -> htmlCodeFileSaver.saveCode((HtmlCodeResult) codeResult));
        REGISTER_MAP.put(CodeGenTypeEnum.MULTI_FILE, codeResult -> multiFileCodeFileSaver.saveCode((MultiFileCodeResult) codeResult));
    }


    /**
     * 执行代码保存
     *
     * @param codeResult  代码结果对象
     * @param codeGenType 代码生成类型
     * @return 保存的目录
     */
    public  File executeSaver(Object codeResult, CodeGenTypeEnum codeGenType) {
        Function<Object, File> function = REGISTER_MAP.get(codeGenType);
        if (function == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return function.apply(codeResult);
    }
}
