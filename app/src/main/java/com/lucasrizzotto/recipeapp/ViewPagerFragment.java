package com.lucasrizzotto.recipeapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.CheckBox;


public class ViewPagerFragment extends android.support.v4.app.Fragment {

    public static final String KEY_IS_INGREDIENTS = "key_is_ingredients";
    public static final String KEY_RECIPE_INDEX = "recipe_index";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int i = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[i]);
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        final CheckBoxesFragment ingredientsFragment = new CheckBoxesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, i);
        bundle.putBoolean(KEY_IS_INGREDIENTS, true);
        ingredientsFragment.setArguments(bundle);

        final CheckBoxesFragment directionsFragment = new CheckBoxesFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, i);
        bundle.putBoolean(KEY_IS_INGREDIENTS, false);
        directionsFragment.setArguments(bundle);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position)
            {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingredients" : "Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }


    // Setting the app name back to normal when we leave!
    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
