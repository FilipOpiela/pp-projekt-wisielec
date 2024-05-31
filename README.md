# pp-projekt-wisielec

Zadanie projektowe

Treść
Stworzyć aplikację, która będzie przedstawiała (i implementowała mechanikę) popularną grę w wisielca
Gra powinna zawierać wbudowaną bazę słów podstawowych (minimum 10), oraz umożliwiać:
-wybór losowego słowa
-możliwość edytowania/dodawania bazy słów
-możliwość wyboru poziomu trudności
-dostęp do statystyk (ilość zwycięstw porażek, prób)
Gra powinna mieć interfejs graficzny oraz może korzystać z dostępu do bazy danych.
__________________________________________________________________________________________
Opis 

Program został wykonany z użyciem ArrayList, java.awt oraz javax.swing.
Kolejne funkcje programu są rozdzielone na osobne pliki - tzn. funkcja edycji bazy słów znajduje
się w innym pliku niż dostęp do statystyk.

Main
W Pliku main zostaje zadeklarowana baza słów oraz wywłujemy Gui. Nie ma tu nic wartego uwagi
poza obsługą wyjątku (na wypadek gdyby wcześniej wspomniana baza nie istaniała - konieczne
ponieważ lista słów nie jest zadeklarowana jako "Static").

Gui
W tym pliku powstaje pierwsze okienko naszej aplikacji. To tutaj zyskujemy możliwość zdecydowania
się na jedną z 3 opcji - grę, edycję bazy, dostęp do statystyk. Zdecydowana większość kodu odpowiada
za wygląd okienka - jego domyślną większość oraz rozmieszczenie przycisków. Warto zwrócić uwagę
na linię 29 - sprawia ona że zamknięcie tego okna jest równoznaczne z zakończeniem pracy aplikacji.

Okno jest zadeklarowane jako JFrame okno. Następnie poleceniami "okno.set[...]" ustalamy jego właściwości
tekst na górnym pasku, domyślną wielkość.
panel zadeklarowany w 65 linii jest czymś co możemy rozumieć jako odpowiednik div'a z html - jest to pojemnik
który może przechowywać w sobie następne elementy. Do tego panelu dodajemy przyciski a następnie panel
umieszczamy wewnątrz okna. 

Przyciski deklarowane jako JButton mają też dodane funkcje wywoływane przez kliknięcie ich - dzieje się to za pomocą
'staty.addActionListener' -- ten przykładowy przycisk wywołuje nowe okienko z statystykami gracza

Ten plik zawiera też publiczne metody mające za zadanie zapisywanie bazy słów oraz zwiększanie liczników wygranych
i przegranych partii. 


Gui_Trudnosc
Do tego pliku przechodzimy wybierając w głównym okienku opcję "graj". Tutaj wybieramy poziom trudności przed grą.
Dostępne są 3 poziomy trudności decydujące o tym ile prób mamy na odgadnięcie słowa. Wszystkie przyciski
wywołują okienko gry, jednak podają mu inny parametr odpowiedzialny za trudność. Okienko interfejsu graficznego powstaje
tak jak w pozostałych przypadkach - tworzymy okno, panel i przyciski. Przyciski dodajemy do panelu a panel do okna.

Gui_Graj
W tym oknie pojawiają się dwa nowe elementy - pole tekstowe, w które gracz wprowadza literę do sprawdzenia oraz StringBuilder
który przechowuje odgadnięte litery oraz znak "-" w miejscu tych jeszcze nie znanych.
Tym razem okno zawiera w sobie dwa panele - górny w którym wyświetlamy odgadnięte znaki oraz dolny który zawiera pole do wprowadzania
liter oraz przycisk potwierdzający.

W zależności od tego czy gracz poprawnie odgadł znak, w górnym panelu pojawi się poprawna litera lub na ekran "wyskoczy" informacja
o niepoprawnej próbie oraz pozostała ilość żyć. Jeśli ilość żyć spadnie do zera gracz zostaje poinformowany o porażce po czym okno gry
zostaje zamknięte. 

Jako kryterium zwycięstwa traktujemy zastąpienie wszystkich znaków "-" reprezentujących nieznane litery, literami odgadniętymi przez gracza


W pliku tym zaimplementowane jest losowanie słów - losowanie liczby między 0 a rozmiarem listy haseł. Oraz metoda sprawdzająca czy 
podana przez gracza litera jest poprawna (wywoływana przyciskiem).

W zależności od tego czy gracz wygrał czy przegrał wywołyywane są metody Gui.wygrana() lub Gui.przegrana 

Gui_lista
Tutaj gracz może przejrzeć słowa dostępne w grze, dodać nowe słowa, lub usunąć te które mu nie odpowiadają. Okno to zawieta pole tekstowe
Trzy przyciski odpowiedzialne za dodawanie, usunięcie słów oraz za sapisanie listy. Lista jest wyświetlana jako okienko. Jeśli ilość słów
wzrośnie do ilości która uniemożliwia wyświetlenie ich wszystkich okienko wyświetli pasek przewijania.
Umożliwia to deklaracja jako JScrollPane.

Gui_staty
Najprostsze okno z tej aplikacji. Zawiera jedynie opis "wygrana/przegrana" oraz wyświetla ile razy gra zakończyła się danym wynikiem.


 
-----------------------------------------------------------------------------------------------------------------------------------------------
W poleceniu była mowa zarówno o bazie słów jak i o bazie danych. Zrozumiałem to jako jedno i to samo - jeśli "baza danych" odnosiła by się do modelu na sql 
program musiał by wyglądać zdecydowanie inaczej. 
Podobnie jeśli "baza danych" miała by być rozumiana jako zewnętrzny plik np. tekstowy co wymusiło by użycie biblioteki do pracy na plikach np. java.io.File lub
java.io.BufferedReader

