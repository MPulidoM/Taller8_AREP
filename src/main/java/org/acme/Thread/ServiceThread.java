
package org.acme.Thread;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.MongoUtil;

/**
 * La clase ServiceThread proporciona puntos finales de API RESTful para operaciones CRUD en ThreadCRUD.
 */
@Path("/Thread")
public class ServiceThread {

    /**
     * Instancia de la clase ThreadCRUD para realizar operaciones CRUD en documentos Thread.
     */
    private ThreadCRUD thread = new ThreadCRUD(MongoUtil.getDB());

     /**
     * Método GET para recuperar el documento Thread en formato JSON.
     *
     * @return Representación de cadena del documento Thread en formato JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getThread() {
        return thread.getThreadDocument().toString();
    }
    
    /**
     * Método POST para agregar un nuevo mensaje de usuario al documento Thread.
     *
     * @param at       El @handle del usuario.
     * @param message  El mensaje del usuario.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addUserPost(@FormParam("user") String at, @FormParam("post") String message) {
        thread.addUserPost(at, message);
    }
}
