package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Usuarios")
public class UsuariosEntity implements Serializable {

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
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Username")
    private String username;
    @Column(name = "Password")
    private String password;
    @Column(name = "Email")
    private String email;

    //Constructores.
    public UsuariosEntity() {}
    public UsuariosEntity(int idUsuario, List<PostsEntity> listaPosts, List<LikesEntity> listaLikes, String nombre, String apellidos, String username, String password, String email) {
        this.idUsuario = idUsuario;
        this.listaPosts = listaPosts;
        this.listaLikes = listaLikes;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public UsuariosEntity(List<PostsEntity> listaPosts, List<LikesEntity> listaLikes, String nombre, String apellidos, String username, String password, String email) {
        this.listaPosts = listaPosts;
        this.listaLikes = listaLikes;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public UsuariosEntity(int idUsuario, String nombre, String apellidos, String username, String password, String email) {
        this.idUsuario = idUsuario;
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
    public List<PostsEntity> getListaPosts() {
        return listaPosts;
    }
    public void setListaPosts(List<PostsEntity> listaPosts) {
        this.listaPosts = listaPosts;
    }
    public List<LikesEntity> getListaLikes() {
        return listaLikes;
    }
    public void setListaLikes(List<LikesEntity> listaLikes) {
        this.listaLikes = listaLikes;
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
        return String.format("ID: %d, Nombre: %s, Apellidos: %s" + System.lineSeparator() + "Username: %s, email: %s, Password: %s" + System.lineSeparator() +
                "Sus Posts: %s" + System.lineSeparator() + "Sus Likes %s", idUsuario, nombre, apellidos, username, email, password, listaPosts, listaLikes);
    }
}
