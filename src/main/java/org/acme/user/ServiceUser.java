package org.acme.user;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.MongoUtil;

@Path("/user")
public class ServiceUser {
    private UserCRUD usuarios = new UserCRUD(MongoUtil.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{user}")
    public String obtenerUsuario(@PathParam("user") String at) {
        return usuarios.getUser(at);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void crearUsuario(@FormParam("name") String name, @FormParam("email") String email) {
        usuarios.addUser(name, email);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void eliminarUsuario(@FormParam("name") String name) {
        usuarios.DeleteUser("@" + name);
    }
}