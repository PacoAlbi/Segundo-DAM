package Ejercicio1;

public class Likes {

    //Atributos.
    private int idLikes, idUsuarios, idPosts;

    //Constructores.
    public Likes () {}

    public Likes(int idLikes, int idUsuarios, int idPosts) {
        this.idLikes = idLikes;
        this.idUsuarios = idUsuarios;
        this.idPosts = idPosts;
    }

    public Likes(int idUsuarios, int idPosts) {
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
