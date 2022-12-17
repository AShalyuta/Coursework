package by.pms.mydog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private TextView text_content;
    private Typeface face1;
    private ImageView iContent;
    private ActionBar actionBar;
    private SharedPreferences def_pref;
    private int category = 0;
    private int position = 0;
    private final int [] array_home = {R.string.home1, R.string.home2,
            R.string.home3, R.string.home4};
    private final int [] array_shepherd = {R.string.shepherd1, R.string.shepherd2,
            R.string.shepherd3, R.string.shepherd4};
    private final int [] array_watchdogs = {R.string.watchdogs1, R.string.watchdogs2,
            R.string.watchdogs3, R.string.watchdogs4};
    private final int [] array_hunting = {R.string.hunting1, R.string.hunting2,
            R.string.hunting3, R.string.hunting4};
    private final int [] array_sled = {R.string.sled1, R.string.sled2,
            R.string.sled3, R.string.sled4};
    private final int [] array_image1 = {R.drawable.vaccin, R.drawable.rac,
            R.drawable.time_r, R.drawable.time_e};
    private final int [] array_text_actionBar = {R.string.vaccine, R.string.diet,
            R.string.walking_time, R.string.feeding_time};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        def_pref = PreferenceManager.getDefaultSharedPreferences(this);
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);
        face1 = Typeface.createFromAsset(this.getAssets(),"fonds/Comfortaa-VariableFont_wght.ttf");
        text_content.setTypeface(face1);
        actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        String text = def_pref.getString("list_preference_1", "Средний");
        if (text != null) {
            switch (text) {
                case "Большой":
                    text_content.setTextSize(20);
                    break;
                case "Средний":
                    text_content.setTextSize(16);
                    break;
                case "Маленький":
                    text_content.setTextSize(14);
                    break;

            }
        }
        reciveIntent();
    }
    private void reciveIntent(){
        Intent i = getIntent();
        if(i != null){
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position",0);
        }
        switch (category){
            case 0:
                iContent.setImageResource(array_image1[position]);
                text_content.setText(array_home[position]);
                actionBar.setTitle(array_text_actionBar[position]);
                break;
            case 1:
                iContent.setImageResource(array_image1[position]);
                text_content.setText(array_shepherd[position]);
                actionBar.setTitle(array_text_actionBar[position]);
                break;
            case 2:
                iContent.setImageResource(array_image1[position]);
                text_content.setText(array_watchdogs[position]);
                actionBar.setTitle(array_text_actionBar[position]);
                break;
            case 3:
                iContent.setImageResource(array_image1[position]);
                text_content.setText(array_hunting[position]);
                actionBar.setTitle(array_text_actionBar[position]);
                break;
            case 4:
                iContent.setImageResource(array_image1[position]);
                text_content.setText(array_sled[position]);
                actionBar.setTitle(array_text_actionBar[position]);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return true;
    }
}
