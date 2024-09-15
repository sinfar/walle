#set($symbol_pound='#')
#set($symbol_dollar='$')
#set($symbol_escape='\' )
package ${package}.util;

import com.isay.starter.mybatis.CodeGenerator;

/**
 * 调用代码生成器
 *
 * @author Axe
 * @date 2020/6/8
 */
public class MybatisUtil {

	public static void main(String[] args) {

		/** 调用CodeGenerator的genCode生成相关代码
		 
		 String url = "jdbc:mysql://172.32.27.83:3306/${rootArtifactId}?useUnicode=true&useSSL=false&characterEncoding=utf8";
		 String driver = "com.mysql.cj.jdbc.Driver";
		 String user = "root";
		 String password = "KRw7e4rVTpoPAhL5SK8B";
		 String author = "Generator";
		 // 上级包名
		 String parent = "com.isay";
		 String outputDir = "/${artifactId}/src/main/";
		 CodeGenerator.genCode(url, driver, user, password, author, parent, outputDir);

		 **/
	}
}
