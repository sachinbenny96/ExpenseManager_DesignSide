package in_finity.byond.expensemanager_designside;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Piechart extends AppCompatActivity {
private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart=findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5,10,5,5);
        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        ArrayList<PieEntry> pieEntries=new ArrayList<>();

        pieEntries.add(new PieEntry(34f,"PartyA"));
        pieEntries.add(new PieEntry(16f,"Partyb"));
        pieEntries.add(new PieEntry(25f,"PartyAc"));
        pieEntries.add(new PieEntry(25f,"Partyd"));


        PieDataSet pieDataSet=new PieDataSet(pieEntries,"countres");
        pieDataSet.setSliceSpace(3f);
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setSelectionShift(5f);

        PieData pieData=new PieData(pieDataSet);
        pieData.setValueTextSize(10);

        pieChart.animateY(1000,Easing.EasingOption.EaseInSine);
        pieChart.setData(pieData);


    }
}
