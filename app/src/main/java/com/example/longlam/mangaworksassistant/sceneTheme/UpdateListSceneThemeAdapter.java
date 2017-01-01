package com.example.longlam.mangaworksassistant.sceneTheme;


import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.longlam.mangaworksassistant.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UpdateListSceneThemeAdapter extends RecyclerView.Adapter<UpdateListSceneThemeAdapter.SceneViewHolder> {

   private ArrayList<String> itemList;
   private boolean[] checkedList;


   public class SceneViewHolder extends RecyclerView.ViewHolder {

      @BindView(R.id.scene_theme_item_checkbox)
      CheckBox sceneItemCheckbox;

      public SceneViewHolder(View itemView) {
         super(itemView);
         ButterKnife.bind(this, itemView);
      }
   }

   public UpdateListSceneThemeAdapter(ArrayList<String> itemList) {
      this.itemList = itemList;
      checkedList = new boolean[itemList.size()];
   }

   @Override
   public SceneViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.update_list_layout, parent, false);
      return new SceneViewHolder(view);
   }

   @Override
   public void onBindViewHolder(final SceneViewHolder holder, int position) {
      holder.sceneItemCheckbox.setText(itemList.get(position));
      holder.sceneItemCheckbox.setChecked(checkedList[position]);
      holder.sceneItemCheckbox.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            int itemPosition = holder.getAdapterPosition();
            checkedList[itemPosition] =  !checkedList[itemPosition];
         }
      });
   }

   @Override
   public int getItemCount() {
      return itemList.size();
   }

   protected void saveCheckedList(SharedPreferences sharedPreferences) {
      SharedPreferences.Editor preferenceEditor = sharedPreferences.edit();
      for (int i = 0; i < itemList.size(); i++) {
         preferenceEditor.putBoolean(itemList.get(i),
                                     checkedList[i]);
      }
      preferenceEditor.apply();
   }

   protected void loadCheckedList(SharedPreferences sharedPreferences) {
      for (int i = 0; i < itemList.size(); i++) {
         boolean isItemChecked = sharedPreferences.getBoolean(itemList.get(i), false);
         checkedList[i] = isItemChecked;
      }
   }

   protected boolean[] getCheckedList() {
      return checkedList;
   }
}