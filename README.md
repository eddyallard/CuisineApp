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

    {"recipeNameSubStr": "your_recipe_substring"}

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

### Get a user with an Id

* **URL**

    <_/api/user/{id}_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "userId": 1,
    "userName": "Jean-Guy",
    "email": "harrypotter@poudlard.ca",
    "userPassword": "pass"
}`

### Get a ingredients owned by a user with their quantity

* **URL**

    <_/api/user/ingredient/{id}_>

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

### Find an ingredient by name

* **URL**

    <_/api/ingredient/find_>

* **Request Type**

    `GET`

* **Data Params**

    {"ingredientNameSubStr": "your_ingredient_substring"}

    _The input is not case sensitive._
* **Success Response:**

  * **Code:** 200 <br />

    **Content:** `[
    {
        "ingredientId": 4,
        "ingredientName": "chicken breast",
        "measureType": "g."
    },
    {
        "ingredientId": 34,
        "ingredientName": "chicken broth",
        "measureType": "unit"
    }
]`

### Get votes for a recipe

* **URL**

    <_/api/vote/{recipeId}_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `[
    {
        "userId": 2,
        "recipeId": 7,
        "voteValue": 1
    }
]`

### Add a recipe

* **URL**

    <_/api/recipe_>

* **Request Type**

    `POST`

* **Data Params**

{
            "recipeName": "Alfredo Pasta","recipeInstruction": "How to do alfredo.", "authorId": 2
        }
    
 _Do not include an id, it will be handled by the database._

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "recipeId": 9,
    "recipeName": "Alfredo Pasta",
    "recipeInstruction": "How to do alfredo.",
    "authorId": 2
}`

###  Add a recipe ingredient

* **URL**

    <_/api/recipe/ingredient_>

* **Request Type**

    `POST`

* **Data Params**

{
    "recipeId": 9,
    "ingredientId": 5,
    "quantiy": 3
}

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "recipeId": 9,
    "ingredientId": 5,
    "quantiy": 3
}`

### Add a user

* **URL**

    <_/api/user_>

* **Request Type**

    `POST`

* **Data Params**

{
    "userName": "Felix",
    "email": "felix@jmail.com",
    "userPassword": "qwerty"
}
    
 _Do not include an id, it will be handled by the database._

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "userId": 4,
    "userName": "Felix",
    "email": "felix@jmail.com",
    "userPassword": "qwerty"
}`

###  Add a user ingredient

* **URL**

    <_/api/user/ingredient_>

* **Request Type**

    `POST`

* **Data Params**

{
    "userId": 2,
    "ingredientId": 5,
    "quantiy": 12
}

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "userId": 2,
    "ingredientId": 5,
    "quantiy": 12
}`

### Add a vote

* **URL**

    <_/api/vote_>

* **Request Type**

    `POST`

* **Data Params**

{
    "recipeId": 9,
    "userId": 4,
    "voteValue": -1
}

_Value must be 1 or -1 for upvote or downvote, this method also acts as a `PUT` because you can use it to update the vote value._

 _Do not include an id, it will be handled by the database._

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** `{
    "recipeId": 9,
    "userId": 4,
    "voteValue": -1
}`

_Note that a user cannot vote twice for the same recipe, this is handled internally. If you receive an empty response, it means you were trying to submit the same vote twice, or that your vote value isn't valid._
    