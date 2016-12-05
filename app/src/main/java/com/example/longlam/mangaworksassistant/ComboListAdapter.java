package com.example.longlam.mangaworksassistant;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComboListAdapter extends RecyclerView.Adapter<ComboListAdapter.ComboViewHolder> {

   private ArrayList<Combo> listOfCombos;
   private ComboListAdapter adapter;

   public class ComboViewHolder extends RecyclerView.ViewHolder {

      @BindView(R.id.theme_text_view)
      TextView themeTextView;
      @BindView(R.id.scene_text_view)
      TextView sceneTextView;
      @BindView(R.id.like_text_view)
      TextView likeTextView;
      @BindView(R.id.dislike_text_view)
      TextView dislikeTextView;

      public ComboViewHolder(View itemView) {
         super(itemView);
         ButterKnife.bind(this, itemView);
      }
   }

   public ComboListAdapter(ArrayList<Combo> listOfCombos) {
      this.listOfCombos = listOfCombos;
      this.adapter = this;
   }

   @Override
   public ComboViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.combo_layout, parent, false);
      return new ComboViewHolder(view);
   }

   @Override
   public void onBindViewHolder(ComboListAdapter.ComboViewHolder holder, int position) {
      Combo combo = listOfCombos.get(position);
      holder.themeTextView.setText(combo.getTheme());
      holder.sceneTextView.setText( combo.getScene());
      holder.likeTextView.setText(combo.getLikeA() + "\n" + combo.getLikeB());
      holder.dislikeTextView.setText(combo.getDislikeA() + "\n" + combo.getDislikeB());
   }

   @Override
   public int getItemCount() {
      return listOfCombos.size();
   }
}