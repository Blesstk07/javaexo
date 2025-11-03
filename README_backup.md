# javaexo

Ce dépôt contient plusieurs petits exercices Java.

## Mise à niveau Java

Ce projet peut être compilé avec un JDK standard. Si vous voulez forcer la compilation et l'exécution avec la dernière LTS (Java 21), suivez les étapes ci-dessous.

Option A — SDKMAN (recommandé pour les développeurs):

1. Installez SDKMAN si nécessaire:

   curl -s "https://get.sdkman.io" | bash
   source "$HOME/.sdkman/bin/sdkman-init.sh"

2. Installez Java 21 et définissez-le par défaut:

   sdk install java 21-open
   sdk default java 21-open

3. Vérifiez la version:

   java -version

Option B — paquet système (Debian/Ubuntu):

1. Installez OpenJDK 21 via apt (si disponible) :

   sudo apt update
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
