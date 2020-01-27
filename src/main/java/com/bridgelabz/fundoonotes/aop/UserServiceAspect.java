package com.bridgelabz.fundoonotes.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoonotes.dto.UserDTOLogin;
import com.bridgelabz.fundoonotes.utility.Utility;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class UserServiceAspect {
    
	
	
//	UserDTOLogin userlogin=new UserDTOLogin();
	@Before("execution(* com.bridgelabz.fundoonotes.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature());
		log.info("Before method Execute:" + joinPoint.getSignature());
		log.info("User Enter the mathod:");
	}

	@After("execution(* com.bridgelabz.fundoonotes.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("After method:" + joinPoint.getSignature());
		log.info("Successfully response returned");
	}

	@Around("execution(* com.bridgelabz.fundoonotes.serviceImpletation.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("Before Method Execute:" + joinPoint.getSignature());
		Object o = joinPoint.proceed();
		log.info("After method Execution:" + joinPoint.getSignature());
	}

}
