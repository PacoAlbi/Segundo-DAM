package DAO;

import Entities.UsuariosEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ConectarConBBDD {
    /**
     * Atributos de clase para poder usarlos durante la sesión de conexión al CRUD.
     */
    private SessionFactory sessionFactory;
    private Session sesion;
    private Transaction transaction;
    /**
     * Método que establece la conexión con la BBDD.
     */
    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    /**
     * Método que abre la conexión y prepara la sesión y la transacción para empezar.
     */
    public void abrirConexion() {
        setUp();
        sesion = sessionFactory.openSession();
        transaction = sesion.beginTransaction();
    }
    /**
     * Método que cierra la conexón y hace un commit si sale bien o un rollback si sale mal.
     * Avisa si hay error.
     */
    public void cerrar() {
        try {
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("Error haciendo el commit.");
        }
        sessionFactory.close();
    }
    /**
     * Método para recuperar e imprimir a un usuario y sus datos asociados.
     * Recibe el id del usuario que va a recuperar.
     * @param id entero que representa el id del usuario.
     * @throws Exception Lanza una excepción si algo falla.
     */
    public void leer(int id) throws Exception {
        UsuariosEntity usuario = sesion.load(UsuariosEntity.class, id);
        System.out.println(usuario);
    }
    /**
     * Método para guardar un Objeto del tipo que sea en la BBDD.
     * @param objeto Es el objeto del tipo que sea para guardar en la BBDD.
     * @return ¿?
     * @throws Exception Lanza una excepción si algo falla.
     */
    public Object guardar(Object objeto) throws Exception {
        return sesion.save(objeto);
    }
    /**
     * Método que actualiza un usuario en la BBDD.
     * Recibe un usuario ya modificado para actualizar.
     * @param usuario Objeto usuario que actualizará.
     * @throws Exception Lanza una excepción si algo falla.
     */
    public void actualizar(UsuariosEntity usuario) throws Exception {
        UsuariosEntity persona = sesion.get(UsuariosEntity.class,usuario.getIdUsuario());
        // session.saveOrUpdate(persona);       // session.merge(persona);
        sesion.update(persona);
    }
    /**
     * Método que borra un usuario de la BBDD y por ende, sus registros asociados.
     * Recibe el id de un usuario.
     * @param id Entero que representa el id.
     * @throws Exception Lanza una excepción si algo falla.
     */
    public void borrar (int id) throws Exception {
        UsuariosEntity usuario = sesion.get(UsuariosEntity.class,id);
        sesion.delete(usuario);
    }
}