package top.zzk0.api.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzk0.util.constants.ErrorEnum;
import top.zzk0.util.web.ResponseUtil;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public JSONObject defaultErrorHandler(HttpServletRequest req, Exception e) {
        String errorPosition = "";
        //如果错误堆栈信息存在
        if (e.getStackTrace().length > 0) {
            StackTraceElement element = e.getStackTrace()[0];
            String fileName = element.getFileName() == null ? "未找到错误文件" : element.getFileName();
            int lineNumber = element.getLineNumber();
            errorPosition = fileName + ":" + lineNumber;
        }
        JSONObject jsonObject = new JSONObject();
        JSONObject errorObject = new JSONObject();
        errorObject.put("errorLocation", e.toString() + "    错误位置:" + errorPosition);
        jsonObject.put("info", errorObject);
        return jsonObject;
    }

    /**
     * GET/POST请求方法错误的拦截器
     * 因为开发时可能比较常见,而且发生在进入 controller 之前,上面的拦截器拦截不到这个错误
     * 所以定义了这个拦截器
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JSONObject httpRequestMethodHandler() {
        return ResponseUtil.errorJson(ErrorEnum.A0101);
    }

    /**
     * 本系统自定义错误的拦截器
     * 拦截到此错误之后,就返回这个类里面的json给前端
     * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
     */
    @ExceptionHandler(ResponseException.class)
    public JSONObject commonJsonExceptionHandler(ResponseException responseException) {
        return responseException.getResultJson();
    }

    /**
     * controller 无法把前端传来的数据解析成 json
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JSONObject httpMessageNotReadableException() {
        return ResponseUtil.errorJson(ErrorEnum.A0102);
    }
}

