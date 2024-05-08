import java.util.*;
public class ControladorTransaction implements Controller {
    ConsoleReader con=new ConsoleReader();
    Scanner leer = new Scanner(System.in);
    @Override
    public void execute() {
        Menu menu = new Menu();
        int n = 0;
            menu.addMenuItem(1, new MenuItem("BORROW", this::booroe));
            menu.addMenuItem(2, new MenuItem("RETURN", this::retun));
            menu.addMenuItem(3, new MenuItem("MOSTRAR TODAS LAS TRANSACCIONES", this::MostrartodaslasTransacciones));
            menu.addMenuItem(4, new MenuItem("FILTRAR TRANSACCIONES POR CLIENTE", this::Filtrarcliente));
            menu.addMenuItem(5, new MenuItem("FILTRAR TRANSACCIONES POR FECHA", this::Filtrarfecha));
            menu.addMenuItem(6, new MenuItem("FILTRAR TRANSACCIONES POR LIBRO", this::porlibro));
            menu.display();
    }
    public void booroe(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        for (Book boors : RepositoryBook.books) {
            if (boors.isAvailable) {
                int d = boors.getPublishDate().day;
                int m = boors.getPublishDate().month;
                int y = boors.getPublishDate().year;
                String publish1 = d + "/" + m + "/" + y;
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                        boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                System.out.println("-------------------------------------------------------------------------------------------");
            }//if

        }//Book
        for (User clients : RepositoryArrayAdClie.Adminycliente) {
            if (clients instanceof Client) {
                Client ps = (Client) clients;
                String book = "";
                for (Book client : ps.getBorrowedBoooks()) {
                    book += client.title + "|";
                }//Borrowed
                int day = ps.getProfile().birthdate.day;
                int mon = ps.getProfile().birthdate.month;
                int yea = ps.getProfile().birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                        ps.getProfile().name, ps.getProfile().lastName, Birthdate, clients.username, book);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }//if de instance
        }//for repo
        System.out.println("Id:" + id);
        System.out.println("Type: Borrow ");
        System.out.print("Nombre del cliente: ");
        String nc = leer.nextLine();
        System.out.print("Apellido del cliente: ");
        String ac = leer.nextLine();
        StringValidator in = s -> s.matches("\\d+");
        String ib = con.ReadString("Isbn", in);
        IntegerValidator id2=(value)-> value > 0 && value <=31;
        int D= con.ReadInt("Day",id2);
        IntegerValidator me2=(value)-> value> 0&& value <=12;
        int M=con.ReadInt("Month",me2);
        IntegerValidator ye2=(value)->value> 0&& value<=9999;
        int Y= con.ReadInt("Year",ye2);
        Date publish = new Date(D, M, Y);
        publish.setDate();


