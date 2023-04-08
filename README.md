# FeedMe
An application that helps everyone find their restaurants of belonging!

## Proposal
### What will this application do?
This application is called *FeedMe* and has some features similar to *Yelp*. So when we select a location from the 
app, it will pop out **four** recommended restaurants for us to consider. We will be able to see a brief introduction 
for each restaurant (e.g. what type of food, the average cost per customer) and also some popular dishes in it.

### Who will use it?
- People who want to try some new restaurants to eat in a place
- Visitors who just come to a new place and have no idea where to eat
- Tourists who want to get a taste of some delicious local cuisines

### Why am I interested in this project?
I am a huge foodie and also a fan of a food program called _MasterChef_. Therefore, I want to design an application 
for foodies like me to target some fantastic restaurants better.


## User Stories
__General__
- As a user, I want to be able to select a city and view some recommended restaurants in it
- As a user, I want to be able to add a restaurant to my collection
- As a user, I want to be able to remove a restaurant from my collection
- As a user, when I start the application, I want to be given the option to load my previously saved collection from file

__GUI__
- As a user, I want to be able to preview at least one image of the dishes in a restaurant before I decide whether to add that restaurant into my collection
- As a user, I want to be able to select a restaurant in my collection and view some of its information again
- As a user, I want to be able to save my collection to file before I quit the app

__Console based__
- As a user, I want to be able to see its brief introduction and some recommended dishes when I choose a restaurant
- As a user, I want to be able to renew my entire collection
- As a user, when I select the quit from the app, I want to be prompted the option to save my collection to file


## Instructions for Grader

- You can generate the first required action related to adding restaurants to a collection by first clicking the "Browse restaurants around me" button on the main user interface. Following the subsequent instructions, you will be able to browse some restaurants in each city and put your favourite one(s) into the collection   
- You can generate the second required action related to removing restaurants from a collection by first clicking the "View my current collection" button on the main user interface. Then, you can select an added restaurant in your collection and click on the "Delete" button to remove it from your collection
- You can locate my visual component by clicking the "Show picture" button before adding a selected restaurant to your collection
- You can save the state of my application by clicking the "Save my current collection" button on the main user interface
- You can reload the state of my application by clicking the "Load my previously saved collection" button on the main user interface


## Phase 4: Task 2
Below is the log:

Wed Apr 05 19:08:05 PDT 2023
Miku was added to collection

Wed Apr 05 19:08:09 PDT 2023
The Vancouver Fish Company was added to collection

Wed Apr 05 19:08:17 PDT 2023
More information of Miku was shown

Wed Apr 05 19:08:20 PDT 2023
Miku was removed from collection

Wed Apr 05 19:08:22 PDT 2023
More information of The Vancouver Fish Company was shown

## Phase 4: Task 3
One of the most significant refactoring I would do is to change the data structure of my Collection class from ArrayList to HashMap. 
Since I am using ArrayList, I have to write a lot of foreach loops and if statements to print all the restaurants from my collection or to retrieve one restaurant, 
which is time-consuming and requires a lot of work. By using HashMap, I can replace those loops with a few lines of code.

Another thing I noticed is that ShowLondonResGUI, ShowNewYorkResGUI, and ShowVancouverResGUI these three classes are reasonably similar. 
It would be much better if I could create a superclass and let these three extend it so that they can share some common functionalities. 
This can also reduce so much repetitive code in my current software.

Last but not least, one more thing that makes me uneasy is the Restaurant's information (a parameter of Restaurant). 
Since I do not allow my users to create their restaurants in my app, I have to set up some fixed ones for them to choose from. 
But, instead of a sentence, the information parameter of each of my Restaurants is usually like a paragraph. 
At first, I found that having such a long paragraph text in my Restaurants' instantiation was ugly, especially since I instantiated them in some of my GUI classes; 
therefore, I had to cut the paragraph into a single sentence to make my code feel not so tedious. 
Now when I think back, I should put them in my Main class or just let users be able to create their own restaurants. Either approach will make my code more organized.





