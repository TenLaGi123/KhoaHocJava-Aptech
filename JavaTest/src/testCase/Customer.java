package testCase;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String email;
    private Integer customerId;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public ArrayList<Ticket> getTickets() {

        return tickets;

    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Customer(String name, String email, Integer customerId) {
        this.name = name;
        this.email = email;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        for(Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }

        return "name: "+ name + " email: "
                                 + email + "customerID: " + customerId;
    }
}
