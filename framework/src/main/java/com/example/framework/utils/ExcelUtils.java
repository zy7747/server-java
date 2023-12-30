package com.example.framework.utils;

import com.alibaba.excel.EasyExcel;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Excel 工具类
 */
public class ExcelUtils {

    /**
     * 将列表以 Excel 响应给前端
     *
     * @param is   数据流
     * @param head Excel head 头
     * @param <T>  泛型，保证 head 和 data 类型的一致性
     */
    public static <T> List<T> imports(InputStream is, Class<T> head) {
        // 输出 Excel
        return EasyExcel.read(is).head(head).sheet().doReadSync();
    }

    /**
     * 将列表以 Excel 响应给前端
     *
     * @param response  响应
     * @param fileName  文件名
     * @param sheetName Excel sheet 名
     * @param head      Excel head 头
     * @param list      数据列表
     * @param <T>       泛型，保证 head 和 data 类型的一致性
     * @throws IOException 写入失败的情况
     */
    public static <T> void export(HttpServletResponse response, String fileName, String sheetName, Class<T> head, List<T> list) throws IOException {
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setCharacterEncoding("utf-8");

        // 输出 Excel
        EasyExcel.write(response.getOutputStream(), head)
                .sheet(sheetName)
                .doWrite(list);
    }
}
