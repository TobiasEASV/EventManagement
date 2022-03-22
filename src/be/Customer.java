package be;

public class Customer {
    private String customerEmail;
    private String customerName;
    private int id;



    public Customer(String customerEmail, String customerName)
    {
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
