package com.backend.automation.bcr.utils;

import com.backend.automation.bcr.model.dtos.ReporteMantenimiento;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase la cual se pueden reutilizar metodos el cual te devuelve un valor
 *
 * @author Edward Cordova Chavez
 */
public class Commons {

    /**
     * Este metodo sirve para mapear los campos del reporte con los datos del json enviado
     * @param reporte json enviado al api el cual tiene los campos del reporte
     * @return los parametros los cuales se completaran en el reporte
     */
    public static Map<String, Object> buildParameters(ReporteMantenimiento reporte){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nombre_entidad", reporte.getNombreEntidad());
        parameters.put("rol_entidad", reporte.getRolEntidad());
        parameters.put("anio_ejec", reporte.getAnioEjecucion());
        parameters.put("mes_ejec", reporte.getMesEjecucion());
        parameters.put("dura_mant_prg", reporte.getDuraMantPrg());
        parameters.put("dura_mant_crr", reporte.getDuraMantCrr());
        parameters.put("dura_mant_emg", reporte.getDuraMantEmg());
        parameters.put("cant_mant_prg", reporte.getCantMantPrg());
        parameters.put("cant_mant_crr", reporte.getCantMantCrr());
        parameters.put("cant_mant_emg", reporte.getCantMantEmg());

        parameters.put("mant_x", reporte.getMantenimientoCod());
        parameters.put("fecha_inicio", reporte.getFechaInicio());
        parameters.put("fecha_fin", reporte.getFechaFin());
        parameters.put("hora_inicio", reporte.getHoraInicio());
        parameters.put("hora_fin", reporte.getHoraFin());
        parameters.put("dura_x", reporte.getDuracion());
        parameters.put("tipo_mant", reporte.getTipoMant());
        parameters.put("nodis_degra", reporte.getNoDispDeg());
        parameters.put("pase_prd", reporte.getPaseProd());
        parameters.put("motivo", reporte.getMotivo());
        parameters.put("imp_othr_entidad", reporte.getOtrEntidad());
        parameters.put("probl_detec", reporte.getPrbDetec());
        parameters.put("coment_adic", reporte.getComentAdicionales());

        return parameters;
    }
}
