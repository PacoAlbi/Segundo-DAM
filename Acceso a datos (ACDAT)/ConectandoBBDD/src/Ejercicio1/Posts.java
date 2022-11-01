package Ejercicio1;

import java.util.Date;

public class Posts {

    //Atributos.
    private int idPosts, idUsuarios;
    private Date created_at, updated_at;

    //Constructores.
    public Posts (){}

    public Posts(int idPosts, int idUsuarios, Date created_at_date, Date updated_at_date) {
        this.idPosts = idPosts;
        this.idUsuarios = idUsuarios;
        this.created_at = created_at_date;
        this.updated_at = updated_at_date;
    }

    public Posts(int idUsuarios, Date created_at_date, Date updated_at_date) {
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    //toString sobreescrito a mi gusto.
    @Override
    public String toString() {
        return String.format("idPost: %d, creado por el usuario cuya id es %d" + System.lineSeparator() + "Creado en la fecha %s, modificado en la fecha %s", idPosts, idUsuarios, created_at, updated_at);
    }
}
