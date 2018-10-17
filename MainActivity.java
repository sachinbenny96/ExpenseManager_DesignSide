package in_finity.byond.expensemanager_designside;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import net.steamcrafted.materialiconlib.MaterialDrawableBuilder;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextInputEditText e1;
private FloatingActionButton save_button;
private Button button;
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
        final AnimatedVectorDrawable piganimated= (AnimatedVectorDrawable) getDrawable(R.drawable.piganimated);
        final AnimatedVectorDrawable addDrawable= (AnimatedVectorDrawable)getDrawable(R.drawable.checktoadd);
        ImageView amount_icon;
        amount_icon=findViewById(R.id.amount_icon);
        category_list_recyclerview=findViewById(R.id.category_list_recycler);
        iconValues=new ArrayList<>();
        save_button=findViewById(R.id.save_button);
        save_button.setImageDrawable(addDrawable);
        amount_icon.setImageDrawable(piganimated);
        e1=findViewById(R.id.amount_edittext);
        if(e1.hasFocus()){
            piganimated.start();
        }

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
            }
        });
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),ListMonthWise.class);
                View statusBar=findViewById(android.R.id.statusBarBackground);
                View navigatiobar=findViewById(android.R.id.navigationBarBackground);
                Pair<View,String> p1=Pair.create((View)save_button,"floating");
                Pair<View,String> p2=Pair.create(statusBar,Window.STATUS_BAR_BACKGROUND_TRANSITION_NAME);
                Pair<View,String> p3=Pair.create(navigatiobar,Window.NAVIGATION_BAR_BACKGROUND_TRANSITION_NAME);

                Bundle bundle=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,p1,p2,p3).toBundle();
                startActivity(i,bundle);
                addDrawable.start();
            }
        });
        adapter_cat=new AdpaterClass_Category_Choose(getApplicationContext(),iconValues);
        RecyclerView.LayoutManager manager=new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.HORIZONTAL,false);
        category_list_recyclerview.setLayoutManager(manager);
        category_list_recyclerview.setAdapter(adapter_cat);
        prepare_category_list();
        final Calendar myCalendar=Calendar.getInstance();
        Chip datechooser=findViewById(R.id.datechoose);

        datechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datepicker=new DatePickerFragment();
                datepicker.show(getSupportFragmentManager(),"sachin");
            }
        });
    }

    private void showdialog() {
        final View dialogView = View.inflate(this,R.layout.category_add_fragment,null);
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(dialogView);
        Button imageView = dialog.findViewById(R.id.done_button);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revealShow(dialogView, false, dialog);
            }
        });

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                revealShow(dialogView, true, null);
            }
        });

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_BACK){

                    revealShow(dialogView, false, dialog);
                    return true;
                }

                return false;
            }
        });



        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        dialog.show();
    }

    private void revealShow(View dialogView, boolean b, final Dialog dialog) {
        final View view = dialogView.findViewById(R.id.dialog);

        int w = view.getWidth();
        int h = view.getHeight();

        int endRadius = (int) Math.hypot(w, h);

        int cx = (int) (button.getX() + (button.getWidth()/2));
        int cy = (int) (button.getY())+ button.getHeight() + 56;


        if(b){
            Animator revealAnimator = ViewAnimationUtils.createCircularReveal(view, cx,cy, 0, endRadius);

            view.setVisibility(View.VISIBLE);
            revealAnimator.setDuration(700);
            revealAnimator.start();

        } else {

            Animator anim =
                    ViewAnimationUtils.createCircularReveal(view, cx, cy, endRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    dialog.dismiss();
                    view.setVisibility(View.INVISIBLE);

                }
            });
            anim.setDuration(700);
            anim.start();
        }
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
