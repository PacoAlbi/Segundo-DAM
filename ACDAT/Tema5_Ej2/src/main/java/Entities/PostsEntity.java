package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Posts")
public class PostsEntity implements Serializable {

    //Atributos.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idPost")
    private int idPost;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private UsuariosEntity usuario;
    @Column(name = "Created_at")
    private String created_at;
    @Column(name = "Updated_at")
    private String updated_at;

    //Constructores.
    public PostsEntity(){}
    public PostsEntity(int idPost, UsuariosEntity usuario, String created_at, String updated_at) {
        this.idPost = idPost;
        this.usuario = usuario;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public PostsEntity(UsuariosEntity usuario, String created_at, String updated_at) {
        this.usuario = usuario;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public PostsEntity(int idPost, String created_at, String updated_at) {
        this.idPost = idPost;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    //Getter y Setter.
    public int getIdPost() {
        return idPost;
    }
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
    public UsuariosEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
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
        return String.format("idPost: %d, creado por el usuario cuya id es %d" + System.lineSeparator() + "Creado en la fecha %s, modificado en la fecha %s", idPost, usuario.getIdUsuario(), created_at, updated_at);
    }
}