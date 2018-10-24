package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Departamento;

@Dao
public interface DepartamentoDao {

    @Query("SELECT * FROM Departamento")
    List<Departamento> getAll();

    @Insert
    long insert(Departamento depto);

    @Delete
    void delete(Departamento depto);
}
