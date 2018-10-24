package ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Random;

import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao.DepartamentoDao;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao.EmpleadoDao;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao.MyDatabase;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.dao.ProyectoDao;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Departamento;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Empleado;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.Proyecto;
import ar.edu.utn.frsf.isi.dam.mapeoentidadesejemplo.modelo.ProyectoConEmpleados;

public class MainActivity extends AppCompatActivity {

    private Button btnBorrarTodo;
    private Button btnCrearDepartamentos;
    private Button btnCrearEmpleados;
    private Button btnCrearProyectos;

    private Button btnConsultarEmpleados;
    private Button btnConsultarDeptos;
    private Button btnConsultarProyectos;

    private TextView tvResultado;
    private DepartamentoDao deptoDao;
    private EmpleadoDao empDao;
    private ProyectoDao pryDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.miBarraHerramientas);
        setSupportActionBar(myToolbar);

        tvResultado = (TextView) findViewById(R.id.txtResultado);

        deptoDao = MyDatabase.getInstance(this).getDepartamentoDao();
        empDao = MyDatabase.getInstance(this).getEmpleadoDao();
        pryDao = MyDatabase.getInstance(this).getProyectoDao();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuCrearDepto:
                Runnable r1 = new Runnable() {
                    @Override
                    public void run() {
                        final String resultado = crearDepartamentoYRetornarLista();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResultado.setText(resultado);
                            }
                        });
                    }
                };
                Thread t1 = new Thread(r1);
                t1.start();
                return true;
            case R.id.mnuCrearEmpleado:
                Runnable r2 = new Runnable() {
                    @Override
                    public void run() {
                        final String resultado = crearEmpleadoYRetornarLista();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResultado.setText(resultado);
                            }
                        });
                    }
                };
                Thread t2 = new Thread(r2);
                t2.start();
                return true;
            case R.id.mnuCrearProyecto:
                Runnable r3 = new Runnable() {
                    @Override
                    public void run() {
                        final String resultado = crearProyectoYRetornarLista();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResultado.setText(resultado);
                            }
                        });
                    }
                };
                Thread t3 = new Thread(r3);
                t3.start();
                return true;
            case R.id.mnuBorrarTodo:
                Runnable r4 = new Runnable() {
                    @Override
                    public void run() {
                        borrarTodo();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResultado.setText("");
                            }
                        });
                    }
                };
                Thread t4 = new Thread(r4);
                t4.start();
                return true;
            case R.id.mnuConsultarDeptos:
                Runnable r5 = new Runnable() {
                    @Override
                    public void run() {
                        final String res = consultaDepartamentos();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResultado.setText(res);
                            }
                        });
                    }
                };
                Thread t5 = new Thread(r5);
                t5.start();
                return true;
            case R.id.mnuConsultarEmpleados:
                Runnable r6 = new Runnable() {
                    @Override
                    public void run() {
                        final String res = consultaEmpleados();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResultado.setText(res);
                            }
                        });
                    }
                };
                Thread t6 = new Thread(r6);
                t6.start();
                return true;
            case R.id.mnuConsultarProy:
                Runnable r7 = new Runnable() {
                    @Override
                    public void run() {
                        final String res = consultaProyectos();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResultado.setText(res);
                            }
                        });
                    }
                };
                Thread t7= new Thread(r7);
                t7.start();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private String crearDepartamentoYRetornarLista() {
        Departamento d1 = new Departamento();
        Random r = new Random();
        d1.setNombre(" DEPTO _ " + r.nextInt(1000));
        deptoDao.insert(d1);
        return consultaDepartamentos();
    }


    private String crearProyectoYRetornarLista() {
        Random r = new Random();
        Proyecto p1 = new Proyecto();
        p1.setTitulo(" PROYECTO " + r.nextInt(50));
        p1.setPresupuesto(1000 * r.nextDouble());
        long idProyectoCreado = pryDao.insert(p1);

        List<Empleado> empleadoLista = empDao.getAll();
        if (empleadoLista == null || empleadoLista.isEmpty()) {
            crearEmpleadoYRetornarLista();
            empleadoLista = empDao.getAll();
        }
        int i = 0;
        while (i < 2 && i < empleadoLista.size()) {
            Empleado aux = empleadoLista.get(i);
            aux.setIdProyectoAsignado(idProyectoCreado);
            empDao.update(aux);
            i++;
        }
        return consultaProyectoPorId(idProyectoCreado);
    }

    private String crearEmpleadoYRetornarLista() {
        List<Departamento> lista = deptoDao.getAll();
        if (lista == null || lista.isEmpty()) {
            crearDepartamentoYRetornarLista();
            lista = deptoDao.getAll();
        }
        Empleado e1 = new Empleado();

        Random r = new Random();
        e1.setNombre(" Empleado _ " + r.nextInt(1000));
        e1.setTrabajaEn(lista.get(r.nextInt(lista.size())));
        empDao.insert(e1);
        return consultaEmpleados();
    }

    private String consultaDepartamentos(){
        List<Departamento> lista = deptoDao.getAll();
        final StringBuilder resultado = new StringBuilder(" === DEPARTAMENTOS ==="+ "\r\n");
        for (Departamento d : lista) {
            resultado.append(d.getId() + ": " + d.getNombre() + "\r\n");
        }
        return resultado.toString();
    }

    private String consultaEmpleados(){
        List<Empleado> empleadoLista = empDao.getAll();
        StringBuilder resultado = new StringBuilder(" === EMPLEADOS === "+ "\r\n");
        for (Empleado d : empleadoLista) {
            resultado.append(d.getId() + ": " + d.getNombre() + d.getTrabajaEn().getNombre() + "\r\n");
        }
        return resultado.toString();
    }

    private String consultaProyectoPorId(long id){
        List<ProyectoConEmpleados> listPry = pryDao.buscarPorIdConEmpleados(id);
        final StringBuilder resultado = new StringBuilder(" === PROYECTOS === "+ "\r\n");
        for (ProyectoConEmpleados pry : listPry) {
            resultado.append(pry.proyecto.getTitulo() + pry.proyecto.getPresupuesto() + "\r\n");
            resultado.append("Empleados >>: "+ "\r\n");
            for (Empleado unEmp : pry.empleados) {
                resultado.append("    >"+ unEmp.getId() + " > " + unEmp.getNombre() + " " + unEmp.getTrabajaEn().getNombre() + "\r\n");
            }
        }
        return resultado.toString();
    }

    private String consultaProyectos(){
        List<Proyecto> pryLista= pryDao.getAll();
        StringBuilder tmp =new StringBuilder();
        for(Proyecto p : pryLista) {
            tmp.append(this.consultaProyectoPorId(p.getId()));
        }
        return tmp.toString();
    }



    private void borrarTodo() {
        MyDatabase.getInstance(this).borrarTodo();
    }

}