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
     * @param password
     * @return
     */
    @Override
    public DevUser login(String devCode, String password) {
        DevUser user= null;
        user = mapper.getLoginUser(devCode);
        if(null!=user){
            if(user.getDevPassword().equals(password)){
                user = null;
            }
        }
        return user;
    }
}
