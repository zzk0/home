package top.zzk0.util.web;

import top.zzk0.util.StringUtil;

import javax.servlet.http.HttpServletRequest;


public class HttpUtil {
    /**
     * 获取发起请求主机的ip地址
     * @param request 请求
     * @return ip 地址
     */
    public static String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (!StringUtil.isNullOrEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {

            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (!StringUtil.isNullOrEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }
}
