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


public class RockofAphrodite extends AppCompatActivity {
    TextView Title;
    TextView Start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringslayout);

        SpannableString ss0 = new SpannableString("This interesting geological formation of huge rocks off the southwest coast in the Pafos (Paphos) district forms one of the most impressive natural sites of Cyprus associated with Aphrodite, the Greek goddess of love and beauty. \n" +
                "\n" +
                "According to legend, this strikingly beautiful spot is where Aphrodite rose from the waves and the foaming sea and was then escorted on a shell at the rocks known as ‘Rock ofAphrodite’ or ‘Petra tou Romiou’ in Greek. The Greek name, Petra tou Romiou, “the Rock of the Greek”, is associated with the legendary Byzantine hero, Digenis Akritas, who kept the marauding Saracens at bay with his amazing strength. It is said that he heaved a huge rock into the sea, destroying the enemy's ships.\n" +
                "\n" +
                "It is said that in certain weather conditions, the waves rise, break and form a column of water that dissolves into a pillar of foam. With imagination, this looks for just a moment like an ephemeral, evanescent human shape. The site is on the Aphrodite Cultural Route.");

        TextView Introduction = (TextView) findViewById(R.id.Intro);
        Introduction.setText(ss0);
        Introduction.setMovementMethod(LinkMovementMethod.getInstance());
        Introduction.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.attraction7, 0, 0);
        Introduction.setCompoundDrawablePadding(20);

        SpannableString ss = new SpannableString("Kouklia, Paphos,Cyprus\n"
                );

        TextView textView = (TextView) findViewById(R.id.SecondStart);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        SpannableString ss5 = new SpannableString("The Rock of Aphrodite is accessible to the public " +
                "24 hours a day, 365 days a year.");


        TextView SecondQuestionAnswer = (TextView) findViewById(R.id.SecondQuestionAnswer);
        SecondQuestionAnswer.setText(ss5);
        SecondQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString ss6 = new SpannableString("Entrance: Free");
        ss6.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 10, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView ThirdQuestionAnswer = (TextView) findViewById(R.id.ThirdQuestionAnswer);
        ThirdQuestionAnswer.setText(ss6);
        ThirdQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        Title = (TextView)findViewById(R.id.Title);
        String htmlString="<u>Petra tou Romiou - Rock of Aphrodite</u>";
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
