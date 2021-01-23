package top.zzk0.api.exception;

import com.alibaba.fastjson.JSONObject;
import top.zzk0.util.constants.ErrorEnum;
import top.zzk0.util.web.ResponseUtil;

public class ResponseException extends RuntimeException {

    private final JSONObject resultJson;

    /**
     * 调用时可以在任何代码处直接throws这个Exception,
     * 都会统一被拦截,并封装好json返回给前台
     *
     * @param errorEnum 以错误的ErrorEnum做参数
     */
    public ResponseException(ErrorEnum errorEnum) {
        this.resultJson = ResponseUtil.errorJson(errorEnum);
    }

    public ResponseException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }

    public JSONObject getResultJson() {
        return resultJson;
    }
}
