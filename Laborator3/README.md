# Laborator 3 PPA 
Repo-ul este destinat grupelor de laborator din cadrul ETTI, UPB la materia Programare pe Platforme Android, an III, semestrul II (2022-2023), in zilele de Marti 17-19 PAR/IMPAR.

# Functionalitate
Pachetul contine o Activitate, doua Fragmente si un Serviciu. Scopul laboratorului este de a intelege cum se realizeaza transferul intre Fragmente (prin FragmentManager), dar si cum functioneaza Serviciile in Android.

<h3> MainActivity </h3>
	Contine:
	<ul>
		<li>Un singur element: FragmentContainerView ce permite adaugarea layout-urilor celorlalte Fragmente.</li>
	</ul>

<h3> FirstFragment </h3>
	Contine:
	<ul>
		<li>Un Button care porneste Serviciul</li>
		<li>Un alt Button care permite transferul catre SecondFragment</li>	
	</ul>
	
<h3> SecondFragment </h3>
	Contine:
	<ul>
		<li>Un Button care opreste Serviciul pornit anterior.</li>
		<li>Un alt Button care ne intoarce la Fragmentul anterior.</li>	
	</ul>	
	
<h3> Serviciul </h3>
	Contine:
	<ul>
		<li>Un Thread care ne afiseaza o "notificare" la fiecare 10 secunde.</li>
		<li>Un Toast care permite afisarea textului "Laborator 3"</li>
		<li>Un Handler ce ne ajuta sa gestionam Thread-ul creat anterior</li>		
</ul>	
	
<h3> Misc </h3>

	In vederea realizarii laboratorului, va trebui inteles cum lucreaza un Thread (Fir de Executie), acesta nefiind legat de Fragmentul din care este lansat.
	Serviciul are nevoie de un Handler, dar si de un Looper pentru a putea afisa Toast-ul (fiind componenta de tip UI).
	Transferul intre Fragmente se realizeaza cu ajutorul FragmentManager-ului care gestioneaza Ciclul de Viata al Fragmentelor.
	
	

# Despre
Repo-ul contine codul scris in cadrul laboratorului, impreuna cu layout-urile din Android Studio.

Pentru a vedea clasele scris in Java urmati path-ul: app-> src-> main ->java/src/ion_popescu/myapplication MainActivity.java, ToastService.java, FirstFragment si SecondFragment.

Pentru a vedea layout-ul (GUI) din android Studio urmati path-ul: app-> src-> main -> res -> layout -> activity_main.xml sau fragment_first.xml/fragment_second.xml.



<h2> !! NU copiati fara sa intelegeti codul </h2>
