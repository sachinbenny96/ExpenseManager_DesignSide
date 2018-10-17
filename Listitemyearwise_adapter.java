package in_finity.byond.expensemanager_designside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Listitemyearwise_adapter extends RecyclerView.Adapter<Listitemyearwise_adapter.myViewHolder> {
    Context mContext;
    List<List_items_yearwise> list_items_yearwises;

    public Listitemyearwise_adapter(Context mContext, List<List_items_yearwise> list_items_yearwises) {
        this.mContext = mContext;
        this.list_items_yearwises = list_items_yearwises;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_year_list,parent,false);
        return new Listitemyearwise_adapter.myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
    List_items_yearwise list_items=list_items_yearwises.get(position);
    holder.Month.setText(list_items.getMonth());
        holder.income_value.setText(list_items.getIncome());
        holder.expense_value.setText(list_items.getExpense());
        holder.total_value.setText(list_items.getTotal());
    }

    @Override
    public int getItemCount() {
        return list_items_yearwises.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public TextView Month,income_value,expense_value,total_value;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Month=itemView.findViewById(R.id.month_name);
            income_value=itemView.findViewById(R.id.income_value);
            expense_value=itemView.findViewById(R.id.expense_value);
            total_value=itemView.findViewById(R.id.total_value);
        }
    }
}
