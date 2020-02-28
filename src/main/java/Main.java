//import java.io.File;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DirectoryLister lister = new DirectoryLister();
        String folder = lister.giveAddress();
        File file = new File(folder);
        lister.showDirectories(file);
        lister.printSum();
        lister.closeScanner();
    }
}
