package com.yajun.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yajun.config.WxConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WxService {

    @Autowired
    private WxConfig wxConfig;

    //service代码
    public Map<String, Object> getSessionKey(String code) {
        StringBuilder url = new StringBuilder(wxConfig.getSessionHost() + "?");
        url.append("appid=");//appid设置
        url.append(wxConfig.getAppId());
        url.append("&secret=");//secret设置
        url.append(wxConfig.getSecret());
        url.append("&js_code=");//code设置
        url.append(code);
        url.append("&grant_type").append(wxConfig.getGrantType());
        Map<String, Object> map = null;
        try {
            // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)

            HttpClient client = HttpClientBuilder.create().build();//构建一个Client
            HttpGet get = new HttpGet(url.toString());    //构建一个GET请求
            HttpResponse response = client.execute(get);//提交GET请求
            HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
            String content = EntityUtils.toString(result);
            //LogUtils.debug(content);//打印返回的信息
            JSONObject res = JSONObject.parseObject(content);
            map = parseJSON2Map(res);
        } catch (Exception e) {
            e.printStackTrace();
            //LogUtils.debug("获取openid失败");
        }
        return map;
    }


    //json转map,这个小工具是我从网上找的,谢谢作者
    public static Map<String, Object> parseJSON2Map(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                @SuppressWarnings("unchecked")
                Iterator<Object> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = (JSONObject) it.next();
                    list.add(parseJSON2Map(json2));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }
}
