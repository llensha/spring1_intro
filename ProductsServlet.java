import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
public class ProductsServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        ArrayList<Product> products = new ArrayList();
        products.add(new Product(1, "Apricot", 100.00));
        products.add(new Product(2, "Orange", 200.00));
        products.add(new Product(3, "Cherry", 300.00));
        products.add(new Product(4, "Melon", 400.00));
        products.add(new Product(5, "Strawberry", 500.50));
        products.add(new Product(6, "Lemon", 600.00));
        products.add(new Product(7, "Mango", 700.00));
        products.add(new Product(8, "Watermelon", 750.75));
        products.add(new Product(9, "Peach", 800.80));
        products.add(new Product(10, "Apple", 900.00));

        for (Product product : products) {
            out.println("<html><body><h1>" + String.format("Product id = %d, title = %s, cost = %.2f;%n", product.getId(), product.getTitle(), product.getCost()) + "</h1></body></html>");
        }

        out.close();
    }
}

