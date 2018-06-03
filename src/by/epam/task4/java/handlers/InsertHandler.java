package by.epam.task4.java.handlers;

import by.epam.task4.java.model.entity.Client;
import org.json.simple.JSONObject;

public class InsertHandler {

    private String name;
    private String patronymic;
    private String surname;
    private String birthday;

    public InsertHandler(Object json) {
        JSONObject jsonObject =   (JSONObject) json;
        this.name = (String) jsonObject.get("name");
        this.patronymic = (String) jsonObject.get("patronymic");
        this.surname = (String) jsonObject.get("surname");
        this.birthday = (String) jsonObject.get("birthday");
    }

    public Client getClient() {
        Client client = new Client(name,patronymic,surname,birthday);
        return client;
    }
}
