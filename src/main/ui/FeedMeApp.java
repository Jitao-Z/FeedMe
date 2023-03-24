//package ui;

//import model.Collection;
//import model.Restaurant;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
//// FeedMe application
//public class FeedMeApp {
//    private static final String JSON_STORE = "./data/collection.json";
//    private Scanner input;
//    private Collection collection;
//    private Restaurant vr1;
//    private Restaurant vr2;
//    private Restaurant vr3;
//    private Restaurant vr4;
//    private Restaurant lr1;
//    private Restaurant lr2;
//    private Restaurant lr3;
//    private Restaurant lr4;
//    private Restaurant nr1;
//    private Restaurant nr2;
//    private Restaurant nr3;
//    private Restaurant nr4;
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//
//
//    // EFFECTS: runs the FeedMe application
//    public FeedMeApp() throws FileNotFoundException {
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//        runFeedMe();
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: processes user input
//    public void runFeedMe() {
//        boolean shouldRepeat = true;
//        String instruction = null;
//
//        init();
//
//        while (shouldRepeat) {
//            displayMenu();
//            instruction = input.next();
//            instruction = instruction.toLowerCase();
//
//            if (instruction.equals("q")) {
//                quitApplication();
//                shouldRepeat = false;
//            } else {
//                executeInstruction(instruction);
//            }
//        }
//
//        System.out.println("Thank you for using FeedMe!");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    private void quitApplication() {
//        showQuitOptions();
//        String option = input.next();
//        option = option.toLowerCase();
//
//        if (option.equals("y")) {
//            saveCollection();
//        } else if (!(option.equals("y") || option.equals("n"))) {
//            quitApplication();
//        }
//    }
//
//    // EFFECTS: saves the collection to file
//    private void saveCollection() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(collection);
//            jsonWriter.close();
//            System.out.println("Successfully saved your collection to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write the collection to " + JSON_STORE);
//        }
//    }
//
//    // EFFECTS: displays quit options to user
//    private void showQuitOptions() {
//        System.out.println("\nDo you want to save your current collection?");
//        System.out.println("\ty -> yes");
//        System.out.println("\tn -> no");
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: executes user instruction
//    private void executeInstruction(String instruction) {
//        if (instruction.equals("b")) {
//            chooseCity();
//        } else if (instruction.equals("l")) {
//            loadCollection();
//        } else {
//            visitCollection();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads collection from file
//    private void loadCollection() {
//        try {
//            collection = jsonReader.read();
//            System.out.println("Loaded successfully from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//            ;
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: visits the current collection
//    private void visitCollection() {
//        if (collection.getListRestaurant().size() == 0) {
//            System.out.println("Your collection is empty for now.");
//        } else {
//            for (Restaurant restaurant : collection.getListRestaurant()) {
//                System.out.println(restaurant.getName());
//            }
//
//            changeCollection();
//
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: adjusts the current collection based on chosen decision
//    private void changeCollection() {
//        displayChoice();
//        String decision = input.next();
//        decision = decision.toLowerCase();
//
//        if (decision.equals("y")) {
//            deleteRestaurant();
//        } else if (decision.equals("n")) {
//            System.out.println("Going back to the main menu!");
//        } else if (decision.equals("r")) {
//            renewExistingCollection();
//        } else {
//            changeCollection();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: deletes all the restaurants from the collection
//    private void renewExistingCollection() {
//        collection.getListRestaurant().removeAll(collection.getListRestaurant());
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: deletes the restaurant which user inputs its name
//    private void deleteRestaurant() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("Type out the restaurant name below in order to delete that restaurant "
//                + "from your collection");
//        System.out.print("Restaurant Name: ");
//        String rn = input.nextLine();     // the order of this line with the line above cannot be changed
//        for (Restaurant restaurant : collection.getListRestaurant()) {
//            if (restaurant.getName().equals(rn)) {
//                collection.removeRestaurant(restaurant);
//                for (Restaurant r : collection.getListRestaurant()) {
//                    System.out.println(r.getName());
//                }
//                return;
//            }
//        }
//    }
//
//
//    // EFFECTS: displays options of how to adjust the collection to user
//    private void displayChoice() {
//        System.out.println("\nDo you want to modify your collection?");
//        System.out.println("\ty -> yes, I want to edit my collection");
//        System.out.println("\tn -> no, everything is all good");
//        System.out.println("\tr -> I want to renew my entire collection");
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: processes user instruction
//    private void chooseCity() {
//
//        displayCity();
//        String instruction = input.next();
//        instruction = instruction.toLowerCase();
//
//        while (!(instruction.equals("v") || instruction.equals("l") || instruction.equals("n"))) {
//            displayCity();
//            instruction = input.next();
//            instruction = instruction.toLowerCase();
//        }
//
//        if (instruction.equals("v")) {
//            chooseVancouverRestaurant();
//        } else if (instruction.equals("l")) {
//            chooseLondonRestaurant();
//        } else if (instruction.equals("n")) {
//            chooseNewYorkRestaurant();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: chooses one of the showing restaurants to view more details
//    private void chooseNewYorkRestaurant() {
//        displayNewYorkRestaurant();
//        String instruction = input.next();
//        instruction = instruction.toLowerCase();
//
//        while (!(instruction.equals("b")
//                || instruction.equals("o")
//                || instruction.equals("k")
//                || instruction.equals("r"))) {
//            displayNewYorkRestaurant();
//            instruction = input.next();
//            instruction = instruction.toLowerCase();
//        }
//
//        if (instruction.equals("b")) {
//            showBoucherieDetail();
//        } else if (instruction.equals("o")) {
//            showOlioDetail();
//        } else if (instruction.equals("k")) {
//            showRicoDetail();
//        } else {
//            showRoyalDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showRoyalDetail() {
//        System.out.println("Royal 35 Steakhouse is a stone’s throw away from iconic New York City "
//                + "landmark, The Empire State Building, combining the vibrant energy of New York City "
//                + "with an authentic steakhouse setting in Midtown. \nFine dining Steakhouse featuring "
//                + "Prime USDA steaks & seafood, plus martinis & wine, presented in a warm, sophisticated setting."
//                + "\nPopular dishes: Dry Aged Porterhouse, Seafood Tower, Chillean Sea Bass Fish");
//
//        System.out.println("\nDo you want to add Royal 35 Steakhouse into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(nr4);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showRoyalDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showRicoDetail() {
//        System.out.println("At K. Rico, the butchering and Dry-Aging of the steaks is done in-house, and our "
//                + "cuts are displayed right there at the table before guests place their orders, \nresulting "
//                + "in a very unique and memorable New York City dining experience."
//                + "\nPopular dishes: Roasted Oysters, Fufu de Chorizo, Ceviche de Corvina");
//
//        System.out.println("\nDo you want to add K Rico Steakhouse into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(nr3);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showRicoDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showOlioDetail() {
//        System.out.println("An authentic trattoria, the restaurant specializes in classic Italian "
//                + "preparations, with a focus on house-made pastas "
//                + "\nand thin-crust Neapolitan-style pizza, as well as time-honored favorites "
//                + "such as caprese salad, fritto misto, and tiramisu."
//                + "\nPopular dishes: Italian Wedding Soup, Tortellini Di Vitello, Tilefish Arrosto");
//
//        System.out.println("\nDo you want to add Olio e Piu into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(nr2);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showOlioDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showBoucherieDetail() {
//        System.out.println("BOUCHERIE is a traditional French brasserie and steakhouse, celebrating Joie de "
//                + "Vivre in the heart of West Village. \nThe restaurant prepares a menu of French classics and "
//                + "timeless bistro favorites, in addition to the dry-aged steaks. "
//                + "\nAn absinthe-inspired bar offers classic drinks, signature cocktails and craft beers."
//                + "\nPopular dishes: Lobster Bisque, Boeuf Bourguignon, Cupid");
//
//        System.out.println("\nDo you want to add Boucherie West Village into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(nr1);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showBoucherieDetail();
//        }
//    }
//
//
//    // EFFECTS: shows all restaurants in New York City for user to choose
//    private void displayNewYorkRestaurant() {
//        System.out.println("\nHere are some hot restaurants, pick one to check more details!");
//        System.out.println("b -> Boucherie West Village");
//        System.out.println("o -> Olio e Piu");
//        System.out.println("k -> K Rico Steakhouse");
//        System.out.println("r -> Royal 35 Steakhouse");
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: chooses one of the showing restaurants to view more details
//    private void chooseLondonRestaurant() {
//        displayLondonRestaurant();
//        String instruction = input.next();
//        instruction = instruction.toLowerCase();
//
//        while (!(instruction.equals("l")
//                || instruction.equals("a")
//                || instruction.equals("g")
//                || instruction.equals("i"))) {
//            displayLondonRestaurant();
//            instruction = input.next();
//            instruction = instruction.toLowerCase();
//        }
//
//        if (instruction.equals("l")) {
//            showLauncestonDetail();
//        } else if (instruction.equals("a")) {
//            showAlexanderDetail();
//        } else if (instruction.equals("g")) {
//            showAndyDetail();
//        } else {
//            showIndianRoomDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showIndianRoomDetail() {
//        System.out.println("A modern, glass-fronted Indian on the burgeoning strip between The Bedford pub "
//                + "and Balham High Road, \nIndian Room has found itself something of a haven for couples. "
//                + "Well worth trying are the handful of dishes unique to this popular local restaurant, "
//                + "\na wonderful apricot chicken Kashmir among them."
//                + "\nPopular dishes: Goan Seafood Curry, Mumbai Fish Curry, Zinga Methi");
//
//        System.out.println("\nDo you want to add Indian Room into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(lr4);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showIndianRoomDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showAndyDetail() {
//        System.out.println("Andy's Taverna restaurant in a corner of London that could be reasonably nicknamed "
//                + "Little Greek gem in Camden is a charming, \ncasual dining spot with all the cheer of the Greek "
//                + "islands. "
//                + "This long-established restaurant is famous for its warm staff, \npocket-friendly prices and "
//                + "generous portions. Sea bass and sea bream are "
//                + "flown in daily from Greece."
//                + "\nPopular dishes: Lamp, Mossaka");
//
//        System.out.println("\nDo you want to add Andy’s Greek Taverna into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(lr3);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showAndyDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showAlexanderDetail() {
//        System.out.println("Located at the heart of Camden, offering delicious Greek and Mediterranean Cuisine, "
//                + "cooked on original charcoal grill. \nFor private, group and special "
//                + "occasions. Enjoy the surroundings of our indoor garden or a spot of lunch on "
//                + "the outside terrace." + "\nPopular dishes: Alexander's Kebab, Sheftalia, House Mixed Grill");
//
//        System.out.println("\nDo you want to add Alexander The Great into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(lr2);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showAlexanderDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showLauncestonDetail() {
//        System.out.println("Nestled in the quaint residential streets of Kensington, Launceston Place is an award "
//                + "winning hidden gem. Open for lunch Wednesday to Sunday and dinner Wednesday to Sunday, "
//                + "\nLaunceston Place attracts a loyal local following, as well as being a fantastic destination "
//                + "for visitors to this charming London neighbourhood."
//                + "\nPopular dishes: Pork, Cheese Cart, Cod");
//
//        System.out.println("\nDo you want to add Launceston Place into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(lr1);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showLauncestonDetail();
//        }
//    }
//
//
//    // EFFECTS: shows all restaurants in London for user to choose
//    private void displayLondonRestaurant() {
//        System.out.println("\nHere are some hot restaurants, pick one to check more details!");
//        System.out.println("l -> Launceston Place");
//        System.out.println("a -> Alexander The Great");
//        System.out.println("g -> Andy’s Greek Taverna");
//        System.out.println("i -> Indian Room");
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: chooses one of the showing restaurants to view more details
//    private void chooseVancouverRestaurant() {
//        displayVancouverRestaurant();
//        String instruction = input.next();
//        instruction = instruction.toLowerCase();
//
//        while (!(instruction.equals("m")
//                || instruction.equals("a")
//                || instruction.equals("c")
//                || instruction.equals("t"))) {
//            displayVancouverRestaurant();
//            instruction = input.next();
//            instruction = instruction.toLowerCase();
//        }
//
//        if (instruction.equals("m")) {
//            showMikuDetail();
//        } else if (instruction.equals("a")) {
//            showAnnaLenaDetail();
//        } else if (instruction.equals("c")) {
//            showSteakhouseDetail();
//        } else {
//            showFishCompanyDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showFishCompanyDetail() {
//        System.out.println("The Vancouver Fish Company is a seafood-focused Restaurant & Bar located on historic "
//                + "Granville Island in beautiful Vancouver, BC."
//                + "\nWe have assembled an amazing "
//                + "team of kitchen and "
//                + "service staff and are excited to have the opportunity to be at "
//                + "your service while presenting a fresh take on seafood in Vancouver."
//                + "\nPopular dishes: Fresh Oysters, Tomahawk, Brant Lake Wagyu, Tuna Poke Bowl");
//
//        System.out.println("\nDo you want to add The Vancouver Fish Company into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(vr4);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showFishCompanyDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showSteakhouseDetail() {
//        System.out.println("Our newest location is now open in Downtown Vancouver. Located on the east side of the "
//                + "Vancouver Convention Centre, within walking distance \nfrom Waterfront Station, our newest "
//                + "location "
//                + "offers spectacular views of the Vancouver Harbour, North Shore Mountains and Canada Place. "
//                + "\nThe culmination of more than fifteen years of experience serving our communities, "
//                + "Chop offers handcrafted cuisine, signature cocktails, and enlightened hospitality. "
//                + "\nEnjoyed by guests at 16 locations across Canada."
//                + "\nPopular dishes: Chili Garlic Shrimp, Prime Rib, Centre Cut New York");
//
//        System.out.println("\nDo you want to add Chop Steakhouse $ Bar - Coal Harbour into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(vr3);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showSteakhouseDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showAnnaLenaDetail() {
//        System.out.println("AnnaLena is a Tasting Menu focused restaurant located steps from Kitsilano Beach "
//                + "and a short walk from Downtown Vancouver, British Columbia."
//                + "\nWe offer a set menu that can "
//                + "feature seafood, local produce, meat and dessert."
//                + "\nPopular dishes: Wagyu Short Rib, "
//                + "Shaved Foie "
//                + "Gras, Seasonal Bison Short Ribs");
//
//        System.out.println("\nDo you want to add AnnaLena into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(vr2);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showAnnaLenaDetail();
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: decides whether putting this specific restaurant into the collection
//    private void showMikuDetail() {
//        System.out.println("Situated along the Burrard Inlet next to the Vancouver landmark Canada Place, "
//                + "Miku Waterfront continues to deliver gourmet Aburi cuisine \npaired with its well known, "
//                + "energetic ambience." + "\nPopular dishes:Salmon Oshi Roll, Aburi Sushi, Ebi Oshi, Red Wave Roll");

