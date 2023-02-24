package com.service;

import com.model.Book;

import java.util.*;
import com.dao.BookDAO;
import com.util.ApplicationUtil;

import static com.util.ApplicationUtil.*;

public class BookService {
    public static List <Book> buildBookList(List <String> bookRecords)
    {
        List <Book> bList = new ArrayList<Book>();

//         Write code
        for (String book:bookRecords) {
            String temp[] = book.split(":");

            int bookId = Integer.parseInt(temp[0]);
            String department = temp[1];
            String bookName = temp[2];
            String bookAuthor = temp[3];
            double price = Double.parseDouble(temp[4]);
            String edition = temp[5];
            String publisher = temp[6];
            java.util.Date date0fPurchase = stringToDateConverter(temp[7]);

            bList.add(new Book(bookId, department, bookName, bookAuthor, price, edition, publisher, date0fPurchase));
        }

        return bList;
    }

    public boolean addBookList(String books[]){

        boolean res=false;

        // Write code
        List<String> validatedBooks = extractDetails(books);
        List<Book> bookList = buildBookList(validatedBooks);

        BookDAO bookDao = new BookDAO();

        int insertedBookCount = bookDao.insertBookList(bookList);

        if (insertedBookCount == bookList.size()) {
            res = true;
        }

        return res;
    }

    public int calculateDepartmentCount(String department)
    {
        // Write code
        BookDAO bookDao = new BookDAO();
        List<Book> retrivedBooks = bookDao.retrieveBookList(department);

        return retrivedBooks.size();
    }

}