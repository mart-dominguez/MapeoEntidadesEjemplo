package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao.EstadoConverter;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao.FechaConverter;

@Entity
public class Empleado {

    public enum Estado{PERMANENTE,PASANTE,CONTRATO,TEMPORAL};

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nombre;
    @Embedded(prefix = "dep_")
    private Departamento trabajaEn;
    @TypeConverters(EstadoConverter.class)
    private Estado estado;



    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    @TypeConverters(FechaConverter.class)
    private Date fechaContrato;

    private long idProyectoAsignado;

    public Empleado() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getTrabajaEn() {
        return trabajaEn;
    }

    public void setTrabajaEn(Departamento trabajaEn) {
        this.trabajaEn = trabajaEn;
    }

    public long getIdProyectoAsignado() {
        return idProyectoAsignado;
    }

    public void setIdProyectoAsignado(long idProyectoAsignado) {
        this.idProyectoAsignado = idProyectoAsignado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }
}
