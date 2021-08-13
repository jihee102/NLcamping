package com.jihee.nlcamping.Model;

import java.util.ArrayList;
import java.util.List;

public class CampingAdmin {
    public static ArrayList<Province> provinces;

    public CampingAdmin(){
        provinces = new ArrayList<>();
        Province northHolland = new Province("North Holland","flag_north_holland.png","north_holland.png");
        Province drenthe = new Province("Drenthe","flag_drenthe.png","drenthe.png");
        Province flevoland = new Province("Flevoland","flag_flevoland.png","flevoland.png");
        Province frisland = new Province("Frisland","flag_frisland.png","frisland.png");
        Province gelderland = new Province("Gelderland", "flag_gelderland.png","gelderland.png");
        Province groningen = new Province("Groningen","flag_groningen.png","groningen.png");
        Province limburg = new Province("Limburg","flag_limburg.png","limburg.png");
        Province northBrabant = new Province("North Brabant","flag_north_brabant.png","north_brabant.png");
        Province southHolland =new Province("South Holland","flag_South_holland.png","south_holland.png");
        Province overijssel = new Province("Overijssel","flag_overijssel.png","overijssel.png");
        Province utrecht = new Province("Utrecht","flag_utrecht.png","utrecht.png");
        Province zeeland = new Province("Zeeland","flag_zeeland.png", "zeeland.png");

        provinces.add(northHolland);
        provinces.add(drenthe);
        provinces.add(flevoland);
        provinces.add(frisland);
        provinces.add(gelderland);
        provinces.add(groningen);
        provinces.add(limburg);
        provinces.add(northBrabant);
        provinces.add(southHolland);
        provinces.add(overijssel);
        provinces.add(utrecht);
        provinces.add(zeeland);

        northHolland.addCampingPark("Camping De Eenhoorn","Burgerwoudweg 1, 1476 NE Schardam","0299 402 828","campingdeeenhoorn.nl","eenhoorn.jpg");
        northHolland.addCampingPark("Camping Vliegenbos Amsterdam","Meeuwenlaan 138, 1022 AM Amsterdam","020 636 8855","amsterdam.nl","vliegenbos.jpg");
        northHolland.addCampingPark("Camping Zeeburg Amsterdam","Zuider IJdijk 20, 1095 KN Amsterdam","020 694 4430","campingzeeburg.nl","zeeburg.jpg");
        northHolland.addCampingPark("Kennemer Duincamping de Lakens","Zeeweg 60, 2051 EC Overveen","023 541 1570","campingdelakens.nl","kennemer.jpg");
        northHolland.addCampingPark("Camping De Nollen","Westerweg 8, 1759 JD Callantsoog","0224 581 281","denollen.nl","nollen.jpg");

        drenthe.addCampingPark("Lente van Drenthe", "Houtvester Jansenweg 2, 9462 TB Gasselte", "0599 564 333","lentevandrenthe.nl/","lentevandrenthe.jpg");
        drenthe.addCampingPark("Vakantiepark CAPFUN De Fruithof","Melkweg 2, 7871 PE Klijndijk","0591 512 427","www.capfun.com","capfunFruithof.jpg");
        drenthe.addCampingPark("Camping Midden Drenthe","Elperweg 5, 9433 TJ Zwiggelte","0593 370 022","campingmiddendrenthe.nl","campingmiddendrenthe.jpg");

        flevoland.addCampingPark("Molecaten Park Flevostrand","Strandweg 1, 8256 RZ Biddinghuizen","0320 288 480","molecaten.nl/flevostrand","molecatenpark.jpg");
        flevoland.addCampingPark("Netl de Wildste Tuin","Leemringweg 19, 8317 RD Kraggenburg","0527 203 043","http://www.netl.nl/","wildstetuin.jpg");
        flevoland.addCampingPark("Camping Green Forest","Groenewoudse Weg 98, 3896 LS Zeewolde,","036 523 6366","https://www.hetgroenebos.nl/","greenforest.jpg");

        frisland.addCampingPark("Camping 'It Wiid'","Koaidyk 10, 9264 TP Earnewald","0511 539 223","https://www.wiid.nl/","Itwiid.jpg");
        frisland.addCampingPark("Camperplaats Leeuwarden","De Zwemmer 3, 8939 CA Leeuwarden","06 41318424","https://www.camperplaatsleeuwarden.nl/","leeuwarden.jpg");
        frisland.addCampingPark("Friesland vakantiepark Bergumermeer","Solcamastraat 30, 9262 ND Sumar","0511 461 385","http://www.bergumermeer.nl/","bergumermeer.jpg");

        gelderland.addCampingPark("Campsites Gelderland","Rijnbandijk 10a, 4024 BM Eck en Wiel","0344 691 655","https://www.gelderlandcampings.nl/","campsitesgelderland.jpg");
        gelderland.addCampingPark("camping park The Green Island","Lutenkampstraat 2, 6629 KS Appeltern","0487 562 130","http://www.groeneeiland.nl/","thegreenisland.jpg");
        gelderland.addCampingPark("Buitenplaats Beekhuizen","Bovenallee 1, 6881 AJ Velp","026 202 0365","http://www.buitenplaatsbeekhuizen.nl/","beekhuizen.jpg");
        gelderland.addCampingPark("Ardoer Camping Ackersate","Harremaatweg 26, 3781 NJ Voorthuizen","0342 471 274","https://www.ackersate.nl/","ackersate.jpg");
        gelderland.addCampingPark("Camping Helfterkamp","Gortelseweg 24, 8171 RA Vaassen","0578 571 839","http://www.helfterkamp.nl/","helfterkamp.jpg");

        groningen.addCampingPark("Camping Pool Leekstermeer","Matsloot 1-A, 9749 TJ Matsloot","0598 620 031","http://www.campingpool.nl/","leekstermeer.jpg");
        groningen.addCampingPark("Vakantiepark Meerzicht","Matsloot 3, 9749 TJ Matsloot","050 551 5466"," ","meerzicht.jpg");
        groningen.addCampingPark("Vakantiepark Cnossen Leekstermeer","Tarralaan 6, 9745 ER Groningen","06 51962463","http://www.detuinindestad.nl/","cnossenleekstermeer.jpg");

        limburg.addCampingPark("Recreatiepark de Leistert","Heldensedijk 5, 6088 NT Roggel","0475 493 030","https://www.leistert.nl/","recreatiepark.jpg");
        limburg.addCampingPark("De Schatberg","Midden Peelweg 5, 5975 MZ Sevenum","077 467 7777","http://www.schatberg.nl/","deschatberg.jpg");
        limburg.addCampingPark("Camping Gulperberg Limburg","1, Berghem, 6271 NP Gulpen","043 450 2330","https://www.campinggulperberg.nl/","gulperberg.jpg");

        northBrabant.addCampingPark("Camping Ponderosa","Maaijkant 26, 5113 BD Ulicoten","013 519 9391","https://www.ponderosa.nl/","ponderosa.jpg");
        northBrabant.addCampingPark("Camping Fort Dunes","Maaijkant 26, 5113 BD Ulicoten","013 519 9391","https://www.ponderosa.nl/","fortdunes.jpg");
        northBrabant.addCampingPark("Recreation TerSpegelt","Postelseweg 88, 5521 RD Eersel","0497 512 016","http://www.terspegelt.nl/","terspegelt.jpg");

        southHolland.addCampingPark("Landal Miggelenberg","Miggelenbergweg 65, 7351 BP Hoenderloo","055 378 1251","http://www.landal.nl/Miggelenberg","landalmiggelenberg.jpg");
        southHolland.addCampingPark("Camping Ter Leede Leerdam","Recht van Ter Leede 28 A, 4143 LP Leerdam","0345 599 232","http://campingterleede.nl/","leerdam.jpg");
        southHolland.addCampingPark("Landal Coldenhove","Boshoffweg 6, 6961 LD Eerbeek","0313 659 101","http://www.landal.nl/coldenhove","landalcoldenhove.jpg");

        overijssel.addCampingPark("Holiday & Camping Mölke","Molendijk 107, 7466 PD Zuna","0548 512 743","https://www.molke.nl/","molke.jpg");
        overijssel.addCampingPark("Charme Camping Heidepark","Verbindingsweg 2A, 8151 PP Lemelerveld","0572 371 525","http://www.campingheidepark.nl/","heidepark.jpg");
        overijssel.addCampingPark("Summercamp Heino","Kruisweg 2, 7461 ZV Rijssen","0572 393 049","http://www.heino.nl/","heino.jpg");

        utrecht.addCampingPark("Fort aan de Klop","1e Polderweg 4, 3563 MC Utrecht","030 266 0555","http://www.fortaandeklop.com/","fortaandeklop.jpg");
        utrecht.addCampingPark("Camping Between Heaven and Earth","Kanonsdijk 7, 3737 MS Groenekan","030 262 6798","http://www.tussenhemelenaarde.info/","heavenandearth.jpg");
        utrecht.addCampingPark("Caravan Park Voormolen","Zuid IJsseldijk 22, 3401 PX IJsselstein"," 06 12481062","http://www.devoormolen.nl/","voormolen.jpg");

        zeeland.addCampingPark("Vakantiepark Hof van Zeeland","Hof van Zeeland 175, 4451 RS Heinkenszand","0113 562 260","http://www.hofvanzeeland.nl/","hofvanzeeland.jpg");
        zeeland.addCampingPark("Molecaten Park Hoogduin","Zwartepolderweg 1, 4506 HT Cadzand","0117 391 235","https://www.molecaten.nl/hoogduin","hoogduin.jpg");
        zeeland.addCampingPark("Roompot Hof Domburg","Schelpweg 7, 4357 RD Domburg","088 044 4999","https://www.roompot.nl/","domburg.jpg");

    }



