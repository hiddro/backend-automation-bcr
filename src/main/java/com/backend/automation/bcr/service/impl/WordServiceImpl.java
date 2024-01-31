package com.backend.automation.bcr.service.impl;

import com.backend.automation.bcr.model.dtos.ReporteMantenimiento;
import com.backend.automation.bcr.service.WordService;
import net.sf.jasperreports.engine.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre_entidad", "BECHEPE");

        JasperReport report = JasperCompileManager.compileReport(filePath);
        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

        return JasperExportManager.exportReportToPdf(print);
    }
}
