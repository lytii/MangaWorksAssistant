package com.example.longlam.mangaworksassistant.comboList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.longlam.mangaworksassistant.R;
import com.example.longlam.mangaworksassistant.sceneTheme.UpdateListActivity;

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
      setContentView(R.layout.combo_list_activity);
      ButterKnife.bind(this);
   }

   @Override
   protected void onResume() {
      super.onResume();
      getPresenter().setUpCombos();
   }

   protected ArrayList<String> getStringArray(int id) {
      return new ArrayList<>(Arrays.asList(getResources().getStringArray(id)));
   }

   protected void setComboListRecyclerView(ComboListAdapter comboListAdapter) {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
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
      startActivity(intent);
   }

   protected ComboListPresenter getPresenter() {
      return comboListPresenter;
   }
}
