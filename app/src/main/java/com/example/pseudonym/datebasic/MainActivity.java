package com.example.pseudonym.datebasic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Person> personList_ = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // construct menu
        Menu menu = navigationView.getMenu();
        PersonBuilder personbuilder = new PersonBuilder();
        List<Person> person_list = personbuilder.buildFromAssetFile(MainActivity.this, "preset_persons.xml");
        for (Person person : person_list){
            MenuItem mi = menu.add(person.getName());
            mi.setIcon(person.getImage());
            mi.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    OnePersonDetailActivity.actionStart(MainActivity.this, (String)item.getTitle());

                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);

                    return true;
                }
            });
        }
//        Menu topChannelMenu = menu.addSubMenu("Top Channels");

        if (menu.size() != 0){
            MenuItem mi = menu.getItem(menu.size()-1);
            mi.setTitle(mi.getTitle());
            mi.setIcon(mi.getIcon());
        }

        // my initialization
//        initAllPerson();
//        AllPersonAdapter adapter = new AllPersonAdapter(MainActivity.this, R.layout.all_persons,personList_);
//        ListView listView = (ListView)findViewById(R.id.listView_duration);
//        listView.setAdapter(adapter);


        Days2TodayBuilder builder = new Days2TodayBuilder();
        List<Memo> memo_list = builder.buildFromAssetFile(this, "preset_persons.xml");
        AllPersonAdapter adapter = new AllPersonAdapter(MainActivity.this, R.layout.all_persons, memo_list);
        ListView listView = (ListView)findViewById(R.id.listView_duration);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            OnePersonDetailActivity.actionStart(MainActivity.this, "皮娃");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initAllPerson(){
//        Person xiaowa = new Person(getResources().getString(R.string.xiaowa_name),
//                getResources().getString(R.string.xiaowa_birthday),
//                R.drawable.xiaowa);
//        personList_.add(xiaowa);
//
//        Person piwa = new Person(getResources().getString(R.string.piwa_name),
//                getResources().getString(R.string.piwa_birthday),
//                R.drawable.piwa);
//        personList_.add(piwa);
    }
}
