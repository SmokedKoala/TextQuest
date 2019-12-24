package ru.samsung.itschool.book.androidquest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Character wither;
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wither = new Character("Геральт");
        story = new Story();
        updateStatus();
    }

    private void go(int i) {
        story.go(i + 1);
        updateStatus();
        if (story.isEnd())
            Toast.makeText(this, "Игра закончена!", Toast.LENGTH_LONG).show();
    }


    private void updateStatus() {
        wither.A += story.current_situation.dA;
        wither.K += story.current_situation.dK;
        wither.R += story.current_situation.dR;
        wither.S +=story.current_situation.dS;
        ((TextView) findViewById(R.id.status)).
                setText("Уровень:" + wither.K +
                        "\nЗолото:" + wither.A + "\nРепутация:" + wither.R+ "\nЗдоровье:" + wither.S);
        ((TextView) findViewById(R.id.title)).
                setText(story.current_situation.subject);
        ((TextView) findViewById(R.id.desc)).
                setText(story.current_situation.text);
        ((LinearLayout) findViewById(R.id.layout)).removeAllViews();
        for (int i = 0; i < story.current_situation.direction.length; i++) {
            Button b = new Button(this);
            b.setText(Integer.toString(i + 1));
            final int buttonId = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    go(buttonId);
                }
            });
            ((LinearLayout) findViewById(R.id.layout)).addView(b);
        }
    }

}
