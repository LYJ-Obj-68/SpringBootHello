package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lxj
 *
 * 此java类是你创建项目时自动给你生成的,创建好项目后直接运行此方法
 * */

/**
 * @SpringBootApplication 这个注解可以说是:“以一顶三”
 * 		@Configuration : 配置一个类来加载配置
 * 		@ComponentScan ：若主类是在root包(根包),则不需要这个配置;若不是root包,就需要进行扫描
 *		@RestController ：组合注解(可以看成:@Controller 和 @ResponseBody给前端返回json对象)
 * */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
