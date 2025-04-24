package com.swiss_army_app.daily_verse;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DailyVerse {
    private final List<String> verses = new ArrayList<>();
    private final List<String> images = new ArrayList<>();
    private final Random random = new Random();

    public void loadVerses() {
        System.out.println("Verses path: " + getClass().getResource("/com/swiss_army_app/daily_verse/data/verses.txt"));
        System.out.println("Images path: " + getClass().getResource("/com/swiss_army_app/daily_verse/images/plum_grain.png"));


        // get the verses file
        InputStream inputStream = getClass().getResourceAsStream("/com/swiss_army_app/daily_verse/data/verses.txt");
        if (inputStream == null) {
            System.out.println("File not found!");
            return;
        }
        // make a buffered reader (has methods that can read lines of text)
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));

        // local var to hold each line (temp)
        String line;
        // add all the lines from the verses file to the Array List
        try {
            while ((line = buffReader.readLine()) != null) {
                verses.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadImages() {
        try {
            // get to the images folder
            URL resourceUrl = getClass().getResource("/com/swiss_army_app/daily_verse/images");

            if (resourceUrl == null) {
                System.out.println("Image folder not found!");
                return;
            }

            // make the location into a file object (a pointer to interact with)
            File folder = new File(resourceUrl.toURI());
            // array of all the images found in the folder
            File[] imageFiles = folder.listFiles();
            // loop through the File array and add their paths to the images Array List
            if (imageFiles != null) {
                for (File file : imageFiles) {
                    if (file.isFile()) {
                        images.add("/com/swiss_army_app/daily_verse/images/" + file.getName());
                    }
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public String getRandomVerse() {
        return verses.get(random.nextInt(verses.size()));
    }

    public String getRandomImage() {
        return images.get(random.nextInt(images.size()));
    }
}
