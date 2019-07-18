package testCase;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private Integer customerID;

    public Ticket(String ticketId, Integer customerID, Date startDate, Date endDate, Integer regionID) {
        this.ticketId = ticketId;
        this.customerID = customerID;
        this.startDate = startDate;
        this.buyDate = new Date();
        this.endDate = endDate;
        this.regionID = regionID;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    private Date startDate;
    private Date buyDate;
    private Date endDate;
    private Integer regionID ;

    public Boolean isValid(){
        if((buyDate.compareTo(startDate) >= 0) && (buyDate.compareTo(endDate) >= 0)){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "ticketID: "+ ticketId + " CustomerID: "+customerID+ " startDate: " +startDate + " endDate: "
                +endDate+ " regionID: " +regionID;
    }
}
