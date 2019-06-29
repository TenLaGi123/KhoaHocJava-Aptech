import java.util.Calendar;
import java.util.Date;

public class DefaultExpiration {

    public Date getExpireDate() {
        Calendar myCal = Calendar.getInstance();
        myCal.set(Calendar.YEAR, 2019);
        myCal.set(Calendar.MONTH, 6);
        myCal.set(Calendar.DAY_OF_MONTH, 24);
        Date theDate = myCal.getTime();
        return theDate;
    }

    public Boolean dateChecking(){
        Date currentDate = new Date();
        Date expireDate = getExpireDate();
        return  expireDate.compareTo(currentDate) > 0 ? true : false ;
    }


}
