package in_finity.byond.expensemanager_designside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
private FloatingActionButton save_button;
private RecyclerView category_list_recyclerview;
private AdpaterClass_Category_Choose adapter_cat;
private List<MaterialDrawableBuilder.IconValue> iconValues;
private MaterialCardView materialCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupWindowsAnimations();
        setContentView(R.layout.activity_main);
        materialCardView=findViewById(R.id.holder_main);
        category_list_recyclerview=findViewById(R.id.category_list_recycler);
        iconValues=new ArrayList<>();
        save_button=findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),ListMonthWise.class);
                Bundle bundle=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,save_button,"floating").toBundle();
                startActivity(i,bundle);
            }
        });
        adapter_cat=new AdpaterClass_Category_Choose(getApplicationContext(),iconValues);
        RecyclerView.LayoutManager manager=new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.HORIZONTAL,false);
        category_list_recyclerview.setLayoutManager(manager);
        category_list_recyclerview.setAdapter(adapter_cat);
        prepare_category_list();
        final Calendar myCalendar=Calendar.getInstance();
        FloatingActionButton datechooser=findViewById(R.id.date_choose);

        datechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker=new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(),"sachin");
            }
        });

    }


    private void setupWindowsAnimations() {
        Fade slide=new Fade();
        slide.setDuration(1);
        slide.excludeTarget(android.R.id.statusBarBackground,true);
        getWindow().setExitTransition(slide);
        getWindow().setReenterTransition(slide);

    }

    private void updatelabe() {
    }

    private void prepare_category_list() {
        MaterialDrawableBuilder.IconValue iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_USD");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_INR");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_USD");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_INR");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_USD");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_INR");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_USD");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_INR");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_USD");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_INR");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_USD");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_INR");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_USD");
        iconValues.add(iconValue);
        iconValue=MaterialDrawableBuilder.IconValue.valueOf("CURRENCY_INR");
        iconValues.add(iconValue);


        adapter_cat.notifyDataSetChanged();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentdate=DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        Toast.makeText(getApplicationContext(),currentdate,Toast.LENGTH_SHORT).show();
    }
}
