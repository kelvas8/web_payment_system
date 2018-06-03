package by.epam.task4.java.model.dao.interfaces;

import by.epam.task4.java.model.entity.Account;

public interface IAccountsDAO {

    public int insertAccount();
    public boolean deleteAccount();
    public Account findAccount();
    public boolean updateAccount();
}
