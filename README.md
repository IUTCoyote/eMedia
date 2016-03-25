# eMedia 

Tutoriel d'utilisation de git par HOUDAYER Pierre

## Cloner le projet (première étape)
- Installer git windows 
- Se déplacer avec un explorateur de fichier dans D:\jee6\workspace
- clic droit puis "Git bash here"
- [Terminal git bash] git clone https://github.com/IUTCoyote/eMedia.git

## Développement en local (Dépôt local)
- Se déplacer avec un explorateur de fichier dans D:\jee6\workspace\emedia
- clic droit puis "Git bash here"
- {EFFECTUER SES MODIFICATIONS SUR LE CODE}
- tester ( ok ? commiter la version => suite SINON corriger sa version)
- [Terminal git bash] git add --all
- [Terminal git bash] git commit -m "{MON MESSAGE : CE QUE J'AI FAIS, POURQUOI}"
- ...
- {EFFECTUER SES MODIFICATIONS SUR LE CODE}
- - tester ( ok ? commiter la version => suite SINON corriger sa version)
- [Terminal git bash] git add --all
- [Terminal git bash] git commit -m "{MON MESSAGE : CE QUE J'AI FAIS, POURQUOI}"
- ... autant de fois que necéssaire jusqu'à une version finale ...

## Mise à jour du dépot distant de GitHub
- (Avoir réalisé la tâche précédente)
- Se déplacer avec un explorateur de fichier dans D:\jee6\workspace\emedia
- clic droit puis "Git bash here"
- [Terminal git bash] git add --all
- [Terminal git bash] git commit -m "{MON MESSAGE : CE QUE J'AI FAIS, POURQUOI}"
- [Terminal git bash] git push
- /!\ uniquement en cas d'erreur de type /!\: 
- > "On branch Master : Your branch is ahead of 'origin/master' by 1 commit ... "
- > ==> [Terminal git bash] git pull
- > ==> [Terminal git bash] git push
- [Terminal git bash][Openssh] GitHub_UserName
- [Terminal git bash][Openssh] GitHub_Password_For_UserName

##En cas de problèmes de connexions
- [Terminal git bash] git config --global http.proxy https://proxy.univ-lemans.fr:3128


## Génération du WAR
- Se déplacer dans le dossier source dans un invte de commande
- Mettre en place l'environement (PATH) dans l'invite de commande avec le script "setenvp.bat" 
- [Terminal] setenvp.bat
- Le fichier pom.xml doit être présent
- [Terminal] mvn install
- Le WAR est généré dans un dossier target
