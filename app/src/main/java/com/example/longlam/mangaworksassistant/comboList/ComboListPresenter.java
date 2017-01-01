package com.example.longlam.mangaworksassistant.comboList;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.longlam.mangaworksassistant.Combo;
import com.example.longlam.mangaworksassistant.HardCodedCombos;
import com.example.longlam.mangaworksassistant.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComboListPresenter {
   private ComboListActivity activity;
   private ComboListAdapter adapter;

   String TAG = this.toString();

   ArrayList<String> sceneList;
   ArrayList<String> themeList;
   ArrayList<Combo> fullCombos;
   boolean[] sceneCheckedItems;
   boolean[] themeCheckedItems;
   boolean likeAscToggle = false;


   public ComboListPresenter(ComboListActivity activity) {
      this.activity = activity;
      getLists();
   }

   // Hard coded stuff
   private void getLists() {
      sceneList = activity.getStringArray(R.array.scenes);
      themeList = activity.getStringArray(R.array.themes);
      sceneCheckedItems = new boolean[sceneList.size()];
      themeCheckedItems = new boolean[themeList.size()];
      fullCombos = HardCodedCombos.parseCombos();
   }

   private void updateAdapter(ArrayList<Combo> comboArrayList) {
      adapter = new ComboListAdapter(comboArrayList);
      activity.setComboListRecyclerView(adapter);
   }

   protected void loadThemeSceneList() {
      SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
      for (int i = 0; i < themeList.size(); i++) {
         themeCheckedItems[i] = sharedPreferences.getBoolean(themeList.get(i), themeCheckedItems[i]);
      }
      for (int i = 0; i < sceneList.size(); i++) {
         sceneCheckedItems[i] = sharedPreferences.getBoolean(sceneList.get(i), sceneCheckedItems[i]);
      }
      loadAdapter();
   }

   protected void loadAdapter() {
      ArrayList<Combo> updatedList = new ArrayList<>();
      for (Combo combo : fullCombos) {
         int sceneIndex = sceneList.indexOf(combo.getScene());
         int themeIndex = themeList.indexOf(combo.getTheme());
         if (sceneCheckedItems[sceneIndex] && themeCheckedItems[themeIndex]) {
            updatedList.add(combo);
         }
      }
      updateAdapter(updatedList);
   }

   protected void updateComboListByTheme() {
      adapter.sortByTheme();
   }

   protected void updateComboListByScene() {
      adapter.sortByScene();
   }

   protected void updateComboListByLike() {
      likeAscToggle = !likeAscToggle;
      ArrayList<Combo> currentList = adapter.getListOfCombos();
      Collections.sort(currentList, new Comparator<Combo>() {
         @Override
         public int compare(Combo combo, Combo t1) {
            return likeAscToggle ? combo.getLikeA().compareTo(t1.getLikeA()) : t1.getLikeA().compareTo(combo.getLikeA());
         }
      });
      updateAdapter(currentList);
   }
}