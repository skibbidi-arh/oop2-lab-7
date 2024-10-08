public class Product {

    double price;
    double taxrate;
    String name;
    int quantity;
    public  Product(String name,double price,int quantity, double taxrate) {

        this.price = price;
        this.taxrate = taxrate;
        this.name = name;
        this.quantity = quantity;
    }

    double calculateTotalPrice() {


        return this.price+ (this.price /100)* this.taxrate;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
    public int getQuantity() {
        return this.quantity;
    }
}
