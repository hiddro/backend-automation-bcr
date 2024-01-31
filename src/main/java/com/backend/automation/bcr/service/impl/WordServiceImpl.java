package com.backend.automation.bcr.service.impl;

import com.backend.automation.bcr.model.dtos.ReporteMantenimiento;
import com.backend.automation.bcr.service.WordService;
import com.backend.automation.bcr.utils.Commons;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class WordServiceImpl implements WordService {

    @Override
    public byte[] jasperExportReport(ReporteMantenimiento reporte) throws JRException {
        // Definición de rutas y otros detalles...
        String filePath = "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "templates" + File.separator +
                "report" + File.separator +
                "ReportMant.jrxml";

        JasperReport report = JasperCompileManager.compileReport(filePath);
        JasperPrint print = JasperFillManager.fillReport(report, Commons.buildParameters(reporte), new JREmptyDataSource());

        return JasperExportManager.exportReportToPdf(print);
    }
}
