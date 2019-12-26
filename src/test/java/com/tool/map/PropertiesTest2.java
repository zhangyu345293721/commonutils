package com.tool.map;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * map遍历键值对
 *
 * @author: zhangyu
 */
public class PropertiesTest2 {
    public void printAll() {
        Properties prop = new Properties();
        String file = "config.properties";
        try(InputStream input= getClass().getClassLoader().getResourceAsStream(file);) {
            if(input == null) {
                System.out.println("无法加载文件" + file);
                return ;
            }
            prop.load(input);
            // 方法一
            Set<Object> keys = prop.keySet();
            for(Object key:keys) {
                System.out.println("key:" + key.toString() + "|" + "value:" + prop.get(key));
            }
            // 方法二：
            Set<Map.Entry<Object, Object>> entrys = prop.entrySet();//返回的属性键值对实体
            for(Map.Entry<Object, Object> entry:entrys){
                System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
            }
            // 方法三：
            Enumeration<?> e = prop.propertyNames();
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = prop.getProperty(key);
                System.out.println("Key:" + key + ",Value:" + value);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        PropertiesTest2 p = new PropertiesTest2();
        p.printAll();
    }
}
