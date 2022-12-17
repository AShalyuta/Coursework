package by.pms.mydog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class Logo_Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        startMainActivity();
    }

    private void startMainActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent i = new Intent(Logo_Activity.this,MainActivity.class);
                startActivity(i);
            }
        }).start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
