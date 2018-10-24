package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Departamento;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Empleado;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Proyecto;

@Database(entities = {Departamento.class,Empleado.class,Proyecto.class},version = 2)
public abstract class EjemploDatabase extends RoomDatabase {
    public abstract EmpleadoDao empleadoDao();
    public abstract DepartamentoDao departamentoDao();
    public abstract ProyectoDao proyectoDao();
}
