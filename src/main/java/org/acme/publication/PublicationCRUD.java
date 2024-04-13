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

/**
 * Clase `PublicationCRUD` proporciona operaciones CRUD para documentos de publicaciones en una base de datos MongoDB.
 */
public class PublicationCRUD {
    
    /**
     * Atributo `collectionPublication` es una colección de MongoDB para realizar operaciones CRUD en documentos de publicaciones.
     */
    private final MongoCollection<Document> collectionPublication;
    
    /**
     * Constructor para inicializar la clase `PublicationCRUD` con una instancia de `MongoDatabase`.
     *
     * @param database Instancia de `MongoDatabase`.
     */
    public PublicationCRUD(MongoDatabase database) {
        this.collectionPublication = database.getCollection("posts");
    }
    
    /**
     * Método para agregar una nueva publicación a la colección.
     *
     * @param at    El usuario que publica.
     * @param message El mensaje de la publicación.
     */
    public void addPublication(String at, String message) {
        Document nuevoPost = new Document("usuario", at).append("mensaje", message);
        collectionPublication.insertOne(nuevoPost);
    }
    
    /**
     * Método para obtener una lista de todas las publicaciones en formato JSON.
     *
     * @return Representación de cadena de la lista de publicaciones en formato JSON.
     */
    public String PublicationArray() {
        Gson json = new Gson();
        Bson projection = Projections.fields(Projections.include("usuario", "mensaje"), Projections.excludeId());
        List<Document> posts = new ArrayList<>();
        collectionPublication.find().projection(projection).into(posts);
        String ans = json.toJson(posts);
        return ans;
    }
    
    /**
     * Método para obtener las publicaciones de un usuario específico en formato JSON.
     *
     * @param at El usuario para el que se desean obtener las publicaciones.
     * @return Representación de cadena de las publicaciones del usuario en formato JSON.
     */
    public String getUserPublication(String at) {
        Bson projection = Projections.fields(Projections.include("usuario", "mensaje"),
                Projections.excludeId());
        List<Document> postsUsuario = new ArrayList<>();
        collectionPublication.find(eq("usuario", at)).projection(projection).into(postsUsuario);
        Gson json = new Gson();
        String ans = json.toJson(postsUsuario);
        return ans;
    }
    
    /**
     * Método para eliminar una publicación específica de la colección.
     *
     * @param at    El usuario que publicó.
     * @param message El mensaje de la publicación.
     */
    public void DeletePost(String at, String message) {
        Bson filter = Filters.and(eq("usuario", at), eq("mensaje", message));
        collectionPublication.deleteOne(filter);
    }
}
