package DAO;

import Entities.Ciudadania;
import Entities.Matrimonios;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Conection {
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
     * Precondiciones: Debe recibir un objeto.
     * Método para guardar un Objeto del tipo que sea en la BBDD.
     * @param objeto Es el objeto del tipo que sea para guardar en la BBDD.
     * @return Devuelve un objeto por si quiero mostrarlo.
     * Postcondiciones: Se guarda el usuario en la BBDD con sus datos.
     */
    public Object guardar(Object objeto){
        return sesion.save(objeto);
    }

    /**
     * Precondiciones: Debe recibir un ciudadano válido.
     * Método que actualiza un ciudadano en la BBDD.
     * Recibe un ciudadano ya modificado para actualizar.
     * @param ciudadano Objeto usuario que actualizará.
     * Postcondiciones: Se actualiza el ciudadano.
     */
    public void actualizarMuerte (Ciudadania ciudadano){
        sesion.update(ciudadano);
    }

    /**
     * Precondiciones: Debe recibir un matrimonio válido.
     * Método que actualiza un matrimonio en la BBDD.
     * Recibe un matrimonio ya modificado para actualizar.
     * @param matrimonio Objeto usuario que actualizará.
     * Postcondiciones: Se actualiza el matrimonio.
     */
    public void actualizarDivorcio (Matrimonios matrimonio){
        sesion.update(matrimonio);
    }
}