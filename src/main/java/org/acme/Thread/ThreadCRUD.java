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

public class ThreadCRUD {
    private final MongoCollection<Document> ThreadCollection;

    public ThreadCRUD(MongoDatabase database) {
        this.ThreadCollection = database.getCollection("hilo");
        Long documentos = ThreadCollection.countDocuments();
        boolean bandera = documentos.intValue() == 0;
        if (bandera) {
            Document mainThread = new Document("nombre", "Principal").append("posts", new ArrayList<Document>());
            ThreadCollection.insertOne(mainThread);
        }
    }

    public String getThreadDocument() {
        Bson ThreadProjection  = Projections.fields(Projections.include("nombre", "posts"), Projections.excludeId());
        Document thread = ThreadCollection.find().projection(ThreadProjection ).first();
        Gson json = new Gson();
        return thread != null ? json.toJson(thread) : json.toJson(new Document());
    }

    public void addUserPost(String arroba, String mensaje) {
        ArrayList<Document> post = (ArrayList<Document>) ThreadCollection.find().first().get("posts");
        LinkedList<Document> linkedPost = new LinkedList<>(post);
        linkedPost.addFirst(new Document("arroba", arroba).append("mensaje", mensaje));
        Document threadEx = new Document("nombre", "Principal").append("posts", linkedPost);
        ThreadCollection.findOneAndUpdate(eq("nombre", "Principal"), set("posts", linkedPost));
    }
}