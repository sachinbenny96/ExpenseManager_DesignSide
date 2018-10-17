package in_finity.byond.expensemanager_designside;

public class List_Items {
    String Name,Amount;

    public List_Items() {
    }

    public List_Items(String name,  String amount) {
        Name = name;
        Amount = amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }
}
