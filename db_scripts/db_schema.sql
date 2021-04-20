USE school;

DROP TABLE IF EXISTS Vote;
DROP TABLE IF EXISTS UserIngredient;
DROP TABLE IF EXISTS RecipeIngredient;
DROP TABLE IF EXISTS  Recipe;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS  Ingredient;

CREATE table User (
	UserId int NOT NULL AUTO_INCREMENT primary key,
    UserName varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    UserPassword varchar(255) NOT NULL,
    Roles varchar(50),
    Permissions varchar(50),
    Active bool
);

CREATE table Recipe (
	RecipeId int NOT NULL AUTO_INCREMENT primary key,
    RecipeName varchar(50),
    RecipeInstruction varchar(1000),
    UserId int,
    foreign key(UserId) REFERENCES User(UserId)
);

CREATE table Ingredient (
	IngredientId int NOT NULL AUTO_INCREMENT primary key,
    IngredientName varchar(50),
    measureType ENUM('g.','ml.','unit')
);

CREATE table RecipeIngredient (
	IngredientId int NOT NULL,
    RecipeId int NOT NULL,
    Quantity float,
    primary key(IngredientId, RecipeId),
    foreign key(IngredientId) REFERENCES Ingredient(IngredientId) ON DELETE CASCADE,
    foreign key(RecipeId) REFERENCES Recipe(RecipeId) ON DELETE CASCADE
);

CREATE table UserIngredient (
	IngredientId int NOT NULL,
    UserId int NOT NULL,
    Quantity float,
    primary key(IngredientId, UserId),
    foreign key(IngredientId) REFERENCES Ingredient(IngredientId) ON DELETE CASCADE,
    foreign key(UserId) REFERENCES User(UserId) ON DELETE CASCADE
);

CREATE table Vote (
	UserId int NOT NULL,
    RecipeId int NOT NULL,
    VoteValue int NOT NULL default 0,
    primary key(UserId, RecipeId),
    foreign key(UserId) REFERENCES User(UserId) ON DELETE CASCADE,
    foreign key(RecipeId) REFERENCES Recipe(RecipeId) ON DELETE CASCADE
);