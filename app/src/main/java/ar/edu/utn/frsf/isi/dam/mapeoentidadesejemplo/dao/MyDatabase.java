package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao;

import android.arch.persistence.room.Room;
import android.content.Context;

public class MyDatabase {

    // variable de clase privada que almacena una instancia unica de esta entidad
    private static MyDatabase _INSTANCIA_UNICA=null;

    // metodo static publico que retorna la unica instancia de esta clase
    // si no existe, cosa que ocurre la primera vez que se invoca
    // la crea, y si existe retorna la instancia existente.

    public static MyDatabase getInstance(Context ctx){
        if(_INSTANCIA_UNICA==null) _INSTANCIA_UNICA = new MyDatabase(ctx);
        return _INSTANCIA_UNICA;
    }

    private EjemploDatabase db;
    private DepartamentoDao departamentoDao;
    private EmpleadoDao empleadoDao;
    private ProyectoDao proyectoDao;

    // constructor privado para poder implementar SINGLETON
    // al ser privado solo puede ser invocado dentro de esta clase
    // el único lugar donde se invoca es en la linea 16 de esta clase
    // y se invocará UNA Y SOLO UNA VEZ, cuando _INSTANCIA_UNICA sea null
    // luego ya no se invoca nunca más. Nos aseguramos de que haya una
    // sola instancia en toda la aplicacion
    private MyDatabase(Context ctx){
        db = Room.databaseBuilder(ctx,
                EjemploDatabase.class, "database-name")
                .fallbackToDestructiveMigration()
                .build();
        departamentoDao = db.departamentoDao();
        empleadoDao = db.empleadoDao();
        proyectoDao = db.proyectoDao();

    }

    public void borrarTodo(){
        this.db.clearAllTables();
    }

    public DepartamentoDao getDepartamentoDao() {
        return departamentoDao;
    }

    public void setDepartamentoDao(DepartamentoDao departamentoDao) {
        this.departamentoDao = departamentoDao;
    }

    public EmpleadoDao getEmpleadoDao() {
        return empleadoDao;
    }

    public void setEmpleadoDao(EmpleadoDao empleadoDao) {
        this.empleadoDao = empleadoDao;
    }

    public ProyectoDao getProyectoDao() {
        return proyectoDao;
    }

    public void setProyectoDao(ProyectoDao proyectoDao) {
        this.proyectoDao = proyectoDao;
    }
}
