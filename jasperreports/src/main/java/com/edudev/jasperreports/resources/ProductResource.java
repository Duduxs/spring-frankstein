package com.edudev.jasperreports.resources;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;

@Controller
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private DataSource dataSource;

    @PostMapping("/report")
    public void printReport(HttpServletResponse response) {

    }

}
