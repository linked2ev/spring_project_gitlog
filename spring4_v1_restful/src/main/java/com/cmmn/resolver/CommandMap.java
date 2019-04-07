package com.cmmn.resolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
* <pre>
* 1. 패키지명 : com.cmmn.resolver
* 2. 타입명 : CommandMap.java
* 3. 작성일 : 2017. 12. 16.
* 4. 작성자 : linked2ev
* 5. 설명 : CustomMapArgumentResolver handling을 위한 customMap
* </pre>
 */
public class CommandMap {

    Map<String, Object> map = new HashMap<String, Object>();
    
    public Object get(String key){
        return map.get(key);
    }
     
    public void put(String key, Object value){
        map.put(key, value);
    }
     
    public Object remove(String key){
        return map.remove(key);
    }
     
    public boolean containsKey(String key){
        return map.containsKey(key);
    }
     
    public boolean containsValue(Object value){
        return map.containsValue(value);
    }
     
    public void clear(){
        map.clear();
    }
     
    public Set<Entry<String, Object>> entrySet(){
        return map.entrySet();
    }
     
    public Set<String> keySet(){
        return map.keySet();
    }
     
    public boolean isEmpty(){
        return map.isEmpty();
    }
     
    public void putAll(Map<? extends String, ?extends Object> m){
        map.putAll(m);
    }
     
    public Map<String,Object> getMap(){
        return map;
    }
}
