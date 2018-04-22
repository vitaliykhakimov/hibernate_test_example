package vitalik.hibernate.dao.Dao;

import vitalik.hibernate.dao.Model.Book;
import vitalik.hibernate.dao.Model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDao implements DaoInterface<Client, String>{

    private Session currentSession;

    private Transaction currentTransaction;

    public ClientDao() {}

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

    public void persist(Client entity) {
        getCurrentSession().save(entity);
    }

    public void update(Client entity) {
        getCurrentSession().update(entity);
    }

    public Client findById(String id) {
        Client client = (Client) getCurrentSession().get(Client.class, id);
        return client;
    }

    public void delete(Client entity) {
        getCurrentSession().delete(entity);
    }

    public List<Client> findAll() {
        List<Client> books = (List<Client>) getCurrentSession().createQuery("from Client").list();
        return books;
    }

    public void deleteAll() {
        List<Client> entityList = findAll();
        for (Client entity : entityList) {
            delete(entity);
        }
    }

    public List<Client> getClientBooks() {
        List<Client> clients = (List<Client>) getCurrentSession().createQuery("from Client as client, " +
                "Book as Book, Card as card " +
                "where client.id = card.client_id and book.id = card.book_id and card.date > '2018.04.19'").list();
        return clients;
    }
}
