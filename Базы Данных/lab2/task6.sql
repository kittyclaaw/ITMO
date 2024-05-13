--Получить список студентов, зачисленных ровно первого сентября 2012 года на первый курс заочной формы обучения. В результат включить:
--номер группы;
--номер, фамилию, имя и отчество студента;
--номер и состояние пункта приказа;

SELECT
	Н_УЧЕНИКИ."ГРУППА",
	Н_ЛЮДИ."ИД" AS "НОМЕР",
	Н_ЛЮДИ."ФАМИЛИЯ",
	Н_ЛЮДИ."ИМЯ",
	Н_ЛЮДИ."ОТЧЕСТВО",
	Н_УЧЕНИКИ."П_ПРКОК_ИД" AS "НОМЕР ПРИКАЗА",
	Н_УЧЕНИКИ."СОСТОЯНИЕ" AS "СОСТОЯНИЕ ПУНКТА ПРИКАЗА"
FROM
	Н_УЧЕНИКИ
JOIN "Н_ОБУЧЕНИЯ" ON
	Н_ОБУЧЕНИЯ."ЧЛВК_ИД" = Н_УЧЕНИКИ."ЧЛВК_ИД"
	AND Н_ОБУЧЕНИЯ."ВИД_ОБУЧ_ИД" = Н_УЧЕНИКИ."ВИД_ОБУЧ_ИД"
JOIN Н_ЛЮДИ ON
	Н_ЛЮДИ."ИД" = Н_ОБУЧЕНИЯ."ЧЛВК_ИД"
WHERE
	DATE("НАЧАЛО") = '2012-09-01'
	AND Н_УЧЕНИКИ."ПЛАН_ИД" IN (
	SELECT
		Н_ПЛАНЫ."ИД"
	FROM
		Н_ПЛАНЫ
	WHERE
		Н_ПЛАНЫ."КУРС" = 1
		AND Н_ПЛАНЫ."НАПС_ИД" IN (
		SELECT
			Н_ФОРМЫ_ОБУЧЕНИЯ."ИД"
		FROM
			Н_ФОРМЫ_ОБУЧЕНИЯ
		WHERE
			Н_ФОРМЫ_ОБУЧЕНИЯ."НАИМЕНОВАНИЕ" = 'Заочная'
    )
);