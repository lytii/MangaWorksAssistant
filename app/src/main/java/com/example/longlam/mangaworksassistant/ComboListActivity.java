package com.example.longlam.mangaworksassistant;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComboListActivity extends AppCompatActivity {

   ComboListAdapter comboListAdapter;
   ArrayList<Combo> fullCombos = HardCodedCombos.parseCombos();
   String[] sceneList;
   String[] themeList;

   boolean[] sceneCheckedItems;
   boolean[] themeCheckedItems;

   @BindView(R.id.combo_recycler_view)
   RecyclerView comboRecyclerView;

   @OnClick(R.id.add_scene_button)
   public void addScene() {
      if (sceneCheckedItems == null) {
         sceneCheckedItems = new boolean[sceneList.length];
      }
      final boolean[] newSceneCheckedItems = sceneCheckedItems;

      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle("Add your scenes")
             .setMultiChoiceItems(sceneList, sceneCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                   newSceneCheckedItems[i] = b;
                }
             })
             .setNegativeButton("Cancel", null)
             .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   sceneCheckedItems = newSceneCheckedItems;
                   updateList();
                }
             })
             .show();
   }

   @OnClick(R.id.add_theme_button)
   public void addTheme() {
      if (themeCheckedItems == null) {
         themeCheckedItems = new boolean[themeList.length];
      }
      final boolean[] newThemeCheckedItems = themeCheckedItems;

      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle("Add your themes")
             .setMultiChoiceItems(themeList, themeCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                   newThemeCheckedItems[i] = b;
                }
             })
             .setNegativeButton("Cancel", null)
             .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   themeCheckedItems = newThemeCheckedItems;
                   updateList();
                }
             })
             .show();
   }

   protected void updateList() throws NullPointerException {
      ArrayList<Combo> comboList = new ArrayList<Combo>();
      if(sceneCheckedItems == null || themeCheckedItems == null) {
         return;
      }
      for (int sceneIndex = 0; sceneIndex < sceneCheckedItems.length; sceneIndex++) {
         if(!sceneCheckedItems[sceneIndex]) {
            continue;
         }
         String sceneItem = sceneList[sceneIndex];
         for (int themeIndex = 0; themeIndex < themeCheckedItems.length; themeIndex++) {
            if(!themeCheckedItems[themeIndex]) {
               continue;
            }
            String themeItem = themeList[themeIndex];
            for (Combo comboItem: fullCombos) {
               if(comboItem.getSceneId().equals(sceneItem) && comboItem.getThemeId().equals(themeItem)) {
                  comboList.add(comboItem);
               }
            }
         }
      }
      comboListAdapter = new ComboListAdapter(comboList);
      comboRecyclerView.setAdapter(comboListAdapter);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      ButterKnife.bind(this);

      sceneList = getResources().getStringArray(R.array.scenes);
      themeList = getResources().getStringArray(R.array.themes);

      ArrayList<Combo> comboList = new ArrayList<Combo>();
      comboListAdapter = new ComboListAdapter(comboList);
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      comboRecyclerView.setLayoutManager(linearLayoutManager);
      comboRecyclerView.setAdapter(comboListAdapter);
   }
}
