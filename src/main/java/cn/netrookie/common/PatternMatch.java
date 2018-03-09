package cn.netrookie.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式匹配类
 *
 * @author jiangxl
 * @date 2017/10/15
 *
 */
public class PatternMatch {
    public static void main(String[] args){
        regex();
    }

    public static  void regex(){
        String str = "之前只能蓝色屏幕的时候 是在windows徽标之前 还是之后出现的呢";
        String regEx = "[是]*[还是]";
        // String regEx = "^[\\u0391-\\uFFE5]+$ ";
        //   String regEx = "[是][\\u4e00-\\u9fa5][还是]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
        boolean rs = matcher.find();
        System.out.println(rs);
    }
}
