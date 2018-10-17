package in_finity.byond.expensemanager_designside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class ListItemAdapter extends BaseAdapter{
Context context;
ArrayList<List_Items> list_items;
LayoutInflater layoutInflater=null;

    public ListItemAdapter(Context context, ArrayList<List_Items> list_items) {
        this.context = context;
        this.list_items = list_items;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list_items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
        public class Holder{
        TextView tv,tv1;
        }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        List_Items list_item=list_items.get(position);
        Holder holder=new Holder();
        View rowview;
        rowview=layoutInflater.inflate(R.layout.card_list_month_items,null);
        holder.tv=rowview.findViewById(R.id.Name);
        holder.tv1=rowview.findViewById(R.id.Amount);
        holder.tv.setText(list_item.getName());
        holder.tv1.setText(list_item.getAmount());
        return rowview;
    }
}
