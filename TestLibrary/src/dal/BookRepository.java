/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Book;

public class BookRepository extends AbstractRepository<Book> {
    @Override
    public Book findById(int bookId) {
        for (Book book : items) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}
