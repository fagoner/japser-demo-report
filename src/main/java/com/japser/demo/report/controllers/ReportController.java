package com.japser.demo.report.controllers;

import com.japser.demo.report.dao.ReportDao;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportDao reportDao;

    @GetMapping("")
    public void getReport(HttpServletResponse response) throws JRException, IOException, SQLException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"categoryReport.pdf\""));
        OutputStream out = response.getOutputStream();
        JasperPrint jasperPrint = reportDao.generateReport();
        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
    }

}
