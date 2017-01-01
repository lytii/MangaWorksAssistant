package com.example.longlam.mangaworksassistant.comboList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.longlam.mangaworksassistant.Combo;
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

   protected void sortByLike() {
      Collections.sort(listOfCombos, new Comparator<Combo>() {
         @Override
         public int compare(Combo combo, Combo t1) {
            int result = combo.getLikeA().compareTo(t1.getLikeA());
            return (likeAscToggle ? -1 : 1) * result;
         }
      });
      likeAscToggle = !likeAscToggle;
      themeAscToggle = false;
      sceneAscToggle = false;
      notifyDataSetChanged();
   }
}