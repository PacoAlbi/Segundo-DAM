package Vacas.DAL;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Connection {

    private static SessionFactory sessionFactory;
    protected Session session;
    private Transaction transaction;


    /**
     *
     * @throws Exception
     */
    protected static void setUp() throws Exception {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // por defecto: hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    /**
     * Descripcion: Método que se encarga de abrir la sesion del objeto sessionFactory
     * e iniciar la transaccion para realizar el manejo de la base de datos
     * mediante hibernate.
     *
     * Precondiciones: ninguna
     * Postcondiciones: ninguna
     */
    public void abrirSesion(){
        try {
            setUp();
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
        } catch (Exception e) {
            System.err.println("ERROR: Error al iniciar la session");
        }

    }

   /**
    * Descripcion: Método que se encarga de cerrar la sesion del objeto sessionFactory y cerrar la transaccion
    * Precondiciones: Ninguna
    * Postcondiciones: Ninguna
    */
   public void cerrarSesion() {
        try {
            transaction.commit();
            System.out.println("Peticion gestionada correctamente");
        } catch (Exception e) {
            System.err.println("ERROR: No se ha podido realizar el commit, por ello ser procede a un rollback");

            transaction.rollback();
            throw e;
        }
        sessionFactory.close();
    }


}