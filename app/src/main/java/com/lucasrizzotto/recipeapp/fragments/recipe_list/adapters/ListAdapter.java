package com.lucasrizzotto.recipeapp.fragments.recipe_list.adapters;

import com.lucasrizzotto.recipeapp.R;
import com.lucasrizzotto.recipeapp.fragments.recipe_list.fragments.ListFragment;

public class ListAdapter extends RecyclerAdapter {

    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }

}
