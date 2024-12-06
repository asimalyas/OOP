/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentation;
//Dependency inversion principle
//single responibilty model
//open and colosed principle


import model.Book;
import model.Member;
import service.ILibraryService;
import service.LibraryService;
import dal.BookRepository;
import dal.MemberRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestLibrary {
    public static void main(String[] args) {
        // Initialize repositories and service
        BookRepository bookRepository = new BookRepository();
        MemberRepository memberRepository = new MemberRepository();
        ILibraryService libraryService = new LibraryService(bookRepository, memberRepository);

        // Pre-load data
        for (int i = 1; i <= 30; i++) {
            bookRepository.addItem(new Book(i, "Book Title " + i, "Author " + (i % 10)));
        }
        for (int i = 1; i <= 10; i++) {
            memberRepository.addItem(new Member(i, "Member " + i));
        }

        // Create the main frame
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLayout(new BorderLayout());

        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel borrowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField bookIdField = new JTextField(5);
        JTextField memberIdField = new JTextField(5);
        JButton borrowButton = new JButton("Borrow Book");
        borrowPanel.add(new JLabel("Book ID:"));
        borrowPanel.add(bookIdField);
        borrowPanel.add(new JLabel("Member ID:"));
        borrowPanel.add(memberIdField);
        borrowPanel.add(borrowButton);
        panel.add(borrowPanel);

        JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField returnBookIdField = new JTextField(5);
        JButton returnButton = new JButton("Return Book");
        returnPanel.add(new JLabel("Book ID:"));
        returnPanel.add(returnBookIdField);
        returnPanel.add(returnButton);
        panel.add(returnPanel);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Search Book");
        searchPanel.add(new JLabel("Search Book:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        panel.add(searchPanel);

        frame.add(panel, BorderLayout.NORTH);

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bookId = Integer.parseInt(bookIdField.getText());
                    int memberId = Integer.parseInt(memberIdField.getText());
                    resultArea.setText(libraryService.borrowBook(bookId, memberId));
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid Book ID or Member ID\n");
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int bookId = Integer.parseInt(returnBookIdField.getText());
                    resultArea.setText(libraryService.returnBook(bookId));
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid Book ID\n");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                resultArea.setText(libraryService.searchBooks(keyword));
            }
        });

        frame.setVisible(true);
    }
}
