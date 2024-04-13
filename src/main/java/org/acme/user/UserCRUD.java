package org.acme.user;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

/**
 * Clase UserCRUD para realizar operaciones CRUD en la colección de usuarios.
 */
public class UserCRUD {

    /**
     * Atributo UserCollection para almacenar la colección de usuarios.
     */
    private final MongoCollection<Document> UserCollection;

    /**
     * Constructor de la clase UserCRUD.
     *
     * @param database Instancia de la base de datos.
     */
    public UserCRUD(MongoDatabase database) {
        this.UserCollection = database.getCollection("usuarios");
    }

    /**
     * Agrega un nuevo usuario a la colección.
     *
     * @param name  El nombre del usuario.
     * @param email La dirección de correo electrónico del usuario.
     */
    public void addUser(String name, String email) {
        Document newUser = new Document("nombre", name)
                .append("arroba", "@" + name.replace(" ", "_"))
                .append("correo", email);
        UserCollection.insertOne(newUser);
    }
    
     /**
     * Imprime los usuarios en la colección.
     */
    public void UserArray() {
        FindIterable<Document> users = UserCollection.find();
        for (Document user : users) {
            System.out.println(user.toJson());
        }
    }
    
    /**
     * Obtiene la información de un usuario específico en formato JSON.
     *
     * @param arroba El nombre de usuario para el que se desea obtener la información.
     * @return Representación de cadena de la información del usuario en formato JSON.
     */
    public String getUser(String arroba) {
        Bson projection = Projections.fields(Projections.include("user"),
                Projections.excludeId());
        Document usuario = UserCollection.find(eq("user", arroba.replace(" ", "_"))).projection(projection).first();
        Gson json = new Gson();
        return usuario != null ? json.toJson(usuario) : json.toJson(new Document());
    }
    
    /**
     * Elimina un usuario específico de la colección.
     *
     * @param at El nombre de usuario que se desea eliminar.
     */
    public void DeleteUser(String at) {
        UserCollection.deleteOne(eq("user", at));
    }
}
