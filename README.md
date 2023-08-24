# Tondeuse Automatique 

Une tondeuse a gazon automatique destinée aux surfaces rectangulaires.

## Project Overview

Cette aplication permet de parcourir une liste des tondeuses et donne la position final des tondeuses.

L'application prend en entrée un fichier qui contient les informations de la surface a parcourir et les informations de chaque tondeuse ( position initial, orientation, chemin ).

## Installation

Voici les élements pour demarrer l'application.

1. Clone this repository: `git clone https://github.com/mako-abaach/tondeuse.git`
2. Demarer le projet sur votre IDE

Environneemnt : Eclipse, java 17, spring boot 3.1.2

## Usage

Pour tester l'application sur POSTMAN.

- Voici le curl pour faire appel a l'API : curl --location 'localhost:8050/tondeuse/positionfinal?pathFile=src/main/resources/tondeuse.txt'


