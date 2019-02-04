package lesson2;

import lesson2.models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main{
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        // Таблица при старте приложения удаляется и заново создается
        // поэтому чистить не надо

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Product product;

        for(int i = 1; i <= 10000; i++){
            product = new Product();
            product.setArticle("p1001-" + i);
            product.setTitle("Товар #" + i);
            product.setPrice(i * 10.33f);
            session.save(product);
        }

        tx.commit();
        session.close();
        factory.close();
    }
}
