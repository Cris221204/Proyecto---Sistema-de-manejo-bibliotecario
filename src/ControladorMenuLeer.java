import java.util.*;

public class ControladorMenuLeer implements Controller {
    ConsoleReader con= new ConsoleReader();
    Scanner leer = new Scanner(System.in);
    @Override
    public void execute() {
        Menu menu = new Menu();
        int n=0;
        do{
        menu.addMenuItem(1, new MenuItem("CLIENTES", this::Clientes));
        menu.addMenuItem(2,new MenuItem("LIBROS",this::Libros));
        menu.addMenuItem(3,new MenuItem("AUTORES",this::Autores));
        menu.addMenuItem(4,new MenuItem("MOSTRAR TODAS LAS TRANSACCIONES",this::MostrartodaslasTransacciones));
        menu.addMenuItem(5,new MenuItem("FILTRAR TRANSACCIONES POR CLIENTE",this::Filtrarcliente));
        menu.addMenuItem(6,new MenuItem("FILTRAR TRANSACCIONES POR FECHA",this::Filtrarfecha));
        menu.addMenuItem(7,new MenuItem("FILTRAR TRANSACCIONES POR LIBRO",this::porlibro));
        menu.addMenuItem(8,new MenuItem("CERRAR SESION",this::cerrar));
        menu.display();
    }while(n!=0);
    }
    /*1*/
    public void Clientes(){
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
        ControladorMenuLeer n=new ControladorMenuLeer();
        n.execute();
    }
    /*2*/
    public void Libros(){
        for (Book boors : RepositoryBook.books) {
            int d = boors.getPublishDate().day;
            int m = boors.getPublishDate().month;
            int y = boors.getPublishDate().year;
            String publish1 = d + "/" + m + "/" + y;
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                    boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
            System.out.println("-------------------------------------------------------------------------------------------");
        }
        ControladorMenuLeer n=new ControladorMenuLeer();
        n.execute();
    }
    /*3*/
    public void Autores(){
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
            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s| ",
                    autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
            System.out.println("");
            System.out.println("--------------------------------------------");
        } ControladorMenuLeer n=new ControladorMenuLeer();
        n.execute();
    }
    /*4*/
    public void MostrartodaslasTransacciones(){
        for (Transaction tex : RepositoryTransaction.tras) {
            tex.date.getDateh();
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                    tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }//Tex1
        for (Transaction tex2 : RepositoryTransaction.tras2) {
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                    tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
            System.out.println("");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }//Tex2
        ControladorMenuLeer n=new ControladorMenuLeer();
        n.execute();
    }
    /*5*/
    public void Filtrarcliente(){
        System.out.print("Dame el nombre:");
        String nombre = leer.nextLine();
        for (Transaction tex : RepositoryTransaction.tras) {
            if (tex.getClient().profile.name.equals(nombre)) {
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                        tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }//if
        }//for
        for (Transaction tex2 : RepositoryTransaction.tras2) {
            if (tex2.getClient().profile.name.equals(nombre)) {
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                        tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }//if
        }//for
        ControladorMenuLeer n=new ControladorMenuLeer();
        n.execute();
    }
    /*6*/
    public void Filtrarfecha(){
        IntegerValidator id2=(value)-> value > 0 && value <=31;
        int dia= con.ReadInt("Day",id2);
        IntegerValidator me2=(value)-> value> 0&& value <=12;
        int mes=con.ReadInt("Month",me2);
        IntegerValidator ye2=(value)->value> 0&& value<=9999;
        int año= con.ReadInt("Year",ye2);
        Date ne = new Date(dia, mes, año);
        for (Transaction tex : RepositoryTransaction.tras) {
            if (tex.getDate().day == dia && tex.getDate().month == mes && tex.getDate().year == año) {
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                        tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }//if
        }//for
        ControladorMenuLeer n=new ControladorMenuLeer();
        n.execute();
    }
    /*7*/
    public void porlibro(){
        ///////////////////
        StringValidator in2 = l -> l.matches("\\d+");
        String isbn = con.ReadString("Isbn", in2);
        for (Transaction tex : RepositoryTransaction.tras) {
            if (tex.getBook().isbn.equals(isbn)) {
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                        tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }//if
        }//forr
        for (Transaction tex2 : RepositoryTransaction.tras2) {
            if (tex2.getBook().isbn.equals(isbn)) {
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| Date: %s| ",
                        tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }//if
        }//for
        ControladorMenuLeer n=new ControladorMenuLeer();
        n.execute();
    }
    /*8*/
    public void cerrar(){
        Login login = new Login();
        login.execute();
    }
    ////////////case////////////////////
    public void leer() {
        ConsoleReader con= new ConsoleReader();
        Scanner leer = new Scanner(System.in);
        int numero;
        do {
            System.out.println("1) Clientes");
            System.out.println("2) Libros");
            System.out.println("3) Cerrar sesion");
            System.out.println("4) Autores");
            System.out.println("5) Mostrar todas las Transacciones");
            System.out.println("6) Filtrar Transaccion por cliente");
            System.out.println("7) Filtrar Transaccion por fecha");
            System.out.println("8) Filtrar Transaccion por libro ");
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
                    for (Book boors : RepositoryBook.books) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }
                    break;
                case 3:
                    Login login = new Login();
                    login.execute();
                    break;

                case 4:
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
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Books: %s| ",
                                autors.getProfile().name, autors.getProfile().lastName, Birthdate, book2);
                        System.out.println("");
                        System.out.println("--------------------------------------------");
                    }
                    break;
                case 5:
                    for (Transaction tex : RepositoryTransaction.tras) {
                        tex.date.getDateh();
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                                tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                    }//Tex1
                    for (Transaction tex2 : RepositoryTransaction.tras2) {
                        System.out.println("-----------------------------------------------------------------------------------------------");
                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                                tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------------------------------------");
                    }//Tex2
                    break;//Case 5
                case 6:
                    leer.nextLine();
                    System.out.print("Dame el nombre:");
                    String nombre = leer.nextLine();
                    for (Transaction tex : RepositoryTransaction.tras) {
                        if (tex.getClient().profile.name.equals(nombre)) {
                            System.out.println("-----------------------------------------------------------------------------------------------");
                            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                                    tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                            System.out.println("");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }//if
                    }//for
                    for (Transaction tex2 : RepositoryTransaction.tras2) {
                        if (tex2.getClient().profile.name.equals(nombre)) {
                            System.out.println("-----------------------------------------------------------------------------------------------");
                            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                                    tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                            System.out.println("");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }//if
                    }//for
                    break;
                case 7:
                    IntegerValidator id2=(value)-> value > 0 && value <=31;
                    int dia= con.ReadInt("Day",id2);
                    IntegerValidator me2=(value)-> value> 0&& value <=12;
                    int mes=con.ReadInt("Month",me2);
                    IntegerValidator ye2=(value)->value> 0&& value<=9999;
                    int año= con.ReadInt("Year",ye2);
                    Date ne = new Date(dia, mes, año);
                    for (Transaction tex : RepositoryTransaction.tras) {
                        if (tex.getDate().day == dia && tex.getDate().month == mes && tex.getDate().year == año) {
                            System.out.println("-----------------------------------------------------------------------------------------------");
                            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                                    tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                            System.out.println("");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }//if
                    }//for
                    for (Transaction tex2 : RepositoryTransaction.tras2) {
                        if (tex2.getDate().equals(ne)) {
                            System.out.println("-----------------------------------------------------------------------------------------------");
                            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s|  %s| ",
                                    tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                            System.out.println("");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }//for
                    }//if
                    break;
                case 8:
                    leer.nextLine();
                    ///////////////////
                    StringValidator in2 = l -> l.matches("\\d+");
                    String isbn = con.ReadString("Isbn", in2);
                    for (Transaction tex : RepositoryTransaction.tras) {
                        if (tex.getBook().isbn.equals(isbn)) {
                            System.out.println("-----------------------------------------------------------------------------------------------");
                            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| %s| ",
                                    tex.id, tex.type, tex.client.getProfile().name, tex.book.title, tex.date.getDateh());
                            System.out.println("");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }//if
                    }//forr
                    for (Transaction tex2 : RepositoryTransaction.tras2) {
                        if (tex2.getBook().isbn.equals(isbn)) {
                            System.out.println("-----------------------------------------------------------------------------------------------");
                            System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| Date: %s| ",
                                    tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, tex2.date.getDateh());
                            System.out.println("");
                            System.out.println("-----------------------------------------------------------------------------------------------");
                        }//if
                    }//for
                    break;

            }
        } while (numero != 9);
    }


}
