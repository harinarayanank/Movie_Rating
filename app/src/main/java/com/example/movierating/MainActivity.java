package com.example.movierating;

        import androidx.appcompat.app.AppCompatActivity;

        import android.app.AlertDialog;
        import android.app.DatePickerDialog;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.RatingBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView t1 , t2,t3,t4,t5,t6,t7,t8,t9;
    EditText e1,e2;
    RatingBar r1,r2,r3,r4,r5;
    Button b1,b2;
    DatePickerDialog datePickerDialog;
    float total;

    String movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1=(TextView)findViewById(R.id.head);
        t2=(TextView)findViewById(R.id.title);
        t3=(TextView)findViewById(R.id.frozen);
        t4=(TextView)findViewById(R.id.rocket);
        t5=(TextView)findViewById(R.id.spy);
        t6=(TextView)findViewById(R.id.joker);
        t7=(TextView)findViewById(R.id.aladin);
        t8=(TextView)findViewById(R.id.email);
        t9=(TextView)findViewById(R.id.date);

        e1=(EditText)findViewById(R.id.mail);
        e2=(EditText)findViewById(R.id.date2);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button1);

        r1=(RatingBar)findViewById(R.id.rb1);
        r2=(RatingBar)findViewById(R.id.rb2);
        r3=(RatingBar)findViewById(R.id.rb3);
        r4=(RatingBar)findViewById(R.id.rb4);
        r5=(RatingBar)findViewById(R.id.rb5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        e2.setText(dayOfMonth + "/" + (month+1) + "/" + year);

                    }
                }, mYear,mMonth,mDay);
                datePickerDialog.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total = r1.getRating() + r2.getRating() + r3.getRating() + r4.getRating() + r5.getRating();
                float average = total/5;

                if(r1.getRating() > r2.getRating() && r1.getRating() > r3.getRating() && r1.getRating() >r4.getRating() && r1.getRating() > r5.getRating())
                {
                    movie=t3.getText().toString();
                }

                else if(r2.getRating() > r1.getRating() && r2.getRating() > r3.getRating() && r2.getRating() >r4.getRating() && r2.getRating() > r5.getRating())
                {
                    movie=t4.getText().toString();
                }

                else if(r3.getRating() > r1.getRating() && r3.getRating() > r2.getRating() && r3.getRating() >r4.getRating() && r3.getRating() > r5.getRating())
                {
                    movie=t5.getText().toString();
                }

                else if(r4.getRating() > r1.getRating() && r4.getRating() > r2.getRating() && r4.getRating() >r3.getRating() && r4.getRating() > r5.getRating())
                {
                    movie=t6.getText().toString();
                }
                else if(r5.getRating() > r1.getRating() && r5.getRating() > r2.getRating() && r5.getRating() >r3.getRating() && r5.getRating() > r4.getRating())
                {
                    movie=t7.getText().toString();
                }

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Details");
                alertDialog.setMessage("Average Rating is " +average +
                        "\n" + "Best Rated Movie is : " +movie);

                alertDialog.show();
            }
        });
    }
}
