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
            //guardar("Pedro duque", 7412.00);
            //actualizar(28, "Pepe Gotera", 1200.00);
            leer(1);
            //borrar(28);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
     *
     * @param id
     * @throws Exception
     */
    private static void leer(int id) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PersonasEntity persona = session.load(PersonasEntity.class, id); //PersonasEntity persona = session.get(PersonasEntity.class, id); // Esta línea también funcionaría como la anterior
        System.out.println(persona);
        transaction.commit();
        sessionFactory.close();
    }

    /**
     *
     * @param id
     * @param nombre
     * @param saldo
     * @throws Exception
     */
    private static void actualizar(int id,String nombre, double saldo) throws Exception {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PersonasEntity persona = session.get(PersonasEntity.class,id);
        persona.setNombre(nombre);
        persona.setSaldo(saldo);
        // session.saveOrUpdate(persona);       // session.merge(persona);
        session.update(persona);
        transaction.commit();
        sessionFactory.close();
    }

    private static void borrar (int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PersonasEntity persona = session.get(PersonasEntity.class,id);
        session.delete(persona);
        transaction.commit();
        sessionFactory.close();
    }
}
