package com.lucasrizzotto.recipeapp.fragments.recipe_details;

import com.lucasrizzotto.recipeapp.model.Recipes;

public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int i) {
        return Recipes.ingredients[i].split("`");
    }
}
