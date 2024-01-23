package com.backend.automation.bcr.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
public class WordController {

//	@GetMapping(value = "/word",
//			produces = "application/vnd.openxmlformats-"
//					+ "officedocument.wordprocessingml.document")
//	public ResponseEntity<InputStreamResource> word()
//			throws IOException, InvalidFormatException {
//
//		ByteArrayInputStream bis = WordHelper.generateWord();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-Disposition",
//				"inline; filename=mydoc.docx");
//		return ResponseEntity.ok().headers(headers).
//				body(new InputStreamResource(bis));
//	}

	@GetMapping(value = "/download")
	public ResponseEntity<byte[]> wordDownload(HttpServletResponse response) {
		try {
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

			// Exportar el informe a un flujo de bytes
			byte[] pdfBytes = JasperExportManager.exportReportToPdf(print);

			// Configurar el encabezado de la respuesta
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename("ReportGenerated.pdf").build());

			// Devolver el contenido del archivo como parte de ResponseEntity
			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// Manejo de errores...
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
