import java.util.*;

public class Login implements Controller {
    Scanner leer = new Scanner(System.in);
    ConsoleReader CON = new ConsoleReader();

    @Override
    public void execute() {
        Menu menu = new Menu();

        StringValidator pas = (password) -> {
            return password.length() >= 6;
        };
        System.out.println("===BIENVENIDO===");
        System.out.print("Username: ");
        String user = leer.nextLine();
        String pass = CON.ReadString("Password", pas);
        boolean encontrado = false;

        for (User client : RepositoryArrayAdClie.Adminycliente) {
            if (client instanceof Client) {
                if (client.username.equals(user) && client.checkPassword(pass)) {
                    System.out.println("Inicio de sesión exitoso como cliente");
                    encontrado = true;
                    int n=0;
                    do {
                        Controller log = () -> this.tran((Client) client);
                        menu.addMenuItem(1, new MenuItem("LIBROS", this::libros));
                        menu.addMenuItem(2, new MenuItem("TRANSACCIONES", log));
                        menu.addMenuItem(3,new MenuItem("CERRAR SESION",this::cerrar));
                        menu.display();
                    }while (n !=11);
                }
            }
        }
        if (!encontrado) {
            boolean isad = false;
            for (User admin : RepositoryArrayAdClie.Adminycliente) {
                if (admin instanceof Administrator) {
                    Administrator ado = (Administrator) admin;
                    if (admin.username.equals(user) && admin.checkPassword(pass) && ado.isSuperAdmin) {
                        System.out.println("====Inicio de sesión exitoso como superadministrador====");
                        encontrado = true;
                        ControladorSuperAdministrator sup = new ControladorSuperAdministrator();
                        sup.execute();
                        isad = true;
                        break;
                    }
                }
            }
            if (!isad) {
                for (User admin : RepositoryArrayAdClie.Adminycliente) {
                    if (admin.username.equals(user) && admin.checkPassword(pass) && admin instanceof Administrator) {
                        Administrator ads = (Administrator) admin;
                        ArrayList<Permissions> permissions = ads.getPermissions();
                        if (permissions.contains(Permissions.READ) && permissions.contains(Permissions.DELETE) && permissions.contains(Permissions.WRITE)) {
                            System.out.println("Inicio de sesión como administrador");
                            Inicio inicio = new Inicio();
                            inicio.execute();
                            encontrado = true;
                            break;
                        } else if (permissions.contains(Permissions.READ)) {
                            System.out.println("===Menu leer===");
                            ControladorMenuLeer controladorMenuLeer = new ControladorMenuLeer();
                            controladorMenuLeer.execute();
                            encontrado = true;
                        } else if (permissions.contains(Permissions.WRITE)) {
                            System.out.println("===Menu escribir===");
                            ControladorMenuEscribir controladorMenuEscribir = new ControladorMenuEscribir();
                       controladorMenuEscribir.execute();
                            encontrado = true;
                        } else if (permissions.contains(Permissions.DELETE)) {
                            System.out.println("===Menu eliminar===");
                            ControladorMenuEliminar controladorMenuEliminar = new ControladorMenuEliminar();
                            controladorMenuEliminar.execute();
                            encontrado = true;
                            break;
                        } else {
                            System.out.println("No tiene los permisos necesarios para iniciar sesión como administrador");
                            Login login = new Login();
                            login.execute();
                            encontrado = true;
                            break;
                        }
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }

    public void libros() {
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
    }

    public void tran(Client user) {
        for (Transaction tex : RepositoryTransaction.tras) {
            if (tex.getClient().getusername().equals(user)) {
                int d = tex.getDate().day;
                int m = tex.getDate().month;
                int y = tex.getDate().year;
                String Bi = d + "/" + m + "/" + y;
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| Date: %s| ",
                        tex.id, tex.type, tex.client.getProfile().name, tex.book.title, Bi);
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }
        }
        for (Transaction tex2 : RepositoryTransaction.tras2) {
            if (tex2.getClient().getusername().equals(user)) {
                int d1 = tex2.getDate().day;
                int m1 = tex2.getDate().month;
                int y1 = tex2.getDate().year;
                String Bi1 = d1 + "/" + m1 + "/" + y1;
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| Date: %s| ",
                        tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, Bi1);
                System.out.println("");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }
        }
    }
    public void cerrar(){Login login = new Login();
        login.execute();
    }
//////////case////////////
    public void Login() {
        Scanner leer = new Scanner(System.in);
        ConsoleReader CON = new ConsoleReader();
        StringValidator pas = (password) -> {
            return password.length() >= 6;
        };
        System.out.println("===BIENVENIDO===");
        System.out.print("Username: ");
        String user = leer.nextLine();
        String pass = CON.ReadString("Password", pas);
        boolean encontrado = false;

        for (User client : RepositoryArrayAdClie.Adminycliente) {
            if (client instanceof Client) {
                if (client.username.equals(user) && client.checkPassword(pass)) {
                    System.out.println("Inicio de sesión exitoso como cliente");
                    encontrado = true;
                    int opcion;

                    do {
                        System.out.println("Menu clientes");
                        System.out.println("1) Ver libros");
                        System.out.println("2) Ver transacciones");
                        System.out.println("3) Cerrar sesion");
                        System.out.print("Elige una opcion:");
                        opcion = leer.nextInt();
                        switch (opcion) {
                            case 1:
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

                            case 2:
                                for (Transaction tex : RepositoryTransaction.tras) {
                                    if (tex.getClient().getusername().equals(user)) {
                                        int d = tex.getDate().day;
                                        int m = tex.getDate().month;
                                        int y = tex.getDate().year;
                                        String Bi = d + "/" + m + "/" + y;
                                        System.out.println("-----------------------------------------------------------------------------------------------");
                                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| Date: %s| ",
                                                tex.id, tex.type, tex.client.getProfile().name, tex.book.title, Bi);
                                        System.out.println("");
                                        System.out.println("-----------------------------------------------------------------------------------------------");
                                    }
                                }
                                for (Transaction tex2 : RepositoryTransaction.tras2) {
                                    if (tex2.getClient().getusername().equals(user)) {
                                        int d1 = tex2.getDate().day;
                                        int m1 = tex2.getDate().month;
                                        int y1 = tex2.getDate().year;
                                        String Bi1 = d1 + "/" + m1 + "/" + y1;
                                        System.out.println("-----------------------------------------------------------------------------------------------");
                                        System.out.printf("Id: %s| Type: %s| Client: %s| Book: %s| Date: %s| ",
                                                tex2.id, tex2.type, tex2.client.getProfile().name, tex2.book.title, Bi1);
                                        System.out.println("");
                                        System.out.println("-----------------------------------------------------------------------------------------------");
                                    }
                                }
                                break;
                            case 3:
                                Login login = new Login();
                                login.execute();
                                break;
                        }
                    } while (opcion != 4);
                    break;
                }
            }
        }
        if (!encontrado) {
            boolean isad = false;
            for (User admin : RepositoryArrayAdClie.Adminycliente) {
                if (admin instanceof Administrator) {
                    Administrator ado = (Administrator) admin;
                    if (admin.username.equals(user) && admin.checkPassword(pass) && ado.isSuperAdmin) {
                        System.out.println("====Inicio de sesión exitoso como superadministrador====");
                        encontrado = true;
                        ControladorSuperAdministrator sup = new ControladorSuperAdministrator();
                        sup.execute();
                        isad = true;
                        break;
                    }
                }
            }
            if (!isad) {
                for (User admin : RepositoryArrayAdClie.Adminycliente) {
                    if (admin.username.equals(user) && admin.checkPassword(pass) && admin instanceof Administrator) {
                        Administrator ads = (Administrator) admin;
                        ArrayList<Permissions> permissions = ads.getPermissions();
                        if (permissions.contains(Permissions.READ) && permissions.contains(Permissions.DELETE) && permissions.contains(Permissions.WRITE)) {
                            System.out.println("Inicio de sesión como administrador");
                            Inicio inicio = new Inicio();
                            inicio.execute();
                            encontrado = true;
                            break;
                        } else if (permissions.contains(Permissions.READ)) {
                            System.out.println("===Menu leer===");
                            ControladorMenuLeer controladorMenuLeer = new ControladorMenuLeer();
                            controladorMenuLeer.leer();
                            encontrado = true;
                        } else if (permissions.contains(Permissions.WRITE)) {
                            System.out.println("===Menu escribir===");
                            ControladorMenuEscribir controladorMenuEscribir = new ControladorMenuEscribir();
                            controladorMenuEscribir.execute();
                            encontrado = true;
                        } else if (permissions.contains(Permissions.DELETE)) {
                            System.out.println("===Menu eliminar===");
                            ControladorMenuEliminar controladorMenuEliminar = new ControladorMenuEliminar();
                            controladorMenuEliminar.execute();
                            encontrado = true;
                            break;
                        } else {
                            System.out.println("No tiene los permisos necesarios para iniciar sesión como administrador");
                            Login login = new Login();
                            login.execute();
                            encontrado = true;
                            break;
                        }
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
        }
    }


}

//HACER UNA CLASE QUE IMPLEMENTE LO DE CONTROLLER PARA ENCAPSULAR EL MENU DE CLIENTE Y PONERLO EN EL EXECUTE Y LLAMARLA CON EL HASH


