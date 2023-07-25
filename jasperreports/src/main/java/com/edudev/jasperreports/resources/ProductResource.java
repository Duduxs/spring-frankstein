package com.edudev.jasperreports.resources;

import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/report")
    public void printReport(HttpServletResponse response) throws JRException, IOException, SQLException {

        var stream = getClass().getResourceAsStream("/reports/Products.jasper");

        Map<String, Object> params = new HashMap<>();

        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(stream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline; filename=products.pdf");

        OutputStream outputStream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

    }

}
