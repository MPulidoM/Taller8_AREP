
package org.acme.Thread;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.MongoUtil;

@Path("/Thread")
public class ServiceThread {
    private ThreadCRUD thread = new ThreadCRUD(MongoUtil.getDB());

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getThread() {
        return thread.getThreadDocument().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addUserPost(@FormParam("user") String at, @FormParam("post") String message) {
        thread.addUserPost(at, message);
    }
}