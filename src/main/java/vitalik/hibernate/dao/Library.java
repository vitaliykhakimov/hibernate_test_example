package vitalik.hibernate.dao;

import vitalik.hibernate.dao.Model.Book;
import vitalik.hibernate.dao.Model.Card;
import vitalik.hibernate.dao.Model.Client;
import vitalik.hibernate.dao.Service.BookService;
import vitalik.hibernate.dao.Service.CardService;
import vitalik.hibernate.dao.Service.ClientService;
import java.sql.Date;
import java.util.List;

public class Library {
    public static void main(String args[]) {

        Date date = new Date(2018, 04, 20);

        /*BookService bookService = new BookService();
        List<Book> books = bookService.findAllBooksWithExpiredDate();
        System.out.println("Books with expired date: ");
        for (Book b : books) {
            System.out.println(" - " + b.toString());
        }*/

        /*ClientService clientService = new ClientService();
        List<Client> clients = clientService.getClientBooks();
        System.out.println("Clients: ");
        for (Client c : clients) {
            System.out.println(" - " + c.toString());
        }*/

        CardService cardService = new CardService();
        List<Card> cards = cardService.findAll();

        System.out.println("Books with expired date:");
        for (Card c : cards) {
            if (c.getDate().before(date)){
                System.out.println("Название: " + c.getBookByBookId().getTitle() +
                        " Автор: " + c.getBookByBookId().getAuthor() + " Дата: " + c.getDate());
            }
        }

        System.out.println("Client's books with not expired date:");
        for (Card c : cards) {
            if (c.getDate().after(date)){
                System.out.println("Клиент: " + c.getClientByClientId().getName() +
                        " Книга: " + c.getBookByBookId().getTitle() + " Дата: " + c.getDate());
            }
        }
    }
}
