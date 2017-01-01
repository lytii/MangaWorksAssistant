package com.example.longlam.mangaworksassistant.comboList;

import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.longlam.mangaworksassistant.Combo;
import com.example.longlam.mangaworksassistant.HardCodedCombos;
import com.example.longlam.mangaworksassistant.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComboListAdapter extends RecyclerView.Adapter<ComboListAdapter.ComboViewHolder> {

   private ArrayList<Combo> listOfCombos;
   private boolean themeAscToggle;
   private boolean sceneAscToggle;
   private boolean likeAscToggle;

   private ArrayList<String> sceneList;
   private ArrayList<String> themeList;
   private boolean[] sceneCheckedItems;
   private boolean[] themeCheckedItems;

   public class ComboViewHolder extends RecyclerView.ViewHolder {

      @BindView(R.id.theme_item)
      TextView themeTextView;
      @BindView(R.id.scene_theme_item)
      TextView sceneTextView;
      @BindView(R.id.like_text_view)
      TextView likeTextView;

      public ComboViewHolder(View itemView) {
         super(itemView);
         ButterKnife.bind(this, itemView);
      }
   }

   public ComboListAdapter(ArrayList<Combo> listOfCombos) {
      this.listOfCombos = listOfCombos;
      themeAscToggle = false;
      sceneAscToggle = false;
      likeAscToggle = false;
   }

   @Override
   public ComboViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.combo_list_layout, parent, false);
      return new ComboViewHolder(view);
   }

   @Override
   public void onBindViewHolder(ComboListAdapter.ComboViewHolder holder, int position) {
      Combo combo = listOfCombos.get(position);
      holder.themeTextView.setText(combo.getTheme());
      holder.sceneTextView.setText(combo.getScene());
      holder.likeTextView.setText(combo.getLikeA() + "\n" + combo.getLikeB());
   }

   @Override
   public int getItemCount() {
      return listOfCombos.size();
   }

   protected void sortByTheme() {
      Collections.sort(listOfCombos, new Comparator<Combo>() {
         @Override
         public int compare(Combo combo, Combo t1) {
            int result = combo.getTheme().compareTo(t1.getTheme());
            return (themeAscToggle ? -1 : 1) * result;
         }
      });
      themeAscToggle = !themeAscToggle;
      sceneAscToggle = false;
      likeAscToggle = false;
      notifyDataSetChanged();
   }

   protected void sortByScene() {
      Collections.sort(listOfCombos, new Comparator<Combo>() {
         @Override
         public int compare(Combo combo, Combo t1) {
            int result = combo.getScene().compareTo(t1.getScene());
            return (sceneAscToggle ? -1 : 1) * result;
         }
      });
      sceneAscToggle = !sceneAscToggle;
      themeAscToggle = false;
      likeAscToggle = false;
      notifyDataSetChanged();
   }

   protected void loadCheckedThemesScenes(SharedPreferences sharedPreferences) {
      for (int i = 0; i < themeList.size(); i++) {
         themeCheckedItems[i] = sharedPreferences.getBoolean(themeList.get(i), themeCheckedItems[i]);
      }
      for (int i = 0; i < sceneList.size(); i++) {
         sceneCheckedItems[i] = sharedPreferences.getBoolean(sceneList.get(i), sceneCheckedItems[i]);
      }
   }

   protected void setUpCombos() {
      ArrayList<Combo> fullCombos = HardCodedCombos.parseCombos();
      for (Combo combo : fullCombos) {
         int sceneIndex = sceneList.indexOf(combo.getScene());
         int themeIndex = themeList.indexOf(combo.getTheme());
         if (sceneCheckedItems[sceneIndex] && themeCheckedItems[themeIndex]) {
            listOfCombos.add(combo);
         }
      }
      notifyDataSetChanged();
   }

   protected void setSceneList(ArrayList<String> sceneList) {
      this.sceneList = sceneList;
      sceneCheckedItems = new boolean[sceneList.size()];
   }

   protected void setThemeList(ArrayList<String> themeList) {
      this.themeList = themeList;
      themeCheckedItems = new boolean[themeList.size()];
   }
}