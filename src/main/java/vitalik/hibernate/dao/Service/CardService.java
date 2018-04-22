package vitalik.hibernate.dao.Service;

import vitalik.hibernate.dao.Dao.CardDao;
import vitalik.hibernate.dao.Model.Card;

import java.util.List;

public class CardService {
    private static CardDao cardDao;

    public CardService() {
        cardDao = new CardDao();
    }

    public void persist(Card entity) {
        cardDao.openCurrentSessionWithTransaction();
        cardDao.persist(entity);
        cardDao.closeCurrentSessionWithTransaction();
    }

    public void update(Card entity) {
        cardDao.openCurrentSessionWithTransaction();
        cardDao.update(entity);
        cardDao.closeCurrentSessionWithTransaction();
    }

    public Card findById(String id) {
        cardDao.closeCurrentSession();
        Card card = cardDao.findById(id);
        cardDao.closeCurrentSession();
        return card;
    }

    public void delete(Card entity) {
        cardDao.openCurrentSessionWithTransaction();
        cardDao.delete(entity);
        cardDao.closeCurrentSessionWithTransaction();
    }

    public List<Card> findAll() {
        cardDao.openCurrentSessionWithTransaction();
        List<Card> cards = cardDao.findAll();
        cardDao.closeCurrentSessionWithTransaction();
        return cards;
    }

    public void deleteAll() {
        cardDao.openCurrentSessionWithTransaction();
        cardDao.deleteAll();
        cardDao.closeCurrentSessionWithTransaction();
    }
}
