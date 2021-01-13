package jlong_games_and_playback_studios.firstunitedbank;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Launcher extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_jlong_games);
        final Intent moveOn = new Intent(this,HomeScreen.class);

        final CountDownTimer runPlayback_Studios = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                startActivity(moveOn);}
        };

        CountDownTimer runJlong_Games = new CountDownTimer(5000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                setContentView(R.layout.launcher_playback_studios);
                runPlayback_Studios.start();
            }
        };

        runJlong_Games.start();
    }

}
