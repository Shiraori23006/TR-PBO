package dao;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class DiscountedRuleDao {
    int today = LocalDate.now().getDayOfMonth();
    double fixPrice;
    
    public void Diskon(double totalHarga){
        if(today == 10){
            fixPrice = (totalHarga * 0.5) * 0.1 ;
        }
    }
}
