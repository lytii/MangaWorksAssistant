package com.example.longlam.mangaworksassistant;

import java.util.ArrayList;

public class ComboListPresenter {
   private ComboListActivity activity;

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
      updateComboListBySceneAsc();
   }

   protected void setSome(int choice) {
      for (int i = 0; i < choice; i++) {
         sceneCheckedItems[i] = true;
      }
      for (int i = 0; i < choice; i++) {
         themeCheckedItems[i] = true;
      }
      updateComboListBySceneAsc();
   }

   protected void setNone() {
      update(new ArrayList<Combo>());
   }

   private void update(ArrayList<Combo> comboArrayList) {
      activity.setComboListRecyclerView(new ComboListAdapter(comboArrayList));
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
            update(comboList);
         }
      }
   }

   protected void updateComboListBySceneAsc() {

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
         update(comboList);
      }
   }
}