package com.example.cookit.DbHelper

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.cookit.model.Ingredient
import com.example.cookit.model.Procedure
import com.example.cookit.model.Recipe

class RecipeDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "CookItRecipes.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "recipes"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_VEGETARIAN = "vegetarian"
        private const val COLUMN_COOKING_TIME = "cooking_time"
        private const val COLUMN_CALORIES = "calories"
        private const val COLUMN_DIFFICULTY = "difficulty"
        private const val COLUMN_RATINGS = "ratings"
        private const val COLUMN_IMAGE_URL = "image_url"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createRecipesTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAME TEXT," +
                "$COLUMN_VEGETARIAN INTEGER," +
                "$COLUMN_COOKING_TIME TEXT," +
                "$COLUMN_CALORIES INTEGER," +
                "$COLUMN_DIFFICULTY TEXT," +
                "$COLUMN_RATINGS REAL," +
                "$COLUMN_IMAGE_URL TEXT" +
                ")"
        db?.execSQL(createRecipesTableQuery)

        val createIngredientsTableQuery = "CREATE TABLE ingredients (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "recipe_id INTEGER," +
                "name TEXT," +
                "quantity TEXT" +
                ")"
        db?.execSQL(createIngredientsTableQuery)

        val createProceduresTableQuery = "CREATE TABLE procedures (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "recipe_id INTEGER," +
                "steps TEXT," +
                "procedure TEXT" +
                ")"
        db?.execSQL(createProceduresTableQuery)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addRecipe(recipe: Recipe) {
        val db = writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, recipe.name)
        values.put(COLUMN_VEGETARIAN, if (recipe.isVegetarian) 1 else 0)
        values.put(COLUMN_COOKING_TIME, recipe.cookingTime)
        values.put(COLUMN_CALORIES, recipe.calories)
        values.put(COLUMN_DIFFICULTY, recipe.difficulty)
        values.put(COLUMN_RATINGS, recipe.ratings)
        values.put(COLUMN_IMAGE_URL, recipe.imageUrl)
        val recipeId = db.insert(TABLE_NAME, null, values)

        for (ingredient in recipe.ingredients) {
            val ingredientValues = ContentValues()
            ingredientValues.put("recipe_id", recipeId)
            ingredientValues.put("name", ingredient.name)
            ingredientValues.put("quantity", ingredient.quantity)
            db.insert("ingredients", null, ingredientValues)
        }

        for (procedure in recipe.procedure) {
            val procedureValues = ContentValues()
            procedureValues.put("recipe_id", recipeId)
            procedureValues.put("steps", procedure.steps)
            procedureValues.put("procedure", procedure.procedure)
            db.insert("procedures", null, procedureValues)
        }

        db.close()
    }

    @SuppressLint("Range")
    fun getAllRecipes(): ArrayList<Recipe> {
        val recipes = ArrayList<Recipe>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val recipeId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val recipeName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val isVegetarian = cursor.getInt(cursor.getColumnIndex(COLUMN_VEGETARIAN)) == 1
                val cookingTime = cursor.getString(cursor.getColumnIndex(COLUMN_COOKING_TIME))
                val calories = cursor.getInt(cursor.getColumnIndex(COLUMN_CALORIES))
                val difficulty = cursor.getString(cursor.getColumnIndex(COLUMN_DIFFICULTY))
                val ratings = cursor.getFloat(cursor.getColumnIndex(COLUMN_RATINGS))
                val imageUrl = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_URL))

                val ingredients = getIngredientsForRecipe(recipeId)
                val procedure = getProcedureForRecipe(recipeId)

                val recipe = Recipe(
                    name = recipeName,
                    isVegetarian = isVegetarian,
                    cookingTime = cookingTime,
                    calories = calories,
                    difficulty = difficulty,
                    ratings = ratings,
                    ingredients = ingredients,
                    procedure = procedure,
                    imageUrl = imageUrl
                )
                recipes.add(recipe)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return recipes
    }

    @SuppressLint("Range")
    private fun getIngredientsForRecipe(recipeId: Int): List<Ingredient> {
        val ingredients = ArrayList<Ingredient>()
        val db = readableDatabase
        val query = "SELECT * FROM ingredients WHERE recipe_id = $recipeId"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val name = cursor.getString(cursor.getColumnIndex("name"))
                val quantity = cursor.getString(cursor.getColumnIndex("quantity"))
                val ingredient = Ingredient(name, quantity)
                ingredients.add(ingredient)
            } while (cursor.moveToNext())
        }

        cursor.close()

        return ingredients
    }

    @SuppressLint("Range")
    private fun getProcedureForRecipe(recipeId: Int): List<Procedure> {
        val procedure = ArrayList<Procedure>()
        val db = readableDatabase
        val query = "SELECT * FROM procedures WHERE recipe_id = $recipeId"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val steps = cursor.getString(cursor.getColumnIndex("steps"))
                val procedureText = cursor.getString(cursor.getColumnIndex("procedure"))
                val stepProcedure = Procedure(steps, procedureText)
                procedure.add(stepProcedure)
            } while (cursor.moveToNext())
        }

        cursor.close()

        return procedure
    }


    @SuppressLint("Range")
    fun getRecipeByName(recipeName: String): Recipe? {
        val db = readableDatabase
        val selection = "$COLUMN_NAME = ?"
        val selectionArgs = arrayOf(recipeName)
        val cursor = db.query(
            TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
        )

        var recipe: Recipe? = null

        if (cursor.moveToFirst()) {
            val recipeId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
            val isVegetarian = cursor.getInt(cursor.getColumnIndex(COLUMN_VEGETARIAN)) == 1
            val cookingTime = cursor.getString(cursor.getColumnIndex(COLUMN_COOKING_TIME))
            val calories = cursor.getInt(cursor.getColumnIndex(COLUMN_CALORIES))
            val difficulty = cursor.getString(cursor.getColumnIndex(COLUMN_DIFFICULTY))
            val ratings = cursor.getFloat(cursor.getColumnIndex(COLUMN_RATINGS))
            val imageUrl = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_URL))

            val ingredients = getIngredientsForRecipe(recipeId)
            val procedure = getProcedureForRecipe(recipeId)

            recipe = Recipe(
                name = recipeName,
                isVegetarian = isVegetarian,
                cookingTime = cookingTime,
                calories = calories,
                difficulty = difficulty,
                ratings = ratings,
                ingredients = ingredients,
                procedure = procedure,
                imageUrl = imageUrl
            )
        }

        cursor.close()
        db.close()

        return recipe
    }


    @SuppressLint("Range")
    fun searchRecipes(query: String): ArrayList<Recipe> {
        val recipes = ArrayList<Recipe>()
        val db = readableDatabase

        // Prepare the SQL query with a LIKE clause to search for recipes matching the query
        val searchQuery = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_NAME LIKE '%$query%'"
        val cursor = db.rawQuery(searchQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val recipeId = cursor.getInt(cursor.getColumnIndex(COLUMN_ID))
                val recipeName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val isVegetarian = cursor.getInt(cursor.getColumnIndex(COLUMN_VEGETARIAN)) == 1
                val cookingTime = cursor.getString(cursor.getColumnIndex(COLUMN_COOKING_TIME))
                val calories = cursor.getInt(cursor.getColumnIndex(COLUMN_CALORIES))
                val difficulty = cursor.getString(cursor.getColumnIndex(COLUMN_DIFFICULTY))
                val ratings = cursor.getFloat(cursor.getColumnIndex(COLUMN_RATINGS))
                val imageUrl = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_URL))

                val ingredients = getIngredientsForRecipe(recipeId)
                val procedure = getProcedureForRecipe(recipeId)

                val recipe = Recipe(
                    name = recipeName,
                    isVegetarian = isVegetarian,
                    cookingTime = cookingTime,
                    calories = calories,
                    difficulty = difficulty,
                    ratings = ratings,
                    ingredients = ingredients,
                    procedure = procedure,
                    imageUrl = imageUrl
                )
                recipes.add(recipe)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return recipes
    }


}
