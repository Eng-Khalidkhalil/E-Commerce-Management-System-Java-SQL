package onlineshopping;

public class mymain {

    public static void main(String[] args) {
        if (dbonlineshopping.connect() != null) {
            dbonlineshopping.addCategory("Electronics");
            dbonlineshopping.updateCustomerAddress(1, "Amman");
            dbonlineshopping.deleteProduct(5);
        }
    }
}