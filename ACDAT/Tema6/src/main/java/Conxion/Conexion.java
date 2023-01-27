package Conxion;

import Entities.Profesores;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Conexion {
    /**
     * Atributos de clase para poder usarlos durante la sesión de conexión al CRUD.
     */
    private SessionFactory sessionFactory;
    private Session sesion;
    private Transaction transaction;
    /**
     * Precondiciones: No tiene.
     * Método que establece la conexión con la BBDD.
     * Postcondiciones: Se conecta al servidor de BBDD.
     */
    protected void setUp() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    /**
     * Precondiciones: Debe haber una conexión con el servidor.
     * Método que abre la conexión y prepara la sesión y la transacción para empezar.
     * Postcondiciones: Se crea la sesión.
     */
    public void abrirConexion() {
        setUp();
        sesion = sessionFactory.openSession();
        transaction = sesion.beginTransaction();
    }
    /**
     * Precondiciones: La sesión debe estar abierta y conectada.
     * Método que cierra la conexón y hace un commit si sale bien o un rollback si sale mal.
     * Avisa si hay error.
     * Postcondiciones: Se cierra la sesión.
     */
    public void cerrar() {
        try {
            transaction.commit();
            System.out.println(System.lineSeparator() + "Gestión realizada correctamente." + System.lineSeparator());
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(System.lineSeparator() + "Error haciendo el commit." + System.lineSeparator());
        }
        sessionFactory.close();
    }
    /**
     * Precondiciones: Debe recibir un id válido.
     * Método para recuperar e imprimir a un usuario y sus datos asociados.
     * Recibe el id del usuario que va a recuperar.
     * @param id entero que representa el id del usuario.
     * @throws Exception Lanza una excepción si algo falla.
     * Postcondiciones: No tiene.
     */
//    public void getUsuario(int id){
//        UsuariosEntity usuario = sesion.load(UsuariosEntity.class, id);
//        System.out.println(usuario);
//    }

    /**+
     * Precondiciones: No tiene.
     * Método que pide una lista de usuarios a la BBDD y la devuelve a la vista.
     * @return List de usuarios.
     * Postcondiciones: Devuelve una lista de usuarios y todos sus datos.
     */
//    public List<UsuariosEntity> getLista(){
//        Query query = sesion.createQuery("FROM UsuariosEntity ");
//        return (List<UsuariosEntity>) query.list();
//    }
    public void listarProfesorado (){
        List<Profesores> lista = sesion.createQuery("select p from Profesores p").getResultList();
        System.out.println(lista);
        lista = sesion.getNamedQuery("listaPorNombre").setParameter("nombre", "Eva").getResultList();
        System.out.println(lista);
    }
    /**
     * Precondiciones: Debe recibir un objeto.
     * Método para guardar un Objeto del tipo que sea en la BBDD.
     * @param objeto Es el objeto del tipo que sea para guardar en la BBDD.
     * @return ¿?
     * @throws Exception Lanza una excepción si algo falla.
     * Postcondiciones: Se guarda el usuario en la BBDD con sus datos.
     */
    public Object guardar(Object objeto){
        return sesion.save(objeto);
    }
    /**
     * Precondiciones: Debe recibir un usuario válido.
     * Método que actualiza un usuario en la BBDD.
     * Recibe un usuario ya modificado para actualizar.
     * @param usuario Objeto usuario que actualizará.
     * Postcondiciones: Se actualiza el usuario.
     */
    public void actualizar(Object obj){
        //UsuariosEntity persona = sesion.get(UsuariosEntity.class,usuario.getIdUsuario()); Esto es para recuperar a un usuario de una de las clases.
        //persona = usuario;
        //sesion.saveOrUpdate(persona);
        //sesion.merge(persona);
        sesion.update(obj);
    }
    /**
     * Precondiciones: Debe recibir un id válido.
     * Método que borra un usuario de la BBDD y por ende, sus registros asociados.
     * Recibe el id de un usuario.
     * @param id Entero que representa el id.
     * Postcondiciones: Se elimina al usuario.
     */
    public void borrar (Object obj, int id){
        Object usuario = sesion.get(obj.getClass(),id);
        sesion.delete(usuario);
    }
}