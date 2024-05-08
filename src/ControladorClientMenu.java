import java.util.*;
public class ControladorClientMenu {
    public void Con(Client client) {
        Scanner leer = new Scanner(System.in);
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
                    for (Transaction tex2 : RepositoryTransaction.tras2) {
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
                break;
                    case 3:
                      Login login=new Login();
                      login.execute();
                        break;
        }
    }while(opcion!=4);
}
}
