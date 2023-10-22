package com.fahmialfareza.initialDemo.Controllers;

import com.fahmialfareza.initialDemo.Config;
import com.fahmialfareza.initialDemo.Entity.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @GetMapping("/companies")
    public Company getCompanies() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        return context.getBean("company", Company.class);
    }

}
