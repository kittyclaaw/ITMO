BEGIN;

CREATE TYPE HUMAN_STATE AS ENUM(
    'смотрящий'
    );

CREATE TYPE HUMAN_EYE_DIRECTION AS ENUM(
    'на Луну'
    );

CREATE TYPE OBJECT_FORM AS ENUM(
    'круг'
    );

CREATE TYPE METHOD_LEVEL AS ENUM(
    'первоклассную'
    );

CREATE TYPE METHOD_TYPE AS ENUM(
    'абстрактного'
    );

CREATE TYPE METHOD_ORIGINALITY AS ENUM(
    'поистине'
    );

CREATE TYPE CONCLUSION_TIME AS ENUM(
    '3-4 минуты'
    );

CREATE TYPE VERIFICATION_TIME AS ENUM(
    'немедленно'
    );

CREATE TYPE MEAL_COLOR AS ENUM(
    'белые'
    );

CREATE TYPE MEAL_FORM AS ENUM(
    'круглые'
    );

CREATE TYPE MEAL_DENSITY AS ENUM(
    'мягкие'
    );

CREATE TYPE MEAL_SIZE AS ENUM(
    'большой'
    );

CREATE TYPE MEAL_TASTE AS ENUM(
    'очень вкусны'
    );

CREATE TABLE IF NOT EXISTS human(
    id SERIAL NOT NULL PRIMARY KEY,
    method_id INT REFERENCES method(id),
    human_name text NOT NULL,
    human_state HUMAN_STATE,
    human_eye_direction HUMAN_EYE_DIRECTION
);

CREATE TABLE IF NOT EXISTS object(
    id SERIAL PRIMARY KEY,
    human_id INT REFERENCES human(id),
    object_name text NOT NULL,
    object_form OBJECT_FORM
);

CREATE TABLE IF NOT EXISTS method(
    id SERIAL PRIMARY KEY,
    method_level METHOD_LEVEL,
    method_type METHOD_TYPE,
    method_originality METHOD_ORIGINALITY
);

CREATE TABLE IF NOT EXISTS conclusion(
    id SERIAL PRIMARY KEY,
    method_id INT REFERENCES method(id),
    conclusion_time CONCLUSION_TIME,
    conclusion_result BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS verification(
    id SERIAL PRIMARY KEY,
    conclusion_id INT REFERENCES conclusion(id),
    verification_time VERIFICATION_TIME,
    verification_state BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS meal(
    id SERIAL PRIMARY KEY,
    conclusion_id INT REFERENCES conclusion(id),
    meal_name text NOT NULL,
    meal_color MEAL_COLOR,
    meal_form MEAL_FORM,
    meal_density MEAL_DENSITY,
    meal_size MEAL_SIZE,
    meal_taste MEAL_TASTE
);

CREATE TABLE IF NOT EXISTS disease(
    id SERIAL PRIMARY KEY,
    meal_id INT REFERENCES meal(id),
    disease_name text NOT NULL,
    disease_state BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS question(
    id SERIAL PRIMARY KEY,
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
    VALUES ('1', '', '');

INSERT INTO question(meal_id, question_text)
    VALUES ('1', '');

COMMIT;
