package team.weiyu.culture.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YearRegEx {

	private static String regEx1 = "^[y][0-9][0-9][0-9][0-9]$";
	private static String regEx2 = "^[0-9][0-9][0-9][0-9][年]$";
	private static Pattern pattern1 = Pattern.compile(regEx1);
	private static Pattern pattern2 = Pattern.compile(regEx2);
	
	
	public static boolean isLegal(String keyword){
		Matcher matcher1 = pattern1.matcher(keyword);
		Matcher matcher2 = pattern2.matcher(keyword);
		return matcher1.matches()||matcher2.matches();
	}
}
