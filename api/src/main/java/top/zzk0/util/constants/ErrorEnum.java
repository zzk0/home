package top.zzk0.util.constants;

public enum ErrorEnum {

    // 正常
    Z0000("Z0000", "一切正常"),
    A0001("A0001", "客户端出错"),
    B0001("B0001", "服务端出错"),
    C0001("C0001", "第三方服务出错"),

    // A 开头的表示客户端调用的问题
    A0100("A0100", "缺少必填参数"),
    A0101("A0101", "请求方法出错, 检查 GET/POST 等"),
    A0102("A0102", "无法解析成 JSON"),

    // B 开头表示服务端的问题
    B0100("B0100", "空指针异常"),

    // C 开头表示第三方服务的问题
    C0100("C0100", "接口调用失败");

    private final String errorCode;

    private final String errorMsg;

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
