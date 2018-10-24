package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Proyecto;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.ProyectoConEmpleados;

@Dao
public interface ProyectoDao {

    @Query("SELECT * FROM Proyecto")
    List<Proyecto> getAll();

    @Insert
    long insert(Proyecto pry);

    @Delete
    void delete(Proyecto pry);

    @Query("SELECT * FROM Proyecto WHERE id = :pIdPry")
    List<ProyectoConEmpleados> buscarPorIdConEmpleados(long pIdPry);
}