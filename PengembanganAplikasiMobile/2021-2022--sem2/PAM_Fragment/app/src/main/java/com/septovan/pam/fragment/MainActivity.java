package com.septovan.pam.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity
        extends AppCompatActivity
        implements ArticleTitleFragment.OnHeadlineSelectedListener {

    @Override
    public void onArticleSelected(int position) {
        boolean isLandscape = getResources().getBoolean(R.bool.is_landscape);
        if (isLandscape) {
            ArticleBodyFragment articleBodyFragment = (ArticleBodyFragment) getSupportFragmentManager()
                .findFragmentById(R.id.content_frame)
                .getChildFragmentManager()
                .findFragmentById(R.id.article_body);

            articleBodyFragment.updateArticleView(position);
        } else {
            ArticleBodyFragment newArticleBodyFragment = new ArticleBodyFragment();

            Bundle args = new Bundle();
            args.putInt(ArticleBodyFragment.ARG_POSITION, position);
            newArticleBodyFragment.setArguments(args);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.home_content_frame, newArticleBodyFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavView = findViewById(R.id.bottom_navigation);
        bottomNavView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.content_frame, new HomeFragment())
            .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.page_home: {
                            getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_frame, new HomeFragment())
                                .commit();
                        }
                        break;
                    case R.id.page_bookmark: {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.content_frame, new BookmarkFragment())
                                    .commit();
                        }
                        break;
                    case R.id.page_profile: {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.content_frame, new ProfileFragment())
                                    .commit();
                        }
                        break;
                }

                return true;
            }
        };
}