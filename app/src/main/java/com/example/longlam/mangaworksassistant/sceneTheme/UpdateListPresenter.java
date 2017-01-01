package com.example.longlam.mangaworksassistant.sceneTheme;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.longlam.mangaworksassistant.R;

public class UpdateListPresenter {
   private UpdateListActivity activity;

   private UpdateListSceneThemeAdapter sceneListAdapter;
   private UpdateListSceneThemeAdapter themeListAdapter;

   protected UpdateListPresenter(UpdateListActivity activity) {
      this.activity = activity;
   }

   protected UpdateListSceneThemeAdapter getSceneAdapter() {
      if (sceneListAdapter == null) {
         sceneListAdapter = new UpdateListSceneThemeAdapter(activity.getStringArray(R.array.scenes));
      }
      return sceneListAdapter;
   }

   protected UpdateListSceneThemeAdapter getThemeAdapter() {
      if (themeListAdapter == null) {
         themeListAdapter = new UpdateListSceneThemeAdapter(activity.getStringArray(R.array.themes));
      }
      return themeListAdapter;
   }

   protected void saveUpdateList() {
      SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
      sceneListAdapter.saveCheckedList(sharedPreferences);
      themeListAdapter.saveCheckedList(sharedPreferences);
   }

   protected void loadUpdateList() {
      sceneListAdapter.loadCheckedList(PreferenceManager.getDefaultSharedPreferences(activity));
      themeListAdapter.loadCheckedList(PreferenceManager.getDefaultSharedPreferences(activity));
   }
}
