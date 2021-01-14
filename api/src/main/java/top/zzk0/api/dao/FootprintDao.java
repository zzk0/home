package top.zzk0.api.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.zzk0.api.pojo.Footprint;

@Mapper
@Repository
public interface FootprintDao extends BaseMapper<Footprint> {
}
