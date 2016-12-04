package com.example.longlam.mangaworksassistant;

public class Combo {
   private String themeId;
   private String sceneId;
   private String likeIdA;
   private String likeIdB;
   private String dislikeIdA;
   private String dislikeIdB;

   public Combo(String themeId, String sceneId,
                String likeIdA, String dislikeIdA,
                String likeIdB, String dislikeIdB) {
      this.sceneId = sceneId;
      this.themeId = themeId;
      this.likeIdA = likeIdA;
      this.likeIdB = likeIdB;
      this.dislikeIdA = dislikeIdA;
      this.dislikeIdB = dislikeIdB;
   }


   public String getThemeId() {
      return themeId;
   }

   public void setThemeId(String themeId) {
      this.themeId = themeId;
   }


   public String getSceneId() {

      return sceneId;
   }

   public void setSceneId(String sceneId) {
      this.sceneId = sceneId;
   }

   public String getLikeIdA() {

      return likeIdA;
   }

   public void setLikeIdA(String likeIdA) {
      this.likeIdA = likeIdA;
   }

   public String getDislikeIdA() {

      return dislikeIdA;
   }

   public void setDislikeIdA(String dislikeIdA) {
      this.dislikeIdA = dislikeIdA;
   }

   public String getLikeIdB() {

      return likeIdB;
   }

   public void setLikeIdB(String likeIdB) {
      this.likeIdB = likeIdB;
   }

   public void setDislikeIdB(String dislikeIdB) {
      this.dislikeIdB = dislikeIdB;
   }

   public String getDislikeIdB() {
      return dislikeIdB;
   }

   public String toString() {
      return "Theme " + themeId + " Scene " + sceneId + " LikeA " + likeIdA + " DislikeA " + dislikeIdA + " LikeA " + likeIdB + " DislikeB " + dislikeIdB;
   }
}
