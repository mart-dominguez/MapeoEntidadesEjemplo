package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Empleado;

@Dao
public interface EmpleadoDao {

    @Query("SELECT * FROM Empleado")
    List<Empleado> getAll();

    @Insert
    long insert(Empleado emp);

    @Update
    void update(Empleado emp);

    @Delete
    void delete(Empleado emp);
}