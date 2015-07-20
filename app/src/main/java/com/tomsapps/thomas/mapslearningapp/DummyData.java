package com.tomsapps.thomas.mapslearningapp;

import android.text.format.Time;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Thomas on 3/10/2015.
 */
public class DummyData implements IStoryGettingMachien {

    private ArrayList<NewsItem> newsItems = new ArrayList<>();
    private ArrayList<Journalist> journalists = new ArrayList<>();

    public DummyData() {
        Journalist blake = new Journalist("Blake","Crayton-Brown");
        journalists.add(blake);
        Journalist tom = new Journalist("Thomas","Horrobin");
        journalists.add(tom);
        Journalist william = new Journalist("William","Fussey");
        journalists.add(william);

        Time time = new Time();
        time.setToNow();

        newsItems.add(new NewsItem(tom,"St Cuthbert's final service on site","St Cuthbert's Church in Berhampore will hold its last service next week, ending the Anglican church's 95-year-old history on the site.\n" +
                "\n" +
                "The building was declared earthquake prone after the August 2013 earthquake.\n" +
                "\n" +
                "It was sold last month.\n" +
                "\n" +
                "Services have been relocated to the Chapel of St Thomas in Riddiford St, Newtown, also owned by the Wellington South Parish.\n" +
                "\n" +
                "Two other denominations that used the building, The Ethiopian Orthodox and The Congregational Church of Jesus in Samoa and Abroad, have found other venues.\n" +
                "\n" +
                "A deconsecration service, including Bible readings and a brief sermon, will be held in St Cuthbert's Church hall next Thursday at 7pm.",new LatLng(-41.319983, 174.776473),new Time()));
        newsItems.add(new NewsItem(blake,"World Cup Cricket fever building","One Wellingtonian will realise his dreams over the next month when he bowls against cricket stars from around the world.\n" +
                "\n" +
                "Wellington under-19 bowler and former Wellington College student Bhavik Patel is a net bowler for the Cricket World Cup and will help visiting teams during their training sessions.\n" +
                "\n" +
                "Starting Monday, he will bowl to the likes of New Zealand's Brendon McCullum, South Africa's Hashim Amla, England's Joe Root and Sri Lanka's Kumar Sangakkara.\n" +
                "\n" +
                "Patel, 18, has been net bowling for two years and has already bowled against many teams visiting Wellington, but a World Cup is a different kettle of fish.\n" +
                "\n" +
                "\"It's really exciting, but the pressure is on, \" the left-arm spinner said.\n" +
                "\n" +
                "\"You're nervous from ball one, because you don't want to stuff up and get kicked off.\n" +
                "\n" +
                "\"At the same time, it's a World Cup and the teams need to train.\"\n" +
                "\n" +
                "Net bowlers are used to ensure the team's bowlers get a rest, but the batsmen can still practise.\n" +
                "\n" +
                "Repetitive bowling in nets was not always beneficial for top bowlers, Patel said.\n" +
                "\n" +
                "\"Especially the fast bowlers - their bodies might not be able to handle the constant action and they don't want to get injured.\"",new LatLng(-41.301276, 174.781558),time));
        newsItems.add(new NewsItem(tom,"The Royal New Zealand Ballet performs Don Quixote","Love, young lovers and match-makers are the stars of the Royal New Zealand Ballet's next production.\n" +
                "\n" +
                "It's a theme that has really captured the dancers' attention in in both their lives on and off the stage, with Valentine's Day just around the corner.\n" +
                "\n" +
                "Japanese dancers Mayu Tanigaito and Kohei Iwamoto play young lovers Kitri and Basilio in Don Quixote.\n" +
                "\n" +
                "They are in long-term relationships with other dancers in the company, Tanigaito with Paul Mathews and Iwamoto with Madison Geoghegan.\n" +
                "\n" +
                "Tanigaito stole Iwamoto's Japanese student, he joked.\n" +
                "\n" +
                "\"Paul was interested in Japanese and was learning with me, but then suddenly he was asking Mayu a lot of questions and it was like he had this other teacher,\" Iwamoto said.\n" +
                "\n" +
                "\"But that's OK. I coped. It's complicated, but basically she stole my student!\"\n" +
                "\n" +
                "Iwamoto said surprising your love on Valentine's Day was hard when you were together most days.\n" +
                "\n" +
                "Last year the ballet company was on tour in New York and he had to sneak out between rehearsals.\n" +
                "\n" +
                "\"We had a two-hour break and I ran outside into the snow, hailed a taxi and asked to be taken to the closest shops.\n" +
                "\n" +
                "\"I was dripping with sweat and wearing my dancing gear and running around getting things.\n" +
                "\n" +
                "\"When I got back to the changing room, she came in and asked what I did on my break. 'Oh nothing', I said.\"\n" +
                "\n" +
                "In New Zealand the culture around Valentine's Day is similar to the United States. However, it's different in Japan.\n" +
                "\n" +
                "\"In Japan the culture is for the girls to give gifts to the boys,\" Iwamoto said.\n" +
                "\n" +
                "\"So I didn't get many, just my mum and grandma giving me chocolate.\n" +
                "\n" +
                "\"It wasn't exciting then, but it's been great here!\"",new LatLng(-41.289586, 174.777933),time));
        newsItems.add(new NewsItem(blake,"Freedom campers taking over Wellington beach","Owhiro Bay has turned into a camping ground and residents aren't happy.\n" +
                "\n" +
                "Owhiro Bay Residents' Association member Sue Reid said a survey was run from January 16 until 25 to gauge residents' levels of concern.\n" +
                "\n" +
                "The results will be used to negotiate with the city council about what regulations are needed.\n" +
                "\n" +
                "\"We're getting a sense that the majority are calling for change and freedom camping shouldn't be there at all, or should be there with a significant number of changes,\" Reid said.\n" +
                "\n" +
                "\"I don't believe they should be there. It's a really inappropriate environment for freedom campers because it's a marine reserve and we need to protect that coastal environment.\"\n" +
                "\n" +
                "She said campers were not prepared for the extreme weather, which made it an unsafe area to camp.\n" +
                "\n" +
                "The most vehicles she had seen at one time was 56. A quiet day included at least 25 vehicles. Some days it was hard to find a car park, she said.\n" +
                "\n" +
                "\"It's like walking through a camping ground. There's people washing dishes and having showers in public, people who have placed their picnic tables on the footpath, toilet paper on the ground.\n" +
                "\n" +
                "\"It feels quite intrusive. You feel like, as a local, you're intruding on someone else's space.\"",new LatLng(-41.344563, 174.758326),time));
    }

    public ArrayList<NewsItem> GetStories(){
        return newsItems;
    }
}
