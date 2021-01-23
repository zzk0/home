package top.zzk0.api.service.impl;

import org.springframework.stereotype.Service;
import top.zzk0.api.dao.FootprintDao;
import top.zzk0.api.pojo.Footprint;
import top.zzk0.api.service.FootprintService;

import java.util.Date;

@Service
public class FootprintServiceImpl implements FootprintService {

    private final FootprintDao footprintDao;

    public FootprintServiceImpl(FootprintDao footprintDao) {
        this.footprintDao = footprintDao;
    }

    /**
     * 插入一条访问记录
     * @param ip 请求的 ip
     * @param elapsedTime 经过的时间
     */
    @Override
    public void insertFootprint(String ip,
                                String url,
                                Integer elapsedTime) {
        Footprint footprint = new Footprint();
        footprint.setIp(ip);
        footprint.setUrl(url);
        footprint.setElapsedTime(elapsedTime);
        footprint.setCreateTime(new Date());

        footprintDao.insert(footprint);
    }
}
