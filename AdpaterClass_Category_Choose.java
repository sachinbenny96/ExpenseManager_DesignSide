package in_finity.byond.expensemanager_designside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;
import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdpaterClass_Category_Choose extends RecyclerView.Adapter<AdpaterClass_Category_Choose.myViewHolder> {
    @NonNull

    Context mContext;
    List<MaterialDrawableBuilder.IconValue> iconViews;

    public AdpaterClass_Category_Choose(@NonNull Context mContext, List<MaterialDrawableBuilder.IconValue> iconViews) {
        this.mContext = mContext;
        this.iconViews = iconViews;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_icon_view,parent,false);
       return new AdpaterClass_Category_Choose.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        MaterialDrawableBuilder.IconValue iconView=iconViews.get(position);
        holder.iconView.setIcon(iconView);
    }

    @Override
    public int getItemCount() {
        return iconViews.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        MaterialIconView iconView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            iconView=itemView.findViewById(R.id.icon);
        }
    }
}
