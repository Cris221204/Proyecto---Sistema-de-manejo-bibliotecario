import java.util.*;

public class ControladorSuperAdministrator implements Controller {
    Scanner leer = new Scanner(System.in);
    ConsoleReader con = new ConsoleReader();
    @Override
    public void execute() {

        Menu menu = new Menu();
        int n=0; do{
        menu.addMenuItem(1, new MenuItem("CREAR ADMINISTRADOR", this::creaadmi));
        menu.addMenuItem(2, new MenuItem("EDITAR ADMINISTRADOR", this::editar));
        menu.addMenuItem(3, new MenuItem("ELIMINAR ADMINISTRADOR", this::eliminar));
        menu.addMenuItem(4, new MenuItem("MOSTRAR ADMINISTRADORES", this::mostrar));
        menu.addMenuItem(5, new MenuItem("CLIENTE", this::client));
        menu.addMenuItem(6, new MenuItem("AUTOR", this::autor));
        menu.addMenuItem(7, new MenuItem("LIBROS", this:: book));
        menu.addMenuItem(8, new MenuItem("PROFILE", this::pro));
        menu.addMenuItem(9, new MenuItem("TRANSACCIONES", this::tran));
        menu.addMenuItem(10, new MenuItem("PERMISOS", this::editarpermisos));
        menu.addMenuItem(11, new MenuItem("CERRAR SESION", this::cerrar));
        menu.display();
    }while(n!=11);
    }
    public void creaadmi() {
        System.out.print("Name: ");
        String namec = leer.nextLine();
        System.out.print("Last name: ");
        String lastc = leer.nextLine();
        IntegerValidator id = (value) -> value > 0 && value <= 31;
        int D = con.ReadInt("Day", id);
        IntegerValidator me = (value) -> value > 0 && value <= 12;
        int M = con.ReadInt("Month", me);
        IntegerValidator ye = (value) -> value > 0 && value <= 9999;
        int Y = con.ReadInt("Year", ye);
        System.out.print("Username: ");
        String user = leer.nextLine();
        StringValidator pas = password -> password.length() >= 6;
        String pass = con.ReadString("Password", pas);
        Date fechad = new Date(D, M, Y);
        Profile ad1 = new Profile(namec, lastc, fechad);
        Administrator ulti = new Administrator(ad1, user, pass, false);
        ulti.addPermissions();
        RepositoryArrayAdClie.Adminycliente.add(ulti);
    }

