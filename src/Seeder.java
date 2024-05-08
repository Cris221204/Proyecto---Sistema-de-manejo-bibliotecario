public class Seeder {
    public void Ayuda() {
        //Administradores

        // admin1
        Date d1 = new Date(22, 12, 74);
        Profile p1 = new Profile("Pancho", "Perez", d1);
        Administrator ad1 = new Administrator(p1, "andy", "123456", true);
        RepositoryArrayAdClie.Adminycliente.add(ad1);

        //admin2
        Date d2 = new Date(21, 11, 85);
        Profile p2 = new Profile("Aldo", "Meza", d2);
        Administrator ad2 = new Administrator(p2, "Calder", "941234", false);
        ad2.addPermissions();
     RepositoryArrayAdClie.Adminycliente.add(ad2);

        //admin3
        Date d3 = new Date(19, 04, 98);
        Profile p3 = new Profile("Axel", "Sandoval", d3);
        Administrator ad3 = new Administrator(p3, "Cam", "123457", false);
        ad3.addPermissions();
        RepositoryArrayAdClie.Adminycliente.add(ad3);

        //Clientes

        //Cliente 1
        Date dc = new Date(11, 03, 96);//Creo objeto date
        Profile pc = new Profile("Efrain", "Solorzano", dc);//Creo un objeto profile para que guarde date
        Client cc = new Client(pc, "Gin", "788456");//Creo el objeto cliente
        RepositoryArrayAdClie.Adminycliente.add(cc);
        //Cliente 2
        Date dc2 = new Date(20, 06, 87);
        Profile pc2 = new Profile("Alberto", "Sanchez", dc2);
        Client cc2 = new Client(pc2, "Chels", "963789");
        RepositoryArrayAdClie.Adminycliente.add(cc2);
        //Cliente 3
        Date dc3 = new Date(19, 10, 66);
        Profile pc3 = new Profile("Luis", "Ramirez", dc3);
        Client cc3 = new Client(pc3, "Yug", "874561");
        RepositoryArrayAdClie.Adminycliente.add(cc3);
        //Autores
        //Autor 1
        Date da = new Date(16, 11, 03);
        Profile pa = new Profile("Arturo", "Gil", da);
        Author na = new Author(pa);
        RepositoryProfile.cl.add(na);
        //Autor 2
        Date da1 = new Date(31, 12, 95);
        Profile pa1 = new Profile("Roberto", "Linarez", da1);
        Author na1 = new Author(pa1);
        RepositoryProfile.cl.add(na1);
        //Autor 3
        Date da2 = new Date(23, 01, 04);
        Profile pa2 = new Profile("Fernando", "Plata", da2);
        Author na2 = new Author(pa2);
        RepositoryProfile.cl.add(na2);
        //Libros
        //libro1
        Date dl = new Date(22, 11, 85);
        Book nb = new Book("147", "Bleach", d1, na, true);
        RepositoryBook.books.add(nb);
        na.setAuthor(nb);
        //libro2
        Date dl1=new Date(04,01,78);
        Book nb1=new Book("789","100 Mexicanos dijieron",dl1,na1,true);
        RepositoryBook.books.add(nb1);
        na1.setAuthor(nb1);
        //libro3
        Date dl2=new Date(25,12,24);
        Book nb2=new Book("963","Señor de los anillos",dl2,na2,true);
        RepositoryBook.books.add(nb2);
        na2.setAuthor(nb2);
    }
}

