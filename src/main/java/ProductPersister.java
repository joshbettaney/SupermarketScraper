
import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * Persistence class to ease the process of data posting and retrieval to and from the database.
 * @author Joshua Bettaney
 */
public class ProductPersister {

    //Session factory object used to create sessions.
    private SessionFactory sessionFactory = null;

    /**
     * Constructor
     * @throws SQLException
     */
    public ProductPersister() throws SQLException {

        File configFile = new File("C:\\Users\\Joshua\\Documents\\GitHub\\SupermarketScraper\\src\\main\\resources\\hibernate.cfg.xml");

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(configFile).build();

        sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    /**
     * Method called when writing a Product object to the database.
     * @param product The object to be written.
     */
    public void createProduct(Product product) {
        updateProduct(product);

    }

    /**
     * Method to return a product from the database using it's ID.
     * @param prodID Id of the product to be retrieved.
     * @return Product object relating to the given Id.
     */
    public Product readProduct(int prodID) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.find(Product.class, prodID);
        session.getTransaction().commit();
        session.close();
        return product;
    }

    /**
     * Method to update a product in the database.
     * @param product Product to be updated.
     */
    private void updateProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    /**
     * Method to delete a product from the database with the given ID.
     * @param prodID ID of product to be deleted.
     * @return Product that was deleted.
     */
    public Product deleteCustomer(int prodID) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = session.find(Product.class, prodID);
        session.delete(prodID);
        session.close();
        return product;
    }

    /**
     * Method to return a list of all products stored in the database.
     * @return List of Product objects.
     */
    public List<Product> listProducts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Product> products = (List<Product>) session.createQuery("from product").list();
        session.close();
        return products;
    }
}