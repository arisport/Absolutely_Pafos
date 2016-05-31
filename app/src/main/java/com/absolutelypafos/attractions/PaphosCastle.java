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


public class PaphosCastle extends AppCompatActivity {

    TextView Title;
    TextView Start;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stringslayout);

        SpannableString ss0 = new SpannableString("Pafos castle was originally a Byzantine fort built to protect the harbour. " +
                "It was rebuilt by the Lusignans in the 13th century, dismantled by the Venetians in 1570 during the Ottoman " +
                "invasion and rebuilt by the Ottomans after they captured the island in the 16th century. Originally, " +
                "this role was served by the Saranta Kolones fort, the ruins of which lie a few hundred meters to the north. " +
                "During its long history, the Pafos Castle was used, as well as for protection, as prison cells, and even as a " +
                "storage area for salt when the island was a British colony. In 1935 it was declared an ancient monument and " +
                "today is considered as one of the hallmarks of the Pafos region.\n" +
                "Many cultural events take place in the square just in front of the castle, while during September each " +
                "year the Pafos Aphrodite Festival which presents a different opera every year staged here by world famous " +
                "artists with the castle  ");

        TextView Introduction = (TextView) findViewById(R.id.Intro);
        Introduction.setText(ss0);
        Introduction.setMovementMethod(LinkMovementMethod.getInstance());
        Introduction.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.attraction2,0,0);
        Introduction.setCompoundDrawablePadding(20);

        SpannableString ss = new SpannableString("Harbour, Kato Paphos\n" +
                "Tel: +357 26306217");

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+357 26306217"));
                startActivity(intent);
            }
        };
        ss.setSpan(clickableSpan, 25, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
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

        SpannableString ss6 = new SpannableString("Entrance: €2.50");
        ss6.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 11, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        TextView ThirdQuestionAnswer = (TextView) findViewById(R.id.ThirdQuestionAnswer);
        ThirdQuestionAnswer.setText(ss6);
        ThirdQuestionAnswer.setMovementMethod(LinkMovementMethod.getInstance());

        Title = (TextView)findViewById(R.id.Title);
        String htmlString="<u>Medieval Castle of Paphos</u>";
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
