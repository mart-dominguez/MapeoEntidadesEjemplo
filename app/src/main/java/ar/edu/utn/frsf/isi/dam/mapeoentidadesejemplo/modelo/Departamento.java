package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Departamento {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String nombre;

    public Departamento() {
    }

    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
