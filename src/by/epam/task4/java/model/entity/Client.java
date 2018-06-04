package by.epam.task4.java.model.entity;

public class Client {
    private int id;
    private String name;
    private String patronymic;
    private String surname;
    private String birthday;

    public Client(String name, String patronymic, String surname, String birthday) {
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birthday = birthday;
    }

    public Client(int id, String name, String patronymic, String surname, String birthday) {
        this.id = id;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday; }

    @Override
    public String toString() {
        return "{" +
                "id=\"" + id + '\"' +
                ", name=\"" + name + '\"' +
                ", patronymic=\"" + patronymic + '\"' +
                ", surname=\"" + surname + '\"' +
                ", birthday=\"" + birthday + '\"' +
                '}';
    }
}
