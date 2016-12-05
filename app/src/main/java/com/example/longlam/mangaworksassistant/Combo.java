package com.example.longlam.mangaworksassistant;

public class Combo {
   private String theme;
   private String scene;
   private String likeA;
   private String likeB;
   private String dislikeA;
   private String dislikeB;

   public Combo(String themeId, String sceneId,
                String likeIdA, String dislikeIdA,
                String likeIdB, String dislikeIdB) {
      this.scene = sceneId;
      this.theme = themeId;
      this.likeA = likeIdA;
      this.likeB = likeIdB;
      this.dislikeA = dislikeIdA;
      this.dislikeB = dislikeIdB;
   }


   public String getTheme() {
      return theme;
   }

   public void setTheme(String theme) {
      this.theme = theme;
   }


   public String getScene() {

      return scene;
   }

   public void setScene(String scene) {
      this.scene = scene;
   }

   public String getLikeA() {

      return likeA;
   }

   public void setLikeA(String likeA) {
      this.likeA = likeA;
   }

   public String getDislikeA() {

      return dislikeA;
   }

   public void setDislikeA(String dislikeA) {
      this.dislikeA = dislikeA;
   }

   public String getLikeB() {

      return likeB;
   }

   public void setLikeB(String likeB) {
      this.likeB = likeB;
   }

   public void setDislikeB(String dislikeB) {
      this.dislikeB = dislikeB;
   }

   public String getDislikeB() {
      return dislikeB;
   }

   public boolean isCombo(String themeCompare, String sceneCompare) {
      return theme.equals(themeCompare) && scene.equals(sceneCompare);
   }

   public String toString() {
      return "Theme " + theme + " Scene " + scene + " LikeA " + likeA + " DislikeA " + dislikeA + " LikeA " + likeB + " DislikeB " + dislikeB;
   }
}
