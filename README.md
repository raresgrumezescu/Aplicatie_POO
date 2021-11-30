# Aplicatie_POO

Grumezescu Rares, 321CC
Tema mi s-a parut de dificultate medie, deoarece cerintele acopera materia 
invatata la curs si aprofundata in cadrul laboratoarelor. Json-ul consider ca a fost 
mai putin mai dificil, insa, pe langa acesta, ceea ce am reusit sa parcurg din tema 
nu mi s-a parut foarte dificil. Un lucru ce mi-a creat dificultati a fost acela ca in 
unele momente mi-a fost greu sa inteleg in totalitate enuntul; consider ca modul 
in care l-am intele in final a fost unul corect, iar rezolvarile cerintelor consider ca 
se concordeaza cu cerintele din enunt.
Efectiv, am alocat rezolvarii temei in jur de 14 zile, cu cate 3-4, respectiv 6 - 7 ore 
zilnic. Mai mult nu am reusit din cauza celorlalte proiecte pe care le-am avut de 
pregatit la celelalte materii si din cauza orelor de curs si laborator la care a trebuit 
sa asist.
In cadrul acestui README consider ca este de prisos sa explic rolul anumitor 
metode precum cele de tip get, set, add, remove, deoarece din rezolvarea pe care 
am gasit-o, cred ca se vede suficient de clar cum functioneaza acestea. De 
asemenea, am dat nume sugestive variabilelor din clase si de aceea nici in 
comentarii nu am considerat de cuviinta sa le explic rolul. 
Application:
getJobs este o metoda mai complexa; creez un arraylist cu elemente de tip job. 
De asemenea, parcurg cu un iterator lista de companii primita ca parametru si vad 
intai care sunt companiile preferate de utillizator, ce se gasesc in lista data ca 
parametru. Daca a fost gasita o companie corespunzatoare, atunci si itereaza prin 
lista de departamente a acesteia, si se cauta job-urile disponibile (ale caror flag e 
setat cu true). Aceste job-uri se adauga in lista de job-uri. La final, lista aceasta se 
returneaza.
Consumer:
Iau in interiorul ei un obiect de tip Resume (Resume este o clasa interna definita 
in Consumer)
getDegreeInFriendship: parcurge reteaua de cunoscuti ai consumer-ului dat ca 
parametru folosind parcurgerea bfs iterativa. Algoritmul este cel clasic, cu o 
mentiune: in momentul cand se parcurge lista de consumeri ai consumer-ului 
curent, se verifica daca unul din vecini corespunde cu cel cautat. In caz afirmativ, 
se returneaza gradul ce se calculeaza in functie de distanta.
Daca consumer-ul dat ca parametru nu este in reteaua consumer-ului curent, se 
returneaza -1.
getGraduationYear : cauta anul promovarii licentei in lista educatiei din resume 
daca gaseste data, selecteaza cu substring() anul, il converteste la Integer si il 
returneaza.
meanGPA: Calculeaza media academica in functie de cerinta. Practic, calculeaza 
media aritmetica cu care consumer-ul a terminat studiile institutiilor pe care le-a 
promovat. Aceasta se face parcurgand vectorul de studii din resume-ul lui.
Information: 
Clasa implementata folosind principiul incapsularii.
Education:
Constructorul Education: primeste ca parametru mai multe informatii despre un 
viitor consumer Printre aceste informatii se numara si doua date: de inceput al 
studiilor si de sfarsit al lor. Aceste date sunt de tip string si se impart in 
substring-uri folosind metoda substring(index). Se verifica daca aceste date sunt 
corecte din punct de vedere cronologic, verificandu-se, pe rand, anul, luna si ziua 
celor 2 date. Daca aceste date nu corespund realitatii, se vor aruncta exceptii de 
tipul InvalidDatesException. (clasa acestei exceptii este definita mai sus)
compareTo: Compara doua obiecte de tip Education (this si cel primit ca 
parametru), in functie de criteriile cerute in enunt. Rezultatele returnate de 
aceasta matoda sunt date in asa vel incat cu ajutorul ei sa se poata face sortarea 
descrescatoare ceruta.
Experience:
Ca mod de functionare este absolut identica cu Education.
User:
convert: primeste un user si informatiile lui le foloseste pentru a creea un obiect 
de tip employee, pe care il va returna.
getTotalScore: calculeaza scorul total folosind algoritmul din enunt. parcurg 
vectorul de experienta al user-ului si vad cati ani a stat la fiecare comanie in parte. 
Rezultatele le pastrez intr-o variabila experienta. Media academica o aflu cu 
metoda meanGPA. Calculez si returnez apoi media ceruta.
Recruiter:
evaluate: returneaza un double reprezentat de rating-ul pe care un recruiter il 
acorda user-ului primit ca parametru. Tot aici, in obiectul de tip Company luat, 
intru in lista de request-uri a managerului (company.manager.request) si adaug 
un nou request.
Manager: 
process: parcurge lista de cereri si cauta care job-urile care corespund cu cel dat 
ca parametru si care au numarul de candidati nenul. Din acest numar se va scadea 
cate o unitate, pana se ajunge la 0 candidati. User-ul asociat acestui request este 
convertit in employee cu ajutorul functiei convert din Employee, iar acest nou 
employee este adaugat in departamentul corespunzator job-ului. In final, dupa ce 
un user a fost adaugat in job, cererea pentru el va fi stearsa.
Job:
apply: daca job-ul nu a fost inchis, cu ajutorul bfs iterativ, se parcurge reteaua 
user-ului dat ca parametru si, cu cat se coboara mai jos in retea, cu atat se 
salveaza recruiter-ul nivelului parcurs. Cum algoritmul se opreste in momentul 
cand atinge cel mai de jos nivel, conform acestuirationament, in momentul in 
care while-ul se termina, la iesire din el va ramane salvat in variabila recruiter 
chiar recruite-ul cerut in enunt. Se apeleaza evaluate pentru acest recruiter.
meetsRequirements: metoda verifica, pe rand, daca user-ul dat ca parametru 
respecta constrangerile cerute de job in obiectele de tip Constraint.
Company:
getRecruiter: folosind bfs iterativ, parcurg conform algoritmului clasic bfs-iterativ 
reteaua user-ului dat ca parametru. Metoda analoaga celei de mai sus din Joj.
getJobs: creeaza o list cu jobu-urile disponibile dintr-o companie. arcurge lista de 
departamente a companiei si verifica in fiecare, printre job-urile asociate care 
sunt deschise. ACeasta lista este returnata la final.
Department:
Metodele le-am realizat cu ajutorul metodelor predefinite pentru obiectele de tip 
ArrayList: add, remove. Am considerat si metoda abstracta getTotalSalaryBudget. 
IN clasele IT, Management, Finance si Marketing ce mostenesc clasa Department, 
am implementat aceasta metoda sa calculeze bugetul toatl de salarii in functie de 
cerintele pentru angajatii fiecarui departament.
In clasa DepartmentFactory folosesc pattern-ul Factory pentru a crea obiecte 
reprezentand cele 4 departamente.
Am creat de asemenea clasa de testare JsonTest unde citesc 2 fisiere: unu atasat 
de problema si unul scris de mine pentru testare. Citirea din fisierele acestea o 
fac. Cititul si creatul obiectelor pe baza primului fisier imi iese bine, insa din cauza 
unei probleme de compilare pe care nu mai am timp sa o rezolv, nu am reusit sa 
realizez si citirea din cel de-al doilea fisier, cu toate ca conceptele si ideea de citire 
este identica cu cea a primului fisier. Tin sa precizez ca in cele 2 fisiere numerele 
de tip double le-am reprezentat sub forma de string, deoarece numai asa am 
reusit sa realizez citirea acestora.
La cerinta trei am reusit sa creez clasaApplication folosind pattern-ul Singleton si 
de asemenea, am reusit sa folosesc pattern-ul Factory pentru clasa De
