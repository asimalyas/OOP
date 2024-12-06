/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

public interface ILibraryService {
    String borrowBook(int bookId, int memberId);
    String returnBook(int bookId);
    String searchBooks(String keyword);
}
