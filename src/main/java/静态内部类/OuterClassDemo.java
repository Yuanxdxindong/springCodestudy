package 静态内部类;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import javassist.runtime.Inner;
import lombok.Data;

/**
 * @authoryuanxindong
 * @date: 2020/6/19 10:25 下午
 */
@Data
public class OuterClassDemo {
    String outerStr;

    public OuterClassDemo(String outerStr) {
        this.outerStr = outerStr;
    }

    @Data
    public static class StaticInnerClass{
        public StaticInnerClass(String innerStr) {
            this.innerStr = innerStr;
        }

        private  String  innerStr;

    }
    @Data
    public class InnerClass{
        private String innerClassStr;
        public InnerClass(String outerStr) {
            //可以和外部类通讯
            this.innerClassStr = getOuterStr();
        }
    }

    public static void main(String[] args) {
        OuterClassDemo staticClassDemo =new OuterClassDemo("Outer");
        staticClassDemo.getOuterStr();
        // 内部正常类是不能直接new出来的
        //  OuterClass outerClass = new OuterClass();
        StaticInnerClass innerClass = new StaticInnerClass("StaticInner");
        System.out.println(innerClass.getInnerStr());
        initInnerClass();
    }
    public static void initInnerClass(){
        OuterClassDemo staticClassDemo1 = new OuterClassDemo("OuterClassDemo");
        InnerClass innerClass = staticClassDemo1.new InnerClass("outerStr");
        System.out.println(innerClass.getInnerClassStr());
    }
}
