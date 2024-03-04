BEGIN;

CREATE TABLE IF NOT EXISTS method(
    id SERIAL NOT NULL PRIMARY KEY,
    method_level text NOT NULL,
    method_type text NOT NULL,
    method_originality text NOT NULL
);

CREATE TABLE IF NOT EXISTS human(
    id SERIAL NOT NULL PRIMARY KEY,
    method_id INT REFERENCES method(id),
    human_name text NOT NULL,
    human_state text NOT NULL,
    human_eye_direction text NOT NULL
);

CREATE TABLE IF NOT EXISTS object(
    id SERIAL NOT NULL PRIMARY KEY,
    human_id INT REFERENCES human(id),
    object_name text NOT NULL,
    object_form text NOT NULL
);

CREATE TABLE IF NOT EXISTS conclusion(
    id SERIAL NOT NULL PRIMARY KEY,
    method_id INT REFERENCES method(id),
    conclusion_time text NOT NULL,
    conclusion_result BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS verification(
    id SERIAL NOT NULL PRIMARY KEY,
    conclusion_id INT REFERENCES conclusion(id),
    verification_time text NOT NULL,
    verification_state BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS meal(
    id SERIAL NOT NULL PRIMARY KEY,
    conclusion_id INT REFERENCES conclusion(id),
    meal_name text NOT NULL,
    meal_color text NOT NULL,
    meal_form text NOT NULL,
    meal_density text NOT NULL,
    meal_size text NOT NULL,
    meal_taste text NOT NULL
);

CREATE TABLE IF NOT EXISTS disease(
    id SERIAL NOT NULL PRIMARY KEY,
    meal_id INT REFERENCES meal(id),
    disease_name text NOT NULL,
    disease_state BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS question(
    id SERIAL NOT NULL PRIMARY KEY,
    meal_id INT REFERENCES meal(id),
    question_text text NOT NULL
);

INSERT INTO method(method_level, method_type, method_originality)
    VALUES ('первоклассную', 'абстрактного', 'поистине');

INSERT INTO human(method_id, human_name, human_state, human_eye_direction)
    VALUES ('1', 'unk', 'Смотрящий', 'на Луну');

INSERT INTO object(human_id, object_name, object_form)
    VALUES ('1', 'Луна', 'Круг');

INSERT INTO conclusion(method_id, conclusion_time, conclusion_result)
    VALUES ('1', '3-4 минуты', TRUE);

INSERT INTO verification(conclusion_id, verification_state, verification_time)
    VALUES ('1', TRUE, 'немедленно');

INSERT INTO meal(conclusion_id, meal_name, meal_color, meal_form, meal_density, meal_size, meal_taste)
    VALUES ('1', 'голыши', 'белые', 'круглые', 'мягкие', 'большой', 'очень вкусны');

INSERT INTO disease(meal_id, disease_name, disease_state)
    VALUES ('1', 'unk', FALSE);

INSERT INTO question(meal_id, question_text)
    VALUES ('1', 'Может быть, и этот, большой, тоже?..');

COMMIT;
