package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Likes")
public class LikesEntity implements Serializable {

    //Atributos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLike")
    private int idLike;
    @ManyToOne
    //@PrimaryKeyJoinColumn Solo sirve para el One to One y si ambas primary keys se llaman igual. para onetomany y menytoone se usa joincolumn.
    @JoinColumn(name = "idUsuario")
    private UsuariosEntity usuario;
    @ManyToOne
    @JoinColumn(name = "idPost")
    private PostsEntity post;

    //Constructores.
    public LikesEntity() {
    }
    public LikesEntity(int idLike, UsuariosEntity usuario, PostsEntity post) {
        this.idLike = idLike;
        this.usuario = usuario;
        this.post = post;
    }
    public LikesEntity(UsuariosEntity usuario, PostsEntity post) {
        this.usuario = usuario;
        this.post = post;
    }
    //Getter y Setter.
    public int getIdLike() {
        return idLike;
    }

    public void setIdLike(int idLike) {
        this.idLike = idLike;
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public PostsEntity getPost() {
        return post;
    }

    public void setPost(PostsEntity post) {
        this.post = post;
    }

    //toString sobreescrito a mi gusto.
    @Override
    public String toString() {
        return String.format("idLike: %d, idUsuario: %d, idPost: %d", idLike, usuario.getIdUsuario(), post.getIdPost());
    }
}