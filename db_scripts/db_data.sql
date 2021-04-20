INSERT INTO Ingredient(IngredientName,measureType)
VALUES('flour', 'g.'),
('egg','unit'),
('milk','ml.'),
('chicken breast','g.'),
('garlic clove','unit'),
('sugar','g.'),
('salt','g.'),
('rice','g.'),
('vegetable oil','ml.'),
('ham','unit'),
('beef steak','unit'),
('ginger','g.'),
('cheddar cheese','g.'),
('mozzarella cheese','g.'),
('scallions','g.'),
('tofu','g.'),
('carrot','unit'),
('brocoli','unit'),
('honey', 'ml.'),
('mustard', 'ml.'),
('soy sauce','ml.'),
('pepper','g.'),
('orange', 'unit'),
('whole turkey' , 'unit'),
('white onion','unit'),
('corn cob','unit'),
('mayonnaise','ml.'),
('common mushroom','unit'),
('lemon','unit'),
('beet', 'unit'),
('turnip','unit'),
('shrimp','g.'),
('tomato','unit'),
('chicken broth','unit'),
('almonds','g.');

INSERT INTO User(UserName, email, UserPassword, Roles, Permissions, Active)
VALUES ("Jean Guy", "jeanguy@jmail.ca", "qwerty", "", "", false),
("Pierre Paul", "ppaul@coldmail.com", "soleil123", "", "", false),
("Arsène Lupin", "gentleman@cambrioleur.fr", "password", "", "", false),
("François Legault", "legault@aweilleamaison.qc.ca", "horacio", "", "", false);

INSERT INTO Recipe(RecipeName, RecipeInstruction, UserId)
VALUES ("Chat farci", "Prendre une farce et la mettre dans le chat.", 1),
("Poulet aux saveurs", "Faire cuire le poulet dans toutes les saveurs.", 2),
("Tarte aux pommes", "Prendre les pommes et les mettre dans la tarte.", 4);

INSERT INTO RecipeIngredient(IngredientId, RecipeId, Quantity)
VALUES (1,1,2), (4,1,60), (31,1,76), (1,2,2), (6,2,60), (27,2,76), (26,3,1300);

INSERT INTO UserIngredient(IngredientId, UserId, Quantity)
VALUES (10,4,2), (14,1,60), (3,1,76), (11,2,2), (16,2,60), (7,2,76), (6,3,1300);

INSERT INTO Vote(UserId, RecipeId, VoteValue)
VALUES (1,1,1), (2,1,1), (4,2,-1);