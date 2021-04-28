# CuisineApp
### _Access API on https://cuisinas.herokuapp.com/_
## SECURITY

The API is secured. To use it, you must go through these steps, otherwise you will get a 403 error.
1. Sign up [View API Documentation](#add-a-user).
1. Log in [View API Documentation](#login).
1. Fetch the bearer token contained in the header of the log in response.
1. Put that token in every following request to the API.

## API DOCUMENTATION

### Get a recipe with an Id

* **URL**

    <_/api/recipe/{id}_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**    
    `{
    "recipeId": 12,
    "recipeName": "Barbecue Chicken",
    "recipeInstruction": "How to do Barbecue Chicken",
    "authorId": 2
}`

* **Error Response:**

    * **Code:** 404 NOT FOUND  <br />

### Get all recipes

* **URL**

    <_/api/recipe_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**    
    `[
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

* **URL Params**

    `recipeNameSubStr=[string]`

    _The input is not case sensitive._
* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `[
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
    **Content:**    
    `[
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
    **Content:**    
    `[
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

### Get current user

* **URL**

    <_/api/user/self_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**    
    `{
    "userId": 1,
    "userName": "Jean-Guy",
    "email": "harrypotter@poudlard.ca",
    "userPassword": "pass",
    "roles": "",
    "permissions": "",
    "active": false
}`

### Get a user with an Id

* **URL**

    <_/api/user/{id}_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**    
    `{
    "userId": 1,
    "userName": "Jean-Guy",
    "email": "harrypotter@poudlard.ca",
    "userPassword": "pass",
    "roles": "",
    "permissions": "",
    "active": false
}`

### Get a ingredients owned by a user with their quantity

* **URL**

    <_/api/user/ingredient/{id}_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />
    **Content:**    
    `[
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

### Find all ingredients

* **URL**

    <_/api/ingredient_>

* **Request Type**

    `GET`

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
     `[
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

### Find an ingredient by name

* **URL**

    <_/api/ingredient/find_>

* **Request Type**

    `GET`

* **URL Params**

    `ingredientNameSubStr=[string]`

    _The input is not case sensitive._
* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
     `[
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
    **Content:**    
     `[
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
    **Content:**    
     `{
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
    **Content:**    
    `{
    "recipeId": 9,
    "ingredientId": 5,
    "quantiy": 3
    }`

### Add a user

* **URL**

    <_/api/user/signup_>

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
    **Content:**    
    `{
    "userId": 4,
    "userName": "Felix",
    "email": "felix@jmail.com",
    "userPassword": "qwerty"
}`

### Login

* **URL**

    <_/api/user/login_>

* **Request Type**

    `POST`

* **Data Params**

    {
    "username": "Felix",
    "password": "qwerty"
}


* **Success Response:**

  * **Code:** 200 <br />


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
    **Content:**    
    `{
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
    **Content:**    
    `{
    "recipeId": 9,
    "userId": 4,
    "voteValue": -1
}`

* **Error Response:**

    * **Code:** 400 BAD REQUEST  <br />

    _Note that a user cannot vote twice for the same recipe, this is handled internally. If you receive a `400 BAD REQUEST`, it means you were trying to submit the same vote twice, or that your vote value isn't valid(either -1 or 1)._

### Update recipe name

* **URL**

    <_/api/recipe/name/{id}_>

* **Request Type**

    `PUT`

* **Data Params**

    {"newName": "your_new_recipe_name"}

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `{
        "recipeId": 1,
        "recipeName": "your_new_recipe_name",
        "recipeInstruction": "How to do chicken soup.",
        "authorId": 2
    }`

* **Error Response:**

    * **Code:** 404 NOT FOUND  <br />

### Update recipe instruction

* **URL**

    <_/api/recipe/instruction/{id}_>

* **Request Type**

    `PUT`

* **Data Params**

    {"newInstruction": "your_new_recipe_instruction"}

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `{
        "recipeId": 1,
        "recipeName": "Chicken Soup",
        "recipeInstruction": "your_new_recipe_instruction",
        "authorId": 2
    }`

* **Error Response:**

    * **Code:** 404 NOT FOUND  <br />

### Update recipe ingredient quantity

* **URL**

    <_/api/recipe/ingredient>

* **Request Type**

    `PUT`

* **Data Params**

    {
    "recipeId": 9,
    "ingredientId": 5,
    "quantiy": 5
    }

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `{
    "recipeId": 9,
    "ingredientId": 5,
    "quantiy": 5
    }`

    _Note, if nothing is returned, your RecipeIngredient was not found._

* **Error Response:**

    * **Code:** 404 NOT FOUND  <br />

### Update user password

* **URL**

    <_/api/user/password/{id}_>

* **Request Type**

    `PUT`

* **Data Params**

    {"newPassword": "your_new_user_password"}

    _The input is not case sensitive._
* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `{
    "userId": 4,
    "userName": "Felix",
    "email": "felix@jmail.com",
    "userPassword": "your_new_user_password"
    "roles": "",
    "permissions": "",
    "active": false
}`

* **Error Response:**

    * **Code:** 404 NOT FOUND  <br />

### Update user ingredient quantity

* **URL**

    <_/api/user/ingredient>

* **Request Type**

    `PUT`

* **Data Params**

    {
    "userId": 9,
    "ingredientId": 5,
    "quantiy": 5
    }

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `{
    "userId": 9,
    "ingredientId": 5,
    "quantiy": 5
    }`

    _Note, if nothing is returned, your UserIngredient was not found._

* **Error Response:**

    * **Code:** 404 NOT FOUND  <br />

### Delete user ingredient

* **URL**

    <_/api/user/ingredient_>


* **URL Params**

    `userId=[int]`
    `ingredientId=[int]`

* **Request Type**

    `DELETE`

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `User Ingredient Deleted Successfully`

### Delete user

* **URL**

    <_/api/user/{userId}_>

* **Request Type**

    `DELETE`

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `User Deleted Successfully`
   
### Delete recipe ingredient

* **URL**

    <_/api/recipe/ingredient_>


* **URL Params**

    `recipeId=[int]`
    `ingredientId=[int]`

* **Request Type**

    `DELETE`

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `Recipe Ingredient Deleted Successfully`
    
### Delete recipe

* **URL**

    <_/api/recipe/{recipeId}_>

* **Request Type**

    `DELETE`

* **Success Response:**

  * **Code:** 200 <br />

    **Content:**    
    `Recipe Deleted Successfully`
