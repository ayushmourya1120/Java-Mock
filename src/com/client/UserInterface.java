//*Test your application by invoking the service methods from the UserInterface class.
// You are free to write your own code in the main method to invoke the business methods
// 3 to check its correctness. UserInterface class is not taken for evaluation.*/

package com.client;

import com.service.BookService;

import java.util.*;

public class UserInterface {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        BookService bs = new BookService();

        //                 The below code gets the details of books
        //             Give input in the format as specified in the problem statement

        System.out.println("Enter the number of books");
        int num = s.nextInt();
        String b[] = new String[num];
        System.out.println("Enter the book details");
        s.nextLine();
        for (int i = 0; i < num; i++) {
            b[i] = s.nextLine();
        }
        // The below code passes the book details to the addBookList method in the BookService class

        boolean recordsAdded = bs.addBookList(b);
        if (recordsAdded)
            System.out.println("Valid book details are added successfully");
        else
            System.out.println("Failed to add records");
        // The below code calls the calculateDepartmentCount method in the BookService class
        // It will display the count of books for a particular department
        System.out.println("Enter the department");
        String dept = s.next();
        int count = bs.calculateDepartmentCount(dept);
        if (count > 0)
            System.out.println(count + " " + dept + " department books are available");
        else
            System.out.println("No books available for the specified department");
    }
}