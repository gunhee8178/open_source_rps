package example.com.rockpaperscissors;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PlayMJB extends Activity{
    Button rock2, paper2, scissors2;
    TextView humanDraw2, cpuDraw2, winner2, humanScore2, cpuScore2;

    Integer yourturn=0;

    final static MainActivity mainActivity = new MainActivity();
    static Integer life = mainActivity.life;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mjb_play_screen);


        rock2 = (Button) findViewById(R.id.rock2);
        paper2 = (Button) findViewById(R.id.paper2);
        scissors2 = (Button) findViewById(R.id.scissors2);

        humanDraw2 = (TextView) findViewById(R.id.humandraw2);
        cpuDraw2 = (TextView) findViewById(R.id.cpudraw2);
        winner2 = (TextView) findViewById(R.id.winner2);
        humanScore2 = (TextView) findViewById(R.id.humanscore2);
        cpuScore2 = (TextView) findViewById(R.id.cpuscore2);


        rock2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanDraw2.setText("ROCK");
                cpuDraw2.setText(GameAI.getDraw());
                checkDrawWinner2("ROCK", cpuDraw2.getText().toString());
            }
        });

        paper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanDraw2.setText("PAPER");
                cpuDraw2.setText(GameAI.getDraw());
                checkDrawWinner2("PAPER", cpuDraw2.getText().toString());
            }
        });

        scissors2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                humanDraw2.setText("SCISSORS ");
                cpuDraw2.setText(GameAI.getDraw());
                checkDrawWinner2("SCISSORS", cpuDraw2.getText().toString());
            }
        });
    }

    private void checkDrawWinner2(String humanDraw, String cpuDraw) {
        if (humanDraw.equals(cpuDraw) && yourturn==0) {
            winner2.setText("Again!");
        } else if (humanDraw.equals(cpuDraw) && yourturn==1) {
            winner2.setText("You Wins!");
            Integer humanWins2 = Integer.parseInt(humanScore2.getText().toString());
            humanWins2++;
            humanScore2.setText(humanWins2.toString());
            yourturn = 0;
        } else if (humanDraw.equals(cpuDraw) && yourturn==2) {
            winner2.setText("CPU Wins!");
            Integer cpuWins2 = Integer.parseInt(cpuScore2.getText().toString());
            cpuWins2++;
            cpuScore2.setText(cpuWins2.toString());
            yourturn = 0;
        } else if (humanDraw.equals("ROCK")) {
            if (cpuDraw.equals("SCISSORS")) {
                winner2.setText("Your Turn!");
                yourturn = 1;
            } else {
                winner2.setText("CPU Turn!");
                yourturn = 2;
            }
        } else if (humanDraw.equals("PAPER")) {
            if (cpuDraw.equals("ROCK")) {
                winner2.setText("Your Turn!");
                yourturn = 1;
            } else {
                winner2.setText("CPU Turn!");
                yourturn = 2;
            }
        } else {
            if (cpuDraw.equals("PAPER")) {
                winner2.setText("Your Turn!");
                yourturn = 1;
            } else {
                winner2.setText("CPU Turn!");
                yourturn = 2;
            }
        }
    }
}