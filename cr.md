Question 1 : 
    Avec juste le début de ce qu'on veut, en tapant ctrl+espace, on voit automatiquement des propositions de suites loqiques de notre fonction.
Question 3 :
    Le fait de renvoyer directement les entités peut être mauvais pour l'intégrité des données, ça signifie que n'importe qui peut les manipuler et modifier. 
    Je crois que la bonne méthode serait de renvoyer des copies ou de rendre les entités immuables.
Question 4 :
    Les conséquences de la suppression d'un artiste depend du mode de création que nous avons choisi.
    Dans le cas de creation/suppression en cascade, la suppression d'un artiste affecte presque toutes les autres tables :
        Ses chansons et ses albums sont directement supprimés dans les tables respectives, la suppression d'un song implique aussi la modification des playlists...
Question 5 : 
   Cela peut dépendre de la manière dont nous avons configuré et défini nos Entités (Fetch Eager ou Lazy)
        Lazy : ne récupère les données qu'une fois qu'on les ait appelées, cela signifie que les relations ne sont pas automatiquement chargées.
        Eager : quant à lui charge automatiquement toutes les données.
        