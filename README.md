# CuisineApp
## API DOCUMENTATION

### Get a recipe with an Id

* **URL**

    <_/api/recipe/{id}_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "recipeId": 12,
    "recipeName": "Barbecue Chicken",
    "recipeInstruction": "How to do Barbecue Chicken",
    "authorId": 2
}`

### Get all recipes

* **URL**

    <_/api/recipe_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "recipeId": 1,
        "recipeName": "Chicken Soup",
        "recipeInstruction": "How to do chicken soup.",
        "authorId": 2
    },
    {
        "recipeId": 2,
        "recipeName": "Pancakes",
        "recipeInstruction": "How to make pancackes.",
        "authorId": 3
    }
    ]`

### Find a recipe by name

* **URL**

    <_/api/recipe/find_>

* **Request Type**

    `GET`

* **Data Params**

    {"recipeNameSubStr": "Chicken"}

    _The input is not case sensitive._
* **Success Response:**

  * **Code:** 200 <br />

    **Content:** `[
    {
        "recipeId": 1,
        "recipeName": "Chicken Soup",
        "recipeInstruction": "How to do chicken soup.",
        "authorId": 2
    }
    ]`

### Get a ingredients in recipe with their quantity

* **URL**

    <_/api/recipe/ingredient/{recipeId}_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "ingredientDTO": {
            "ingredientId": 1,
            "ingredientName": "flour",
            "measureType": "g."
        },
        "quantity": 150.0
    },
    {
        "ingredientDTO": {
            "ingredientId": 2,
            "ingredientName": "egg",
            "measureType": "unit"
        },
        "quantity": 1.0
    },
    {
        "ingredientDTO": {
            "ingredientId": 4,
            "ingredientName": "chicken breast",
            "measureType": "g."
        },
        "quantity": 650.0
    }
]`

### Get all recipes sorted by their vote count with their vote count

* **URL**

    <_/api/recipe/sorted_by_vote_with_vote_count_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "recipeDTO": {
            "recipeId": 1,
        "recipeName": "Chicken Soup",
        "recipeInstruction": "How to do chicken soup.",
        "authorId": 2
        },
        "voteCount": 2
    },
    {
        "recipeDTO": {
            "recipeId": 2,
        "recipeName": "Pancakes",
        "recipeInstruction": "How to make pancackes.",
        "authorId": 3
        },
        "voteCount": 1
    }
]`