# Le Comptoir

## Présentation

**Le Comptoir** est un projet de développement d'un moteur de caisse modulaire
développé sous contraintes client .

L'objectif est de mettre en évidence le coût de la dette technique et de
vérifier la capacité du code à évoluer face à de nouvelles demandes.

## Technologies utilisées

- **Java 21** : développement du moteur de caisse
- **TypeScript** : client de démonstration
- **Git / GitHub** : gestion des versions et collaboration

Le moteur est développé en **POO pure**, sans base de données, sans
framework d'interface utilisateur et sans framework web.

## Fonctionnalités

Le moteur de caisse évolue progressivement à travers cinq versions.

### v1 – Ticket basique

Le ticket affiche :
- les articles du panier ;
- les quantités ;
- le total du panier.

### v2 – Remise globale

Une remise de **10 %** est appliquée lorsque le total du panier dépasse **50 €**.

### v3 – Offre boissons

Pour les produits de la catégorie boissons : **2 articles achetés = le 3ème offert.**

Lorsque trois articles sont concernés, le produit le moins cher est offert.

### v4 – TVA différenciée

La TVA dépend de la catégorie du produit :
- **5,5 %** pour les produits alimentaires ;
- **20 %** pour les autres produits.

Le ticket présente :
- le montant hors taxes (HT) ;
- le montant de TVA par taux ;
- le montant toutes taxes comprises (TTC).

### v5 – Carte de fidélité

Le système de fidélité fonctionne selon les règles suivantes :

- **1 € dépensé = 1 point** ;
- **100 points = 5 € de remise** ;
- la remise de fidélité est utilisable sur la commande suivante ;
- les différentes remises ne sont pas cumulables ;
- lorsqu'elles sont applicables, la remise la plus avantageuse pour le
  client est retenue.

## Architecture du projet

LeComptoir/
│
├── engine/
│   └── Moteur de caisse Java 21
│
├── demo/
│   └── Client de démonstration TypeScript
│
├── docs/
│   ├── Rapport d'audit
│   ├── Réponse à l'audit
│   └── Diagrammes UML
│
└── README.mdg