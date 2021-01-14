package top.zzk0.util.web;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import top.zzk0.util.constants.ErrorEnum;
import top.zzk0.api.exception.ResponseException;
import top.zzk0.util.StringUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestUtil {

    /**
     * 将请求的 content 转为 json
     * @param request 请求
     */
    public static JSONObject retrieveJson(HttpServletRequest request) {
        StringBuilder jsonStr = new StringBuilder();
        try {
            ServletInputStream servletInputStream = request.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(servletInputStream));
            String line = reader.readLine();
            while (line != null) {
                jsonStr.append(line);
                line=  reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject requestJson = null;
        try {
            requestJson = JSONObject.parseObject(jsonStr.toString());
        }
        catch (JSONException jsonException) {
            throw new ResponseException(ErrorEnum.A0102);
        }
        return requestJson;
    }

    /**
     * 验证是否含有全部必填字段
     *
     * @param requiredColumns 必填的参数字段名称 逗号隔开 比如"userId,name,telephone"
     */
    public static void hasAllRequired(final JSONObject jsonObject, String requiredColumns) {
        if (!StringUtil.isNullOrEmpty(requiredColumns)) {
            //验证字段非空
            String[] columns = requiredColumns.split(",");
            String missCol = "";
            for (String column : columns) {
                Object val = jsonObject.get(column.trim());
                if (StringUtil.isNullOrEmpty(val)) {
                    missCol += column + "  ";
                }
            }
            if (!StringUtil.isNullOrEmpty(missCol)) {
                jsonObject.clear();
                jsonObject.put("code", ErrorEnum.A0100.getErrorCode());
                jsonObject.put("msg",  ErrorEnum.A0100.getErrorMsg() + " : " + missCol.trim());
                jsonObject.put("data", new JSONObject());
                throw new ResponseException(jsonObject);
            }
        }
    }
}
