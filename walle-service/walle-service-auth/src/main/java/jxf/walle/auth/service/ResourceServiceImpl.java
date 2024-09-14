package jxf.walle.auth.service;

import jxf.walle.auth.constant.RedisKeyConstant;
import jxf.walle.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 资源与角色匹配关系管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class ResourceServiceImpl {

    private Map<String, List<String>> resourceRolesMap;
    @Autowired
    private RedisClient redisClent;

    @PostConstruct
    public void initData() {
        resourceRolesMap = new TreeMap<>();
        resourceRolesMap.put("/user/hello", Arrays.asList("ADMIN"));
        resourceRolesMap.put("/user/user/currentUser", Arrays.asList("ADMIN", "TEST"));

        String redisKey = RedisKeyConstant.resourceRolesMapKey();
        redisClent.hSet(redisKey, resourceRolesMap);
    }
}
