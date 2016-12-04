package com.example.longlam.mangaworksassistant;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class OpenUrlTask extends AsyncTask<URL, Integer, Void> {


   @Override
   protected Void doInBackground(URL... urls) {
      for(URL url : urls) {
         HttpURLConnection httpsURLConnection = null;
         try {
            httpsURLConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            readStream(in);
            in.close();
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            httpsURLConnection.disconnect();
         }
      }
      return null;
   }

   private void readStream(BufferedReader in) throws IOException {
      String line;
      ArrayList<String> html = new ArrayList<String>();
      while ((line = in.readLine()) != null){
         html.add(line);
      }

   }
}