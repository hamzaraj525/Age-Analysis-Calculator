package com.learning.agecalculatoranalysis;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textViewResult, textViewYears, textViewMonths,
            textViewDays, textViewHours, textViewMin, textViewNext;
    Button buttonCalendarDate, buttonCalendarBirth, buttonCalculate, buttonClear;

    DatePickerDialog.OnDateSetListener datePickerListener, datePickerListener2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonCalendarDate = findViewById(R.id.btnCalendarDate);
        buttonCalendarBirth = findViewById(R.id.btnCalendarBirthday);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        buttonClear = findViewById(R.id.buttonClear);
        textViewResult = findViewById(R.id.txtSelected);
        textViewYears = findViewById(R.id.txtYears);
        textViewMonths = findViewById(R.id.txtMonths);
        textViewDays = findViewById(R.id.txtDays);
        textViewHours = findViewById(R.id.txtHours);
        textViewMin = findViewById(R.id.txtMin);
        textViewNext = findViewById(R.id.txtNext);

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = simpleDateFormat.format(Calendar.getInstance().getTime());
        buttonCalendarDate.setText(date);
        buttonCalendarBirth.setText(date);


        /*1*/
        buttonCalendarDate.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog1 = new DatePickerDialog(MainActivity.this

                    , datePickerListener, year, month, day);

            datePickerDialog1.show();
        });

        datePickerListener = (view, year1, month1, dayOfMonth) -> {

            month1 = month1 + 1;
            String date12 = dayOfMonth + "/" + month1 + "/" + year1;
            buttonCalendarDate.setText(date12);
        };

        
        /*2*/
        buttonCalendarBirth.setOnClickListener(v -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this

                    , datePickerListener2, year, month, day);
            datePickerDialog.show();
        });


        datePickerListener2 = (view, year12, month12, dayOfMonth) -> {


            month12 = month12 + 1;
            String date13 = dayOfMonth + "/" + month12 + "/" + year12;
            buttonCalendarBirth.setText(date13);
        };


        buttonCalculate.setOnClickListener(v -> {
            String selectedDate = buttonCalendarDate.getText().toString();
            String selectedAge = buttonCalendarBirth.getText().toString();


            @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date date1 = simpleDateFormat1.parse(selectedDate);
                Date date2 = simpleDateFormat1.parse(selectedAge);


                assert date1 != null;
                long startDate = date1.getTime();

                assert date2 != null;
                long endDate = date2.getTime();

                if (startDate <= endDate) {


                    Period period = new Period(startDate, endDate, PeriodType.yearMonthDay());
                    int years = period.getYears();
                    int months = period.getMonths();
                    int days = period.getDays();
                    textViewResult.setText(years + "   year   " + months + "     month   " + days + "  days ");

                    Period period1 = new Period(startDate, endDate, PeriodType.years());
                    int yearTotal = period1.getYears();
                    textViewYears.setText(yearTotal + "  Years");

                    Period period2 = new Period(startDate, endDate, PeriodType.months());
                    int monthTotal = period2.getMonths();
                    textViewMonths.setText(monthTotal + " Months");

                    Period period3 = new Period(startDate, endDate, PeriodType.days());
                    int daysTotal = period3.getDays();
                    textViewDays.setText(daysTotal + "    Days");

                    Period period4 = new Period(startDate, endDate, PeriodType.hours());
                    int HoursTotal = period4.getHours();
                    textViewHours.setText(HoursTotal + "   Total Hours");

                    Period period5 = new Period(startDate, endDate, PeriodType.minutes());
                    int MinutesTotal = period5.getMinutes();
                    textViewMin.setText(MinutesTotal + "   Total Minutes");

                    /*Period period6 = new Period(startDate, endDate);
                    c.set(1999, 7, 24);
                    c.add(Calendar.DATE, 1);
                    int y = period6.getYears();
                    int m = period6.getMonths();
                    int d = period6.getDays();
                    textViewNext.setText(y + "   year   " + m + "     month   " + d + "  days ");*/

                } else {
                    Toast.makeText(getApplicationContext(), "Date should not be larger than current date", Toast.LENGTH_SHORT).show();
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

          /*  Intent intent = new Intent(MainActivity.this, AgeAnalysis.class);
            intent.putExtra("selectedDate", );
            intent.putExtra("selectedAge", );
            startActivity(intent);
            finish();*/
        });
    }
}


