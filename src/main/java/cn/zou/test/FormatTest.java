package cn.zou.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatTest {

    public static void main(String[] args) {
        //打印当前系统时间
        System.out.println(new Date().toString());

        //时间格式化
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
        try {
            Date parse = simpleDateFormat.parse("2022-12-21 11:22:11");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
