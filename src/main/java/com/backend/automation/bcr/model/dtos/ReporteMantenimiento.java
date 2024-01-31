package com.backend.automation.bcr.model.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReporteMantenimiento {

    @JsonProperty(value = "nombreEntidad")
    public String nombreEntidad;

    @JsonProperty(value = "rolEntidad")
    public String rolEntidad;

    @JsonProperty(value = "anioEjecucion")
    public String anioEjecucion;

    @JsonProperty(value = "mesEjecucion")
    public String mesEjecucion;

    @JsonProperty(value = "duraMantPrg")
    public String duraMantPrg;

    @JsonProperty(value = "duraMantCrr")
    public String duraMantCrr;

    @JsonProperty(value = "duraMantEmg")
    public String duraMantEmg;

    @JsonProperty(value = "cantMantPrg")
    public String cantMantPrg;

    @JsonProperty(value = "cantMantCrr")
    public String cantMantCrr;

    @JsonProperty(value = "cantMantEmg")
    public String cantMantEmg;

    @JsonProperty(value = "mantenimientoCod")
    public String mantenimientoCod;

    @JsonProperty(value = "fechaInicio")
    public String fechaInicio;

    @JsonProperty(value = "fechaFin")
    public String fechaFin;

    @JsonProperty(value = "horaInicio")
    public String horaInicio;

    @JsonProperty(value = "horaFin")
    public String horaFin;

    @JsonProperty(value = "duracion")
    public String duracion;

    @JsonProperty(value = "tipoMant")
    public String tipoMant;

    @JsonProperty(value = "noDispDeg")
    public String noDispDeg;

    @JsonProperty(value = "paseProd")
    public String paseProd;

    @JsonProperty(value = "motivo")
    public String motivo;

    @JsonProperty(value = "otrEntidad")
    public String otrEntidad;

    @JsonProperty(value = "prbDetec")
    public String prbDetec;

    @JsonProperty(value = "comentAdicionales")
    public String comentAdicionales;
}
