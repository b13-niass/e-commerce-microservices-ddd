-- Insérer les catégories
INSERT INTO category (id, description, name)
VALUES
    (nextval('category_seq'), 'Produits électroniques de haute qualité', 'Électronique'),
    (nextval('category_seq'), 'Articles pour la maison et cuisine', 'Maison et Cuisine'),
    (nextval('category_seq'), 'Vêtements et accessoires de mode', 'Mode'),
    (nextval('category_seq'), 'Produits de beauté et santé', 'Beauté et Santé'),
    (nextval('category_seq'), 'Équipements pour le sport et les loisirs', 'Sport et Loisirs');

-- Insérer les produits pour chaque catégorie
INSERT INTO product (id, description, name, available_quantity, price, category_id)
VALUES
    -- Produits pour Électronique
    (nextval('product_seq'), 'Un smartphone dernier cri avec 128Go de stockage', 'Smartphone', 50, 799.99, currval('category_seq') - 200),
    (nextval('product_seq'), 'Laptop performant pour le travail et les loisirs', 'Laptop', 30, 1200.00, currval('category_seq') - 200),
    (nextval('product_seq'), 'Casque audio sans fil avec réduction de bruit', 'Casque Audio', 100, 199.99, currval('category_seq') - 200),
    (nextval('product_seq'), 'Télévision 4K UHD 55 pouces', 'Télévision', 20, 599.99, currval('category_seq') - 200),
    (nextval('product_seq'), 'Montre connectée avec suivi de santé', 'Montre Connectée', 40, 149.99, currval('category_seq') - 200),

    -- Produits pour Maison et Cuisine
    (nextval('product_seq'), 'Mixeur multifonction pour préparer vos repas', 'Mixeur', 60, 49.99, currval('category_seq') - 150),
    (nextval('product_seq'), 'Grille-pain avec 6 niveaux de brunissage', 'Grille-pain', 80, 29.99, currval('category_seq') - 150),
    (nextval('product_seq'), 'Aspirateur sans sac, puissant et léger', 'Aspirateur', 15, 89.99, currval('category_seq') - 150),
    (nextval('product_seq'), 'Poêle à frire antiadhésive 28 cm', 'Poêle à Frire', 100, 19.99, currval('category_seq') - 150),
    (nextval('product_seq'), 'Robot de cuisine compact et polyvalent', 'Robot de Cuisine', 25, 129.99, currval('category_seq') - 150),

    -- Produits pour Mode
    (nextval('product_seq'), 'T-shirt en coton pour un confort optimal', 'T-shirt', 200, 9.99, currval('category_seq') - 100),
    (nextval('product_seq'), 'Jeans slim pour un style moderne', 'Jeans', 150, 39.99, currval('category_seq') - 100),
    (nextval('product_seq'), 'Chaussures de sport légères et confortables', 'Chaussures', 100, 59.99, currval('category_seq') - 100),
    (nextval('product_seq'), 'Sac à main élégant en cuir', 'Sac à Main', 50, 79.99, currval('category_seq') - 100),
    (nextval('product_seq'), 'Montre classique avec bracelet en acier', 'Montre', 75, 129.99, currval('category_seq') - 100),

    -- Produits pour Beauté et Santé
    (nextval('product_seq'), 'Rouge à lèvres hydratant et longue tenue', 'Rouge à Lèvres', 150, 14.99, currval('category_seq') - 50),
    (nextval('product_seq'), 'Crème hydratante pour une peau douce', 'Crème Hydratante', 120, 19.99, currval('category_seq') - 50),
    (nextval('product_seq'), 'Shampooing réparateur pour cheveux secs', 'Shampooing', 80, 7.99, currval('category_seq') - 50),
    (nextval('product_seq'), 'Parfum frais et élégant', 'Parfum', 50, 49.99, currval('category_seq') - 50),
    (nextval('product_seq'), 'Brosse à dents électrique rechargeable', 'Brosse à Dents Électrique', 100, 24.99, currval('category_seq') - 50),

    -- Produits pour Sport et Loisirs
    (nextval('product_seq'), 'Vélo tout terrain robuste et léger', 'Vélo', 10, 499.99, currval('category_seq')),
    (nextval('product_seq'), 'Ballon de football résistant', 'Ballon de Football', 200, 19.99, currval('category_seq')),
    (nextval('product_seq'), 'Tapis de yoga antidérapant', 'Tapis de Yoga', 100, 29.99, currval('category_seq')),
    (nextval('product_seq'), 'Haltères ajustables pour un entraînement complet', 'Haltères', 50, 99.99, currval('category_seq')),
    (nextval('product_seq'), 'Raquette de tennis légère et performante', 'Raquette de Tennis', 30, 149.99, currval('category_seq'));
