package ThinkJava.day03;

import java.util.Iterator;

/**
 * @author yuanxindong
 * @date 2020/7/19  8:58 下午
 */
public class IterableClass implements Iterable<String>{
   String [] a = new String[]{
           "a","b","c","d","e"
   };
    @Override
    public Iterator<String> iterator() {
        return null;
    }
}
