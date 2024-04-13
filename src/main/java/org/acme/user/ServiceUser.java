package org.acme.user;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.MongoUtil;

/**
 * Clase ServiceUser para exponer los servicios REST de la aplicación.
 */
@Path("/user")
public class ServiceUser {
    
    /**
     * Atributo usuarios para realizar operaciones CRUD en la colección de usuarios.
     */
    private UserCRUD usuarios = new UserCRUD(MongoUtil.getDB());
    
    /**
     * Obtiene la información de un usuario específico en formato JSON.
     *
     * @param at El nombre de usuario para el que se desea obtener la información.
     * @return Representación de cadena de la información del usuario en formato JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{user}")
    public String obtenerUsuario(@PathParam("user") String at) {
        return usuarios.getUser(at);
    }
    
    /**
     * Agrega un nuevo usuario a la colección.
     *
     * @param name  El nombre del usuario.
     * @param email La dirección de correo electrónico del usuario.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void crearUsuario(@FormParam("name") String name, @FormParam("email") String email) {
        usuarios.addUser(name, email);
    }
    
     /**
     * Elimina un usuario específico de la colección.
     *
     * @param name El nombre de usuario que se desea eliminar.
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void eliminarUsuario(@FormParam("name") String name) {
        usuarios.DeleteUser("@" + name);
    }
}
