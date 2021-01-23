package top.zzk0.util.web;

import com.alibaba.fastjson.JSONObject;
import top.zzk0.util.constants.Constants;
import top.zzk0.util.constants.ErrorEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ResponseUtil {

    /**
     * 返回一个 data 为空对象的成功消息的 JSON
     */
    public static JSONObject successJson() {
        return successJson(new JSONObject());
    }

    /**
     * 返回成功的 JSON
     */
    public static JSONObject successJson(Object data) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", ErrorEnum.Z0000.getErrorCode());
        resultJson.put("msg", ErrorEnum.Z0000.getErrorMsg());
        resultJson.put("data", data);
        return resultJson;
    }

    /**
     * 返回错误信息 JSON
     */
    public static JSONObject errorJson(ErrorEnum errorEnum) {
        JSONObject resultJson = new JSONObject();
        resultJson.put("code", errorEnum.getErrorCode());
        resultJson.put("msg", errorEnum.getErrorMsg());
        resultJson.put("data", new JSONObject());
        return resultJson;
    }

    /**
     * 返回 JSON 给前端
     * @param response 返回体
     * @param jsonObject 返回的 json
     */
    public static void responseJson(HttpServletResponse response, JSONObject jsonObject) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
            out.flush();
            out.close();
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 返回文件给前端, copy and paste
     * @param response 返回体
     * @param file 文件
     */
    public static void responseFile(HttpServletResponse response, File file) {
        if (file.exists()) {
            response.setContentLength((int) file.length());
            String filename = file.getName();
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            response.setContentType("application/octet-stream");

            try {
                // 读文件
                BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(file));
                byte[] b = new byte[buffer.available()];
                int length = buffer.read(b);

                // 给前端
                OutputStream out = response.getOutputStream();
                out.write(b);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
