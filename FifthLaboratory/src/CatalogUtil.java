import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {

        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath())
        )) {
            oos.writeObject(catalog);
        }
        System.out.println("Success");
    }

    public static Catalog load(String path) // loads the catalog from an external file.
            throws InvalidCatalogException {
        try {
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(file);
            Catalog c = (Catalog) in.readObject();

            System.out.println("Success");
            in.close();
            file.close();

            return c;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Catalog class not found");
            e.printStackTrace();
            return null;
        }

    }

    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(URI.create(doc.getLocation()));
        System.out.println("Success");
    }

    static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }
}