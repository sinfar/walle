#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis key
 *
 * @author Elvis
 * @date 2021/01/29
 */
public class RedisKey {

	//region private

	/**
	 * 分隔符
	 */
	private static final String DELIMITER = ":";

	/**
	 * 前缀
	 */
	private static final String KEY_PREFIX = "${rootArtifactId}";

	/**
	 * 获取key
	 *
	 * @param keyPrefix key前缀
	 * @param args      参数
	 * @return
	 * @author elvis
	 * @since 2020/12/26
	 */
	private static String toKey(String keyPrefix, Object... args) {
		List<String> elements = new ArrayList<>();
		elements.add(KEY_PREFIX);
		elements.add(keyPrefix);
		if (args.length > 0) {
			for (Object arg : args) {
				elements.add(arg.toString());
			}
		}
		return String.join(DELIMITER, elements);
	}

	//endregion
}
