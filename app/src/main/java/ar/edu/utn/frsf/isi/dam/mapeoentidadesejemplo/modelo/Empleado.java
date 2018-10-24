package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Empleado {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nombre;
    @Embedded(prefix = "dep_")
    private Departamento trabajaEn;

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
}
