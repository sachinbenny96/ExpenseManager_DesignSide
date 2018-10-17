package in_finity.byond.expensemanager_designside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class card_month_details_adapter extends RecyclerView.Adapter<card_month_details_adapter.myViewHolder> {
    Context context;
    List<MonthList> monthLists;

    public card_month_details_adapter(Context context, ArrayList<MonthList> monthLists) {
        this.context = context;
        this.monthLists = monthLists;
    }

    @NonNull
    @Override

    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_monthly_details,parent,false);
        return new card_month_details_adapter.myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        MonthList monthList=monthLists.get(position);
        holder.textView.setText(monthList.getDate_of_occurance());
        holder.listView.setAdapter(monthList.getAdapter());
    }

    @Override
    public int getItemCount() {
        return monthLists.size();
    }
    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ListView listView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.date_of_occur);
            listView=itemView.findViewById(R.id.innerrecycler);
        }
    }

}
