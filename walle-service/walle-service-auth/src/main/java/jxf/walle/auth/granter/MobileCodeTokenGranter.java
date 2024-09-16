package jxf.walle.auth.granter;

import jxf.walle.auth.service.UserServiceImpl;
import jxf.walle.common.exception.BaseErrorCode;
import jxf.walle.common.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.Map;

/**
 * @author Axe
 * @date 2020/11/18
 * @description 手机验证码授权模式
 */
@Slf4j
public class MobileCodeTokenGranter extends AbstractCustomTokenGranter {

	/**
	 * 中国区号
	 */
	public final static String MOBILE_PREFIX_CN = "86";

	/**
	 * 分隔符
	 */
	public final static String MOBILE_SPLIT = " ";

	private UserServiceImpl userService;

	public MobileCodeTokenGranter(UserServiceImpl userService,
                                  AuthorizationServerTokenServices tokenServices,
                                  ClientDetailsService clientDetailsService,
                                  OAuth2RequestFactory requestFactory) {
		super(tokenServices, clientDetailsService, requestFactory, "sms");
		this.userService = userService;
	}

	@Override
	protected UserDetails getUserDetails(Map<String, String> parameters) {

		String mobile = parameters.get("mobile");
		String code = parameters.get("code");
		if (mobile == null) {
			throw new BizException(BaseErrorCode.ILLEGAL_ARGUMENT.getCode(), "手机号码不能为空");
		}

		if (code == null) {
			throw new BizException(BaseErrorCode.ILLEGAL_ARGUMENT.getCode(), "验证码不能为空");
		}

		return userService.loadUserByMobile(mobile);
	}
}
