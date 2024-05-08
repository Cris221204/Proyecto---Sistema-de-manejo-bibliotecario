import java.util.*; public class ConsoleReader {
    Scanner scanner = new Scanner(System.in);

    public int ReadInt(String prompt, IntegerValidator validator) {
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt + ":");
            int valu = scanner.nextInt();
            scanner.nextLine();
            boolean isvalid = validator.validate(valu);
            if (isvalid) return valu;
        }
        return 0;
    }

    public String ReadString(String prompt, StringValidator validator) {
        boolean valid = false;
        String valu = "";
        while (!valid) {
            System.out.print(prompt + ":");
            valu = scanner.nextLine();
            boolean isvalid = validator.validate(valu);
            if (isvalid) return valu;
        }
        return "";
    }

}
