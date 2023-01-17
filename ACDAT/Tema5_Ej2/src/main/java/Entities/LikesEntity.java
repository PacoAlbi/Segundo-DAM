package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Likes")
public class LikesEntity implements Serializable {

    //Atributos.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idLikes")
    private int idLikes;
    @Column(name = "idUsuarios")
    private int idUsuarios;
    @Column(name = "idPosts")
    private int idPosts;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private UsuarioEntity usuario;

    //Constructores.
    public LikesEntity() {}
    public LikesEntity(int idLikes, int idUsuarios, int idPosts) {
        this.idLikes = idLikes;
        this.idUsuarios = idUsuarios;
        this.idPosts = idPosts;
    }
    public LikesEntity(int idUsuarios, int idPosts) {
        this.idUsuarios = idUsuarios;
        this.idPosts = idPosts;
    }

    //Getter y Setter.
    public int getIdLikes() {
        return idLikes;
    }
    public void setIdLikes(int idLikes) {
        this.idLikes = idLikes;
    }
    public int getIdUsuarios() {
        return idUsuarios;
    }
    public void setIdUsuarios(int idUsuarios) {
        this.idUsuarios = idUsuarios;
    }
    public int getIdPosts() {
        return idPosts;
    }
    public void setIdPosts(int idPosts) {
        this.idPosts = idPosts;
    }

    //toString sobreescrito a mi gusto.
    @Override
    public String toString() {
        return String.format("idLike: %d, idUsuario: %d, idPost: %d", idLikes, idUsuarios, idPosts);
    }
}
