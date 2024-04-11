package org.acme.publication;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

public class PublicationCRUD {

    private final MongoCollection<Document> collectionPublication;

    public PublicationCRUD(MongoDatabase database) {
        this.collectionPublication = database.getCollection("posts");
    }

    public void addPublication(String at, String message) {
        Document nuevoPost = new Document("usuario", at).append("mensaje", message);
        collectionPublication.insertOne(nuevoPost);
    }

    public String PublicationArray() {
        Gson json = new Gson();
        Bson projection = Projections.fields(Projections.include("usuario", "mensaje"), Projections.excludeId());
        List<Document> posts = new ArrayList<>();
        collectionPublication.find().projection(projection).into(posts);
        String ans = json.toJson(posts);
        return ans;
    }

    public String getUserPublication(String at) {
        Bson projection = Projections.fields(Projections.include("usuario", "mensaje"),
                Projections.excludeId());
        List<Document> postsUsuario = new ArrayList<>();
        collectionPublication.find(eq("usuario", at)).projection(projection).into(postsUsuario);
        Gson json = new Gson();
        String ans = json.toJson(postsUsuario);
        return ans;
    }

    public void DeletePost(String at, String message) {
        Bson filter = Filters.and(eq("usuario", at), eq("mensaje", message));
        collectionPublication.deleteOne(filter);
    }
}