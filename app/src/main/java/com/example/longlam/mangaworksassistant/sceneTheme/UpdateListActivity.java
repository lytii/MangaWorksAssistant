package com.example.longlam.mangaworksassistant.sceneTheme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.longlam.mangaworksassistant.R;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class UpdateListActivity extends AppCompatActivity {

   UpdateListPresenter presenter;

   @BindView(R.id.update_list_scene_recycler)
   RecyclerView sceneRecyclerView;

   @BindView(R.id.update_list_theme_recycler)
   RecyclerView themeRecyclerView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.update_list_activity);
      getPresenter();
      ButterKnife.bind(this);
      setRecyclerView();
   }

   @Override
   protected void onResume() {
      super.onResume();
      getPresenter().loadUpdateList();
   }

   @OnClick(R.id.save_button)
   public void save() {
      presenter.saveUpdateList();
      Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
      finish();
   }

   @OnClick(R.id.cancel_button)
   protected void cancel() {
      finish();
   }

   public void setRecyclerView() {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
      sceneRecyclerView.setLayoutManager(linearLayoutManager);
      sceneRecyclerView.setAdapter(getPresenter().getSceneAdapter());

      linearLayoutManager = new LinearLayoutManager(this);
      themeRecyclerView.setLayoutManager(linearLayoutManager);
      themeRecyclerView.setAdapter(getPresenter().getThemeAdapter());
   }

   protected ArrayList<String> getStringArray(int id) {
      return new ArrayList<>(Arrays.asList(getResources().getStringArray(id)));
   }

   private UpdateListPresenter getPresenter() {
      if (presenter == null) {
         presenter = new UpdateListPresenter(this);
      }
      return presenter;
   }
}