package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao;

import android.arch.persistence.room.TypeConverter;

import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Empleado;

public class EstadoConverter {

        @TypeConverter
        public static Empleado.Estado toEstado(String status) {
            return Empleado.Estado.valueOf(status);
        }

        @TypeConverter
        public static String  toString(Empleado.Estado status) {
            return status.toString();
        }
}
