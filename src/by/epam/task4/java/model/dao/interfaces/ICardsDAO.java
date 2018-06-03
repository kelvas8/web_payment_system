package by.epam.task4.java.model.dao.interfaces;

import by.epam.task4.java.model.entity.Card;


public interface ICardsDAO {
    public int insertCard();
    public boolean deleteCard();
    public Card findCard();
    public boolean updateCard();
}
