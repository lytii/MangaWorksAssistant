package com.example.longlam.mangaworksassistant.comboList;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.longlam.mangaworksassistant.R;
import com.example.longlam.mangaworksassistant.sceneTheme.UpdateListActivity;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComboListActivity extends AppCompatActivity {

   static final int UPDATE_LIST_REQUEST = 1;
   ComboListPresenter comboListPresenter;

   @BindView(R.id.combo_recycler_view)
   RecyclerView comboRecyclerView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (comboListPresenter == null) {
         comboListPresenter = new ComboListPresenter(this);
      }
      setContentView(R.layout.combo_list_activity);
      ButterKnife.bind(this);
   }

   @Override
   protected void onResume() {
      super.onResume();
      getPresenter().loadThemeSceneList();
   }

   protected ArrayList<String> getStringArray(int id) {
      return new ArrayList<>(Arrays.asList(getResources().getStringArray(id)));
   }

   protected void setComboListRecyclerView(ComboListAdapter comboListAdapter) {
      final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      comboRecyclerView.setLayoutManager(linearLayoutManager);
      comboRecyclerView.setAdapter(comboListAdapter);
   }

   @OnClick(R.id.scene_legend)
   public void toggleSceneSort() {
      getPresenter().updateComboListByScene();
   }

   @OnClick(R.id.theme_legend)
   public void toggleThemeSort() {
      getPresenter().updateComboListByTheme();
   }

   @OnClick(R.id.update_scene_button)
   public void goToUpdateScene() {
      Intent intent = new Intent(this, UpdateListActivity.class);
      intent.putExtra("Intent", "what is sup");
      startActivityForResult(intent, UPDATE_LIST_REQUEST);
      Log.d(this.getClass().getSimpleName(), "startActiity");
   }

   public void updateSceneList() {
      AlertDialog.Builder builder = new AlertDialog.Builder(this);
      builder.setTitle(R.string.update_scene_list)
             .setMultiChoiceItems(R.array.scenes, getPresenter().getSceneCheckedItems(), new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                   getPresenter().newSceneItem(i, b);
                }
             })
             .setNegativeButton("Cancel", null)
             .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   getPresenter().saveThemeSceneList();
                   getPresenter().updateSceneList();
                   getPresenter().updateComboListByScene();
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
             .setNegativeButton("Cancel", null)
             .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   getPresenter().saveThemeSceneList();
                   getPresenter().updateThemeList();
                   getPresenter().updateComboListByScene();
                }
             })
             .show();
   }

   @OnClick(R.id.like_legend)
   public void toggleLikeSort() {
      getPresenter().updateComboListByLike();
   }

   protected ComboListPresenter getPresenter() {
      return comboListPresenter;
   }
}