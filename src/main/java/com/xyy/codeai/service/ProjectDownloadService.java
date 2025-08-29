package com.xyy.codeai.service;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author zyf
 * @date 2025/8/29 15:07
 */
public interface ProjectDownloadService {
    /**
     * 下载压缩包
     * @param projectPath 路径
     * @param downloadFileName 文件名称
     * @param response 文件流
     */
    void downloadProjectAsZip(String projectPath, String downloadFileName, HttpServletResponse response);
}
