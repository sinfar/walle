package jxf.walle.auth.constant;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Axe
 * @date 2020/11/21
 * @description
 */
@Slf4j
public class RedisKeyConstant {
    /**
     * 分隔符
     */
    private static final String DELIMITER = ":";

    /**
     * 前缀
     */
    public final static String KEY_PREFIX = "auth";

    /**
     * 短信验证码
     */
    private final static String SMS_CODE = "SmsCode";

    /**
     * 短信验证码
     */
    private final static String RESOURCE_ROLES_MAP = "resourceRolesMap";



    /**
     * 生成短信验证码Key
     *
     * @param mobile
     * @return
     */
    public static String smsCodeKey(String mobile) {
        return toKey(SMS_CODE, mobile);
    }

    /**
     * 资源和角色映射的Key
     * @return
     */
    public static String resourceRolesMapKey() {
        return toKey(RESOURCE_ROLES_MAP);
    }

    /**
     * 获取key
     *
     * @param keyPrefix key前缀
     * @param args      参数
     * @author elvis
     * @since 2020/12/26
     */
    private static String toKey(String keyPrefix, Object... args) {
        List<String> elements = new ArrayList<>();
        elements.add(KEY_PREFIX);
        elements.add(keyPrefix);
        if (args != null) {
            if (args.length > 0) {
                for (Object arg : args) {
                    elements.add(arg.toString());
                }
            }
        } else {
            elements.add("null");
        }
        return String.join(DELIMITER, elements);
    }

    //endregion
}
