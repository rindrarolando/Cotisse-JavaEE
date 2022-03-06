/*--Classes--*/

connexion : Connexion -> Connexion à postgres
models : -Maladie -> avoir les maladies
	-Patient -> avoir les patients

requete : 
    ChambreRequete -> requête sur les chambres
    MaladieRequete -> requête sur les maladies
    MedecinRequete -> requête sur les médecins
    PatientRequete -> requête sur les patients
    Requete -> quelques requêtes et fonctions utiles

/*--Requêtes--*/
	-compter le nombre de ligne dans une table
	-Lister les maladies
	-insérer un nouveau patient

/*--Modifications--*/ 

Connexion : -nouveau username et password (mais à chacun de voir son username et son passwoord)
models : -nouvelle classe Medecin 
        -nouvelle classe Chambre
requete : -ajout d'une fonction pour compter le nombre de ligne dans une table
        -ajout d'une fonction pour avoir les colonnes d'une table
        -ajout de classes spécifiées pour chaque requête
nouveau package Controller pour tous les controlleurs (Servlet) : Patientcontroller -> controlleur pour Patient

