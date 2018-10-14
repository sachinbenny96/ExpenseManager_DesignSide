package in_finity.byond.expensemanager_designside;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.List;
import java.util.ArrayList;




public class ListMonthWise extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListItemAdapter listItemAdapter;
    private List<List_Items> list_itemsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowAnimations();
        setContentView(R.layout.activity_list_month_wise);
        list_itemsList=new ArrayList<>();
        listItemAdapter=new ListItemAdapter(getApplicationContext(),list_itemsList);
        recyclerView=findViewById(R.id.month_list_recycler);
        LayoutAnimationController controller=AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_animation_fall_down);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SpacingItemDecoration( 6));
        recyclerView.setAdapter(listItemAdapter);
        prepareList();
}

    private void setWindowAnimations() {
        Fade slide=new Fade();
        slide.setDuration(1);
        slide.excludeTarget(android.R.id.statusBarBackground,true);
        getWindow().setExitTransition(slide);
        getWindow().setEnterTransition(slide);
    }
    private void prepareList() {
        List_Items list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","20/08/2018","$21");
        list_itemsList.add(list_items);

        listItemAdapter.notifyDataSetChanged();

    }
    public class SpacingItemDecoration extends RecyclerView.ItemDecoration{
        private int offset;

        public SpacingItemDecoration(int i) {
            offset=i;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(offset,offset,offset,offset);
        }
    }
}
