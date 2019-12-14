INSERT INTO 
	TBL_EMPLOYEES (first_name, last_name, job, email)
VALUES
  	('Piotr', 'Piotrov', 'Vadybininkas', 'pete@mail.com'),
  	('Vazgen', 'Vitia', 'Vadybininkas', 'aim@one.lt'),
  	('Mantas', 'Plepys', 'Administratorius', 'm.plepys@mail.com'),
  	('Lukas', 'Kastonas', 'Administratorius', 'l.kastonas@gmail.com'),
  	('Petras', 'Balys', 'Administratorius', 'ptriux@one.lt'),
  	('Vilma', 'Tamusiuniene', 'Administratorius', 'v.tamusiuniene@gmail.com'),
  	('Birute', 'Kalinkaite', 'Buhalteris', 'birute112@gmail.com'),
  	('Rimantas', 'Obeliauskas', 'Buhalteris', 'obuolys@gmail.com'),
  	('Erikas', 'Grigaitis', 'Buhalteris', 'georgeusb@gmail.com'),
  	('Rasa', 'Voveraite', 'Sefas', 'rasa.voveraite@mail.com'),
  	('Antanas', 'Smetona', 'Prezidentas', 'prezident@one.lt'),
  	('Pompeius', 'Gaius', 'Vyrejas', 'pomejus@rome.com'),
  	('Elenora', 'Trudo', 'Vyrejas', 'e.trudo@gmail.com'),
  	('Vardenis', 'Pavardenis', 'Vyrejas', 'vardenis@mail.com'),
  	('Vardene', 'Pavardene', 'Vyrejas', 'pavardene@mail.com'),
  	('Jonas', 'Telsys', 'Vyrejas', 'telsiai115@gmail.com'),
  	('Ruta', 'Kaliauskaite', 'Vyrejas', 'scarecrow@mail.com'),
  	('Paulina', 'Trecioke', 'Indu plovejas', 'thirdclass@mail.com'),
  	('Olga', 'Grigevic', 'Indu plovejas', 'p.grigevic@mail.com'),
  	('Arturas', 'Burokas', 'Indu plovejas', 'buroklt@gmail.com'),
  	('Frodas', 'Beginsas', 'Indu plovejas', 'theshire@ring.lotr'),
  	('Semas', 'Fiseris', 'Indu plovejas', 'tomclancy@gmail.com'),
  	('Irma', 'Juozapaite', 'Indu plovejas', 'i.juozapaite@gmail.com'),
  	('Gordonas', 'Freemanas', 'Indu plovejas', 'g.freeman@hl.com'),
  	('Gorgonas', 'Ramzis', 'Indu plovejas', 'f.isforfamily@gmail.com'),
  	('Rokas', 'Balandis', 'Padavejas', 'r.balandis@mail.com'),
  	('Gabriele', 'Malatov', 'Padavejas', 'g.malatov@mail.com'),
  	('Andzelika', 'Angel', 'Padavejas', 'angel@mail.com'),
  	('Agne', 'Rozmary', 'Padavejas', 'rozmarinas@gmail.com'),
  	('Lukas', 'Klevas', 'Padavejas', 'lukeusetheforce@one.lt'),
  	('Anton', 'Petrovic', 'Padavejas', 'a.petrograd@mail.com'),
  	('Jozefas', 'Stolinas', 'Padavejas', 'j.stolin@mail.com'),
  	('Vikter', 'Uzpaskihev', 'Padavejas', 'uzpaskos@gmail.com'),
  	('Olga', 'Petrauskiene', 'Padavejas', 'o.petraukiene@gmail.com'),
  	('Arturas', 'Paulauskas', 'Valytojas', 'a.paulauskas@gmail.com'),
  	('Duglas', 'McArthur', 'Valytojas', 'd.mcarhur@mail.com'),
  	('Ivanas', 'Ivanovas', 'Valytojas', 'ivan@mail.com'),
  	('Tadas', 'Kuldunas', 'Valytojas', 'kuldun@mail.com'),
  	('Erika', 'Kulduniene', 'Valytojas', 'kuldun2@mail.com'),
  	('Sony', 'Ericson', 'Praktikantas', 'sony@mail.com');

INSERT INTO
	TBL_DISH (dish_name, price)
VALUES
('GRAND Plesytos Kiaulienos pica', 18.75),
('MAXI Plesytos Kiaulienos pica', 11.95),
('GRAND Cheburger pica', 18.75),
('MAXI Cheburger pica', 11.95),
('GRAND Chipotle vistienos pica', 18.75),
('MAXI Chipotle vistienos pica', 11.95),
('GRAND Conhita pica', 18.75),
('MAXI Conhita pica', 11.75),
('GRAND Astrioji pica', 18.75),
('MAXI Astrioji pica', 11.95),
('GRAND Meksikietiska pica', 18.75),
('MAXI Meksikietiska pica', 11.95),
('GRAND Amerikana pica', 18.75),
('MAXI Amerika pica', 11.95),
('GRAND Smetoniska pica', 18.75),
('MAXI Smetoniska pica', 11.95),
('Didzkukuliai su mesa', 4.59),
('Zemaiciu blynai', 4.29),
('Apkepti lietiniai su kumpiu ir suriu', 4.29),
('Apkepti kuldunai', 4.19),
('Makaronai su Vistiena', 4.99),
('Sultingi Kiaulienos Sonkauliai BBQ padaze', 7.99),
('Kiaulienos Saslykas', 6.49);
INSERT INTO
    TBL_ORDERS (order_name, client_name, phone_number, full_price)
    VALUES (1, 'Jonas', 86266454, 18.75),
    (2, 'Povilas', 84554844, 11.95),
    (3, 'Harvey', 69420228, 10),
    (4, 'Olivier', 69420221, 15),
    (5, 'Maysa', 69420222, 16.54),
    (6, 'Vihaan', 69420223, 14.44),
    (7, 'Tina', 69420224, 20.25),
    (8, 'Om', 69420225, 420.69),
    (9, 'Algirdas', 69420226, 1377.12),
    (10, 'Arabella', 69420227, 23.20),
    (11, 'Malakai', 69420229, 32.50),
    (12, 'Deen', 69420210, 1.56),
    (13, 'Linzi', 69420211, 18.76);
