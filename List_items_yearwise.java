package in_finity.byond.expensemanager_designside;

public class List_items_yearwise {
    String Month,Income,Expense,Total;

    public List_items_yearwise() {
    }

    public List_items_yearwise(String month, String income, String expense, String total) {
        Month = month;
        Income = income;
        Expense = expense;
        Total = total;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getIncome() {
        return Income;
    }

    public void setIncome(String income) {
        Income = income;
    }

    public String getExpense() {
        return Expense;
    }

    public void setExpense(String expense) {
        Expense = expense;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}
