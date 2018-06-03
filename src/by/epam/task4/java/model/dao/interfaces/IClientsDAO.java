package by.epam.task4.java.model.dao.interfaces;


import by.epam.task4.java.model.entity.Client;

import java.util.ArrayList;

public interface IClientsDAO {

    public boolean insertClient(Client client);
    public ArrayList<Client> getClients();
    public boolean deleteClient(int id);
    public Client findClient();
    public boolean updateClient(Client client);
}
