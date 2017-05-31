package team.weiyu.culture.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.jena.reasoner.rulesys.Rule;

public class RulesData {
	
	public static List<Rule> rulesDataProcess(File fileName) {
		// 以List形式返回读取后的rule规则，传入File文件

		//List rule = null;

		List<Rule> rule = null;
		try {

			Reader reader = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
			// 用Reader以字节的形式读取文件，并转成“UTF-8”格式
			BufferedReader br = new BufferedReader(reader);
			// 利用BufferedReader实现缓存高效读取文件
			rule = Rule.parseRules(Rule.rulesParserFromReader(br));
			// 用org.apache.jena.reasoner.rulesys.Rule中的Rule方法读取rules文件中的规则

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// System.out.println("Rules规则读取成功！");

		return rule;
		// 返回List格式的rule规则

	}
}
