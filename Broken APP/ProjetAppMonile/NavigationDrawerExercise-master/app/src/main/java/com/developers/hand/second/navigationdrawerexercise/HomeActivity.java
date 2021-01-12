package com.developers.hand.second.navigationdrawerexercise;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.vdccalculator.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @BindView(R.id.mDrawerLayout)
    NavigationView navigationView;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.toolbar)
    Toolbar myToolbar;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setupUi();
    }

    private void setupUi() {

        mDrawerLayout = findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, myToolbar, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mDrawerLayout.setClickable(true);
        setSupportActionBar(myToolbar);
        setupNavigationView();
        mToggle.setDrawerIndicatorEnabled(true);
        mToggle.syncState();
        toolbarTitle.setText("Home");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setupNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switchScreen(item.getItemId());
                return true;
            }

        });
    }

    private void switchScreen(int id) {
        switch (id) {
            case R.id.home:
                container.removeAllViews();
                startActivity(new Intent(this, HomeActivity.class));
                mDrawerLayout.closeDrawers();
                break;
            case R.id.Taxe:
                container.removeAllViews();
                startActivity(new Intent(this, MainActivity.class));
                container.addView(new Profile(this));
                toolbarTitle.setText("Profile");
                mDrawerLayout.closeDrawers();
                break;
            case R.id.Carburant:
                container.removeAllViews();
                container.addView(new Profile(this));
                toolbarTitle.setText("Carburant");
                mDrawerLayout.closeDrawers();
                break;
            case R.id.Entretien:
                container.removeAllViews();
                container.addView(new Profile(this));
                toolbarTitle.setText("Entrertien");
                mDrawerLayout.closeDrawers();
                break;
            case R.id.Assurance:
                container.removeAllViews();
                container.addView(new Profile(this));
                toolbarTitle.setText("Assurance");
                mDrawerLayout.closeDrawers();
                break;
            case R.id.CoutTotal:
                container.removeAllViews();
                container.addView(new Profile(this));
                toolbarTitle.setText("Cout Total");
                mDrawerLayout.closeDrawers();
                break;
        }

    }
}
