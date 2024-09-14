package jxf.walle.auth.service;

import jxf.walle.auth.constant.RedisKeyConstant;
import jxf.walle.auth.dto.SecurityUser;
import jxf.walle.auth.dto.UserDTO;
import jxf.walle.auth.dto.VerifySmsCodeDTO;
import jxf.walle.common.exception.BizException;
import jxf.walle.redis.RedisClient;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * 用户管理业务类
 * Created by macro on 2020/6/19.
 */
@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private RedisClient redisClient;

    private List<UserDTO> userList;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserDTO(1L,"macro", password,"13538249629", true, Arrays.asList("ADMIN")));
        userList.add(new UserDTO(2L,"andy", password,"13538249628",true, Arrays.asList("TEST")));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(username)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(findUserList)) {
            throw new UsernameNotFoundException("未找到用户");
        }
        SecurityUser securityUser = new SecurityUser(findUserList.get(0));
        if (!securityUser.isEnabled()) {
            throw new DisabledException("账号不可用");
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException("账号被锁");
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException("账号失效");
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("密码失效");
        }
        return securityUser;
    }

    /**
     * 短信验证码方式
     *
     * @param dto
     * @return
     */
    public UserDetails loadUserByMobile(String mobile) {
        List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(mobile)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(findUserList)) {
            throw new UsernameNotFoundException("未找到用户");
        }
        SecurityUser securityUser = new SecurityUser(findUserList.get(0));
        if (!securityUser.isEnabled()) {
            throw new DisabledException("账号不可用");
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException("账号被锁");
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException("账号失效");
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException("密码失效");
        }
        return securityUser;
    }

    /**
     * 检查验证码
     * @param code
     */
    private boolean checkCode(String code, String mobile) {
        String redisKey = RedisKeyConstant.smsCodeKey(mobile);
        Object value = redisClient.get(redisKey);
        if (value != null && value.equals(code)) {
            redisClient.delete(redisKey);
            return true;
        }
        return false;
    }


}
