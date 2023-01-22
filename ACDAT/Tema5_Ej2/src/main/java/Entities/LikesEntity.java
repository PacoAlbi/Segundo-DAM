package Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Likes")
public class LikesEntity implements Serializable {

    //Atributos.
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idLike")
    private int idLike;
    @ManyToOne
    //@PrimaryKeyJoinColumn
    @JoinColumn(name="idUsuario")
    private UsuariosEntity usuario;
    @OneToMany
    @JoinColumn(name = "idPost")
    private List<PostsEntity> listaPosts;

    //Constructores.
    public LikesEntity() {}
    public LikesEntity(int idLike, UsuariosEntity usuario, List<PostsEntity> listaPosts) {
        this.idLike = idLike;
        this.usuario = usuario;
        this.listaPosts = listaPosts;
    }
    public LikesEntity(UsuariosEntity usuario, List<PostsEntity> listaPosts) {
        this.usuario = usuario;
        this.listaPosts = listaPosts;
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

    public List<PostsEntity> getListaPosts() {
        return listaPosts;
    }

    public void setListaPosts(List<PostsEntity> listaPosts) {
        this.listaPosts = listaPosts;
    }

    //toString sobreescrito a mi gusto.
    @Override
    public String toString() {
        return String.format("idLike: %d, idUsuario: %d, idPost:", idLike, usuario.getIdUsuario());
    }
}
