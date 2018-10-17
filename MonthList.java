package in_finity.byond.expensemanager_designside;

import android.widget.ArrayAdapter;

import androidx.recyclerview.widget.RecyclerView;

class MonthList {
    ListItemAdapter adapter;
    String date_of_occurance;

    public MonthList(ListItemAdapter listItemAdapter, String date_of_occurance) {
        this.adapter = listItemAdapter;
        this.date_of_occurance = date_of_occurance;
    }

    public ListItemAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ListItemAdapter adapter) {
        this.adapter = adapter;
    }


    public String getDate_of_occurance() {
        return date_of_occurance;
    }

    public void setDate_of_occurance(String date_of_occurance) {
        this.date_of_occurance = date_of_occurance;
    }
}
