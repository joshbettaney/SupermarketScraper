import junit.framework.TestCase;
import model.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Test class for testing the POJO class 'Product'.
 * @author Joshua Bettaney
 */
public class ModelTest  {

    Product testProduct = new Product();
    private final String TEST_NAME = "testProduct";
    private final double TEST_PRICE = 1.01;
    private final int TEST_SUP_ID = 1;

    @Test
    public void setTestProduct() {
        testProduct.setName(TEST_NAME);
        testProduct.setPrice(TEST_PRICE);
        assertEquals(TEST_NAME, testProduct.getName());
        assertEquals(TEST_PRICE, testProduct.getPrice(),0);
    }

    @Test
    public void testConstructor() {

        Product testProduct1 = new Product(TEST_NAME, TEST_PRICE, TEST_SUP_ID);
        assertEquals(TEST_NAME, testProduct1.getName());
        assertEquals(TEST_PRICE,testProduct1.getPrice(),0);
        assertEquals(TEST_SUP_ID, testProduct1.getSupermarketID());
    }

}
