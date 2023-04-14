# Laborator 2 PPA 
Repo-ul este destinat grupelor de laborator din cadrul ETTI, UPB la materia Programare pe Platforme Android, an III, semestrul II (2022-2023), in zilele de Marti 17-19 PAR/IMPAR.

# Functionalitate
Pachetul contine doua activitati (MainActivity si Profile) si are ca scop didactic intelegerea transferului de date intre doua Activitati in SDK-ul Android.

<h3> MainActivity </h3>
	Contine:
	<ul>
		<li>Un element EditText pentru introducerea e-mail-ului</li>
		<li>Un element EditText pentru introducerea parolei</li>
		<li>Un button pentru a face trecerea intre cele doua Activitati</li>
	</ul>

<h3> Profile Activity </h3>
	Contine:
	<ul>
		<li>Un element TextView pentru afisarea e-mail-ului</li>
		<li>Un element TextView pentru afisarea lungimii parolei</li>
		<li>Un button pentru termina activitatea curenta</li>		
	</ul>
	
<h3> Misc </h3>

	Pentru a transfera date intre cele doua activitati s-a folosit o Intentie Explicita (Intent intent=new Intent(getApplicationContext(),Profile.class)), impreuna cu adaugarea unor date extra asupra Intentiei respective (provenite din obiectul de tip User).
	
	Pentru a recupera datele transferate in cea de-a doua activitate s-a folosit tot o Intentie care transfera datele intr-un Bundle (sub-clasa a unui BaseBundle) ce functioneaza ca un Map (Key:Value), unde cheia este reprezentata de numele pus in prima Activitate (Intent.putExtra(name,value);).

# Despre
Repo-ul contine codul scris in cadrul laboratorului, impreuna cu layout-urile din Android Studio.

Pentru a vedea clasele scris in Java urmati path-ul: app-> src-> main ->java/src/ion_popescu/myapplication MainActivity.java sau Profile.java

Pentru a vedea layout-ul (GUI) din android Studio urmati path-ul: app-> src-> main -> res -> layout -> activity_main.xml sau activity_profile.xml



<h2> !! NU copiati fara sa intelegeti codul </h2>
