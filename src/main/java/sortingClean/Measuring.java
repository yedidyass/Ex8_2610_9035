package sortingClean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Measuring {

    @Pointcut("execution(* *.*.sort*(..))")
    private void selectAllSort(){}

    @Before("selectAllSort()")
    public void beforeSort(JoinPoint jp){}

    @After("selectAllSort()")
    public void afterSort(JoinPoint jp){}
}
