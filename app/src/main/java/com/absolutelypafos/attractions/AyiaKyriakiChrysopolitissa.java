package com.absolutelypafos.attractions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.absolutelypafos.R;


public class AyiaKyriakiChrysopolitissa extends AppCompatActivity {

    TextView Title;
    TextView Start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringslayout);

        SpannableString ss0 = new SpannableString("The Panagia Chrysopolitissa church was built in the 13th century over the ruins of the " +
                "largest Early Byzantine basilica on the island. Within the compound one can see St. Paul's Pillar, where, according to " +
                "tradition, Saint Paul was flogged before the Roman Governor Sergius Paulus was converted to Christianity. " +
                "Originally the church was seven–aisled, but later was reduced to five-aisles. " +
                "The floor of the basilica was covered with colourful mosaics, some of which are still preserved.\n");

        TextView Introduction = (TextView) findViewById(R.id.Intro);
        Introduction.setText(ss0);
        Introduction.setMovementMethod(LinkMovementMethod.getInstance());
        Introduction.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.attraction6,0,0);
        Introduction.setCompoundDrawablePadding(20);

        SpannableString ss = new SpannableString("Kato Pafos\n" +
                "Tel: +357 26306217");

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+357 26306217"));
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 15, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView textView = (TextView) findViewById(R.id.SecondStart);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        SpannableString ss5 = new SpannableString("Winter hours (16th September – 15th April): 8.30 - 17.00 \n" +
                "Summer hours (16th April – 15th September): 8.30 - 19.30");

        ss5.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 14, 41, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss5.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 71, 100, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView SecondQuestionAnswer = (TextView) findViewById(R.id.SecondQuestionAnswer);
        SecondQuestionAnswer.setText(ss5);
        SecondQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString ss6 = new SpannableString("Entrance: Free");
        ss6.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 10, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView ThirdQuestionAnswer = (TextView) findViewById(R.id.ThirdQuestionAnswer);
        ThirdQuestionAnswer.setText(ss6);
        ThirdQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        Title = (TextView)findViewById(R.id.Title);
        String htmlString="<u>Panagia Chrysopolitissa</u>";
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
