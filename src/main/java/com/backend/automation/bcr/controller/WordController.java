package com.backend.automation.bcr.controller;

import com.backend.automation.bcr.model.dtos.ReporteMantenimiento;
import com.backend.automation.bcr.service.WordService;
import com.backend.automation.bcr.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.PATH_CONTROLLER_PDF)
@CrossOrigin(origins = "*")
public class WordController {

	@Autowired
	WordService wordService;

	@PostMapping(value = Constants.PATH_REPORT)
	public ResponseEntity<byte[]> wordDownload(@RequestBody ReporteMantenimiento reporte) {
		try {
			// Exportar el informe a un flujo de bytes
			byte[] pdfBytes = wordService.jasperExportReport(reporte);

			// Configurar el encabezado de la respuesta
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDisposition(ContentDisposition.builder(Constants.STRING_ATTACHMENT).filename(Constants.PDF_REPORTE_MANTENIMIENTO).build());

			// Devolver el contenido del archivo como parte de ResponseEntity
			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// Manejo de errores...
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
