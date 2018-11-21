package cn.appsys.dao.devuser;

import cn.appsys.pojo.DevUser;
import org.springframework.web.bind.annotation.RequestParam;

public interface DevUserMapper {
    public DevUser getLoginUser(@RequestParam String devCode);
}
