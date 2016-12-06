package com.example.longlam.mangaworksassistant;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class ComboListPresenter {
   private ComboListActivity activity;

   String TAG = this.toString();

   ArrayList<String> sceneList;
   ArrayList<String> themeList;
   ArrayList<Combo> fullCombos;
   boolean[] sceneCheckedItems;
   boolean[] themeCheckedItems;
   boolean[] newThemeCheckedItems;
   boolean[] newSceneCheckedItems;
   boolean sceneAscToggle = false;
   boolean themeAscToggle = false;


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

   // Sets ALL Scenes and Themes
   protected void setFull() {
      for (int i = 0; i < sceneCheckedItems.length; i++) {
         sceneCheckedItems[i] = true;
      }
      for (int i = 0; i < themeCheckedItems.length; i++) {
         themeCheckedItems[i] = true;
      }
      updateComboListByScene();
   }

   protected void setSome(int choice) {
      for (int i = 0; i < choice; i++) {
         sceneCheckedItems[i] = true;
      }
      for (int i = 0; i < choice; i++) {
         themeCheckedItems[i] = true;
      }
      updateComboListByScene();
   }

   protected void setNone() {
      updateAdapter(new ArrayList<Combo>());
   }

   private void updateAdapter(ArrayList<Combo> comboArrayList) {
      activity.setComboListRecyclerView(new ComboListAdapter(comboArrayList));
   }


   protected void saveThemeSceneList() {
      SharedPreferences sharedPreferences = activity.getPreferences(0);
      SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();
      for(int i = 0; i < themeList.size(); i++) {
         preferenceEditor.putBoolean(themeList.get(i), themeCheckedItems[i]);
      }
      for (int i = 0; i < sceneList.size(); i++) {
         preferenceEditor.putBoolean(sceneList.get(i), sceneCheckedItems[i]);
      }
      preferenceEditor.apply();
   }

   protected void loadThemeSceneList() {
      SharedPreferences sharedPreferences = activity.getPreferences(0);
      for(int i = 0; i < themeList.size(); i++) {
         themeCheckedItems[i] = sharedPreferences.getBoolean(themeList.get(i), themeCheckedItems[i]);
      }
      for (int i = 0; i < sceneList.size(); i++) {
         sceneCheckedItems[i] = sharedPreferences.getBoolean(sceneList.get(i), sceneCheckedItems[i]);
      }
      updateComboListByTheme();
   }

   protected boolean[] getThemeCheckedItems() {
      newThemeCheckedItems = themeCheckedItems;
      return themeCheckedItems;
   }

   protected boolean[] getSceneCheckedItems() {
      newSceneCheckedItems = sceneCheckedItems;
      return sceneCheckedItems;
   }

   protected void updateThemeList() {
      themeCheckedItems = newThemeCheckedItems;
   }

   protected void updateSceneList() {
      sceneCheckedItems = newSceneCheckedItems;
   }

   protected void newThemeItem(int i, boolean b) {
      newThemeCheckedItems[i] = b;
   }

   protected void newSceneItem(int i, boolean b) {
      newSceneCheckedItems[i] = b;
   }

   protected void updateComboListByTheme() {

      themeAscToggle = !themeAscToggle;
      ArrayList<Combo> comboList = new ArrayList<Combo>();
      if (sceneCheckedItems == null || themeCheckedItems == null) {
         return;
      }
      for (int themeIndex = 0; themeIndex < themeCheckedItems.length; themeIndex++) {
         if (themeCheckedItems[themeIndex]) {
            String themeItem = themeList.get(themeIndex);
            for (int sceneIndex = 0; sceneIndex < sceneCheckedItems.length; sceneIndex++) {
               if (sceneCheckedItems[sceneIndex]) {
                  String sceneItem = sceneList.get(sceneIndex);
                  for (Combo comboItem : fullCombos) {
                     if (comboItem.isCombo(themeItem, sceneItem)) {
                        if (themeAscToggle) {
                           comboList.add(comboList.size(), comboItem); // asc sort
                        } else {
                           comboList.add(0, comboItem); // desc sort
                        }
                     }
                  }
               }
            }
            updateAdapter(comboList);
         }
      }
   }

   protected void updateComboListByScene() {

      sceneAscToggle = !sceneAscToggle;
      ArrayList<Combo> comboList = new ArrayList<Combo>();
      if (sceneCheckedItems == null || themeCheckedItems == null) {
         return;
      }
      for (int sceneIndex = 0; sceneIndex < sceneCheckedItems.length; sceneIndex++) {
         if (sceneCheckedItems[sceneIndex]) {
            for (int themeIndex = 0; themeIndex < themeCheckedItems.length; themeIndex++) {
               if (themeCheckedItems[themeIndex]) {
                  String themeItem = themeList.get(themeIndex);
                  String sceneItem = sceneList.get(sceneIndex);
                  for (Combo comboItem : fullCombos) {
                     if (comboItem.isCombo(themeItem, sceneItem)) {
                        if (sceneAscToggle) {
                           comboList.add(comboList.size(), comboItem); // asc sort
                        } else {
                           comboList.add(0, comboItem); // desc sort
                        }
                     }
                  }
               }
            }
         }
         updateAdapter(comboList);
      }
   }
}