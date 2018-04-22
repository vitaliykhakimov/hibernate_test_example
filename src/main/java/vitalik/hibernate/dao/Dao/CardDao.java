package vitalik.hibernate.dao.Dao;

import vitalik.hibernate.dao.Model.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CardDao implements DaoInterface<Card, String> {

    private Session currentSession;

    private Transaction currentTransaction;

    public CardDao() {

    }

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() { currentSession.close(); }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void persist(Card entity) {
        getCurrentSession().save(entity);
    }

    public void update(Card entity) {
        getCurrentSession().update(entity);
    }

    public void delete(Card entity) {
        getCurrentSession().delete(entity);
    }


    public Card findById(String id) {
        Card card = (Card) getCurrentSession().get(Card.class, id);
        return card;
    }

    public List<Card> findAll() {
        List<Card> books = (List<Card>) getCurrentSession().createQuery("from Card").list();
        return books;
    }

    public void deleteAll() {
        List<Card> entityList = findAll();
        for (Card entity : entityList) {
            delete(entity);
        }
    }
}
