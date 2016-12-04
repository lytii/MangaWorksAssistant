package com.example.longlam.mangaworksassistant;

import java.util.ArrayList;

public final class HardCodedCombos {
   public static ArrayList<Combo> parseCombos() {

      // 0: Theme
      // 1: Scene
      // 2: Like  - if contains "x2" then (4) is ""
      // 3: Dislike - if contains "x2" then (4) is ""
      // 4: Like
      // 5: Disike
      String[][] combosListString = {{"Adventure", "Nature", "Boys", "Office Workers M", "College M", "Girls"},
            {"Adventure", "Fantasy World", "Boys", "Office Workers M", "Teen Girls", "Middle-aged M"},
            {"Aliens", "Earth", "Teen Boys x2", "Moms", "", "Girls"},
            {"Aliens", "SF", "Teen Boys", "Moms x2", "College M", ""},
            {"Aliens", "Space", "Teen Boys", "Moms", "Office Workers M", "Teen girls"},
            {"Androids", "Future", "College M", "Teen Girls", "Teen Girls", "Middle-aged M"},
            {"Androids", "SF", "College M x2", "Teen Girls", "", "Moms"},
            {"Animals", "Island", "Girls", "Teen Boys", "Teen Boys", "College F"},
            {"Animals", "Nature", "Girls", "Teen Boys", "College M", "Girls"},
            {"Aristocrats", "Present Day", "Office Workers M", "Boys", "College F", "Middle-aged M"},
            {"Aristocrats", "Office", "Office Workers M x2", "Boys", "", "College M"},
            {"Babes", "VR", "Office Workers M", "Office Workers F", "College M", "Girls"},
            {"Babes", "Present Day", "Office Workers M", "Office Workers F", "College F", "Middle-aged M"},
            {"Babes", "Classroom", "Office Workers M", "Office Workers F", "Teen Girls", "Middle-aged M"},
            {"Bad Boy", "Pagoda", "College F", "Office Workers M x2", "Middle-aged M", ""},
            {"Bad Boy", "Campus", "College F", "Office Workers M", "Office Workers F", "College M"},
            {"Bad Boy", "Fantasy World", "College F", "Office Workers M", "Teen Girls", "Middle-aged M"},
            {"Baseball", "Campus", "Middle-aged M", "Moms", "Office Workers F", "College M"},
            {"Basketball", "Campus", "Teen Boys", "Girls", "Office Workers F", "College M"},
            {"Bugs", "City", "Boys", "College F", "Office Workers F", "College M"},
            {"Bugs", "Nature", "Boys", "College F", "College M", "Girls"},
            {"Business", "Earth", "Office Workers M", "College M", "Teen Boys", "Girls"},
            {"Business", "House", "Office Workers M", "College M", "College F", "Boys"},
            {"Cat Ears", "Wild West", "Office Workers M", "Office Workers F", "College M", "College F"},
            {"Cat Ears", "Office", "Office Workers M x2", "Office Workers F", "", "College M"},
            {"Cat Ears", "Hotel", "Office Workers M x2", "Office Workers F", "", "Girls"},
            {"Computers", "Future", "College M", "College F", "Teen Girls", "Middle-aged M"},
            {"Computers", "Earth", "College M", "College F", "Teen Boys", "Girls"},
            {"Computers", "VR", "College M x2", "College F", "", "Girls"},
            {"Computers", "Present Day", "College M", "College F", "College F", "Middle-aged M"},
            {"Cooking", "Europe", "Girls", "Teen Boys", "Teen Girls", "Boys"},
            {"Cooking", "Nature", "Girls", "Teen Boys", "College M", "Girls"},
            {"Cute", "Earth", "Office Workers F", "Teen Boys", "Teen Boys", "Girls"},
            {"Cute", "Old Jpn", "Office Workers F", "Teen Boys", "College M", "Teen Girls"},
            {"Demons", "Fantasy World", "College M", "Moms", "Teen Girls", "Middle-aged M"},
            {"Demons", "Alt. World", "College M", "Moms", "Office Workers M", "Office workers f"},
            {"Demons", "Ruins", "College M", "Moms", "Boys", "Teen Girls"},
            {"Detective", "City", "College F", "Office Workers M", "Office Workers F", "College M"},
            {"Detective", "Toilet", "College F", "Office Workers M", "Office Workers M", "College F"},
            {"Dragons", "Stone Age", "Boys x2", "Girls", "", "Office Workers F"},
            {"Dragons", "Nature", "Boys", "Girls x2", "College M", ""},
            {"Dragons", "Prehistory", "Boys", "Girls x2", "Teen Boys", ""},
            {"Dragons", "Fantasy World", "Boys", "Girls", "Teen Girls", "Middle-aged M"},
            {"Dream", "SF", "Teen Boys", "College M", "College M", "Moms"},
            {"Dream", "City", "Teen Boys", "College M x2", "Office Workers F", ""},
            {"Dream", "Space", "Teen Boys", "College M", "Office Workers M", "Teen girls"},
            {"Family", "House", "Moms", "Teen Boys", "College F", "Boys"},
            {"Family", "Modern Jpn", "Moms", "Teen Boys", "Teen Girls", "Middle-aged M"},
            {"Family", "Apartment", "Moms", "Teen Boys", "Office Workers M", "College M"},
            {"Fishing", "Open Sea", "Middle-aged M", "Girls", "Boys", "Moms"},
            {"Gambling", "Wild West", "College M x2", "Teen Girls", "", "College F"},
            {"Gambling", "City", "College M", "Teen Girls", "Office Workers F", "College M"},
            {"Gangsters", "Campus", "Teen Boys", "Office Workers M", "Office Workers F", "College M"},
            {"Gangsters", "Nature", "Teen Boys", "Office Workers M", "College M", "Girls"},
            {"Gangsters", "Classroom", "Teen Boys", "Office Workers M", "Teen Girls", "Middle-aged M"},
            {"Genius", "Prison", "College F", "Middle-aged M", "College M", "Girls"},
            {"Genius", "Trad. Jpn", "College F x2", "Middle-aged M", "", "Teen Girls"},
            {"Genius", "Office", "College F", "Middle-aged M", "Office Workers M", "College M"},
            {"Genius", "Toilet", "College F", "Middle-aged M", "Office Workers M", "College F"},
            {"Ghosts", "VR", "College M x2", "Girls x2"},
            {"Ghosts", "Old Jpn", "College M x2", "Girls", "", "Teen Girls"},
            {"Ghosts", "Pagoda", "College M", "Girls", "Middle-aged M", "Office Workers M"},
            {"Giant Robots", "Warzone", "Boys", "Office Workers F", "College M", "Teen Girls"},
            {"Giant Robots", "Old Jpn", "Boys", "Office Workers F", "College M", "Teen Girls"},
            {"Giant Robots", "Ruins", "Boys x2", "Office Workers F", "", "Teen Girls"},
            {"Giant Robots", "Earth", "Boys", "Office Workers F", "Teen Boys", "Girls"},
            {"Giant Robots", "Stadium", "Boys", "Office Workers F", "Teen Boys", "Teen Girls"},
            {"High School", "Space", "Office Workers F", "College M", "Office Workers M", "Teen girls"},
            {"Hunks", "Campus", "Teen Girls", "College M x2", "Office Workers F", ""},
            {"Hunks", "Earth", "Teen Girls", "College M", "Teen Boys", "Girls"},
            {"Karate", "Warzone", "Teen Boys", "Moms", "College M", "Teen Girls"},
            {"Karate", "Prison", "Teen Boys", "Moms", "College M", "11Girls"},
            {"Karate", "Ruins", "Teen Boys", "Moms", "Boys", "Teen Girls"},
            {"Love", "Campus", "Teen Girls", "Boys", "Office Workers F", "College M"},
            {"Magic", "Fantasy World", "Girls", "Moms", "Teen Girls", "Middle-aged M"},
            {"Manga", "Pagoda", "Teen Girls", "Moms", "Middle-aged M", "Office Workers M"},
            {"Manga", "Apartment", "Teen Girls", "Moms", "Office Workers M", "College M"},
            {"Monsters", "Alt. World", "Boys", "College F", "Office Workers M", "Office workers f"},
            {"Monsters", "Stone Age", "Boys x2", "College F", "", "Office Workers F"},
            {"Mystery", "Toilet", "College M", "Moms", "Office Workers M", "College F"},
            {"Mystery", "Prehistory", "College M", "Moms", "Teen Boys", "Girls"},
            {"Mystery", "Ruins", "College M", "Moms", "Boys", "Teen Girls"},
            {"Mystery", "Open Sea", "College M", "Moms x2", "Boys", ""},
            {"Nerds", "Toilet", "College M", "Office Workers F", "Office Workers M", "College F"},
            {"Nerds", "Pagoda", "College M", "Office Workers F", "Middle-aged M", "Office Workers M"},
            {"Ninja", "Old Jpn", "Boys", "Office Workers F", "College M", "Teen Girls"},
            {"Pirates", "Open Sea", "Boys x2", "Moms x2"},
            {"Police", "City", "Office Workers M", "Teen Girls", "Office Workers F", "College M"},
            {"Police", "Wild West", "Office Workers M", "Teen Girls", "College M", "College F"},
            {"Politics", "Hotel", "Middle-aged M", "College M", "Office Workers M", "Girls"},
            {"Politics", "Office", "Middle-aged M", "College M x2", "Office Workers M", ""},
            {"Politics", "Old Jpn", "Middle-aged M", "College M", "College M", "Teen Girls"},
            {"Pop Stars", "SF", "Teen Boys", "Boys", "College M", "Moms"},
            {"Pop Stars", "Space", "Teen Boys", "Boys", "Office Workers M", "Teen girls"},
            {"Prince", "Ruins", "Office Workers F", "Office Workers M", "Boys", "Teen Girls"},
            {"Princess", "Europe", "Girls", "Office Workers M", "Teen Girls", "Boys"},
            {"Racing", "Stadium", "Office Workers M", "Teen Girls x2", "Teen Boys", ""},
            {"Rivals", "Fantasy World", "Teen Boys", "Middle-aged M x2", "Teen Girls", ""},
            {"Rivals", "Office", "Teen Boys", "Middle-aged M", "Office Workers M", "College M"},
            {"Robots", "Present Day", "Boys", "Middle-aged M x2", "College F", ""},
            {"Royalty", "Hotel", "College M", "Middle-aged M", "Office Workers M", "Girls"},
            {"Royalty", "VR", "College M x2", "Middle-aged M", "", "Girls"},
            {"Samurai", "Feudal Jpn", "Boys", "Moms", "Office Workers F", "College F"},
            {"Samurai", "Old Jpn", "Boys", "Moms", "College M", "Teen Girls"},
            {"Samurai", "Warzone", "Boys", "Moms", "College M", "Teen Girls"},
            {"Secretary", "Warzone", "College F", "Girls", "College M", "Teen Girls"},
            {"Secretary", "Office", "College F", "Girls", "Office Workers M", "College M"},
            {"Secretary", "Space", "College F", "Girls", "Office Workers M", "Teen girls"},
            {"Sexy", "Open Sea", "Office Workers M", "Boys", "Boys", "Moms"},
            {"Sexy", "Future", "Office Workers M", "Boys", "Teen Girls", "Middle-aged M"},
            {"Snipers", "Wild West", "Office Workers M", "Office Workers F", "College M", "College F"},
            {"Snipers", "Warzone", "Office Workers M", "Office Workers F", "College M", "Teen Girls"},
            {"Snipers", "Office", "Office Workers M x2", "Office Workers F", "", "College M"},
            {"Snipers", "Europe", "Office Workers M", "Office Workers F", "Teen Girls", "Boys"},
            {"Soccer", "Present Day", "Teen Boys", "Middle-aged M x2", "College F", ""},
            {"Soccer", "Europe", "Teen Boys", "Middle-aged M", "Teen Girls", "Boys"},
            {"Sports", "Stadium", "Teen Boys x2", "Middle-aged M", "", "Teen Girls"},
            {"Spy", "Toilet", "College M", "Moms", "Office Workers M", "College F"},
            {"Spy", "Warzone", "College M x2", "Moms", "", "Teen Girls"},
            {"Spy", "Prison", "College M x2", "Moms", "", "Girls"},
            {"Sumo", "Feudal Jpn", "Middle-aged M", "College F x2", "Office Workers F", ""},
            {"Teaching", "Campus", "Teen Girls", "Boys", "Office Workers F", "College M"},
            {"Thieves", "House", "College M", "Middle-aged M", "College F", "Boys"},
            {"Thieves", "Pagoda", "College M", "Middle-aged M", "Middle-aged M", "Office Workers M"},
            {"Toys", "Earth", "Boys", "Moms", "Teen Boys", "Girls"},
            {"Toys", "VR", "Boys", "Moms", "College M", "Girls"},
            {"Treasure", "Fantasy World", "Office Workers F", "Moms", "Teen Girls", "Middle-aged M"},
            {"Treasure", "Stone Age", "Office Workers F", "Moms", "Boys", "Office Workers F"},
            {"Treasure", "Ruins", "Office Workers F", "Moms", "Boys", "Teen Girls"},
            {"Treasure", "Nature", "Office Workers F", "Moms", "College M", "Girls"},
            {"Tricks", "Hotel", "College M", "Teen Girls", "Office Workers M", "Girls"},
            {"Tricks", "Present Day", "College M", "Teen Girls", "College F", "Middle-aged M"},
            {"Underwear", "Campus", "Teen Boys", "Girls", "Office Workers F", "College M"},
            {"Underwear", "City", "Teen Boys", "Girls", "Office Workers F", "College M"},
            {"Unique", "City", "Teen Boys", "Teen Girls", "Office Workers F", "College M"},
            {"Unique", "Feudal Jpn", "Teen Boys", "Teen Girls", "Office Workers F", "College F"},
            {"Unique", "Old Jpn", "Teen Boys", "Teen Girls x2", "College M", ""},
            {"World Dom.", "Fantasy World", "College M", "Moms", "Teen Girls", "Middle-aged M"},
            {"World Dom.", "Earth", "College M", "Moms", "Teen Boys", "Girls"},
            {"World Dom.", "Warzone", "College M x2", "Moms", "", "Teen Girls"},
            {"World Peace", "Present Day", "Moms", "College M", "College F", "Middle-aged M"},
            {"World Peace", "Earth", "Moms", "College M", "Teen Boys", "Girls"},
            {"Youth", "Campus", "Teen Girls", "Office Workers M", "Office Workers F", "College M"},
            {"Youth", "Apartment", "Teen Girls", "Office Workers M", "Office Workers M", "College M"}};
      int size = combosListString.length;
      ArrayList<Combo> comboList = new ArrayList<Combo>();
      for (int i = 0; i < size; i++) {
         String[] comboString = combosListString[i];
         try {
            comboList.add(new Combo(comboString[0], comboString[1],
                                    comboString[2], comboString[3],
                                    comboString[4], comboString[5])
            );
         } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
         }
      }
      return comboList;
   }
}