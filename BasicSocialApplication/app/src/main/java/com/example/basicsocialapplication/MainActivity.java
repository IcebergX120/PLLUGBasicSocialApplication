package com.example.basicsocialapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.basicsocialapplication.ui.main.AlbumsFragment;
import com.example.basicsocialapplication.ui.main.ImagesFragment;
import com.example.basicsocialapplication.ui.main.PostsFragment;
import com.example.basicsocialapplication.ui.main.todo.TodoFragment;
import com.example.basicsocialapplication.ui.main.users.UsersFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private Toolbar mToolbar;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListeners();

        //set new Action Bar
        setSupportActionBar(mToolbar);

        //DrawerToggle
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();

        //Add Home button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        replaceFragment(new UsersFragment());
        getSupportActionBar();
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_main_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void addFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_main_container, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        getSupportFragmentManager().popBackStack();

        switch (item.getItemId()){
            case R.id.nav_profile:
                replaceFragment(new UsersFragment());
                getSupportActionBar();
                break;

            case R.id.nav_posts:
                replaceFragment(new PostsFragment());
                getSupportActionBar();
                break;

            case R.id.nav_images:
                replaceFragment(new ImagesFragment());
                getSupportActionBar();
                break;

            case R.id.nav_albums:
                replaceFragment(new AlbumsFragment());
                getSupportActionBar();
                break;

            case R.id.nav_todo:
                replaceFragment(new TodoFragment());
                getSupportActionBar();
                break;
        }

        mDrawerLayout.closeDrawers();
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Add click to Home button
        if(mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar = (Toolbar) findViewById(R.id.nav_action_bar);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    private void initListeners() {
        mNavigationView.setNavigationItemSelectedListener(this);
    }
}