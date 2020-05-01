package itis.semestr.demo.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger("appenderLogger");

//    @Pointcut("execution(public * ru.itis.springboot.Dao.UserDaoImpl.*(..))")
//    public void pointcutMyService(){}
//
//    @Before("pointcutMyService()")
//    public void beforeCallService(JoinPoint joinPoint){
//        System.out.println("Call of method: " + joinPoint.getSignature());
//    }
//
//    @After("pointcutMyService()")
//    public void afterCallService(JoinPoint joinPoint){
//        Object[] objects = joinPoint.getArgs();
//        User user = (User) objects[0];
//        logger.info("The user is successfully registered"+user);
//    }

    @AfterThrowing(pointcut = "execution(public * itis.semestr.demo.security.details.UserDetailsServiceImpl.*(..))", throwing = "ex")
    public void afterThrowingExc(Throwable ex) throws Throwable{
        logger.warn("Exc" +  ex);
    }

}