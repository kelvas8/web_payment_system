package by.epam.task4.java.model.dao.jdbc;

import by.epam.task4.java.model.dao.interfaces.ITransactionsDAO;
import by.epam.task4.java.model.entity.Transaction;

public class TransactionsDAO implements ITransactionsDAO {
    @Override
    public boolean deleteTransaction() {
        return false;
    }

    @Override
    public Transaction findTransaction() {
        return null;
    }
}
