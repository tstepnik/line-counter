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
                    StringBuilder builder = getAddress(f.getAbsolutePath());
                    sum += lines;
                    System.out.println(builder + "-->" + lines);
                    lines = 0;
                }
            }
        } else {
            System.out.println("Nie można znaleźć folderu o podanej nazwie");
        }
    }

    private StringBuilder getAddress(String fullAddress) {
        String[] addresses = fullAddress.split("\\\\");
        int index = 0;
        int wantedIndex = 0;
        for (String s : addresses) {
            if (s.equals("filelinecounter")) {
                wantedIndex = index;
            }
            index++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = wantedIndex + 1; i < addresses.length; i++) {
            builder.append("\\").append(addresses[i]);
        }
        return builder;
    }

    public void printSum() {
        System.out.println("W sumie " + sum + " lini.");
    }
}
