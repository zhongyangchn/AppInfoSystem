package cn.appsys.service.developer;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class DevUserServiceImple implements DevUserService {
    @Resource
    private DevUserMapper mapper;
    /**
     * 登陆验证
     * @param devCode
     * @param devPassword
     * @return
     */
    @Override
    public DevUser login(String devCode, String devPassword) {
        DevUser user=  null ;
        user = mapper.getLoginUser(devCode);
        if(null!=user){
            if(!user.getDevPassword().equals(devPassword))
                user = null;
        }
        return user;
    }
}