        for (User res : RepositoryArrayAdClie.Adminycliente) {
            if (res instanceof Client) {
                Client le = (Client) res;
                if (le.getProfile().name.equals(nc) && le.getProfile().lastName.equals(ac) && le.getBorrowedBoooks().size() < 3) {
                    for (Book burs : RepositoryBook.books) {
                        if (burs.isbn.equals(ib)) {
                            Transaction tans1 = new Transaction(id, "Borrow", le, burs, publish);
                            RepositoryTransaction.tras.add(tans1);
                            burs.setAvailable(false);
                            //   Client.borrowedBoooks.add(burs);
                            le.setBorrowedBoooks(burs);
                        }
                    }
                }
            }
        }

    }
    public void retun(){
        UUID uuid1 = UUID.randomUUID();
        String id27 = uuid1.toString();
        for (Book boors : RepositoryBook.books) {
            if (!boors.isAvailable) {
                int d = boors.getPublishDate().day;
                int m = boors.getPublishDate().month;
                int y = boors.getPublishDate().year;
                String publish1 = d + "/" + m + "/" + y;
                System.out.println("------------------------------------------------------------------------------------------");
                System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                        boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                System.out.println("-------------------------------------------------------------------------------------------");
            }//if
        }//for
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
        System.out.println("Id:" + id27);
        System.out.println("Type: Return");
        System.out.print("Nombre del cliente: ");
        String nc2 = leer.nextLine();
        System.out.print("Apellido del cliente: ");
        String ac3 = leer.nextLine();
        StringValidator in1 = d -> d.matches("\\d+");
        String ib1 = con.ReadString("Isbn", in1);
        IntegerValidator id3=(value)-> value > 0 && value <=31;
        int D2= con.ReadInt("Day",id3);
        IntegerValidator me3=(value)-> value> 0&& value <=12;
        int M2=con.ReadInt("Month",me3);
        IntegerValidator ye3=(value)->value> 0&& value<=9999;
        int Y2= con.ReadInt("Year",ye3);
        Date publish2 = new Date(D2, M2, Y2);

        for (User cirs : RepositoryArrayAdClie.Adminycliente) {
            if (cirs instanceof Client) {
                Client no = (Client) cirs;
                if (no.getProfile().name.equals(nc2) && no.getProfile().lastName.equals(ac3)) {
                    for (Book ches : no.getBorrowedBoooks()) {
                        if (ches.isbn.equals(ib1)) {

                            Transaction pin = new Transaction(id27, "Return", no, ches, publish2);
                            RepositoryTransaction.tras2.add(pin);
                            System.out.println("Se agrego la transaccion");
                        }//if
                    }//for
                }//if
            }//if
        }//for
        for (int i = 0; i < RepositoryArrayAdClie.Adminycliente.size(); i++) {
            User usel = RepositoryArrayAdClie.Adminycliente.get(i);
            if (usel instanceof Client) {
                Client client = (Client) usel;
                if (client.getProfile().name.equals(nc2) && client.getProfile().lastName.equals(ac3)) {
                    for (int g = 0; g < client.borrowedBoooks.size(); g++) {
                        if (client.getBorrowedBoooks().get(g).isbn.equals(ib1)) {
                            client.getBorrowedBoooks().remove(g);
                            for (Book chest : RepositoryBook.books) {
                                if (chest.isbn.equals(ib1)) {
                                    chest.setAvailable(true);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
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
    }
    /*5*/
    public void Filtrarcliente(){
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
    }
    ////////////case//////////////
    public void trans() {
        ConsoleReader con=new ConsoleReader();
        Scanner leer = new Scanner(System.in);
        System.out.println("1) Borrow ");
        System.out.println("2) Return ");
        System.out.println("3) Mostrar transacciones");
        System.out.println("4) Filtrar por cliente");
        System.out.println("5) Filtrar por fecha");
        System.out.println("6) Filtrar por libro ");
        System.out.println("Elige una opcion: ");
        int elige = leer.nextInt();
        switch (elige) {
            case 1:
                UUID uuid = UUID.randomUUID();
                String id = uuid.toString();
                for (Book boors : RepositoryBook.books) {
                    if (boors.isAvailable) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }//if

                }//Book
                for (User clients : RepositoryArrayAdClie.Adminycliente) {
                    if (clients instanceof Client) {
                        Client ps = (Client) clients;
                        String book = "";
                        for (Book client : ps.getBorrowedBoooks()) {
                            book += client.title + "|";
                        }//Borrowed
                        int day = ps.getProfile().birthdate.day;
                        int mon = ps.getProfile().birthdate.month;
                        int yea = ps.getProfile().birthdate.year;
                        String Birthdate = day + "/" + mon + "/" + yea;
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| Borrowed books: %s| ",
                                ps.getProfile().name, ps.getProfile().lastName, Birthdate, clients.username, book);
                        System.out.println("");
                        System.out.println("--------------------------------------------------------------------------------");
                    }//if de instance
                }//for repo
                System.out.println("Id:" + id);
                leer.nextLine();
                System.out.println("Type: Borrow ");
                System.out.print("Nombre del cliente: ");
                String nc = leer.nextLine();
                System.out.print("Apellido del cliente: ");
                String ac = leer.nextLine();
                StringValidator in = s -> s.matches("\\d+");
                String ib = con.ReadString("Isbn", in);
                IntegerValidator id2=(value)-> value > 0 && value <=31;
                int D= con.ReadInt("Day",id2);
                IntegerValidator me2=(value)-> value> 0&& value <=12;
                int M=con.ReadInt("Month",me2);
                IntegerValidator ye2=(value)->value> 0&& value<=9999;
                int Y= con.ReadInt("Year",ye2);
                Date publish = new Date(D, M, Y);
                publish.setDate();


                for (User res : RepositoryArrayAdClie.Adminycliente) {
                    if (res instanceof Client) {
                        Client le = (Client) res;
                        if (le.getProfile().name.equals(nc) && le.getProfile().lastName.equals(ac) && le.getBorrowedBoooks().size() < 3) {
                            for (Book burs : RepositoryBook.books) {
                                if (burs.isbn.equals(ib)) {
                                    Transaction tans1 = new Transaction(id, "Borrow", le, burs, publish);
                                    RepositoryTransaction.tras.add(tans1);
                                    burs.setAvailable(false);
                                    //   Client.borrowedBoooks.add(burs);
                                    le.setBorrowedBoooks(burs);
                                }
                            }
                        }
                    }
                }
                break; //Case 1
            case 2:
                UUID uuid1 = UUID.randomUUID();
                String id27 = uuid1.toString();
                for (Book boors : RepositoryBook.books) {
                    if (!boors.isAvailable) {
                        int d = boors.getPublishDate().day;
                        int m = boors.getPublishDate().month;
                        int y = boors.getPublishDate().year;
                        String publish1 = d + "/" + m + "/" + y;
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.printf("ISBN: %s| Título: %s| Autor: %s| Fecha de Publicación: %s | Disponible: %s|%n ",
                                boors.isbn, boors.title, boors.author.getProfile().name, publish1, boors.isAvailable);
                        System.out.println("-------------------------------------------------------------------------------------------");
                    }//if
                }//for
                System.out.println("Id:" + id27);
                leer.nextLine();
                System.out.println("Type: Return");
                System.out.print("Nombre del cliente: ");
                String nc2 = leer.nextLine();
                System.out.print("Apellido del cliente: ");
                String ac3 = leer.nextLine();
                StringValidator in1 = d -> d.matches("\\d+");
                String ib1 = con.ReadString("Isbn", in1);
                IntegerValidator id3=(value)-> value > 0 && value <=31;
                int D2= con.ReadInt("Day",id3);
                IntegerValidator me3=(value)-> value> 0&& value <=12;
                int M2=con.ReadInt("Month",me3);
                IntegerValidator ye3=(value)->value> 0&& value<=9999;
                int Y2= con.ReadInt("Year",ye3);
                Date publish2 = new Date(D2, M2, Y2);

                for (User cirs : RepositoryArrayAdClie.Adminycliente) {
                    if (cirs instanceof Client) {
                        Client no = (Client) cirs;
                        if (no.getProfile().name.equals(nc2) && no.getProfile().lastName.equals(ac3)) {
                            for (Book ches : no.getBorrowedBoooks()) {
                                if (ches.isbn.equals(ib1)) {

                                    Transaction pin = new Transaction(id27, "Return", no, ches, publish2);
                                    RepositoryTransaction.tras2.add(pin);
                                    System.out.println("Se agrego la transaccion");
                                }//if
                            }//for
                        }//if
                    }//if
                }//for
                    for (int i = 0; i < RepositoryArrayAdClie.Adminycliente.size(); i++) {
                        User usel = RepositoryArrayAdClie.Adminycliente.get(i);
                        if (usel instanceof Client) {
                            Client client = (Client) usel;
                             if (client.getProfile().name.equals(nc2) && client.getProfile().lastName.equals(ac3)) {
                                for (int g = 0; g < client.borrowedBoooks.size(); g++) {
                                    if (client.getBorrowedBoooks().get(g).isbn.equals(ib1)) {
                                        client.getBorrowedBoooks().remove(g);
                                        for (Book chest : RepositoryBook.books) {
                                            if (chest.isbn.equals(ib1)) {
                                                chest.setAvailable(true);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                break; //Case 2
            case 3:
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
                break;//Case 3
            case 4:
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
                break;//Case 4
            case 5:
                leer.nextLine();
                IntegerValidator id4=(value)-> value > 0 && value <=31;
                int dia= con.ReadInt("Day",id4);
                IntegerValidator me4=(value)-> value> 0&& value <=12;
                int mes=con.ReadInt("Month",me4);
                IntegerValidator ye4=(value)->value> 0&& value<=9999;
                int año= con.ReadInt("Year",ye4);
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
                break;//Case 5
            case 6:
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
                break;//Case 6
        }//Swich
    }//Metodo que llama al menu


}//Clase

