package com.lucasrizzotto.recipeapp.fragments.recipe_details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.lucasrizzotto.recipeapp.R;

public abstract class CheckBoxesFragment extends Fragment {

    private static final String KEY_CHECKED_BOXES = "checked_boxes";
    private CheckBox[] mCheckBoxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int i = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.checkBoxesLayout);
        String[] content = getContents(i);
        mCheckBoxes = new CheckBox[content.length];
        boolean[] checkedBoxes = new boolean[mCheckBoxes.length];
        if(savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null)
        {
            checkedBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }
        setUpCheckBoxes(content, linearLayout, checkedBoxes);
        return view;
    }

    public abstract String[] getContents(int i);

    private void setUpCheckBoxes(String[] content, ViewGroup container, boolean[] checkedBoxes) {
        int i = 0;
        for(String item : content) {
            mCheckBoxes[i] = new CheckBox(getActivity());
            mCheckBoxes[i].setPadding(8, 16, 8, 16);
            mCheckBoxes[i].setTextSize(20f);
            mCheckBoxes[i].setText(item);
            container.addView(mCheckBoxes[i]);
            if(checkedBoxes[i]) {
                mCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];
        int i = 0;
        for(CheckBox checkBox : mCheckBoxes) {
            stateOfCheckBoxes[i] = checkBox.isChecked();
            i++;
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckBoxes);
        super.onSaveInstanceState(outState);

    }
}
