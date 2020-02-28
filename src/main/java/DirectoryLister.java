import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryLister {
    private int sum = 0;
    private Scanner sc;

    public void closeScanner() {
        sc.close();
    }

    public String giveAddress() {
        System.out.println("Podaj adres folderu: ");
        sc = new Scanner(System.in);
        String folderAddress = sc.nextLine();
        System.out.println(folderAddress);
        return folderAddress;
    }

    public void showDirectories(File file) throws IOException {
        int lines = 0;

        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {

                if (f.isDirectory()) {
                    showDirectories(f);
                } else {
                    sc = new Scanner(f);

                    while (sc.hasNextLine()) {
                        sc.nextLine();
                        lines++;
                    }
                    String builder = getAddress(f.getAbsolutePath(), file.getAbsolutePath());
                    sum += lines;
                    System.out.println(builder + "-->" + lines);
                    lines = 0;
                }
            }
        } else {
            System.out.println("Nie można znaleźć folderu o podanej nazwie");
        }
    }

    private String getAddress(String fullAddress, String partWantededDelete) {
        return fullAddress.replace(partWantededDelete, "");
    }

    public void printSum() {
        System.out.println("W sumie " + sum + " lini.");
    }
}
