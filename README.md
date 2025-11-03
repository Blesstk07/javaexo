# javaexo# javaexo

Collection d'exercices Java - configuration minimale pour Java 21Ce dépôt contient plusieurs petits exercices Java.

## Prérequis## Mise à niveau Java

- JDK 21 installé et actif (voir `java -version`).

Ce projet peut être compilé avec un JDK standard. Si vous voulez forcer la compilation et l'exécution avec la dernière LTS (Java 21), suivez les étapes ci-dessous.

## Compilation (local, sans Maven)

Depuis la racine du dépôt :Option A — SDKMAN (recommandé pour les développeurs):

```bash1. Installez SDKMAN si nécessaire:

# compiler toutes les sources valides vers target/classes

javac -d target/classes -encoding UTF-8 --release 21 *.java   curl -s "https://get.sdkman.io" | bash

   source "$HOME/.sdkman/bin/sdkman-init.sh"

# créer un JAR exécutable (Main est le point d'entrée par défaut)

jar cfe target/javaexo.jar Main -C target/classes .2. Installez Java 21 et définissez-le par défaut:



# exécuter le JAR   sdk install java 21-open

java -jar target/javaexo.jar   sdk default java 21-open

```

3. Vérifiez la version:

## Notes

- Certains fichiers malformés/doublons ont été déplacés dans le dossier `broken_files/` : regardez-les si vous voulez les corriger. java -version

- Un fichier de synthèse `CHANGES_AND_COMMENTS.md` contient le détail des changements et commentaires par fichier.

- Le projet n'utilise pas la structure standard Maven (`src/main/java`). Si vous préférez, je peux réorganiser le projet et rendre `mvn package` fonctionnel.Option B — paquet système (Debian/Ubuntu):

## Si vous voulez un build Maven fonctionnel1. Installez OpenJDK 21 via apt (si disponible) :

- Déplacer les sources dans `src/main/java` et `src/test/java`, puis relancer `mvn -U -e package`.

- Si Maven échoue à cause du réseau (plugins non résolus), vous pouvez compiler localement avec `javac` comme ci-dessus. sudo apt update

  sudo apt install openjdk-21-jdk

2. Définissez JAVA_HOME dans votre shell:

   export JAVA_HOME="/usr/lib/jvm/java-21-openjdk-amd64"
   export PATH="$JAVA_HOME/bin:$PATH"

3. Vérifiez la version:

   java -version

## Compiler et exécuter

Pour compiler tous les fichiers Java du dépôt:

    javac *.java

Pour exécuter l'exemple principal (si `Main.java` est le point d'entrée) :

    java Main

Remarques:

- Si vous utilisez Maven/Gradle, ajustez la configuration du plugin `maven-compiler-plugin` ou `sourceCompatibility`/`targetCompatibility` pour Java 21.
- L'outil d'upgrade automatique n'est pas disponible dans cet environnement. Si vous voulez que j'applique automatiquement les modifications (OpenRewrite, changements de dépendances), fournissez l'accès à un environnement compatible ou dites-moi d'utiliser des modifications manuelles.

```
# javaexo
```
