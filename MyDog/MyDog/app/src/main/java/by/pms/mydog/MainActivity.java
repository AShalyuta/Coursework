package by.pms.mydog;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ArrayAdapter<String> adapter;
    private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listView);
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.home_arrays);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category",category_index);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.home);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {

            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            funcArray(R.string.home,R.array.home_arrays,0);
        }
        else if (id == R.id.nav_shepherd) {
            funcArray(R.string.shepherd,R.array.shepherd_arrays,1);
        }
        else if (id == R.id.nav_watchdogs) {
            funcArray(R.string.watchdogs,R.array.watchdogs_arrays,2);
        }
        else if (id == R.id.nav_hunting) {
            funcArray(R.string.hunting,R.array.hunting_arrays,3);
        }
        else if (id == R.id.nav_sled) {
            funcArray(R.string.sled,R.array.sled_arrays,4);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void funcArray(int title, int nameArray, int index) {
        toolbar.setTitle(title);
        array = getResources().getStringArray(nameArray);
        adapter.clear();
        adapter.addAll(array);
        adapter.notifyDataSetChanged();
        category_index = index;
    }
}