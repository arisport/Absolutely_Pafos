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
import android.widget.ImageView;
import android.widget.TextView;

import com.absolutelypafos.R;


public class PaphosPark extends AppCompatActivity {

    TextView Test;
    TextView Title;
    TextView Start;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringslayout);

        SpannableString ss0 = new SpannableString("The inclusion of the Kato Pafos archaeological"+
                "site in the UNESCO World Heritage Sites list in 1980 was the starting point for " +
                "the creation of a General Plan whose aim would be primarily to protect and maintain" +
                " the archaeological remains, as well as to promote them and provide comprehensive " +
                "information to visitors. Kato Pafos archaeological Park includes sites and monuments" +
                " from prehistoric times to the Middle Ages, while most remains date to the Roman period." +
                " The marvellous mosaic floors of four Roman villas from the impressive epicentre of the finds. " +
                "The complex includes other important monuments, such as the Asklipieion, the Odeion, the Agora," +
                " the Saranta Kolones (Forty Columns) Fortress, the Limeniotissa Ruins of early Christian Basilica " +
                "and the Tombs of the Kings.");

        TextView Introduction = (TextView) findViewById(R.id.Intro);
        Introduction.setText(ss0);
        Introduction.setMovementMethod(LinkMovementMethod.getInstance());
        Introduction.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.attrainside1,0,0);
        Introduction.setCompoundDrawablePadding(20);

        SpannableString ss = new SpannableString("Kato Pafos, near Pafos harbour\n" +
                "Tel: +357 26306217");

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+357 26306217"));
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 35, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
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

        SpannableString ss6 = new SpannableString("Entrance: €4.50");


        ss6.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 11, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView ThirdQuestionAnswer = (TextView) findViewById(R.id.ThirdQuestionAnswer);
        ThirdQuestionAnswer.setText(ss6);
        ThirdQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        Title = (TextView)findViewById(R.id.Title);
        String htmlString="<u>Paphos Archaeological Park</u>";
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
