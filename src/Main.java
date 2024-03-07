import java.util.concurrent.Callable;

public class Main {
    public static void main(String[] args) {
        Book[] books ={
                new Book("Clean Code","Robert M.Martin",2008, 600),
                new Book("Effective Java","Joshua Bloch",2017,600)
        };
        System.out.println("\nKitaplar Başarıyla Eklendi!");
        Customer[] customers = {
                new Customer("Gökhan Azizioğlu","gazizoglu@cumhuriyet.edu.tr",2000),
        };
        System.out.println("\nMüşteriler Başarıyla Eklendi!");

        double balance = 0;

        String email = "gazizoğlu@cumhuriyet.edu.tr";
        Customer foundCustomer=null;
        for (Customer c : customers){
            if (c.getEmail().equals(email)){
                foundCustomer=c;
                break;
            }
        }
        if (foundCustomer==null){
            throw new IllegalArgumentException("Müşteri bulunamadı!");
        }
        String bookName="Clean Code";
        Book foundBook=null;

        for (Book b : books){
            if (b.getName().equals(bookName)){
                foundBook=b;
                break;
            }
        }
        if (foundBook==null){
            throw new IllegalArgumentException("Kitap bulunamadı!");
        }
        try{
            foundCustomer.buyBook(foundBook.getPrice());
            balance+=foundBook.getPrice();
            System.out.println("\nkitap başarıyla satın alındı!");
        }catch (IllegalArgumentException e){
            System.out.println("\n"+e.getMessage());
        }
        System.out.println("Bakiye: "+balance);
    }
}