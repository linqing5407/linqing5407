package com.example.controller.redisControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/redisControl")
public class RedisControl {


    @Autowired
    private RedisTemplate redisTemplate;

    private String redisKey ="demotestkeyredis";
    /**
     *
     *查询中台对外API接口
     * @return
     */
    @RequestMapping("/easBankQueryTest")
    @ResponseBody
    public Object easBankQueryTest() {
        try {
//            for(int i=0;i<200000;i++){
//                redisTemplate.opsForHash().put("redisKey,i+"demo农业银行"+9865+i,i+"福州世茂建设银行"+800+i);
//            }

            Map<String,String> result = new HashMap<>();

            Cursor<Map.Entry<Object,Object>> cursor =redisTemplate.opsForHash().scan(redisKey,ScanOptions.
                    scanOptions().match("*7*").count(15).build());
            int count =0;
            while (cursor.hasNext()) {
                System.out.println("getCursorId:"+cursor.getCursorId()+"---"+cursor.getPosition());
                Map.Entry<Object,Object> entry = cursor.next();
                String key = (String)entry.getKey();
                String valueSet = (String)entry.getValue();
                result.put(key,valueSet);
                count = count+1;
                if(count==100){
                    cursor.close();
                    System.out.println(cursor.getCursorId()+"---"+cursor.getPosition());
                    break;
                }
            }
            //关闭cursor
            cursor.close();
            System.out.println(cursor.getCursorId()+"---"+cursor.getPosition());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
    }
}
