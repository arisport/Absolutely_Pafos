package com.absolutelypafos.attractions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.absolutelypafos.R;


public class LaraBayTurtleConservationStation extends AppCompatActivity {
    TextView Title;
    TextView Start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringslayout);

        SpannableString ss0 = new SpannableString("The Lara Bay Turtle Conservation Station at Akamas is a small turtle beach just 15 minutes away from Paphos. " +
                "The turtles are specially conserved at this beach and especially the Chelonia mydas species, which is in danger of extinction." +
                "The Lara Bay Turtle Conservation Station at Akamas is a small turtle beach just 15 minutes away from Paphos. The turtles are specially conserved at this beach and especially the Chelonia mydas species, which is in danger of extinction. \n" +
                "The Lara Bay Turtle Conservation Station offers a small hut telling visitors information about the turtles. There can be up to 50 nests at one time on this beach and it is recommended to watch where you step. \n" +
                "Signs are shown and small circle open air cilindros are placed where suspected eggs lay.\n" +
                "Not easy to get to without going on a 4X4 trip or having a motor vehicle.\n" +
                "Great place for supivised children to see the small turtles aswell as learn all about them");

        TextView Introduction = (TextView) findViewById(R.id.Intro);
        Introduction.setText(ss0);
        Introduction.setMovementMethod(LinkMovementMethod.getInstance());
        Introduction.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.attraction9,0,0);
        Introduction.setCompoundDrawablePadding(20);

        SpannableString ss = new SpannableString("Akamas, Akamas Peninsula National Park, Cyprus"
                );
        
        TextView textView = (TextView) findViewById(R.id.SecondStart);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        SpannableString ss5 = new SpannableString("The station is accessible to the public 24 hours a day, 365 days a year.");


        TextView SecondQuestionAnswer = (TextView) findViewById(R.id.SecondQuestionAnswer);
        SecondQuestionAnswer.setText(ss5);
        SecondQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString ss6 = new SpannableString("Entrance: Free");
        ss6.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 10, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView ThirdQuestionAnswer = (TextView) findViewById(R.id.ThirdQuestionAnswer);
        ThirdQuestionAnswer.setText(ss6);
        ThirdQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        Title = (TextView)findViewById(R.id.Title);
        String htmlString="<u>Lara Bay Turtle Conservation Station</u>";
        Title.setText(Html.fromHtml(htmlString));
        Start = (TextView)findViewById(R.id.Start);
        String htmlStringStart="<u>General Information</u>";
        Start.setText(Html.fromHtml(htmlStringStart));

        TextView MainStart = (TextView) findViewById(R.id.MainStart);
        String htmlStringMain="<u>Address</u>";
        MainStart.setText(Html.fromHtml(htmlStringMain));

        TextView SecondQuestion = (TextView) findViewById(R.id.SecondQuestion);
        String htmlStringSecond="<u>Opening Hours</u>";
        SecondQuestion.setText(Html.fromHtml(htmlStringSecond));

        TextView ThirdQuestion = (TextView) findViewById(R.id.ThirdQuestion);
        String htmlStringThird="<u>Additional Information</u>";
        ThirdQuestion.setText(Html.fromHtml(htmlStringThird));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_attractions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                overridePendingTransition(R.anim.rotate_out, R.anim.rotate_in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
