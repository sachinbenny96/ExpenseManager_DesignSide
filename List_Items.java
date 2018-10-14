package in_finity.byond.expensemanager_designside;

public class List_Items {
    String Name,Date,Amount;

    public List_Items() {
    }

    public List_Items(String name, String date, String amount) {
        Name = name;
        Date = date;
        Amount = amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
