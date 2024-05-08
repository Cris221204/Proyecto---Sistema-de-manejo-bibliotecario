import java.util.Scanner;

public class ControladorAuthor implements Controller {
    Scanner leer = new Scanner(System.in);
    ConsoleReader cR = new ConsoleReader();

    @Override
    public void execute() {
        Menu menu = new Menu();
        int n = 0;

            menu.addMenuItem(1, new MenuItem("CREAR", this::CrearAuthor));
            menu.addMenuItem(2, new MenuItem("EDITAR", this::EditarAuthor));
            menu.addMenuItem(3, new MenuItem("ELIMINAR", this::EliminarAuthor));
            menu.display();

    }

    public void CrearAuthor() {
        System.out.print("Name: ");
        String nameau = leer.nextLine();
        System.out.print("Last name: ");
        String lastau = leer.nextLine();
        IntegerValidator id = (value) -> value > 0 && value <= 31;
        int D = cR.ReadInt("Day", id);
        IntegerValidator me = (value) -> value > 0 && value <= 12;
        int M = cR.ReadInt("Month", me);
        IntegerValidator ye = (value) -> value > 0 && value <= 9999;
        int Y = cR.ReadInt("Year", ye);
        Date birth = new Date(D, M, Y);
        Profile autor = new Profile(nameau, lastau, birth);
        Author cel = new Author(autor);
        RepositoryProfile.cl.add(cel);
        System.out.println("Autor creado con exito");
    }

    public void EditarAuthor() {
        for (Author autors : RepositoryProfile.cl) {
            String book2 = "";
            for (Book autol : autors.getAuthor()) {
                book2 += autol.title + "|";
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
        System.out.print("Dame el nombre:");
        String nombre3 = leer.nextLine();
        System.out.print("Dame el apellido:");
        String apellido3 = leer.nextLine();
        System.out.println("");
        for (Author sep : RepositoryProfile.cl) {
            if (sep.getProfile().name.equals(nombre3) && sep.getProfile().lastName.equals(apellido3)) {
                System.out.println("===Profile Reboot===");
                System.out.print("Nombre: ");
                String names = leer.nextLine();
                System.out.print("Last name: ");
                String last = leer.nextLine();
                IntegerValidator id1 = (value) -> value > 0 && value <= 31;
                int D1 = cR.ReadInt("Day", id1);
                IntegerValidator me1 = (value) -> value > 0 && value <= 12;
                int M2 = cR.ReadInt("Month", me1);
                IntegerValidator ye1 = (value) -> value > 0 && value <= 9999;
                int Y3 = cR.ReadInt("Year", ye1);
                Date birth1 = new Date(D1, M2, Y3);
                sep.getProfile().name = names;
                sep.getProfile().lastName = last;
                sep.getProfile().birthdate = birth1;
                return;
            }
        }
    }

    public void EliminarAuthor() {
        for (Author autors : RepositoryProfile.cl) {
            String book2 = "";
            for (Book autore : autors.getAuthor()) {
                book2 += autore.title + "|";
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
        System.out.print("Name: ");
        String namec2 = leer.nextLine();
        System.out.print("Last name: ");
        String lastc2 = leer.nextLine();

        for (int i = 0; i < RepositoryProfile.cl.size(); i++) {
            if (RepositoryProfile.cl.get(i).getProfile().name.equals(namec2) && RepositoryProfile.cl.get(i).getProfile().lastName.equals(lastc2)) {
                RepositoryProfile.cl.remove(i);
            }
        }
    }
/////////////////CASE////////////////////////////
    public void ca() {
        int numero = 0;
        System.out.println("1) Crear");
        System.out.println("2) Actualizar");
        System.out.println("3) Eliminar");
        System.out.println("Escoja una opcion: ");
        numero = leer.nextInt();
        leer.nextLine();
        switch (numero) {
            case 1:
                System.out.print("Name: ");
                String nameau = leer.nextLine();
                System.out.print("Last name: ");
                String lastau = leer.nextLine();
                IntegerValidator id = (value) -> value > 0 && value <= 31;
                int D = cR.ReadInt("Day", id);
                IntegerValidator me = (value) -> value > 0 && value <= 12;
                int M = cR.ReadInt("Month", me);
                IntegerValidator ye = (value) -> value > 0 && value <= 9999;
                int Y = cR.ReadInt("Year", ye);
                Date birth = new Date(D, M, Y);
                Profile autor = new Profile(nameau, lastau, birth);
                Author cel = new Author(autor);
                RepositoryProfile.cl.add(cel);
                System.out.println("Autor creado con exito");
                break;
            case 2:
                for (Author autors : RepositoryProfile.cl) {
                    String book2 = "";
                    for (Book autol : autors.getAuthor()) {
                        book2 += autol.title + "|";
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
                System.out.print("Dame el nombre:");
                String nombre3 = leer.nextLine();
                System.out.print("Dame el apellido:");
                String apellido3 = leer.nextLine();
                System.out.println("");
                for (Author sep : RepositoryProfile.cl) {
                    if (sep.getProfile().name.equals(nombre3) && sep.getProfile().lastName.equals(apellido3)) {
                        System.out.println("===Profile Reboot===");
                        System.out.print("Nombre: ");
                        String names = leer.nextLine();
                        System.out.print("Last name: ");
                        String last = leer.nextLine();
                        IntegerValidator id1 = (value) -> value > 0 && value <= 31;
                        int D1 = cR.ReadInt("Day", id1);
                        IntegerValidator me1 = (value) -> value > 0 && value <= 12;
                        int M2 = cR.ReadInt("Month", me1);
                        IntegerValidator ye1 = (value) -> value > 0 && value <= 9999;
                        int Y3 = cR.ReadInt("Year", ye1);
                        Date birth1 = new Date(D1, M2, Y3);
                        sep.getProfile().name = names;
                        sep.getProfile().lastName = last;
                        sep.getProfile().birthdate = birth1;
                        return;
                    }
                }
                break;
            case 3:
                for (Author autors : RepositoryProfile.cl) {
                    String book2 = "";
                    for (Book autore : autors.getAuthor()) {
                        book2 += autore.title + "|";
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
                System.out.print("Name: ");
                String namec2 = leer.nextLine();
                System.out.print("Last name: ");
                String lastc2 = leer.nextLine();

                for (int i = 0; i < RepositoryProfile.cl.size(); i++) {
                    if (RepositoryProfile.cl.get(i).getProfile().name.equals(namec2) && RepositoryProfile.cl.get(i).getProfile().lastName.equals(lastc2)) {
                        RepositoryProfile.cl.remove(i);
                    }
                }
                break;
        }
    }


}
