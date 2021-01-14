package top.zzk0.api.service;


public interface FootprintService {

    /**
     * 插入一条访问记录
     * @param ip 请求的 ip
     * @param elapsedTime 经过的时间
     */
    void insertFootprint(String ip,
                         String url,
                         Integer elapsedTime);
}
