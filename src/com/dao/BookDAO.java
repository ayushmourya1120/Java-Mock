package com.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.model. Book;

import java.util.*;
import java.sql.*;
import java.io.*;

import static com.util.ApplicationUtil.*;

public class BookDAO {
    public int insertBookList(List<Book> bookList) {
        // Write code
        int count = 0;

        try {

            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into BOOK values (?, ?, ?, ?, ?, ?, ?, ?)");

            for (Book book : bookList) {

                int bookId = book.getBookId();
                String department = book.getDepartment();
                String bookName = book.getBookName();
                String bookAuthor = book.getBookAuthor();
                double price = book.getPrice();
                String edition = book.getEdition();
                String publisher = book.getPublisher();
                java.util.Date dateOfPurchase = book.getDateOfPurchase();
                java.sql.Date sqlDate = utilToSqlDateConverter(dateOfPurchase);
                ps.setInt(1, bookId);
                ps.setString(2, department);
                ps.setString(3, bookName);
                ps.setString(4, bookAuthor);
                ps.setDouble(5, price);
                ps.setString(6, edition);
                ps.setString(7, publisher);
                ps.setDate(8, sqlDate);

                count += ps.executeUpdate();

            }

        } catch (SQLException e) {

        }

        return count;
    }

    public List<Book> retrieveBookList(String department) {

        // Write code
        List<Book> listOfBooks = new ArrayList<>();

        try {

            Connection con = DBConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from BOOK where DEPT = ?");
            ps.setString(1, department);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                int bookId = rs.getInt(1);
                String dep = rs.getString(2);
                String bookName = rs.getString(3);
                String bookAuthor = rs.getString(4);
                double price = rs.getDouble(5);
                String edition = rs.getString(6);
                String publisher = rs.getString(7);
                java.sql.Date dateOfPurchase = rs.getDate(8);

                java.util.Date utDate = sqlToUtilDateConverter(dateOfPurchase);

                listOfBooks.add(new Book(bookId, dep, bookName, bookAuthor, price, edition, publisher, utDate));
            }

        } catch (SQLException e) {

        }

        return listOfBooks;
    }
}