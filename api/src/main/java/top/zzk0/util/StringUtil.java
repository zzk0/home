package top.zzk0.util;

public class StringUtil {

    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }

    /**
     * 获取扩展名
     * @param filename 字符串类型的文件名字
     * @return 后缀名
     */
    public static String getExtensionName(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }
}
