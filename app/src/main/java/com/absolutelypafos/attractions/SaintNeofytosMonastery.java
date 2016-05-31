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


public class SaintNeofytosMonastery extends AppCompatActivity {

    TextView Title;
    TextView Start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringslayout);

        SpannableString ss0 = new SpannableString("Saint Neophytos monastery lies 10 km outside Pafos, near Tala village. " +
                "Saint Neophytos was the founder of the monastery in 1159. He lived there and died in 1219 at the age of 85." +
                " The main church of the monastery was built around 200 years after his death and is dedicated to the Virgin Mary. \n" +
                "A famous painter, Theodoros Apsevdis, undertook to paint the frescoes in the Enkleistra." +
                " You can also see Byzantine icons of exceptional artistic quality in the main church of the " +
                "monastery and also visit the museum of the monastery, which has exhibits from both the ancient " +
                "period and Byzantine period.\n" +
                "Interesting places for the visitor are the cave with the cell of Saint Neophytos (Enkleistra). " +
                "The Enkleistra, an enclosure carved out of the mountain by the hermit, contains some of the finest " +
                "Byzantine frescoes\n" +
                " dating from the 12th to the 15th century. " +
                "His rock-table and the stone platform on which  he slept are still preserved in " +
                "his cell, as is his grave. According to legend, this grave is adjusted so that it comes " +
                "to measures whoever  tries it.");

        TextView Introduction = (TextView) findViewById(R.id.Intro);
        Introduction.setText(ss0);
        Introduction.setMovementMethod(LinkMovementMethod.getInstance());
        Introduction.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.attraction5,0,0);
        Introduction.setCompoundDrawablePadding(20);

        SpannableString ss = new SpannableString("Tala Village, Paphos\n" +
                "Tel: +357 26652481");

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+357 26652481"));
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 25, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView textView = (TextView) findViewById(R.id.SecondStart);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        SpannableString ss5 = new SpannableString("Winter hours (16th September – 15th April): 09:00 – 16:00 \n" +
                "Summer hours (16th April – 15th September): 09:00 - 18:00");

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
        String htmlString="<u>Saint Neophytos Monastery</u>";
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
