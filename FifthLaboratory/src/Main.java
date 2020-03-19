
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, CatalogUtil.InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "/home/ionut/Documents/java/catalog.ser");

        Document doc =
                new Document("java1", "Java Course 1", "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");

        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws CatalogUtil.InvalidCatalogException, IOException, FileNotFoundException {
        Catalog catalog = (Catalog) CatalogUtil.load("/home/ionut/Documents/java/catalog.ser");

        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
}

