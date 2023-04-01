package cn.wpr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"cn.wpr.common.*","cn.wpr.*.*","cn.wpr.common.utils"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