//        System.out.println("\nDo you want to add Miku into collection?");
//        System.out.println("\ty -> add to collection");
//        System.out.println("\tn -> not add to collection");
//
//        String finalDesign = input.next();
//        if (finalDesign.equals("y")) {
//            collection.addRestaurant(vr1);
//            System.out.println("Added successfully!");
//        } else if (finalDesign.equals("n")) {
//            System.out.println("Check some others later!");
//        } else {
//            showMikuDetail();
//        }
//    }
//
//
//    // EFFECTS: shows all restaurants in Vancouver for user to choose
//    private void displayVancouverRestaurant() {
//        System.out.println("\nHere are some hot restaurants, pick one to check more details!");
//        System.out.println("m -> Miku");
//        System.out.println("a -> AnnaLena");
//        System.out.println("c -> Chop Steakhouse & Bar");
//        System.out.println("t -> The Vancouver Fish Company");
//    }
//
//
//    // EFFECTS: displays options of cities for user to choose
//    private void displayCity() {
//        System.out.println("\nChoose one city from:");
//        System.out.println("v -> Vancouver");
//        System.out.println("l -> London");
//        System.out.println("n -> New York City");
//    }
//
//
//    // EFFECTS: displays menu of options to user
//    private void displayMenu() {
//        System.out.println("\nSelect from:");
//        System.out.println("b -> browse restaurants around me");
//        System.out.println("c -> check my current collection");
//        System.out.println("l -> load the previously saved collection from file");
//        System.out.println("q -> quit");
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: initializes input and collection
//    private void init() {
//        input = new Scanner(System.in);
//        collection = new Collection();
//
//        initVancouver();
//        initLondon();
//        initNewYork();
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: initializes all restaurants in Vancouver
//    private void initVancouver() {
//        vr1 = new Restaurant("Miku", "Vancouver");
//        vr2 = new Restaurant("AnnaLena", "Vancouver");
//        vr3 = new Restaurant("Chop Steakhouse & Bar", "Vancouver");
//        vr4 = new Restaurant("The Vancouver Fish Company", "Vancouver");
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: initializes all restaurants in London
//    private void initLondon() {
//        lr1 = new Restaurant("Launceston Place", "London");
//        lr2 = new Restaurant("Alexander The Great", "London");
//        lr3 = new Restaurant("Andy’s Greek Taverna", "London");
//        lr4 = new Restaurant("Indian Room", "London");
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: initializes all restaurants in New York City
//    private void initNewYork() {
//        nr1 = new Restaurant("Boucherie West Village", "New York City");
//        nr2 = new Restaurant("Olio e Piu", "New York City");
//        nr3 = new Restaurant("K Rico Steakhouse", "New York City");
//        nr4 = new Restaurant("Royal 35 Steakhouse", "New York City");
//    }
//
//}
//
