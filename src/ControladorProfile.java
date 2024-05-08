import java.util.*;

public class ControladorProfile implements Controller {
    Scanner leer = new Scanner(System.in);
    @Override
    public void execute() {
        Menu menu = new Menu();
        int n=0;
        menu.addMenuItem(1, new MenuItem("CLIENTES", this::cliente));
        menu.addMenuItem(2,new MenuItem("AUTORES",this::auto));

        menu.display();

    }
    public void cliente(){
        for (User clients : RepositoryArrayAdClie.Adminycliente) {
            if (clients instanceof Client){
                Client clien=(Client) clients;
                String book = "";
                for (Book client : clien.getBorrowedBoooks()) {
                    book += client.title + "|";
                }
                int day = clien.getProfile().birthdate.day;
                int mon = clien.getProfile().birthdate.month;
                int yea = clien.getProfile().birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                        clien.getProfile().name, clien.getProfile().lastName, Birthdate, clients.username, book);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }}

    }
    public void auto(){
        for (Author autors : RepositoryProfile.cl) {
            String book2 = "";
            for (Book autor : autors.getAuthor()) {
                book2 += autor.title + "|";
            }
            int day = autors.getProfile().birthdate.day;
            int mon = autors.getProfile().birthdate.month;
            int yea = autors.getProfile().birthdate.year;
            String Birthdate = day + "/" + mon + "/" + yea;
            System.out.println("--------------------------------------------");
            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s ",
                    autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
            System.out.println("");
            System.out.println("--------------------------------------------");
        }
    }
    //////////////case////////////////
    public void profiles() {
        Scanner leer = new Scanner(System.in);
        int numero = 0;
        System.out.println("2) Author");
        System.out.println("1) Cliente");
        System.out.println("Escoja una opcion: ");
        numero = leer.nextInt();
        leer.nextLine();
        switch (numero) {
            case 1:
                for (User clients : RepositoryArrayAdClie.Adminycliente) {
                    if (clients instanceof Client){
                        Client clien=(Client) clients;
                    String book = "";
                    for (Book client : clien.getBorrowedBoooks()) {
                        book += client.title + "|";
                    }
                    int day = clien.getProfile().birthdate.day;
                    int mon = clien.getProfile().birthdate.month;
                    int yea = clien.getProfile().birthdate.year;
                    String Birthdate = day + "/" + mon + "/" + yea;
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                            clien.getProfile().name, clien.getProfile().lastName, Birthdate, clients.username, book);
                    System.out.println("");
                    System.out.println("--------------------------------------------------------------------------------");
                }}
                break;
            case 2:
                for (Author autors : RepositoryProfile.cl) {
                    String book2 = "";
                    for (Book autor : autors.getAuthor()) {
                        book2 += autor.title + "|";
                    }
                    int day = autors.getProfile().birthdate.day;
                    int mon = autors.getProfile().birthdate.month;
                    int yea = autors.getProfile().birthdate.year;
                    String Birthdate = day + "/" + mon + "/" + yea;
                    System.out.println("--------------------------------------------");
                    System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s ",
                            autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
                    System.out.println("");
                    System.out.println("--------------------------------------------");
                }
                break;
            case 3:
                System.out.println("No se puede realizar");
                break;
        }
    }


}
