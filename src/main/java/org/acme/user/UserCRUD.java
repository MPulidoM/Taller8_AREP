package org.acme.user;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public class UserCRUD {
    private final MongoCollection<Document> UserCollection;

    public UserCRUD(MongoDatabase database) {
        this.UserCollection = database.getCollection("usuarios");
    }

    public void addUser(String name, String email) {
        Document newUser = new Document("nombre", name)
                .append("user", "@" + name.replace(" ", "_"))
                .append("correo", email);
        UserCollection.insertOne(newUser);
    }

    public void UserArray() {
        FindIterable<Document> users = UserCollection.find();
        for (Document user : users) {
            System.out.println(user.toJson());
        }
    }

    public String getUser(String arroba) {
        Bson projection = Projections.fields(Projections.include("user"),
                Projections.excludeId());
        Document usuario = UserCollection.find(eq("user", arroba.replace(" ", "_"))).projection(projection).first();
        Gson json = new Gson();
        return usuario != null ? json.toJson(usuario) : json.toJson(new Document());
    }

    public void DeleteUser(String at) {
        UserCollection.deleteOne(eq("user", at));
    }
}
