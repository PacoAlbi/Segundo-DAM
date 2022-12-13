import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

    private static SessionFactory sessionFactory;
    public static void main(String[] args) {
        try {
            setUp();
            guardar("Evita Peron", 2000.00);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Método para hace un insert
     * @param nombre
     * @param saldo
     */
    private static void guardar(String nombre, Double saldo) {
        PersonasEntity persona = new PersonasEntity(nombre, saldo);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        int id = (int) session.save(persona);
        transaction.commit();
        System.out.println(id);
        sessionFactory.close();
    }

    /**
     * Método que crea la conexión a la BBDD
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
}