    public void editar() {
        for (User Admins : RepositoryArrayAdClie.Adminycliente) {
            if (Admins instanceof Administrator) {
                Administrator ado = (Administrator) Admins;
                int day = Admins.profile.birthdate.day;
                int mon = Admins.profile.birthdate.month;
                int yea = Admins.profile.birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                        Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
        System.out.print("Dame el nombre:");
        String nombre2 = leer.nextLine();
        System.out.print("Dame el username: ");
        String un = leer.nextLine();
        for (User mod : RepositoryArrayAdClie.Adminycliente) {
            if (mod instanceof Administrator) {
                Administrator ad = (Administrator) mod;
                if (ad.profile.name.equals(nombre2) && ad.username.equals(un)) {
                    StringValidator pa = password -> password.length() >= 6;
                    System.out.print("Nombre: ");
                    String names = leer.nextLine();
                    System.out.print("Last name: ");
                    String last = leer.nextLine();
                    IntegerValidator id2 = (value) -> value > 0 && value <= 31;
                    int D1 = con.ReadInt("Day", id2);
                    IntegerValidator me2 = (value) -> value > 0 && value <= 12;
                    int M2 = con.ReadInt("Month", me2);
                    IntegerValidator ye2 = (value) -> value > 0 && value <= 9999;
                    int Y3 = con.ReadInt("Year", ye2);
                    System.out.print("Username: ");
                    String user2 = leer.nextLine();
                    String pass2 = con.ReadString("Password", pa);
                    Date date = new Date(D1, M2, Y3);
                    mod.profile.name = names;
                    mod.profile.lastName = last;
                    mod.profile.birthdate = date;
                    mod.username = user2;
                    mod.password = pass2;
                }
            }
        }
    }

    public void eliminar() {
        for (User Admins : RepositoryArrayAdClie.Adminycliente) {
            if (Admins instanceof Administrator) {
                Administrator las = (Administrator) Admins;
                int day = Admins.profile.birthdate.day;
                int mon = Admins.profile.birthdate.month;
                int yea = Admins.profile.birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                        Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, las.isSuperAdmin);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
        System.out.print("Name: ");
        String namec1 = leer.nextLine();
        System.out.print("Last name: ");
        String lastc1 = leer.nextLine();
        System.out.print("Username:");
        String Us = leer.nextLine();
        boolean superexis = false;
        for (int i = 0; i < RepositoryArrayAdClie.Adminycliente.size(); i++) {
            if (RepositoryArrayAdClie.Adminycliente.get(i).profile.name.equals(namec1) && RepositoryArrayAdClie.Adminycliente.get(i).profile.lastName.equals(lastc1) && RepositoryArrayAdClie.Adminycliente.get(i).username.equals(Us)) {
              if(RepositoryArrayAdClie.Adminycliente.get(i).username.equals("andy")){
                  return;
              }
                RepositoryArrayAdClie.Adminycliente.remove(i);
                break;
            }
        }
        if ((superexis)) {
            System.out.println("No se puede eliminar");
        }
    }

    public void mostrar() {
        for (User Admins : RepositoryArrayAdClie.Adminycliente) {
            if (Admins instanceof Administrator) {
                Administrator ado = (Administrator) Admins;
                int day = Admins.profile.birthdate.day;
                int mon = Admins.profile.birthdate.month;
                int yea = Admins.profile.birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                        Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
    }

    public void client() {
        System.out.println("===CLIENT===");
        ControladorClient client = new ControladorClient();
        client.execute();
    }

    public void autor() {
        System.out.println("===AUTHOR===");
        ControladorAuthor auti = new ControladorAuthor();
        auti.execute();
    }

    public void book() {
        System.out.println("===BOOK===");
        ControladorBook booki = new ControladorBook();
        booki.execute();
    }

    public void pro() {
        System.out.println("===PROFILE===");
        ControladorProfile profils = new ControladorProfile();
        profils.execute();
    }

    public void tran() {
        System.out.println("===TRANSACTION===");
        ControladorTransaction teis = new ControladorTransaction();
        teis.execute();
    }

    public void editarpermisos() {
        for (User Admins : RepositoryArrayAdClie.Adminycliente) {
            if (Admins instanceof Administrator) {
                Administrator ado = (Administrator) Admins;
                int day = Admins.profile.birthdate.day;
                int mon = Admins.profile.birthdate.month;
                int yea = Admins.profile.birthdate.year;
                String Birthdate = day + "/" + mon + "/" + yea;
                System.out.println("--------------------------------------------------------------------------------");
                System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                        Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------");
            }
        }
        leer.nextLine();
        System.out.print("Dame el username: ");
        String dam = leer.nextLine();
        for (User rep : RepositoryArrayAdClie.Adminycliente) {
            if (rep instanceof Administrator) {
                Administrator pres = (Administrator) rep;
                if (rep.username.equals(dam)) {
                    if (pres.isSuperAdmin) {
                        System.out.println("No puedes modificar los permisos");
                        ControladorSuperAdministrator controladorSuperAdministrator = new ControladorSuperAdministrator();
                        controladorSuperAdministrator.execute();
                    }

                    System.out.println("===Permisos actuales del administrador===");
                    for (Permissions pes : pres.getPermissions()) {
                        System.out.println(pes);
                    }

                    System.out.println("1) Eliminar");
                    System.out.println("2) Agregar");
                    System.out.print("Selecciona una opcion:");
                    int ag = leer.nextInt();
                    if(ag==1){
                        pres.getPermissions().clear();
                        System.out.println("Eliminados");
                    }else if(ag==2){
                        System.out.println("===Permisos===");
                        System.out.println("1) Agregar Eliminar");
                        System.out.println("2) Agregar Leer");
                        System.out.println("3) Agregar Escribir");
                        System.out.println("4) Agregar todos los permisos anteriores");
                        System.out.print("Seleccionar: ");
                        int p = leer.nextInt();
                        if(p==1){
                            pres.addDelete();

                        }else if(p==2){
                            pres.addRead();
                        }else if(p==3){
                            pres.addWrite();
                        }else if(p==4){
                            pres.addPermissions();
                            System.out.println("Agregados");
                        }
                    }
                }
            }
        }
    }

public void cerrar(){
    Login login = new Login();
    login.execute();
}
/////////case//////////////////
    public void Senad() {
        Scanner leer = new Scanner(System.in);
        ConsoleReader con = new ConsoleReader();
        int n;
        do {
            System.out.println("===Menu SuperAdmin===");
            System.out.println("1) Crear administrador");//si funciona
            System.out.println("2) Editar administrador");//si funciona
            System.out.println("3) Eliminar administrador");// si funciona
            System.out.println("4) Mostrar los administradores");//si funciona
            System.out.println("5) Client");
            System.out.println("6) Author");
            System.out.println("7) Book");
            System.out.println("8) Profile");
            System.out.println("9) Transaction");
            System.out.println("10) Cerrar sesion");
            System.out.println("11) Editar permisos");
            System.out.print("Elige:");
            n = leer.nextInt();
            switch (n) {
                case 1:
                    leer.nextLine();
                    System.out.print("Name: ");
                    String namec = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc = leer.nextLine();
                    IntegerValidator id = (value) -> value > 0 && value <= 31;
                    int D = con.ReadInt("Day", id);
                    IntegerValidator me = (value) -> value > 0 && value <= 12;
                    int M = con.ReadInt("Month", me);
                    IntegerValidator ye = (value) -> value > 0 && value <= 9999;
                    int Y = con.ReadInt("Year", ye);
                    System.out.print("Username: ");
                    String user = leer.nextLine();
                    StringValidator pas = password -> password.length() >= 6;
                    String pass = con.ReadString("Password", pas);
                    Date fechad = new Date(D, M, Y);
                    Profile ad1 = new Profile(namec, lastc, fechad);
                    Administrator ulti = new Administrator(ad1, user, pass, false);
                    ulti.addPermissions();
                    RepositoryArrayAdClie.Adminycliente.add(ulti);
                    break;
                case 2:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator ado = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
                    leer.nextLine();
                    System.out.print("Dame el nombre:");
                    String nombre2 = leer.nextLine();
                    System.out.print("Dame el username: ");
                    String un = leer.nextLine();
                    for (User mod : RepositoryArrayAdClie.Adminycliente) {
                        if (mod instanceof Administrator) {
                            Administrator ad = (Administrator) mod;
                            if (ad.profile.name.equals(nombre2) && ad.username.equals(un)) {
                                StringValidator pa = password -> password.length() >= 6;
                                System.out.print("Nombre: ");
                                String names = leer.nextLine();
                                System.out.print("Last name: ");
                                String last = leer.nextLine();
                                IntegerValidator id2 = (value) -> value > 0 && value <= 31;
                                int D1 = con.ReadInt("Day", id2);
                                IntegerValidator me2 = (value) -> value > 0 && value <= 12;
                                int M2 = con.ReadInt("Month", me2);
                                IntegerValidator ye2 = (value) -> value > 0 && value <= 9999;
                                int Y3 = con.ReadInt("Year", ye2);
                                System.out.print("Username: ");
                                String user2 = leer.nextLine();
                                String pass2 = con.ReadString("Password", pa);
                                Date date = new Date(D1, M2, Y3);
                                mod.profile.name = names;
                                mod.profile.lastName = last;
                                mod.profile.birthdate = date;
                                mod.username = user2;
                                mod.password = pass2;
                            }
                        }
                    }
                    break;
                case 3:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator las = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, las.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
                    leer.nextLine();
                    System.out.print("Name: ");
                    String namec1 = leer.nextLine();
                    System.out.print("Last name: ");
                    String lastc1 = leer.nextLine();
                    System.out.print("Username:");
                    String Us = leer.nextLine();
                    boolean superexis = false;
                    for (int i = 0; i < RepositoryArrayAdClie.Adminycliente.size(); i++) {
                        if (RepositoryArrayAdClie.Adminycliente.get(i).profile.name.equals(namec1) && RepositoryArrayAdClie.Adminycliente.get(i).profile.lastName.equals(lastc1) && RepositoryArrayAdClie.Adminycliente.get(i).username.equals(Us)) {
                            RepositoryArrayAdClie.Adminycliente.remove(i);
                            break;
                        }
                    }
                    if ((superexis)) {
                        System.out.println("No se puede eliminar");
                    }
                    break;
                case 4:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator ado = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("===CLIENT===");
                    ControladorClient client = new ControladorClient();
                    client.execute();
                    break;
                case 6:
                    System.out.println("===AUTHOR===");
                    ControladorAuthor auti = new ControladorAuthor();
                    auti.execute();
                    break;
                case 7:
                    System.out.println("===BOOK===");
                    ControladorBook booki = new ControladorBook();
                    booki.execute();
                    break;
                case 8:
                    System.out.println("===PROFILE===");
                    ControladorProfile profils = new ControladorProfile();
                    profils.execute();
                    break;
                case 9:
                    System.out.println("===TRANSACTION===");
                    ControladorTransaction teis = new ControladorTransaction();
                    teis.execute();
                    break;
                case 10:
                    Login login = new Login();
                    login.execute();
                    break;
                case 11:
                    for (User Admins : RepositoryArrayAdClie.Adminycliente) {
                        if (Admins instanceof Administrator) {
                            Administrator ado = (Administrator) Admins;
                            int day = Admins.profile.birthdate.day;
                            int mon = Admins.profile.birthdate.month;
                            int yea = Admins.profile.birthdate.year;
                            String Birthdate = day + "/" + mon + "/" + yea;
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.printf("Name: %s| Last name: %s| Birthdate: %s| Username: %s| IsSuperAdmin: %s|",
                                    Admins.profile.name, Admins.profile.lastName, Birthdate, Admins.username, ado.isSuperAdmin);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------------------------------");
                        }
                    }
                    leer.nextLine();
                    System.out.print("Dame el username: ");
                    String dam = leer.nextLine();
                    for (User rep : RepositoryArrayAdClie.Adminycliente) {
                        if (rep instanceof Administrator) {
                            Administrator pres = (Administrator) rep;
                            if (rep.username.equals(dam)) {
                                if (pres.isSuperAdmin) {
                                    System.out.println("No puedes modificar los permisos");
                                    ControladorSuperAdministrator controladorSuperAdministrator = new ControladorSuperAdministrator();
                                    controladorSuperAdministrator.execute();
                                }

                                System.out.println("===Permisos actuales del administrador===");
                                for (Permissions pes : pres.getPermissions()) {
                                    System.out.println(pes);
                                }

                                System.out.println("1) Eliminar");
                                System.out.println("2) Agregar");
                                System.out.print("Selecciona una opcion:");
                                int ag = leer.nextInt();
                                if(ag==1){
                                    pres.getPermissions().clear();
                                    System.out.println("Eliminados");
                                }else if(ag==2){
                                    System.out.println("===Permisos===");
                                    System.out.println("1) Agregar Eliminar");
                                    System.out.println("2) Agregar Leer");
                                    System.out.println("3) Agregar Escribir");
                                    System.out.println("4) Agregar todos los permisos anteriores");
                                    System.out.print("Seleccionar: ");
                                    int p = leer.nextInt();
                                    if(p==1){
                                        pres.addDelete();

                                    }else if(p==2){
                                        pres.addRead();
                                    }else if(p==3){
                                        pres.addWrite();
                                    }else if(p==4){
                                        pres.addPermissions();
                                        System.out.println("Agregados");
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        } while (n != 12);
    }
}//Resolver lo de el booleano de superadmin por que si no, no vas a poder avanzar a esta cosa