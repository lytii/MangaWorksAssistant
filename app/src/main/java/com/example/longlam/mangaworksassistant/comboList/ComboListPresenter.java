package com.example.longlam.mangaworksassistant.comboList;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.longlam.mangaworksassistant.Combo;
import com.example.longlam.mangaworksassistant.R;

import java.util.ArrayList;

public class ComboListPresenter {
   private ComboListActivity activity;
   private ComboListAdapter adapter;

   public ComboListPresenter(ComboListActivity activity) {
      this.activity = activity;
   }

   protected void setUpCombos() {
      adapter = new ComboListAdapter(new ArrayList<Combo>());
      activity.setComboListRecyclerView(adapter);

      adapter.setSceneList(activity.getStringArray(R.array.scenes));
      adapter.setThemeList(activity.getStringArray(R.array.themes));

      SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
      adapter.loadCheckedThemesScenes(sharedPreferences);
      adapter.setUpCombos();
   }

   protected void updateComboListByTheme() {
      adapter.sortByTheme();
   }

   protected void updateComboListByScene() {
      adapter.sortByScene();
   }
}