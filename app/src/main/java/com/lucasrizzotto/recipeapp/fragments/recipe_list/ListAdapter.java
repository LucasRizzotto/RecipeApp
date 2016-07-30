package com.lucasrizzotto.recipeapp.fragments.recipe_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lucasrizzotto.recipeapp.R;
import com.lucasrizzotto.recipeapp.model.Recipes;

public class ListAdapter extends RecyclerView.Adapter {

    private final ListFragment.OnRecipeSelectedInterface mListener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;
        private ImageView mImageView;
        private int mIndex;

        public ListViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.recipeTitle);
            mImageView = (ImageView) itemView.findViewById(R.id.recipeImage);
            itemView.setOnClickListener(this);
        }

        public void bindView(int i) {
            mIndex = i;
            mTextView.setText(Recipes.names[i]);
            mImageView.setImageResource(Recipes.resourceIds[i]);
        }

        @Override
        public void onClick(View view) {
            mListener.onListRecipeSelected(mIndex);
        }
    }

}
