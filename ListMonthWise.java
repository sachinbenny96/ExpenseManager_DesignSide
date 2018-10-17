package in_finity.byond.expensemanager_designside;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.ArrayList;




public class ListMonthWise extends AppCompatActivity {
    private FloatingActionButton add_button;
    private RecyclerView recyclerView;


    private ListItemAdapter listItemAdapter;
    private card_month_details_adapter card_month_details_adapter1;


    private List<List_Items> list_itemsList;
    private ArrayList<MonthList> monthWises;


    RecyclerView.LayoutManager layoutManager;


    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindowAnimations();
        setContentView(R.layout.activity_list_month_wise);

        final AnimatedVectorDrawable addDrawable= (AnimatedVectorDrawable)getDrawable(R.drawable.addtocheck);

        list_itemsList=new ArrayList<>();
        monthWises=new ArrayList<>();
        //
        listItemAdapter=new ListItemAdapter(getApplicationContext(),(ArrayList<List_Items>) list_itemsList);
        card_month_details_adapter1=new card_month_details_adapter(getApplicationContext(), monthWises);
        //
        recyclerView=findViewById(R.id.month_list_recycler);
        LayoutAnimationController controller=AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_animation_fall_down);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutAnimation(controller);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new SpacingItemDecoration( 10));
        recyclerView.setAdapter(card_month_details_adapter1);


        add_button=findViewById(R.id.save_button2);
        button=findViewById(R.id.materialButton4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Piechart.class);
                startActivity(i);
            }
        });
        add_button.setImageDrawable(addDrawable);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                View statusBar=findViewById(android.R.id.statusBarBackground);
                View navigatiobar=findViewById(android.R.id.navigationBarBackground);
                Pair<View,String> p1=Pair.create((View)add_button,"floating");
                Pair<View,String> p2=Pair.create(statusBar,Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME);
                Pair<View,String> p3=Pair.create(navigatiobar,Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME);

                Bundle bundle=ActivityOptions.makeSceneTransitionAnimation(ListMonthWise.this,p1,p2,p3).toBundle();
                startActivity(i,bundle);
                addDrawable.start();
            }
        });
        prepareMonthList();
}



    private void setWindowAnimations() {
        Slide slide=new Slide();
        slide.setDuration(300);
        slide.excludeTarget(android.R.id.statusBarBackground,true);
        getWindow().setExitTransition(slide);
        getWindow().setEnterTransition(slide);
    }

    private void prepareMonthList() {
       prepareList();
       MonthList monthList=new MonthList(listItemAdapter,"20/10/2018");
       monthWises.add(monthList);
        monthList=new MonthList(listItemAdapter,"21/10/2018");
        monthWises.add(monthList);
        card_month_details_adapter1.notifyDataSetChanged();

    }
    private void prepareList() {
        List_Items list_items=new List_Items("Car Loan","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","$21");
        list_itemsList.add(list_items);
        list_items=new List_Items("Car Loan","$21");
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
            outRect.set(0,offset,0,offset);
        }
    }

    public class myAdapter extends ArrayAdapter{
        String[] desc;
        String[] date;

        public myAdapter(@NonNull Context context, int resource, String[] desc, String[] date) {
            super(context, resource);
            this.desc = desc;
            this.date = date;
        }
    }
}
