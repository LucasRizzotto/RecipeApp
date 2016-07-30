package com.lucasrizzotto.recipeapp;

import android.app.*;
import android.app.Fragment;
import android.support.v4.app.*;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements com.lucasrizzotto.recipeapp.ListFragment.OnRecipeSelectedInterface {

    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.lucasrizzotto.recipeapp.ListFragment saveFragment = (com.lucasrizzotto.recipeapp.ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
        if(saveFragment == null) {
            com.lucasrizzotto.recipeapp.ListFragment fragment = new com.lucasrizzotto.recipeapp.ListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager(); // Gives access to the FRAGMENT TRANSACTION API
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onListRecipeSelected(int i) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, i);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager(); // Gives access to the FRAGMENT TRANSACTION API
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}
