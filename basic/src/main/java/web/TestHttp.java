package web;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * http通信测试
 *
 * @author junhu
 */
public class TestHttp
{
    public static void main(String[] args)
    {
        try
        {
            // --------------测试请求/test/index begin---------------------------
            // HttpUtil.get("http://localhost:8080/Java_http/test/index?name=zhangsan&age=22&sex=nan");

//             Map<String, String> parameterMap = new HashMap<String, String>();
//             parameterMap.put("name", "zhangsan");
//             parameterMap.put("age", "22");
//             parameterMap.put("sex", "nan");
//             test.util.HttpUtil.post("http://localhost:8080/Java_http/test/index", parameterMap);
            // --------------测试请求/test/index end---------------------------


            // --------------测试请求/test/index2 begin---------------------------
            // HttpUtil.get("http://localhost:8080/Java_http/test/index2?userName=zhangsan&userAge=22&userSex=nan");

            // Map<String, String> parameterMap = new HashMap<String, String>();
            // parameterMap.put("userName", "zhangsan");
            // parameterMap.put("userAge", "22");
            // parameterMap.put("userSex", "nan");
            // HttpUtil.post("http://localhost:8080/Java_http/test/index2", parameterMap);
            // --------------测试请求/test/index2 end---------------------------
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