    public CampingPark findCampingParkByName(String name){
       for(Province p : provinces){
           if(p.findCampingParkByName(name)!=null){
              return findCampingParkByName(name);
           }
       }
       return null;
    }

    public Province findProvince(String name){
        for(Province p : provinces){
            if(p.getProvinceName().equals(name))
                return p;
        }
        return null;
    }

    public void addProvince(String name) throws CampingException {
        if(findProvince(name)!=null){
            Province p = new Province(name);
            provinces.add(p);
        }else{
            throw new CampingException("The province is already exist.");
        }
    }

    public void addCampingParkInProvince(String name, String parkName, String address, String phone, String webAddress, String iamge) throws CampingException{
        if(findProvince(name)!= null){
            findProvince(name).addCampingPark(name,address,phone,webAddress,iamge);
        }else{
            throw new CampingException("The province doesn't exist.");
        }
    }

    public void addCampingParkReview(String campingParkName, String id, String content, int score)throws CampingException{
        if(findCampingParkByName(campingParkName)!= null){
            findCampingParkByName(campingParkName).addReview(id,content,score);
        }else{
            throw new CampingException("Camping park doesn't exist.");
        }
    }

    public void makingReview() {
        String[] goodReviews = {"Good experience", "I want to use there again", "beautiful Park!", "awesome place!", "I want to recommend this park",
                "you can relax there.", "Nice place to go with family", "!!!!", "See you next time", "Wow"};
        String[] badReviews = {"Boring Place", "So so..", "It was raining whole week. so I couldn't enjoy.", "No anymore friendly", "No swimming pool",
                "while i was staying there, no power..", "the public toiler was dirty.", "???..", "Expensive..", "I don't know"};
        for (Province p : provinces) {
            if(p.getCampingParks() != null){
                for (int i = 0; i <p.getCampingParks().size() ; i++) {
                    for (int j = 0; j < 5; j++) {
                        double random = (Math.random() * 5) + 1;
                        int score = (int) random;
                        int elementInArray = (int) (Math.random() * 10);
                        String text;
                        if (random > 2.5) {
                            text = goodReviews[elementInArray];
                        } else {
                            text = badReviews[elementInArray];
                        }
                        p.getCampingParks().get(i).addReview("ID"+(j+1),text,score);
                    }
                }
            }
        }
    }

    public void setRandomPropertyAmentities() {

        for (Province p : provinces) {
            if(p.getCampingParks() != null) {
                for(CampingPark c : p.getCampingParks()) {
                        boolean[] random = new boolean[7];
                        for (int i = 0; i < 7; i++) {
                            int number = (int) (Math.random() * 10) + 1;
                            if (number < 6) {
                                random[i] = true;
                            } else {
                                random[i] = false;
                            }
                        }
                        PropertyAmenity amenities = new PropertyAmenity(random[0], random[1], random[2], random[3], random[4], random[5], random[6]);
                        c.setAmenities(amenities);

                }
            }
        }
    }

    public List<Province> getProvinces() {
        return provinces;
    }

}
