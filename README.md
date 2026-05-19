# Application Android — Broadcast Receivers

## Présentation

Ce projet consiste à développer une application Android utilisant différents types de **BroadcastReceiver** afin de comprendre le fonctionnement des événements système et des broadcasts personnalisés.

L’application permet :
- de détecter les changements du mode avion
- de réagir au démarrage du téléphone
- d’envoyer et recevoir un broadcast interne personnalisé

Le projet a été réalisé en Java avec Android Studio.

---

# Objectifs du projet

- Comprendre le fonctionnement des BroadcastReceiver
- Différencier les receivers statiques et dynamiques
- Utiliser les IntentFilter
- Envoyer des broadcasts personnalisés
- Gérer correctement l’enregistrement et la suppression des receivers

---

# Technologies utilisées

- Java
- Android Studio
- Android SDK
- BroadcastReceiver
- Intent
- IntentFilter
- Toast

---

# Structure du projet

```text
com.example.broadcastwatcherapp
│
├── MainActivity.java
├── NetworkModeReceiver.java
├── StartupReceiver.java
├── InternalMessageReceiver.java
└── activity_main.xml
```

---

# Fonctionnement général

L’application possède trois receivers différents :

## 1. Receiver Dynamique

Le receiver dynamique écoute :
- les changements du mode avion

Il est activé et désactivé directement depuis l’interface utilisateur.

---

## 2. Receiver Statique

Le receiver statique détecte :
- le démarrage du téléphone (`BOOT_COMPLETED`)

Il est déclaré dans le fichier `AndroidManifest.xml`.

---

## 3. Broadcast Personnalisé

L’application peut :
- envoyer un broadcast interne
- recevoir ce broadcast via un receiver dédié

---

# Interface graphique

L’interface contient :
- un TextView indiquant l’état du receiver
- un bouton pour activer/désactiver le receiver dynamique
- un bouton pour envoyer un broadcast personnalisé

---

# Permissions utilisées

Dans `AndroidManifest.xml` :

```xml
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED"/>
```

---

# Déclaration des Receivers

## Receiver statique

```xml
<receiver
    android:name=".StartupReceiver"
    android:exported="false">
    <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED"/>
    </intent-filter>
</receiver>
```

## Receiver personnalisé

```xml
<receiver
    android:name=".InternalMessageReceiver"
    android:exported="false"/>
```

---

# Tests réalisés

## Test 1 — Receiver dynamique

- activation du receiver
- changement du mode avion
- affichage des Toasts correspondants

## Test 2 — Broadcast personnalisé

- envoi du broadcast interne
- réception du message personnalisé

## Test 3 — Receiver statique

- redémarrage de l’émulateur/appareil
- déclenchement du receiver BOOT_COMPLETED

---

# Démonstration vidéo

https://github.com/user-attachments/assets/b87dadf1-e36a-4b6a-96ee-4f7516727c74

---

# Résultats obtenus

- Receiver dynamique fonctionnel
- Receiver statique correctement déclaré
- Broadcast personnalisé opérationnel
- Gestion correcte des IntentFilter
- Compatibilité Android moderne respectée

---

