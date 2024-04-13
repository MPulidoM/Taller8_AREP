package org.acme.publication;

import org.acme.MongoUtil;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

/**
 * Clase ServicePublication para exponer los servicios REST de la aplicación.
 */
@Path("/publication")
public class ServicePublication {
    
    /**
     * Atributo publication para realizar operaciones CRUD en la colección de publicaciones.
     */
    private PublicationCRUD publication = new PublicationCRUD(MongoUtil.getDB());
    
    /**
     * Obtiene las publicaciones de un usuario específico en formato JSON.
     *
     * @param name El nombre de usuario para el que se desean obtener las publicaciones.
     * @return Representación de cadena de las publicaciones del usuario en formato JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public String getPublication(@PathParam("name") String name) {
        return publication.getUserPublication("@" + name);
    }
    
    /**
     * Obtiene una lista de todas las publicaciones en formato JSON.
     *
     * @return Representación de cadena de la lista de publicaciones en formato JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPublicationArr() {
        return publication.PublicationArray();
    }
    
    /**
     * Agrega una nueva publicación a la colección.
     *
     * @param at    El usuario que publica.
     * @param message El mensaje de la publicación.
     */
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void CreatePublication(@FormParam("user") String at, @FormParam("post") String message) {
        publication.addPublication(at, message);
    }
    
     /**
     * Elimina una publicación específica de la colección.
     *
     * @param at    El usuario que publicó.
     * @param message El mensaje de la publicación.
     */
    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void DeletePublication(@FormParam("user") String at, @FormParam("post") String message) {
        publication.DeletePost(at, message);
    }
}
