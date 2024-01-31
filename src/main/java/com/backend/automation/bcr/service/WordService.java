package com.backend.automation.bcr.service;

import com.backend.automation.bcr.model.dtos.ReporteMantenimiento;
import net.sf.jasperreports.engine.JRException;

public interface WordService {
    byte[] jasperExportReport(ReporteMantenimiento reporte) throws JRException;
}
