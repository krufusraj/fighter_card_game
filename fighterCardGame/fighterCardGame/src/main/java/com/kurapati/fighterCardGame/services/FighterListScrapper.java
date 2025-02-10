package com.kurapati.fighterCardGame.services;
import com.kurapati.fighterCardGame.models.Fighter;
import com.kurapati.fighterCardGame.repositories.CardRepository;
import com.kurapati.fighterCardGame.repositories.FighterRepository;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.File;  // Import the File class
import com.kurapati.fighterCardGame.models.Card;
import org.springframework.stereotype.Component;

@Component
public class FighterListScrapper {
    CardRepository cardRepository;
    FighterRepository fighterRepository;

    public FighterListScrapper(CardRepository cardRepository,FighterRepository fighterRepository) {
        this.cardRepository = cardRepository;
        this.fighterRepository = fighterRepository;

    }

    Document doc;

    public void seedDatabase(){
        try {
            // fetching the target website
            doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_current_UFC_fighters").get();
            List<Map<String, String>> fighterList = updateFighterList(doc);
            System.out.println(fighterList);
            for(Map<String,String> fighter:fighterList){
                cardRepository.save(
                        new Card(
                                  fighter.get("Name"),
                                  fighter.get("Weight Class"),
                                  "Bronze",
                                  fighter.get("Country"),
                                  fighter.get("Nickname"),
                                  fighter.get("Endeavor record"),
                                  fighter.get("Ht."),
                                  fighter.get("Age"),
                                  fighter.get("Result / next fight / status")
                        )
                );
                fighterRepository.save(
                        new Fighter(
                                fighter.get("Name"),
                                fighter.get("Country"),
                                fighter.get("Nickname"),
                                fighter.get("Endeavor record"),
                                fighter.get("Weight Class"),
                                fighter.get("Ht."),
                                fighter.get("Age"),
                                fighter.get("Result / next fight / status")
                        )
                );
            }
            //writeToFile(fighterList);

//            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(List<Map<String, String>> figherList){
        try {
            File myObj = new File("fighterList.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            FileWriter myWriter = new FileWriter("fighterList.txt");
            for(Map<String,String> fighter:figherList){
                myWriter.write(fighter.toString()+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    private  List<Map<String, String>> updateFighterList(Document Doc){
        List<Map<String, String>> fighterList = new ArrayList<Map<String, String>>();
        //Get tables
        Elements tables = doc.getElementsByClass("wikitable sortable");
        for(Element table:tables) {
            //Get the headers of the table
            List <String> headerTexts = getHeaders(table);
            //Check headers of the tables to see if they match the debuted fighters tables
            if(getSelectedTables(headerTexts)){
                fighterList.addAll(updateFighterMap(table,headerTexts));
            }

        }

        return fighterList;

    }

    private List<String> getHeaders(Element table){
        Elements headers = table.getElementsByTag("th");
        List<String> headerTexts = new ArrayList<>();
        for (Element header : headers) {
            headerTexts.add(header.text());
        }
        return headerTexts;
    }

    private Boolean getSelectedTables(List<String> headerTexts) {
        List<String> targetHeaders = new ArrayList<>(Arrays.asList(
                "ISO",
                "Name",
                "Age",
                "Ht.",
                "Nickname",
                "Result / next fight / status",
                "Ref",
                "Endeavor record",
                "MMA record"

        ));

        return headerTexts.equals(targetHeaders);


    }



    private List<Map<String, String>> updateFighterMap(Element table, List<String> headerTexts){
        String weightClass = getWeightClass(table);



        Elements dataRows = table.select("tr");
        List<Map<String, String>> fighters = new ArrayList<Map<String, String>>();

        for(int i = 1; i < dataRows.size(); i++){
            Map<String, String> fighter = new HashMap<String, String>();
            Element row = dataRows.get(i);
            Elements colVals = row.select("th,td");
            Element flagImg = colVals.getFirst().select("td img").first();
            String country = "";
            if (flagImg != null) {
                country = flagImg.attr("alt");
            }


            fighter.put(headerTexts.get(1), colVals.get(1).text());
            fighter.put(headerTexts.get(2), colVals.get(2).text());
            fighter.put(headerTexts.get(3), colVals.get(3).text());
            fighter.put(headerTexts.get(4), colVals.get(4).text());
            fighter.put(headerTexts.get(5), colVals.get(5).text());
            fighter.put(headerTexts.get(7), colVals.get(7).text());
            fighter.put(headerTexts.get(8), colVals.get(8).text());
            fighter.put("Country",country);
            fighter.put("Weight Class",weightClass);
            //System.out.println(fighter);
            fighters.add(fighter);
        }
        System.out.println(fighters);
        return fighters;

    }

    private String getWeightClass(Element table){
        Element prevElement = table.previousElementSibling();
        String weightClass = "";
        if (prevElement != null && prevElement.tagName().equals("div")) {
            Element h3 = prevElement.selectFirst("h3");
            if (h3 != null) {
                weightClass = h3.text();
            }
        }
        return weightClass;
    }


}
