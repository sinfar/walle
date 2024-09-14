package jxf.walle.auth.granter;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Map;

/**
 * @author Axe
 * @date 2020/11/18
 * @description 自定义授权模式抽象类
 */
public abstract class AbstractCustomTokenGranter extends AbstractTokenGranter {

	private final OAuth2RequestFactory requestFactory;

	protected AbstractCustomTokenGranter(AuthorizationServerTokenServices tokenServices,
                                         ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory,
                                         String grantType) {
		super(tokenServices, clientDetailsService, requestFactory, grantType);
		this.requestFactory = requestFactory;
	}

	@Override
	protected OAuth2Authentication getOAuth2Authentication(ClientDetails client,
		TokenRequest tokenRequest) {
		Map<String, String> parameters = tokenRequest.getRequestParameters();
		UserDetails customUser = getUserDetails(parameters);
		if (customUser == null) {
			throw new InvalidGrantException("无法获取用户信息");
		}
		//自定义认证
		OAuth2Request storedOAuth2Request = this.requestFactory
			.createOAuth2Request(client, tokenRequest);
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
			customUser, null, customUser.getAuthorities());
		authentication.setDetails(customUser);
		OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(storedOAuth2Request,
			authentication);
		return oAuth2Authentication;
	}

	/**
	 * 抽象方法，根据参数查找相应的用户信息
	 * @param parameters 参数
	 * @return 用户详情
	 */
	protected abstract UserDetails getUserDetails(Map<String, String> parameters);
}
