package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class ProyectoConEmpleados {
    @Embedded
    public Proyecto proyecto;

    @Relation(parentColumn = "id", entityColumn = "idProyectoAsignado", entity = Empleado.class)
    public List<Empleado> empleados;
}
