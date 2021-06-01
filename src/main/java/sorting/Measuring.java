package sorting;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.nio.charset.StandardCharsets;

@Aspect
public class Measuring {

    long start;

    @Pointcut("execution(* *.*.sort*(..))")
    private void selectAllSort() {
    }

    @Before("selectAllSort()")
    public void beforeSort(JoinPoint jp) {
        System.out.println("Running sort in " + jp.getThis().getClass() +
                " with array size " +
                ((Integer[]) jp.getArgs()[0]).length);
        start = System.currentTimeMillis();
    }

    @After("selectAllSort()")
    public void afterSort(JoinPoint jp) {
        System.out.println("Function sort in " + jp.getThis().getClass() +
                " took <" + (System.currentTimeMillis() - start) + "> ms");
    }

}
