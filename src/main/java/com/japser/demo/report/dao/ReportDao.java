package com.japser.demo.report.dao;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
@Transactional
public class ReportDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JasperPrint generateReport() throws SQLException, IOException, JRException {
        Connection conn = Objects.requireNonNull(jdbcTemplate.getDataSource()).getConnection();

        InputStream reportStream = getClass().getResourceAsStream("/".concat("SimpleReport.jrxml"));
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

        Map<String, Object> parameters = new HashMap<String, Object>();

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);
        conn.close();
        return print;
    }

}
