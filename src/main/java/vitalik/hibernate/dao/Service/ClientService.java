package vitalik.hibernate.dao.Service;

import vitalik.hibernate.dao.Dao.ClientDao;
import vitalik.hibernate.dao.Model.Book;
import vitalik.hibernate.dao.Model.Client;

import java.util.List;

public class ClientService {
    private static ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public void persist(Client entity) {
        clientDao.openCurrentSessionWithTransaction();
        clientDao.persist(entity);
        clientDao.closeCurrentSessionWithTransaction();
    }

    public void update(Client entity) {
        clientDao.openCurrentSessionWithTransaction();
        clientDao.update(entity);
        clientDao.closeCurrentSessionWithTransaction();
    }

    public Client findById(String id) {
        clientDao.closeCurrentSession();
        Client client = clientDao.findById(id);
        clientDao.closeCurrentSession();
        return client;
    }

    public void delete(Client entity) {
        clientDao.openCurrentSessionWithTransaction();
        clientDao.delete(entity);
        clientDao.closeCurrentSessionWithTransaction();
    }

    public List<Client> findAll() {
        clientDao.openCurrentSessionWithTransaction();
        List<Client> clients = clientDao.findAll();
        clientDao.closeCurrentSessionWithTransaction();
        return clients;
    }

    public void deleteAll() {
        clientDao.openCurrentSessionWithTransaction();
        clientDao.deleteAll();
        clientDao.closeCurrentSessionWithTransaction();
    }

    public List<Client> getClientBooks() {
        clientDao.openCurrentSessionWithTransaction();
        List<Client> clients = clientDao.getClientBooks();
        clientDao.openCurrentSessionWithTransaction();
        return clients;
    }
}
