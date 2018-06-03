package by.epam.task4.java.model.dao.interfaces;

import by.epam.task4.java.model.entity.Transaction;

public interface ITransactionsDAO {

    public boolean deleteTransaction();
    public Transaction findTransaction();
}
