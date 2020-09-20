package cn.cy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//等等1247777111？？
@SpringBootApplication
@MapperScan(basePackages = {"cn.cy.*.dao"})
public class AquariusApplication {
	public static void main(String[] args) {
		SpringApplication.run(AquariusApplication.class,args);
	}

}
