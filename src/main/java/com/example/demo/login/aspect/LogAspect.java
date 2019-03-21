package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	// Controllerのログ出力
	@Around("execution( * *..*.*Controller.*(..))")
	//@Around("bean( * Controller)")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable {

		System.out.println(" メソッド開始：" + jp.getSignature());

		try {

			Object result = jp.proceed();
			System.out.println(" メソッド終了：" + jp.getSignature());

			return result;

		} catch(Exception e){

			System.out.println(" メソッド異常終了：" + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

	// UserDaoクラスのログ出力
	@Around("execution( * *..*.*UserDao.*(..))")
	//@Around("bean( * Controller)")
	public Object daoLog(ProceedingJoinPoint jp) throws Throwable {

		System.out.println(" メソッド開始：" + jp.getSignature());

		try {

			Object result = jp.proceed();
			System.out.println(" メソッド終了：" + jp.getSignature());

			return result;

		} catch(Exception e){

			System.out.println(" メソッド異常終了：" + jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

	/* ******************************************
	 * @Beforeと@Afterのサンプル
	 *
	// 最初の*以外は半角スペースいらない
	@Before("execution( * *..*.*Controller.*(..))")
	public void startLog(JoinPoint jp) {

		System.out.println(" メソッド開始：" + jp.getSignature());
	}

	// 最初の*以外は半角スペースいらない
	@After("execution( * *..*.*Controller.*(..))")
	public void endLog(JoinPoint jp) {

		System.out.println(" メソッド終了：" + jp.getSignature());
	}
	********************************************** */

}
