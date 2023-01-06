package lab04;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Testing class for generic Library.
 *
 */
public class LibraryGenericTest {

  public static void main(String[] args) {

    // test a library that uses names (String) to id patrons
    Library<String> lib1 = new Library<String>();
    lib1.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib1.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib1.add(9780446580342L, "David Baldacci", "Simple Genius");

    String patron1 = "Jane Doe";

    if (!lib1.checkout(9780330351690L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib1.checkout(9780374292799L, patron1, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<String>> booksCheckedOut1 = lib1
        .lookup(patron1);
    if (booksCheckedOut1 == null
        || booksCheckedOut1.size() != 2
        || !booksCheckedOut1.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut1.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut1.get(0).getHolder().equals(patron1)
        || !booksCheckedOut1.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut1.get(1).getHolder().equals(patron1)
        || !booksCheckedOut1.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib1.checkin(patron1))
      System.err.println("TEST FAILED: checkin(holder)");

    // test a library that uses phone numbers (PhoneNumber) to id patrons
    Library<PhoneNumber> lib2 = new Library<PhoneNumber>();
    lib2.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib2.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib2.add(9780446580342L, "David Baldacci", "Simple Genius");

    PhoneNumber patron2 = new PhoneNumber("305.555.1234");

    if (!lib2.checkout(9780330351690L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: first checkout");
    if (!lib2.checkout(9780374292799L, patron2, 1, 1, 2008))
      System.err.println("TEST FAILED: second checkout");
    ArrayList<LibraryBook<PhoneNumber>> booksCheckedOut2 = lib2
        .lookup(patron2);
    if (booksCheckedOut2 == null
        || booksCheckedOut2.size() != 2
        || !booksCheckedOut2.contains(new Book(9780330351690L, "Jon Krakauer",
            "Into the Wild"))
        || !booksCheckedOut2.contains(new Book(9780374292799L,
            "Thomas L. Friedman", "The World is Flat"))
        || !booksCheckedOut2.get(0).getHolder().equals(patron2)
        || !booksCheckedOut2.get(0).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1))
        || !booksCheckedOut2.get(1).getHolder().equals(patron2)
        || !booksCheckedOut2.get(1).getDueDate().equals(
            new GregorianCalendar(2008, 1, 1)))
      System.err.println("TEST FAILED: lookup(holder)");
    if (!lib2.checkin(patron2))                           
      System.err.println("TEST FAILED: checkin(holder)");
    
    
    
    // FILL IN for tests
    
    
   
    
    
    // FOR LAB: write tests for getInventoryList
    System.out.println("Library 1 (Strings) Results:");
    ArrayList<LibraryBook<String>> inventory = lib1.getInventoryList();
    for (LibraryBook<String> lb: inventory) {
    	System.out.println(lb.getIsbn());
    }
    
    System.out.println("Library 2 (Phone #s) Results:");
    ArrayList<LibraryBook<PhoneNumber>> inventory2 = lib2.getInventoryList();
    for (LibraryBook<PhoneNumber> lb: inventory2) {
    	System.out.println(lb.getIsbn());
    }
    
    if (!(inventory.get(0).getIsbn()== 9780330351690L && inventory.get(1).getIsbn()==9780374292799L && inventory.get(2).getIsbn()==9780446580342L)) {
    	System.err.println("TEST FAILED: getInventoryList()");
    }
    
   
    
    
    
    
    System.out.println("Testing done.");
    
    // test a medium library: you will use this for homework
    Library<String> lib3 = new Library<String>();    
    lib3.addAll("Mushroom_Publishing.txt");
    
    //testing with Type String
    String person1 = "Anna";
    ArrayList<LibraryBook<String>> lib3ISBNSorted = lib3.getInventoryList();
    System.out.println("getInventoryList lib3 Method Results: " + lib3ISBNSorted); //tests getInventoryList()
    Library<String> lib4 = new Library<String>();    
    lib4.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib4.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib4.add(9780446580342L, "David Baldacci", "Simple Genius");
    ArrayList<LibraryBook<String>> lib4ISBNSorted = lib4.getInventoryList();
    System.out.println("getInventoryList lib4 Method Results: " + lib4ISBNSorted); //tests getInventoryList()
    
    ArrayList<LibraryBook<String>> lib3AuthorSorted = lib3.getOrderedByAuthor();
    System.out.println("getOrderedByAuthor lib3 Method Results: " + lib3AuthorSorted);//tests getOrderedByAuthor()
 
    if (!lib3.checkout(9781843190004L, person1, 1, 1, 2008))
        System.err.println("TEST FAILED: first checkout");
    if (!lib3.checkout(9781843190011L, person1, 2, 3, 2008))
        System.err.println("TEST FAILED: second checkout");
    if (!lib3.checkout(9781843190028L, person1, 3, 3, 2008))
        System.err.println("TEST FAILED: third checkout");
    if (!lib3.checkout(9781843190042L, person1, 4, 4, 2008))
        System.err.println("TEST FAILED: fourth checkout");
    System.out.println("");

    
    ArrayList<LibraryBook<String>> person1OverDue = lib3.getOverdueList(2,4,2008);
    System.out.println("getOverDueList lib3 Method ResultS: " + person1OverDue); // tests getOverdueList()
    
    
    //testing with Type PhoneNumber
    Library<PhoneNumber> lib5 = new Library<PhoneNumber>();
    lib5.addAll("Mushroom_Publishing.txt");
    PhoneNumber number = new PhoneNumber("732.555.5555");
    ArrayList<LibraryBook<PhoneNumber>> lib5ISBNSorted = lib5.getInventoryList();
    System.out.println("getInventoryList lib5 Method Results: " + lib5ISBNSorted); //tests getInventoryList()
    Library<PhoneNumber> lib6 = new Library<PhoneNumber>();    
    lib6.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib6.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib6.add(9780446580342L, "David Baldacci", "Simple Genius");
    ArrayList<LibraryBook<PhoneNumber>> lib6ISBNSorted = lib6.getInventoryList();
    System.out.println("getInventoryList lib6 Method Results: " + lib6ISBNSorted); //tests getInventoryList()
    
    ArrayList<LibraryBook<PhoneNumber>> lib5AuthorSorted = lib5.getOrderedByAuthor();
    System.out.println("getOrderedByAuthor lib5 Method Results: " + lib5AuthorSorted);//tests getOrderedByAuthor()
    
    if (!lib5.checkout(9781843190004L, number, 2, 3, 2008))
        System.err.println("TEST FAILED: first checkout");
    if (!lib5.checkout(9781843190011L, number, 1, 1, 2008))
        System.err.println("TEST FAILED: second checkout");
    if (!lib5.checkout(9781843190028L, number, 3, 3, 2008))
        System.err.println("TEST FAILED: third checkout");
    if (!lib5.checkout(9781843190042L, number, 4, 4, 2008))
        System.err.println("TEST FAILED: fourth checkout");
    System.out.println("");

    
    ArrayList<LibraryBook<PhoneNumber>> numberOverDue = lib5.getOverdueList(2,4,2008);
    System.out.println("getOverDueList lib5 Method ResultS: " + numberOverDue); // tests getOverdueList()
    
    

  }
}
