package programming2test.etest1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore
{
    public static int ISBN_INDEX = 0;
    public static int TITLE_INDEX = 1;
    public static int AUTHOR_INDEX = 2;
    public static int PUBLISHER_INDEX = 3;
    public static int PUBLISHER_YEAR_INDEX = 4;
    public static int QUANTITY_INDEX = 5;
    public static int PRICE_INDEX = 6;

    public static void main(String[] args)
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
        try
        {
            FileReader fileReader = new FileReader("books.txt");// Enter the entire path of the file if needed
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;
            while(!endOfFile)
            {
                String bookLine = bufferedReader.readLine();
                if (bookLine != null)
                {
                    String[] bookData = bookLine.split(", ");
                    String isbn = bookData[ISBN_INDEX];
                    String title = bookData[TITLE_INDEX];
                    String author = bookData[AUTHOR_INDEX];
                    String publisher = bookData[PUBLISHER_INDEX];
                    int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
                    int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
                    double price = Double.parseDouble (bookData[PRICE_INDEX]);
                    Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
                    bookList.add(book);

                }
                else
                {
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } // End try

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Uncomment the following lines once you have implemented the required methods
        //printBookDetails(bookList);
        //purchaseBook(bookList);
    }
    public static void printBookDetails(ArrayList<Book> bookList){
        for(Object object : bookList){
            Book theBook = (Book)object;
            System.out.print(theBook.getIsbn() + " | ");
            System.out.print(theBook.getTitle() + " | ");
            System.out.print(theBook.getAuthor() + " | ");
            System.out.print(theBook.getPublisher() + " | ");
            System.out.print(theBook.getPublishYear() + " | ");
            System.out.print(theBook.getQuantity() + " | ");
            System.out.print(theBook.getPrice() + " | ");
        }
    }
    public static Book getBook(ArrayList<Book> bookList, String title){
        for(Object object : bookList){
            Book theBook = (Book)object;
            if(theBook.getTitle().equals(title)){
                return theBook;
            }
        }
        return null;
    }
    public static void topUpCard(ChargeCard card, double amount){
        card.topUpFunds(amount);
    }
    public static void purchaseBook(ArrayList<Book> bookList){
        Scanner scanner = new Scanner(System.in);
        double funds = scanner.nextDouble();
        ChargeCard theCard = new ChargeCard();
        boolean validAmount = false;
        while(!validAmount) {
            System.out.print("How many money do you want to place");
            if(scanner.hasNextDouble()) {
                if(scanner.nextDouble() <= 0) {
                    System.out.print("Error! Enter a positive number");
                }
                else {
                    topUpCard(theCard, scanner.nextDouble());
                    validAmount = true;
                }
            }
            else{
                System.out.print("Error! Enter a number");
            }
        }
        boolean quit = false;
        String status = "";
        Book currentBook;
        int quantity;
        while(!quit){
            System.out.println(theCard.getFunds());
            System.out.print("\nPlease enter your book name");
            if(theCard.getFunds() <= 0) {
                quit = true;
                System.out.print("Low Balance");
            }
            else{
                if(scanner.hasNext()){
                    status = scanner.next();
                    if(status.equals("quit"))
                        quit = true;
                    else {
                        currentBook = getBook(bookList, status);
                        if (currentBook == null) {
                            System.out.println("We don't have this book");
                        } else {
                            quantity = currentBook.getQuantity();
                            if(currentBook.getQuantity() == 0){
                                System.out.println("We don't have enough books");
                            }
                            else{
                                quantity--;
                                currentBook.setQuantity(quantity);
                                theCard.removeFunds(currentBook.getPrice());
                                System.out.print("Payment Succeed");
                            }
                        }
                    }
                }
                else{
                    System.out.println("Please enter a string");
                }
            }
        }
    }
}


