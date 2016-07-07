package com.igate.ars.logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ArsLogger {
	public static final Logger logger =  Logger.getRootLogger();  
	   public ArsLogger(){	
		   PropertyConfigurator.configure("D:/Manwar_Works/work/ARS/Source/AirlineReservationSystem/WebContent/resources/log4j.properties");
			
		}
		
		 @Pointcut("execution(* com.igate.ars.dao.*DaoImpl.*(..))")
	     public void daoMethods() { }
		 
		 @AfterReturning("daoMethods()")
	     public void afterSuccess(){
			 logger.info("successful execution of the method...");
	     }
		 
		 @Around("daoMethods()")
		 public Object aroundDaoMethod(ProceedingJoinPoint joinpoint) throws Throwable{
			 logger.info(joinpoint.getSignature()+" called...");
		
			 Object output=joinpoint.proceed();
			 
			 logger.info(joinpoint.getSignature()+" execution complete...");
			 
			 return output; 
			 
	     }
		 
		 @AfterThrowing("daoMethods()")
	     public void afterException(){
			 logger.info("Exception occured during execution...");
	     }
		 
}
