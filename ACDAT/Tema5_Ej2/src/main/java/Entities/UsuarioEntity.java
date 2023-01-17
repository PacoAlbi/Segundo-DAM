package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Usuario")
public class UsuarioEntity implements Serializable {

    //Atributos.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private int idUsuario;
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="idUsuario")
    private List<PostsEntity> listaPosts;
    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="idUsuario")
    private List<LikesEntity> listaLikes;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;

    //Constructores.
    public UsuarioEntity() {}
    public UsuarioEntity(int id, String nombre, String apellidos, String username, String email, String password) {
        this.idUsuario = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public UsuarioEntity(String nombre, String apellidos, String username, String password, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Getter y Setter para modificar los atributos.
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
        return String.format("ID: %d, Nombre: %s, Apellidos: %s" + System.lineSeparator() + "Username: %s, email: %s, Password: %s", idUsuario, nombre, apellidos, username, email, password);
    }
}
