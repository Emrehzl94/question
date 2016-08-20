package question.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import question.service.beans.SayGreeting;

public class TestGreeting {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		SayGreeting greeting = ctx.getBean("greeting", SayGreeting.class);
		System.out.println(greeting.sayHello());

	}

}