package in_finity.byond.expensemanager_designside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.MyviewHolder> {
    Context context;
    List<List_Items> itemsList;


    public class MyviewHolder extends RecyclerView.ViewHolder{

       public TextView Title,Date,Amount;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.Name);
            Date = itemView.findViewById(R.id.date);
            Amount = itemView.findViewById(R.id.amount);
        }
    }

    public ListItemAdapter(Context context, List<List_Items> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_month_items,parent,false);
        return new MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
    List_Items items=itemsList.get(position);
    holder.Title.setText(items.getName());
    holder.Amount.setText(items.getAmount());
    holder.Date.setText(items.getDate());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

}
