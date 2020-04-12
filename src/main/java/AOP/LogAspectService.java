package AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

// @Aspect 告诉容器当前类是切面类而不是容器类
@Aspect
public class LogAspectService {
    //抽取公共的切入点表达式
    @Pointcut("execution(public int AOP.MathCalculator.*(..))")
    public void pointCut() {
    }

    ;

    // @before  在目标方法前进行切入，切入点表达式（指定在那個方法切入）
    @Before("pointCut()")
    private void logstart(JoinPoint joinPoint) {
        System.out.println("divide run start>>>> methodNAme："
                + joinPoint.getSignature().getName() + "methd paramter:{}"
                + Arrays.asList(joinPoint.getArgs()).toString());
    }

    //后置通知在方法运行结束后无论方法是正常结束还是异常结束
    //别的类使用pointCut公用切面就使用下面这种方式
    @After("pointCut()")
    private void logEnd() {
        System.out.println("divide run end>>>>");
    }

    //返回通知当目标方法正常返回之后运行
    //接受返回的結果
    @AfterReturning(value = "pointCut()", returning = "result")
    private void logResult(Object result) {
        System.out.println("divide run  return result>>>> result:{}" + result);
    }

    //方法异常后执行
    //接受返回的異常信息
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    private void logException(Exception exception) {
        System.out.println("divide run Exception>>>> {}" + exception.getMessage());
    }

    //手动推进目标方法运行
    //环绕通知
    @Around(value = "pointCut()")
    private void logAround() {
        System.out.println("divide run >>>>");
    }
}
