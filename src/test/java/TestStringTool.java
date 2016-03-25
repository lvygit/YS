//

import com.sddr.DateTool;
import com.sddr.StringTool;

import java.util.Date;

/**
 * Created by lvyong on 2016/3/23.
 */
public class TestStringTool {
//    @Test
//    public void TestStr(){
//        int num = com.sddr.StringTool.getRandomNum();
//        System.out.println(num);
//
//    }

    public static void main(String[] args ){
        test();
    }

    public static void test(){
        System.out.println("test");
        String strTest = "123,234,456,678,,";
        String[] sL = StringTool.StrSplit(strTest,",");
        for (String s:sL
                ) {
            String info = "message:"+s;
            System.out.println(info);
        }

        int i = StringTool.getRandomNum();
        System.out.println(i);
        String dtStr = DateTool.getTimeAgo("2016-01-25 00:00:01",null);
        System.out.println(dtStr);

        String dtN = DateTool.date2Str(new Date());
        System.out.println(dtN);
    }
}
