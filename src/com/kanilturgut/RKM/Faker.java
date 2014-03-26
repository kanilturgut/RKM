package com.kanilturgut.RKM;

import android.content.Context;
import com.kanilturgut.RKM.page_model.Foursquare;
import com.kanilturgut.RKM.page_model.Instagram;
import com.kanilturgut.RKM.page_model.SocialUser;
import com.kanilturgut.RKM.page_model.Twitter;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by kanilturgut on 26/03/14, 15:36.
 */
public class Faker {

    Context context;

    public static List<SocialUser> socialUserList = new LinkedList<SocialUser>();
    public static List<Twitter> twitterList = new LinkedList<Twitter>();
    public static List<Foursquare> foursquareList = new LinkedList<Foursquare>();
    public static List<Instagram> instagramList = new LinkedList<Instagram>();

    public Random random = new Random();

    public Faker(Context context) {
        this.context = context;
    }

    //Social users fake accounts
    public void createFakeSocilaUsers() {

        SocialUser user = new SocialUser();
        user.setName("Kadir Anıl");
        user.setSurname("Turğut");
        user.setUsername("kanilturgut");
        user.setAvatar(context.getResources().getDrawable(R.drawable.anil));
        socialUserList.add(user);

        user = new SocialUser();
        user.setName("Muhammet");
        user.setSurname("Can");
        user.setUsername("jeffisabelle");
        user.setAvatar(context.getResources().getDrawable(R.drawable.muhammet));
        socialUserList.add(user);

        user = new SocialUser();
        user.setName("Can");
        user.setSurname("Demirdağ");
        user.setUsername("cano");
        user.setAvatar(context.getResources().getDrawable(R.drawable.can));
        socialUserList.add(user);

        user = new SocialUser();
        user.setName("Umut Ozan");
        user.setSurname("Yıldırım");
        user.setUsername("feluna");
        user.setAvatar(context.getResources().getDrawable(R.drawable.ozan));
        socialUserList.add(user);

        user = new SocialUser();
        user.setName("Onur Can");
        user.setSurname("Sert");
        user.setUsername("ocsert");
        user.setAvatar(context.getResources().getDrawable(R.drawable.onur));
        socialUserList.add(user);
    }

    public List<SocialUser> getSocialUserList() {
        return socialUserList;
    }

    //fake tweets
    public void createFakeTweets() {

        Twitter twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("DÜZGÜN ADAM ARAMAKLA BULUNMAZ. ADAM ALINIR, DÜZELTİLİR, MUTLU OLUNUR :)");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);

        twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("KALBİ OLAN TEK ERKEK KUPA PAPAZIDIR...");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);

        twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("BABAM HEP DERDİ Kİ; BAŞINI DİK TUT PRENSESİM, YOKSA TACIN DÜŞER.");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);

        twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("YA ABİ NASIL YAAAAA !!!");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);

        twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("İSTEDİĞİMİ HAYATIMA, İSTEDİĞİMİN DE HAYATINA SOKARIM !!!!");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);

        twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("Tweet atmaktan usandım");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);

        twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("Buralar eskiden tarlaydı");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);

        twitter = new Twitter();
        twitter.setHashtag("tobbetu");
        twitter.setTweet("Pist isteyen gençlerimiz için sağlıklı ve güvenli koşullarda yarışabilecekleri bir drag pisti sözü verdim.");
        twitter.setUser(socialUserList.get(random.nextInt(5)));
        twitterList.add(twitter);
    }

    public List<Twitter> getTwitterList() {
        return twitterList;
    }

    //fake foursquare
    public void createFakeFoursquares() {

        Foursquare foursquare = new Foursquare();
        foursquare.setPost("Yalnız mekan yıkılıyor gençler...");
        foursquare.setUser(socialUserList.get(random.nextInt(5)));
        foursquare.setMayor(random.nextBoolean());
        foursquareList.add(foursquare);

        foursquare = new Foursquare();
        foursquare.setPost("Burada yenilebilecek tek şey tavuk");
        foursquare.setUser(socialUserList.get(random.nextInt(5)));
        foursquare.setMayor(random.nextBoolean());
        foursquareList.add(foursquare);

        foursquare = new Foursquare();
        foursquare.setPost("Fare gördüm olm mekanda");
        foursquare.setUser(socialUserList.get(random.nextInt(5)));
        foursquare.setMayor(random.nextBoolean());
        foursquareList.add(foursquare);

        foursquare = new Foursquare();
        foursquare.setPost("Böyle mekanda böyle insanlarda olmaz olsun");
        foursquare.setUser(socialUserList.get(random.nextInt(5)));
        foursquare.setMayor(random.nextBoolean());
        foursquareList.add(foursquare);

        foursquare = new Foursquare();
        foursquare.setPost("Ankaranın buglarına s...yım");
        foursquare.setUser(socialUserList.get(random.nextInt(5)));
        foursquare.setMayor(random.nextBoolean());
        foursquareList.add(foursquare);

        foursquare = new Foursquare();
        foursquare.setPost("Arkadaşlarla latte qeyfi :))");
        foursquare.setUser(socialUserList.get(random.nextInt(5)));
        foursquare.setMayor(random.nextBoolean());
        foursquareList.add(foursquare);

        foursquare = new Foursquare();
        foursquare.setPost("Bored...");
        foursquare.setUser(socialUserList.get(random.nextInt(5)));
        foursquare.setMayor(random.nextBoolean());
        foursquareList.add(foursquare);
    }

    public List<Foursquare> getFoursquareList() {
        return foursquareList;
    }


    //fake instagram
    public void createFaketInstagrams() {

        Instagram instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.a));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("StartupWeekend birincisi Coveplyyyyy");
        instagramList.add(instagram);

        instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.b));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("Bu mekandaki herşeyden nefret ediyorum arkadaş.");
        instagramList.add(instagram);

        instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.c));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("Buraların en büyüğü o bir başka bugs bunny bugs bunny çok yaşa...");
        instagramList.add(instagram);

        instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.d));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("Selamınaleyküm gardaş");
        instagramList.add(instagram);

        instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.e));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("Aşkitomla marmaris keyfiii :)(L)");
        instagramList.add(instagram);

        instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.f));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("Bir bitmediniz lan bir bitmediniz");
        instagramList.add(instagram);

        instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.g));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("Tobb ETÜ garajda çalışma keyfi");
        instagramList.add(instagram);

        instagram = new Instagram();
        instagram.setUser(socialUserList.get(random.nextInt(socialUserList.size())));
        instagram.setImageOfInstagram(context.getResources().getDrawable(R.drawable.h));
        instagram.setNumberOfLike(random.nextInt(100));
        instagram.setPost("Enforce ile yaşamak");
        instagramList.add(instagram);
    }

    public List<Instagram> getInstagramList() {
        return instagramList;
    }

    public void createLists() {
        createFakeSocilaUsers();
        createFaketInstagrams();
        createFakeFoursquares();
        createFakeTweets();
    }
}
