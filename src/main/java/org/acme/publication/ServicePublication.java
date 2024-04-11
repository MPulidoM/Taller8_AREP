package org.acme.publication;

import org.acme.MongoUtil;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/publication")
public class ServicePublication {

    private PublicationCRUD publication = new PublicationCRUD(MongoUtil.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public String getPublication(@PathParam("name") String name) {
        return publication.getUserPublication("@" + name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPublicationArr() {
        return publication.PublicationArray();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void CreatePublication(@FormParam("user") String at, @FormParam("post") String message) {
        publication.addPublication(at, message);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void DeletePublication(@FormParam("user") String at, @FormParam("post") String message) {
        publication.DeletePost(at, message);
    }
}
