package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Posts")
public class PostsEntity implements Serializable {

    //Atributos.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idPosts")
    private int idPosts;
    @Column(name = "idUsuarios")
    private int idUsuarios;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "updated_at")
    private String updated_at;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private UsuarioEntity usuario;

    //Constructores.
    public PostsEntity(){}
    public PostsEntity(int idPosts, int idUsuarios, String created_at_date, String updated_at_date) {
        this.idPosts = idPosts;
        this.idUsuarios = idUsuarios;
        this.created_at = created_at_date;
        this.updated_at = updated_at_date;
    }
    public PostsEntity(int idUsuarios, String created_at_date, String updated_at_date) {
        this.idUsuarios = idUsuarios;
        this.created_at = created_at_date;
        this.updated_at = updated_at_date;
    }

    //Getter y Setter.
    public int getIdPosts() {
        return idPosts;
    }
    public void setIdPosts(int idPosts) {
        this.idPosts = idPosts;
    }
    public int getIdUsuarios() {
        return idUsuarios;
    }
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    //toString sobreescrito a mi gusto.
    @Override
    public String toString() {
        return String.format("idPost: %d, creado por el usuario cuya id es %d" + System.lineSeparator() + "Creado en la fecha %s, modificado en la fecha %s", idPosts, idUsuarios, created_at, updated_at);
    }
}
