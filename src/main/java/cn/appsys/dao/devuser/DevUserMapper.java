package cn.appsys.dao.devuser;

import cn.appsys.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {
    public DevUser getLoginUser(@Param("devCode")String devCode);
}
