

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    @Test
    public void testEgetprice() {
        Product e = new Electronics("fan",200,2);
        Double price = e.getPrice();
        Double actualPrice = 200.0;
        assertEquals(price,actualPrice);

    }
@Test
    public void testCgetprice() {
        Product e = new Clothing("pant",200,3);
        Double price = e.getPrice();
        Double actualPrice = 200.0;
        assertEquals(price,actualPrice);

    }

    @Test
    public void testFgetprice() {
        Product e = new Furniture("desk",200,4);
        Double price = e.getPrice();
        Double actualPrice = 200.0;
        assertEquals(price,actualPrice);

    }

    @Test
    public void testEprice() {
        Product e = new Electronics("fan",200,2);
        Double price = e.calculateTotalPrice();
        Double actualPrice = 230.0;
        assertEquals(price,actualPrice);

    }

    @Test
    public void testCprice() {
        Product e = new Clothing("pant",200,3);
        Double price = e.calculateTotalPrice();
        Double actualPrice = 220.0;
        assertEquals(price,actualPrice);

    }

    @Test
    public void testFprice() {
        Product e = new Furniture("desk",200,1);
        Double price = e.calculateTotalPrice();
        Double actualPrice = 216.0;
        assertEquals(price,actualPrice);

    }

    @Test
    public void testorderManagerAsPrice()
    {

        List<Product> p = new ArrayList<Product>();
        Product a= new Electronics("fan",200,2);
        Product b= new Furniture("table",200,2);
        Product c= new Clothing("jacket",1000,2);
        p.add(a);
        p.add(b);
        p.add(c);
        OrderManager om = new OrderManager(p);
        om.sortProducts();
        Product p1= b;
        Product p2= c;
        Product top= p.get(0);
        Product bottom= p.get(2);
        assertEquals(p2,bottom);

    }

    @Test
    public void testorderManagerAsName()
    {

        List<Product> p = new ArrayList<Product>();
        Product a= new Electronics("a fan",200,2);
        Product b= new Electronics("b light",200,2);
        Product c= new Electronics("c tv",1000,2);
        p.add(b);
        p.add(a);
        p.add(c);
        OrderManager om = new OrderManager(p);
        om.sortProducts();
        Product p1= a;
        Product p2= c;
        Product top= p.get(0);
        Product bottom= p.get(2);
        assertEquals(p2,bottom);

    }

    @Test
    public void testorderManagerAsStock()
    {

        List<Product> p = new ArrayList<Product>();
        Product a= new Electronics("fan",200,2);
        Product b= new Electronics("fan",200,3);
        Product c= new Electronics("fan",1000,4);
        p.add(b);
        p.add(a);
        p.add(c);
        OrderManager om = new OrderManager(p);
        om.sortProducts();
        Product p1= a;
        Product p2= c;
        Product top= p.get(0);
        Product bottom= p.get(2);
        assertEquals(p2,bottom);

    }

    @Test
    public void testorderManagerAllSame()
    {

        List<Product> p = new ArrayList<Product>();
        Product a= new Electronics("fan",200,2);
        Product b= new Electronics("fan",200,2);
        Product c= new Electronics("fan",1000,2);
        p.add(b);
        p.add(a);
        p.add(c);
        OrderManager om = new OrderManager(p);
        om.sortProducts();
        Product p1= b;
        Product p2= c;
        Product top= p.get(0);
        Product bottom= p.get(2);
        assertEquals(p2,bottom);

    }

}
