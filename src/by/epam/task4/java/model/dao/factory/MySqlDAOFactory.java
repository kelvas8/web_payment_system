package by.epam.task4.java.model.dao.factory;

import by.epam.task4.java.model.dao.jdbc.AccountsDAO;
import by.epam.task4.java.model.dao.jdbc.CardsDAO;
import by.epam.task4.java.model.dao.jdbc.ClientsDAO;
import by.epam.task4.java.model.dao.jdbc.TransactionsDAO;


public class MySqlDAOFactory extends DAOFactory {





    @Override
    public CardsDAO getCardsDAO() {
        return new CardsDAO();
    }

    @Override
    public TransactionsDAO getTransactionsDAO() {
        return new TransactionsDAO();
    }

    @Override
    public ClientsDAO getClientDAO() {
        return new ClientsDAO();
    }

    @Override
    public AccountsDAO getAccountsDAO() {
        return new AccountsDAO();
    }
}
