package jxf.walle.auth.enums;

/**
 * @author Axe
 * @date 2020/11/18
 * @description 授权方式
 */

public enum GrantType {

    /**
     * 账号密码混合登录
     */
    PWD("pwd"),

    /**
     * 短信验证码登录
     */
    SMS("sms"),

    /**
     * 邮箱验证码登录
     */
    EMAIL("email"),

    REFRESH_TOKEN("refresh_token"),

    AUTHORIZATION_CODE("authorization_code"),

    /**
     * 客户端模式
     */
    CLIENT_CREDENTIALS("client_credentials"),

    PASSWORD("password"),

    /**
     * 第三方登录授权方式
     */
    OPEN_LOGIN("open_login"),
    /**
     * 代登录
     */
    PROXY_LOGIN("proxy_login"),
    /**
     * 快捷登录
     */
    QUICK_LOGIN("quick_login");


    private String val;

    public String getVal() {
        return val;
    }

    private GrantType(String val) {
        this.val = val;
    }
}
