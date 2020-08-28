import junit.framework.TestCase;
import model.Product;


/**
 * Test class for testing the DAO class 'ProductPersister'.
 * @author Joshua Bettaney
 */
public class PersisterTest extends TestCase {

    private ProductPersister persister;
    private Product testProduct;
    private int initialSize;

    @Override
    protected void setUp() throws Exception {

        persister = new ProductPersister();
        testProduct = new Product("testName", 1.01, 1);
        initialSize = persister.listProducts().size();
    }

    /**
    public void testCreate(){
        persister.createProduct(testProduct);
        int newAmountOfProducts = persister.listProducts().size();
        assertEquals(initialSize + 1, newAmountOfProducts);
    }

    public void testDelete() {
        int id = 1;
        persister.deleteCustomer(id);
        int newAmountOfProducts = persister.listProducts().size();

        assertEquals(initialSize, newAmountOfProducts);

    }
*/
}
