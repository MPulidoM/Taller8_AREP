package org.acme.Thread;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

/**
 * Clase `ThreadCRUD` proporciona operaciones CRUD para documentos de hilo en una base de datos MongoDB.
 */
public class ThreadCRUD {

    /**
     * Atributo `ThreadCollection` es una colección de MongoDB para realizar operaciones CRUD en documentos de hilo.
     */
    private final MongoCollection<Document> ThreadCollection;
    
    /**
     * Constructor para inicializar la clase `ThreadCRUD` con una instancia de `MongoDatabase`.
     *
     * @param database Instancia de `MongoDatabase`.
     */
    public ThreadCRUD(MongoDatabase database) {
        this.ThreadCollection = database.getCollection("hilo");
        Long documentos = ThreadCollection.countDocuments();
        boolean bandera = documentos.intValue() == 0;
        if (bandera) {
            Document mainThread = new Document("nombre", "Principal").append("posts", new ArrayList<Document>());
            ThreadCollection.insertOne(mainThread);
        }
    }
    
    /**
     * Método para obtener el documento de hilo en formato JSON.
     *
     * @return Representación de cadena del documento de hilo en formato JSON.
     */
    public String getThreadDocument() {
        Bson ThreadProjection  = Projections.fields(Projections.include("nombre", "posts"), Projections.excludeId());
        Document thread = ThreadCollection.find().projection(ThreadProjection ).first();
        Gson json = new Gson();
        return thread != null ? json.toJson(thread) : json.toJson(new Document());
    }
    
    /**
     * Método para agregar un nuevo mensaje de usuario al hilo.
     *
     * @param arroba   El @handle del usuario.
     * @param mensaje  El mensaje del usuario.
     */
    public void addUserPost(String arroba, String mensaje) {
        ArrayList<Document> post = (ArrayList<Document>) ThreadCollection.find().first().get("posts");
        LinkedList<Document> linkedPost = new LinkedList<>(post);
        linkedPost.addFirst(new Document("User", arroba).append("message", mensaje));
        Document threadEx = new Document("nombre", "Principal").append("posts", linkedPost);
        ThreadCollection.findOneAndUpdate(eq("nombre", "Principal"), set("posts", linkedPost));
    }
}
