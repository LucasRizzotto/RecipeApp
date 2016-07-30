package com.lucasrizzotto.recipeapp.fragments.recipe_details;

import com.lucasrizzotto.recipeapp.model.Recipes;

public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int i) {
        return Recipes.directions[i].split("`");
    }
}
