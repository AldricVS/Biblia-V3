# Cahier des charges

Ce n'est pas un énorme projet. On note ici 
les différentes tâches de celui-ci.

## 1. Actions possibles

- Créer une entrée (livre, magazine)
  - Différentes interfaces si c'est un livre ou un magazine ?
- Modifier une entrée (même interface que la création, mais avec les champs préremplis)
- Supprimer une entrée (avec confirmation)
- Chercher une entrée via texte libre, avec autorisation d'erreurs d'orthographe par exemple (fuzzy search)

## 2. Actions automatisées

- à chaque démarrage, on veut créer une backup des données
au càs-où il y aurait un soucis (avec rotation des backups ?)
  - Si possible, envoyer ces backups sur un stockage externe (mail, drive, etc.)

## 3. Structure d'une entrée

Une entrée, c'est :
- Un type (livre / magazine)
- Un titre (REQUIS, mais non unique)
- Un sous-titre (utile si c'est un livre)
- Un numéro (utile si c'est un magazine)
- Un auteur
- Des mots-clés
- Une description textuelle

> ça serait sympa d'envoyer un warning si le combo
> `titre` / `sous-titre` / `numéro` est le même qu'un déjà créé
