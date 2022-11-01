package Ejercicio1;

public class Usuario {

    //Atributos.
    private int id;
    private String nombre, apellidos, username, password, email;

    //Constructores.
    public Usuario() {}

    public Usuario(int id, String nombre, String apellidos, String username, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Usuario(String nombre, String apellidos, String username, String password, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Getter y Setter para modificar los atributos.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //toString sobreescrito a mi gusto.
    @Override
    public String toString() {
        return String.format("ID: %d, Nombre: %s, Apellidos: %s" + System.lineSeparator() + "Username: %s, email: %s, Password: %s", id, nombre, apellidos, username, email, password);
    }
}
