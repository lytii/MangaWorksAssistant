package com.example.longlam.mangaworksassistant;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComboListActivity extends AppCompatActivity {

   ComboListPresenter comboListPresenter;

   @BindView(R.id.combo_recycler_view)
   RecyclerView comboRecyclerView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (comboListPresenter == null) {
         comboListPresenter = new ComboListPresenter(this);
      }
      setContentView(R.layout.activity_combo_list);
      ButterKnife.bind(this);
      getPresenter().setFull();
   }

   protected ArrayList<String> getStringArray(int id) {
      return new ArrayList<String>(Arrays.asList(getResources().getStringArray(id)));
   }

   protected void setComboListRecyclerView(ComboListAdapter comboListAdapter) {
      final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      comboRecyclerView.setLayoutManager(linearLayoutManager);
      comboRecyclerView.setAdapter(comboListAdapter);
   }

   protected void setRecyclerViewSnapping(LinearLayoutManager linearLayoutManager) {
      int top = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
      linearLayoutManager.scrollToPositionWithOffset(top, 20);
   }

   @OnClick(R.id.scene_legend)
   public void toggleSceneSortAsc() {
      getPresenter().updateComboListBySceneAsc();
   }

   @OnClick(R.id.theme_legend)
   public void toggleThemeSortAsc() {
      getPresenter().updateComboListByTheme();
   }

   @OnClick(R.id.update_scene_button)
   public void updateSceneList() {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle(R.string.update_scene_list)
            .setMultiChoiceItems(R.array.scenes, getPresenter().getSceneCheckedItems(), new DialogInterface.OnMultiChoiceClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                  getPresenter().newSceneItem(i, b);
               }
            })
            .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                  getPresenter().updateSceneList();
                  getPresenter().updateComboListBySceneAsc();
               }
            })
            .show();
   }

   @OnClick(R.id.update_theme_button)
   public void updateThemeList() {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle(R.string.update_theme_list)
             .setMultiChoiceItems(R.array.themes, getPresenter().getThemeCheckedItems(), new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                   getPresenter().newThemeItem(i, b);
                }
             })
             .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   getPresenter().updateThemeList();
                   getPresenter().updateComboListBySceneAsc();
                }
             })
             .show();
   }

   protected ComboListPresenter getPresenter() {
      return comboListPresenter;
   }
}
