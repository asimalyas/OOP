/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dal.BookRepository;
import dal.MemberRepository;
import model.Book;
import model.Member;

public class LibraryService implements ILibraryService {
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    // Applying GRASP principle: **Controller**
    // LibraryService acts as a controller for handling book-borrowing operations and other service tasks.
    public LibraryService(BookRepository bookRepository, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public String borrowBook(int bookId, int memberId) {
        Book book = bookRepository.findById(bookId);
        Member member = memberRepository.findById(memberId);

        if (book == null) return "Book not found.";
        if (member == null) return "Member not found.";
        if (book.isBorrowed()) return "Book is already borrowed.";

        book.setBorrowed(true);
        return "Book borrowed successfully by " + member.getName();
    }

    @Override
    public String returnBook(int bookId) {
        Book book = bookRepository.findById(bookId);
        if (book == null) return "Book not found.";
        if (!book.isBorrowed()) return "Book was not borrowed.";

        book.setBorrowed(false);
        return "Book returned successfully.";
    }

    @Override
    public String searchBooks(String keyword) {
        StringBuilder result = new StringBuilder("Search Results:\n");
        boolean found = false;

        for (Book book : bookRepository.getItems()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.append(book.toString()).append("\n");
                found = true;
            }
        }
        return found ? result.toString() : "No books found with the keyword: " + keyword;
    }
}
