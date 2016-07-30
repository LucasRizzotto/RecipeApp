package com.lucasrizzotto.recipeapp.fragments.recipe_list.adapters;

import com.lucasrizzotto.recipeapp.R;
import com.lucasrizzotto.recipeapp.fragments.recipe_list.fragments.GridFragment;

public class GridAdapter extends RecyclerAdapter {

    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }

}
