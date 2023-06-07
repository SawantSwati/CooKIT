package com.example.cookit.data

import android.content.Context
import com.example.cookit.model.Ingredient
import com.example.cookit.model.Procedure
import com.example.cookit.model.Recipe
import com.example.cookit.DbHelper.RecipeDBHelper

class AddDataInDatabase(context: Context) {

    // Create a RecipeDBHelper instance
    val dbHelper = RecipeDBHelper(context)

    // Add the recipe to the database
    fun addRecipeToDatabase() {
        // Create a sample recipe
        val ChickenCurry = Recipe(
            name = "Chicken Curry",
            isVegetarian = false,
            cookingTime = "40 mins",
            calories = 476,
            difficulty = "Medium",
            ratings = 4.5f,
            ingredients = listOf(
                Ingredient(name = "vegetable, canola, or sunflower", quantity = "1/4 cup"),
                Ingredient(name = "onions", quantity = "2 large"),
                Ingredient(name = "tomatoes", quantity = "2 large"),
                Ingredient(name = "garlic paste", quantity = "2 tablespoons"),
                Ingredient(name = "ginger paste", quantity = "1 tablespoon"),
                Ingredient(name = "coriander powder", quantity = "2 teaspoons"),
                Ingredient(name = "cumin powder", quantity = "1 teaspoon"),
                Ingredient(name = "turmeric powder", quantity = "1/2 teaspoon"),
                Ingredient(name = "red chili powder", quantity = "1/2 teaspoon"),
                Ingredient(name = "garam masala", quantity = "2 teaspoons"),
                Ingredient(name = "chicken pieces", quantity = "2 1/4 pounds (1 kilogram)"),
                Ingredient(name = "hot water", quantity = "1 1/2 cups")
            ),
            procedure = listOf(
                Procedure(steps = "Step 1", procedure = "Heat olive oil in a skillet over medium heat. Sauté onion until lightly browned."),
                Procedure(steps = "Step 2", procedure = "Stir in garlic, curry powder, cinnamon, paprika, bay leaf, ginger, sugar, and salt. Continue stirring for 2 minutes."),
                Procedure(steps = "Step 3", procedure = "Add chicken pieces, tomato paste, yogurt, and coconut milk. Bring to a boil, reduce heat, and simmer for 20 to 25 minutes."),
                Procedure(steps = "Step 4", procedure = "Remove bay leaf, and stir in lemon juice and cayenne pepper. Simmer 5 more minutes."),
                Procedure(steps = "Step 5", procedure = "Serve hot and enjoy!"),
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FchikenCurry.jpg?alt=media&token=8d2bf5fb-cc31-4daa-8e78-a1ad602e24b6"
        )


        val VegFriedRice = Recipe(
            name = "Veg Fried Rice",
            isVegetarian = true,
            cookingTime = "20 mins",
            calories = 360,
            difficulty = "Medium",
            ratings = 4.0f,
            ingredients = listOf(
                Ingredient(name = " boiled rice", quantity = "2 cup"),
                Ingredient(name = "tsoy sauce", quantity = "1 tablespoon"),
                Ingredient(name = "chopped garlic", quantity = "1 tablespoon"),
                Ingredient(name = " carrot", quantity = "1/4 cup"),
                Ingredient(name = "cabbage", quantity = "1/4 cup "),
                Ingredient(name = " green onion", quantity = "1/4 cup "),
                Ingredient(name = "unflower oil", quantity = "2 tablespoon"),
                Ingredient(name = "vinegar", quantity = "1 tablespoon"),
                Ingredient(name = "onion", quantity = "1/4 cup"),
                Ingredient(name = "red bell pepper", quantity = "1/4 cup"),
                Ingredient(name = "green beans", quantity = "1/4 cup"),
                Ingredient(name = "salt", quantity = "1 tablespoon"),
                Ingredient(name = "black pepper", quantity = "1 tablespoon")
            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = " To prepare this recipe, firstly boil the rice and keep it aside. You can also use leftover rice from lunch in order to prepare a delicious dinner."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Chop all the veggies and keep them together on a plate."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Fry the veggies. Add 2 tbsp oil to a pan. Add chopped garlic and saute for a minute. Now add all the veggies together and fry for a few minutes (3-4 minutes)."
                ),
                Procedure(
                    steps = "Step 4",
                    procedure = "Adjust the seasoning. Now add soy sauce and vinegar. Keep on high heat and mix well. Lastly, add salt, pepper as per taste and cook for the last one minute."
                ),
                Procedure(
                    steps = "Step 5",
                    procedure = "Ready to be served. Once cooked, garnish with chopped green onions. Your vegetable fried rice is ready to be served with chilli paneer or manchurian."
                )

            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FfriedRice.jpg?alt=media&token=b605c214-c781-4388-9086-cffb89bfbf58"
        )


        val Casserole = Recipe(
            name = "Casserole",
            isVegetarian = false,
            cookingTime = "50 mins",
            calories = 258,
            difficulty = "Easy",
            ratings = 4.0f,
            ingredients = listOf(
                Ingredient(name = "Breakfast Sausage", quantity = "1 pound"),
                Ingredient(name = " Green Pepper (diced)", quantity = " 1 "),
                Ingredient(name = "Small Onion (diced)", quantity = "1 "),
                Ingredient(name = "Red Pepper (diced)", quantity = "1 "),
                Ingredient(name = "Garlic (minced)", quantity = "1 teaspoons"),
                Ingredient(name = "Cubed Hash Brown Potatoes ", quantity = "3 cups"),
                Ingredient(name = "Eggs", quantity = "3"),
                Ingredient(name = "Milk", quantity = "1 cup"),
                Ingredient(name = "Salt And Pepper", quantity = "add"),
                Ingredient(name = "Red Pepper Flakes", quantity = "1 teaspoons"),
                Ingredient(name = "Cheddar Cheese (divided)", quantity = "2 cups"),
                Ingredient(name = "Green Onions (for garnish)", quantity = "add"),

                ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "Heat oven to 400 degrees and spray 9 x 13 baking dish with cooking spray."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Cook sausage over medium-high heat until no longer pink. Add green peppers, red peppers, onion and garlic to pan and cook for an addition 5 minutes."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Add half of the hashbrowns to baking dish. Sprinkle half of the sausage mixture evenly over hashbrowns. Sprinkle 1 cup of cheese over sausage and hashbrowns."
                ),
                Procedure(
                    steps = "Step 4",
                    procedure = "Layer remaining hashbrowns, sausage mixture, and cheese."
                ),
                Procedure(
                    steps = "Step 5",
                    procedure = "In medium bowl, whisk eggs, milk, salt, pepper and red pepper flakes together. Pour egg mixture over potatoes, sausage, and cheese in baking dish."
                ),
                Procedure(
                    steps = "Step 6",
                    procedure = "Bake for 35 – 40 minutes or until eggs are fully cooked."
                ),
                Procedure(
                    steps = "Step 7", procedure = "Sprinkle with green onions and serve. Enjoy!"
                )
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FfriedRice.jpg?alt=media&token=b605c214-c781-4388-9086-cffb89bfbf58"
        )


        val IdliBatter = Recipe(
            name = "Idli Batter",
            isVegetarian = true,
            cookingTime = "10 mins",
            calories = 360,
            difficulty = "Easy",
            ratings = 4.0f,
            ingredients = listOf(
                Ingredient(name = "urad dal", quantity = "100 gm"),
                Ingredient(name = "rice", quantity = "300 gm"),
                Ingredient(name = "salt", quantity = "1 pinch")

            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "First, soak the Urad Dal and rice till they soften. Once they are ready, take a grinder jar and add the soaked urad dal and rice in it and grind. Make a fine paste of these ingredients and transfer them to a bowl. Make sure that the batter isn't too thin as the thickness of the batter will decide how fluffy the end product is."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Next, sprinkle a pinch of salt, and let the batter ferment until it starts to rise. Once it rises, the batter is ready to be used and can be used to make yummy hot idlis."
                )
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FidliBatter.jpg?alt=media&token=59ce6de9-a32d-47b9-8f80-a9e3673b5b35"
        )


        val MasalaDosa = Recipe(
            name = "Masala Dosa",
            isVegetarian = true,
            cookingTime = "30 mins",
            calories = 421,
            difficulty = "easy",
            ratings = 5.0f,
            ingredients = listOf(
                Ingredient(name = "parboiled rice", quantity = "2 cup"),
                Ingredient(name = "urad dal", quantity = "1/2 cup"),
                Ingredient(name = "salt", quantity = "1 teaspoon"),
                Ingredient(name = "refined oil", quantity = "1/4 cup"),
                Ingredient(name = "fenugreek seeds", quantity = "1/2 teaspoon "),
                Ingredient(name = "boiled potato", quantity = "1/2 kilograms"),
                Ingredient(name = "chopped green chilli", quantity = "2 medium"),
                Ingredient(name = "mustard seeds", quantity = "1 tablespoon"),
                Ingredient(name = "turmeric", quantity = "tablespoon"),
                Ingredient(name = "sliced onion", quantity = "1 1/2 cup"),
                Ingredient(name = " refined oil", quantity = "2 tablespoon"),
                Ingredient(name = "salt", quantity = "1 tablespoon"),
                Ingredient(name = "curry leaves", quantity = "10 leaves"),
                Ingredient(name = "water", quantity = "1/4 cup")
            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = " Prepare the batter and ferment overnight Masala Dosa is one of the most popular South Indian delicacies.To prepare the batter for Masala Dosa, wash and soak the rice(with fenugreek added into it) and urad dal in separate containers for approximately 6 - 8 hours. Once the rice and urad dal are soaked well, grind them separately in a mixer using the water in which they were soaked, till the mixture reaches a smooth consistency.Mix the batter of both the ingredients in a bigger container and add salt to it . Combine well and allow it to ferment overnight.."
                ),

                Procedure(
                    steps = "Step 2",
                    procedure = "Prepare the potato filling for Masala Dosa To prepare the filling of the dosa, heat 2 tbsp oil in a thick -bottomed pan and let the mustard seeds splutter . Then, add sliced onions, curry leaves, green chillies and saute them till the onions turn pink . Then, add a pinch of salt, turmeric powder and mix them well . Now, take the cubed potatoes and add them to the sauteed onions and mix them together.Pour water gradually into the mixture and allow the potatoes to simmer for around4 minutes . When the mixture is in semi - thick state, turn off the gas and let it rest for a few seconds."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Pan fry your dosa on a dosa tawa Now, take a dosa tawa and heat it on low - medium flame . Smear 1 tsp oil on it to prepare the dosa.When the tawa is hot, pour and spread the batter evenly in a circular motion ."
                ),

                Procedure(
                    steps = "Step 4",
                    procedure = "Add filling and fold the dosa When the colour of dosa 's edges turns into brown, reduce the flame and sprinkle few drops of oil on the dosa sides and put 2 tablespoons of filling. Fold the dosa . Repeat the process until all the batter and filling is used up.Serve hot Masala Dosa with coconut chutney and sambhar"
                )

            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FmasalaDosa.jpg?alt=media&token=c8cc3a0d-a4ee-41d3-b14a-6dca1391e504"
        )


        val Pakundalu = Recipe(
            name = "Pakundalu",
            isVegetarian = true,
            cookingTime = "20 mins",
            calories = 194,
            difficulty = "Medium",
            ratings = 4.0f,
            ingredients = listOf(
                Ingredient(name = "soaked overnight,ground rice", quantity = "1 cup"),
                Ingredient(name = "coconut", quantity = "1/2 cup"),
                Ingredient(name = "refined oil", quantity = "1 tablespoon"),
                Ingredient(name = " jaggery", quantity = "1/4 cup"),
                Ingredient(name = "powdered green cardamom", quantity = "1 teaspoon ")

            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "Grind rice into a smooth batter Grind the rice which was soaked overnight into a smooth batter. You can add some water to make the batter smoother."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Melt jaggery Now heat a heavy-bottomed pan, add jaggery and let it melt. Once melted, add cardamom powder, freshly grated coconut and stir a bit."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Mix melted jaggery with rice batter Now mix jaggery-coconut mixture with rice batter and mix well to create a thick batter."
                ),
                Procedure(
                    steps = "Step 4",
                    procedure = "Make small dumplings Now grease a appe pan with oil and pour the batter into the moulds. You can also use a tawa for the same, but it won't give you the required thickness of ​Pakundalu​. So, it is better to use appe pan."
                ),
                Procedure(
                    steps = "Step 5",
                    procedure = "Cook and serve Cook from both sides until golden brown and serve hot."
                )
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2Fimage.jpeg?alt=media&token=780cd3a1-bdd8-4209-a846-326292d4a89a"
        )


        val PaladaPradhaman = Recipe(
            name = "Palada Pradhaman",
            isVegetarian = true,
            cookingTime = "1 Hours",
            calories = 400,
            difficulty = "Medium",
            ratings = 5.0f,
            ingredients = listOf(
                Ingredient(name = "rice", quantity = "1 cup"),
                Ingredient(name = "water", quantity = "2 1/2 cup"),
                Ingredient(name = "cashews", quantity = "1"),
                Ingredient(name = "ghee", quantity = "1 tablespoon"),
                Ingredient(name = "milk", quantity = "2 1/2"),
                Ingredient(name = "sugar", quantity = "2 cup"),
                Ingredient(name = " green cardamom", quantity = "1"),
                Ingredient(name = "grated coconut", quantity = "1 tablespoon")

            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "Boil rice flakes.To stat with wash the rice properly and drain the excess water. Fry the rice flakes in some ghee, and then boil in water."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Boil milk.While the rice is boiling, boil milk and add grated coconut in it. Add this milk to the boiled rice."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Add sugar and coconut. Turn the gas on a lower flame, and add sugar. Let it boil for 2-3 minutes, and then add grated coconuts."
                ),
                Procedure(
                    steps = "Step 4",
                    procedure = "Add cashew for garnish and serve. In a shallow fry pan, fry the chopped cashew and garnish it on the pradhaman. Put crushed cardamom for added extravagance."
                )
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FpaladaPradhaman.jpg?alt=media&token=89ba9054-e9d6-4733-8d77-9fd0371756da"
        )


        val KadhaiGobhi = Recipe(
            name = "Kadhai Gobhi",
            isVegetarian = true,
            cookingTime = "30 mins",
            calories = 298,
            difficulty = "Medium",
            ratings = 4.5f,
            ingredients = listOf(
                Ingredient(name = "cauliflower ", quantity = "200 gm"),
                Ingredient(
                    name = "refined oil= ", "6 tablespoon "
                ),
                Ingredient(
                    name = "tomato", quantity = "1 medium"
                ),
                Ingredient(name = "garam masala powder", quantity = "1 tablespoon"),
                Ingredient(name = "coriander powde", quantity = "1 tablespoon"),
                Ingredient(name = " Kashmiri red chilli", quantity = "1 tablespoon"),
                Ingredient(name = "garlic paste", quantity = "1/2 tablespoon"),
                Ingredient(name = "salt", quantity = "required"),
                Ingredient(name = "potato", quantity = "1 large"),
                Ingredient(name = "capsicum (green pepper)", quantity = "1 medium"),
                Ingredient(name = " coriander leaves", quantity = "2 tablespoon"),
                Ingredient(name = "cumin seeds", quantity = "1 tablespoon"),
                Ingredient(name = "turmeric", quantity = "1/2 tablespoon"),
                Ingredient(name = "ginger paste", quantity = "1/2 tablespoon"),
                Ingredient(
                    name = "asafoetida", quantity = "1/4 tablespoon"
                )
            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "Saute cauliflower and capsicum Heat oil in a kadhai.Add the asafoetida, turmeric and potatoes to it.Stir them well and cook them coveredfor 5 - 10 minutes . Then, add the cauliflower florets in them . Mix well and cook covered for 10 minutes till tender . Sprinkle some salt in it . Add the capsicum, cook covered for five minutes till tender but don 't overcook; leave them crunchy."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Add spices and cook well Add red chilli powder, coriander-cumin powder, garam masala and ginger-garlic paste to it. Mix them well and cook for two minutes while stirring occasionally . Now, add the chopped tomatoes, mix well and cook until tomatoes are tender . When the oil separates, add some chopped coriander to garnish and serve with hot roti or naan."
                )
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FKadhaiGobhi.jpeg?alt=media&token=a5c42c4c-8f0e-45c9-928e-5b6e50ca9be6"
        )


        val RiceBalls = Recipe(
            name = "Rice Balls",
            isVegetarian = true,
            cookingTime = "20 mins",
            calories = 360,
            difficulty = "Medium",
            ratings = 4.0f,
            ingredients = listOf(
                Ingredient(name = " boiled rice", quantity = "2 cup"),
                Ingredient(name = "tsoy sauce", quantity = "1 tablespoon"),
                Ingredient(name = "chopped garlic", quantity = "1 tablespoon"),
                Ingredient(name = " carrot", quantity = "1/4 cup"),
                Ingredient(name = "cabbage", quantity = "1/4 cup "),
                Ingredient(name = " green onion", quantity = "1/4 cup "),
                Ingredient(name = "unflower oil", quantity = "2 tablespoon"),
                Ingredient(name = "vinegar", quantity = "1 tablespoon"),
                Ingredient(name = "onion", quantity = "1/4 cup"),
                Ingredient(name = "red bell pepper", quantity = "1/4 cup"),
                Ingredient(name = "green beans", quantity = "1/4 cup"),
                Ingredient(name = "salt", quantity = "1 tablespoon"),
                Ingredient(name = "black pepper", quantity = "1 tablespoon")
            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = " To prepare this recipe, firstly boil the rice and keep it aside. You can also use leftover rice from lunch in order to prepare a delicious dinner."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Chop all the veggies and keep them together on a plate."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Fry the veggies. Add 2 tbsp oil to a pan. Add chopped garlic and saute for a minute. Now add all the veggies together and fry for a few minutes (3-4 minutes)."
                ),
                Procedure(
                    steps = "Step 4",
                    procedure = "Adjust the seasoning. Now add soy sauce and vinegar. Keep on high heat and mix well. Lastly, add salt, pepper as per taste and cook for the last one minute."
                ),
                Procedure(
                    steps = "Step 5",
                    procedure = "Ready to be served. Once cooked, garnish with chopped green onions. Your vegetable fried rice is ready to be served with chilli paneer or manchurian."
                )
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FriceBalls.jpeg?alt=media&token=fcdb4abc-06d9-4f86-9c7e-08251936e90e"
        )


        val PistaBurfi = Recipe(
            name = "Pista Burfi",
            isVegetarian = true,
            cookingTime = "50 mins",
            calories = 284,
            difficulty = "Hard",
            ratings = 5.0f,
            ingredients = listOf(
                Ingredient(name = " powdered", quantity = "1/2 teaspoon"),
                Ingredient(name = "  tablespoon", quantity = "1"),
                Ingredient(name = "pista", quantity = "1 cup "),
                Ingredient(name = "sugar", quantity = "1 cup"),

                ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "  Soak pistas in warm water To prepare these delicious burfis, soak the pistachios in warm water for about 20 minutes."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Blend to form a smooth paste Drain the water and remove the skin of the pistachios.Add the pistachios and 2- 3 drops of food color in a mixer to blend them to form a smooth"
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = " Prepare sugar syrup Then, prepare a sugar syrup by dissolving the sugar in the water."
                ),
                Procedure(
                    steps = "Step 4",
                    procedure = "Mix pista pasta Add the pista paste to the sugar syrup and keep stirring. Add the cardamom powder and cook for a few minutes."
                ),
                Procedure(
                    steps = "Step 5",
                    procedure = "Let it rest Grease a plate using the ghee and spread the pista mixture on it. Allow it set for about an hour."
                ),
                Procedure(
                    steps = "Step 6",
                    procedure = "Cut into burfis Then, cut into desired shapes and garnish with the silver vark. Serve."
                )
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2Fpista-badam-barfi.jpeg?alt=media&token=7b76a73f-99d4-469f-ade3-1c8263acdbbf"
        )


        val NachoBeefDinner = Recipe(
            name = "Nacho Beef Dinner",
            isVegetarian = true,
            cookingTime = "45 mins",
            calories = 476,
            difficulty = "Medium",
            ratings = 4.5f,
            ingredients = listOf(
                Ingredient(name = " Spanish rice mix", quantity = "1 package"),
                Ingredient(name = "ground beef", quantity = "1/2 pound"),
                Ingredient(name = "water", quantity = "2 cups"),
                Ingredient(name = "canned or frozen corn ", quantity = "1 cup"),
                Ingredient(name = "canned black beans, drained and rinsed", quantity = "1 cup"),
                Ingredient(name = "tomato, chopped", quantity = "1"),
                Ingredient(name = "shredded Mexican cheese", quantity = "1 cup"),
                Ingredient(name = " sour cream tortilla chips", quantity = "1/2 cup"),

                ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "Heat a skillet over medium heat. Add the rice (reserve the seasoning packet) and ground beef. Cook, stirring frequently, until the beef is browned."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Add the water, corn, beans, and reserved seasoning packet. Bring the mixture to a boil then reduce the heat to a low simmer. Cover the skillet and cook for 15-20 minutes or until the rice is tender."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Stir in the tomatoes. Sprinkle with the shredded cheese. Cover for 1 minute to melt the cheese. Remove the pan from the heat. Top with the sour cream and serve with tortilla chips."
                )
            ),
            imageUrl = "https://cdn.cdkitchen.com/recipes/images/2016/03/108719-5100-mx.jpg"
        )


        val BananaKheer = Recipe(
            name = "Banana Kheer",
            isVegetarian = true,
            cookingTime = "20 mins",
            calories = 360,
            difficulty = "Easy",
            ratings = 4.0f,
            ingredients = listOf(
                Ingredient(name = "milk", quantity = "2 cup"),
                Ingredient(name = "mashed banana", quantity = "1 cup"),
                Ingredient(name = "cardamom powder", quantity = "1/2 tablespoon"),
                Ingredient(name = "strands kesar", quantity = "2"),
                Ingredient(name = "Jaggery powder", quantity = "as for teste"),
                Ingredient(name = " roughly chopped nuts (of your choice)", quantity = "Half cup "),
                Ingredient(name = "Sliced banana", quantity = "to garnish")

            ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = " Boil the milk on low-medium flame until it thickens."
                ),
                Procedure(
                    steps = "Step 2",
                    procedure = "Add kesar, cardamom powder and dry fruits to it. Simmer until the kesar leaves colour."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "Take mashed banana in a bowl and add the milk to it."
                ),
                Procedure(steps = "Step 4", procedure = "Garnish with sliced banana and serve.")

            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FbananaKheer.jpg?alt=media&token=9c9f39d3-cf71-4812-bf95-fa1c504dd042"
        )



        val RavaIdli  = Recipe(
            name = "RavaIdli ",
            isVegetarian = true,
            cookingTime = "40 mins",
            calories = 476,
            difficulty = "Medium",
            ratings = 4.5f,
            ingredients = listOf(
                Ingredient(name = "Rava (suji / semolina)", quantity = "1 cup"),
                Ingredient(name = "Mustard Seeds", quantity = "1/2  tablespoons"),
                Ingredient(name = " Cumin Seeds", quantity = "1/2 tablespoons"),
                Ingredient(name = " Asafoetida (hing)", quantity = "1 pinch"),
                Ingredient(name = " Chana Dal (gram dal)", quantity = "1 tablespoon"),
                Ingredient(name = "Urad Dal (black split lentils without husk)", quantity = "1 teaspoons"),
                Ingredient(name = "sprigs Curry Leaves", quantity = "1 or 2"),
                Ingredient(name = "Dry Red Chilli", quantity = "1"),
                Ingredient(name = "Cashew Nuts, broken into pieces", quantity = "7"),
                Ingredient(name = "Thick Yogurt (curd)", quantity = "2 cup"),
                Ingredient(name = "grated Carrot", quantity = "1/2 cup"),
                Ingredient(name = "Green Chillies, finely chopped", quantity = "2"),
                Ingredient(name = "grated Ginger",quantity = "1 tablespoons "),
                Ingredient(name = "Water",quantity = "2 cup"),
                Ingredient(name = "finely chopped Coriander Leaves",quantity = "2 tablespoon"),
                Ingredient(name = "Eno Fruit Salt",quantity = "1 tablespoons"),
                Ingredient(name = "Oil",quantity = "1 tablespoons"),
                Ingredient(name = "Ghee",quantity = "1 tablespoons"),
                Ingredient(name = "salt",quantity = " add"),

                ),
            procedure = listOf(
                Procedure(steps = "Step 1", procedure = "Heat 1/2 tablespoon ghee and 1 tablespoon oil in a heavy based pan or kadai. Add mustard seeds; when they start to crackle, add cumin seeds, asafoetida, chana dal and urad dal. Sauté until dal turns light brown. Add curry leaves, dry red chilli and cashew nuts and sauté for 30-40 seconds."),
                Procedure(steps = "Step 2", procedure = "Add rava (semolina) and mix well."),
                Procedure(steps = "Step 3", procedure = "Roast it on medium flame until it turns light brown, stirring continuously. Make sure that it does not burn. Turn off the flame and transfer it to a plate. Allow it to cool for 7-8 minutes."),
                Procedure(steps = "Step 4", procedure = "Prepare a mixture of curd, chopped green chillies, grated ginger and salt in a large bowl.\n"),
                Procedure(steps = "Step 5", procedure = "Add roasted rava and (1 cup + 2 tablespoons) water and mix well. Make sure that there are no lumps."),
                Procedure(steps = "Step 6", procedure = "Add grated carrot and chopped coriander leaves and mix properly. Keep batter aside for 15 minutes to settle."),
                Procedure(steps = "Step 7", procedure = "Pour 2 glasses water in steamer and heat over medium flame. Grease Idli molds (plates) with oil. Add Eno fruit salt in batter and stir for a minute.\n"),
                Procedure(steps = "Step 8", procedure = "After adding eno, you will notice bubbles on the surface of a batter."),
                Procedure(steps = "Step 9", procedure = "Pour batter in greased molds and steam it on medium flame for 10-15 minutes. Do not steam it on very high or very low flame.\n"),
                Procedure(steps = "Step 10", procedure = "After 15 minutes, turn off flame and remove molds from steamer. When it cools down a bit, remove prepared idli from it."),
                Procedure(steps = "Step 11", procedure = "Instant rawa idli is ready, serve with coconut chutney."),
            ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/cookit-2da6c.appspot.com/o/Images%2Frava-idli-recipe.jpg?alt=media&token=1df5aa10-5266-4956-a0a6-3beea3863437&_gl=1*jw9mm2*_ga*MTI3NjQ5NTA1MS4xNjg2MTE4MTA2*_ga_CW55HF8NVT*MTY4NjExODEwNi4xLjEuMTY4NjEyMTEyOC4wLjAuMA.."
        )



        val BreakfastPizza = Recipe(
            name = "Breakfast Pizza",
            isVegetarian = false,
            cookingTime = "20 mins",
            calories = 360,
            difficulty = "Easy",
            ratings = 4.0f,
            ingredients = listOf(
                Ingredient(name = "shredded sweet potato", quantity = "3 cup"),
                Ingredient(name = "eggs, whisked (for binding crust)", quantity = "2"),
                Ingredient(name = "garlic powder", quantity = "1/2 tablespoon"),
                Ingredient(name = "onion powder", quantity = "2 tablespoon"),
                Ingredient(name = "Italian seasoning", quantity = "1/2 tablespoons"),
                Ingredient(name = "ground Italian sausage", quantity = "1/3 pound"),
                Ingredient(name = "diced onion", quantity = "1/3  cup"),
                Ingredient(name = "broccoli", quantity = "1/3  cup"),
                Ingredient(name = "sliced cherry tomatoes", quantity = "1/3  cup"),
                Ingredient(name = "fresh eggs (for topping pizza)", quantity = "4"),

                ),
            procedure = listOf(
                Procedure(
                    steps = "Step 1",
                    procedure = "Preheat oven to 350ºF. Lightly grease a pizza pan."
                ),


                Procedure(
                    steps = "Step 2",
                    procedure = "Mix eggs, potatoes, and the seasonings (garlic powder, onion powder, Italian seasoning, and a little salt and pepper) together in a small bowl. Use the mixture to form a \"crust\" by spreading it out by hand in the center of the pizza pan to create a flat round shape about 9\"-10\" in diameter and around 1/4\" thick."
                ),
                Procedure(
                    steps = "Step 3",
                    procedure = "First just bake the crust by itself in the oven at 350ºF for 20-25 minutes."
                ),
                Procedure(steps = "Step 4", procedure = "While the crust is baking, sauté the onions in a stovetop skillet over medium heat for 3-4 minutes. Next add the sausage to the same skillet with the onion and cook until sausage is browned."),

                Procedure(
                    steps = "Step 5",
                    procedure = "Remove pan with the crust from the oven after 20-25 minutes and top with the onion/sausage mixture. Next add the tomatoes and broccoli. Finally crack one fresh egg on top of each quarter section of the breakfast pizza."
                ),
                Procedure(
                    steps = "Step 6",
                    procedure = "Slide breakfast pizza into the 350ºF oven and bake about 15 minutes, or just until eggs on top are cooked through – avoid overcooking the eggs! Slice, plate and enjoy! Serves 4."
                ),

                ),
            imageUrl = "https://firebasestorage.googleapis.com/v0/b/cookit-2da6c.appspot.com/o/Images%2FPaleo%20and%20Gluten-Free%20Breakfast%20Pizza.jpg?alt=media&token=378f98ab-8f28-420f-a04b-a544fb27cc2a&_gl=1*kg4652*_ga*MTI3NjQ5NTA1MS4xNjg2MTE4MTA2*_ga_CW55HF8NVT*MTY4NjExODEwNi4xLjEuMTY4NjEyMjYyNC4wLjAuMA.."
        )
        // Add the recipe to the database

        dbHelper.addRecipe(ChickenCurry)
        dbHelper.addRecipe(VegFriedRice)
        dbHelper.addRecipe(Casserole)
        dbHelper.addRecipe(IdliBatter)
        dbHelper.addRecipe(MasalaDosa)
        dbHelper.addRecipe(Pakundalu)
        dbHelper.addRecipe(PaladaPradhaman)
        dbHelper.addRecipe(KadhaiGobhi)
        dbHelper.addRecipe(RiceBalls)
        dbHelper.addRecipe(PistaBurfi)
        dbHelper.addRecipe(NachoBeefDinner)
        dbHelper.addRecipe(BananaKheer)
        dbHelper.addRecipe(RavaIdli)
        dbHelper.addRecipe(BreakfastPizza)
    }
}
