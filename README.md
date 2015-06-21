# Analisi statica di Deadlock su Bytecode Java #

Il software permette di effettuare un'analisi statica di un programma Java, al fine di rilevare la presenza di possibili deadlock.
In particolare, per bypassare l'eterogeneità sintattica delle numerose librerie Java dedite al parallelismo, questo viene fatto analizzandone direttamente il bytecode.
Partendo da quest'ultimo, viene generato un opportuno programma Lam (**deadLock Analysis Model**, http://www.cs.unibo.it/~laneve/papers/concur2014.pdf) che potrà essere dato in input al tool **DF4ABS** (http://df4abs.nws.cs.unibo.it). Questo sfrutta un algoritmo che, partendo dal suddetto programma Lam, è in grado di rilevare eventuali circolarità che indicano la possibile presenza di deadlock.

## Download del repository e compilazione del codice sorgente (istruzioni Linux / OS X) ##

1) Download del repository (https://bitbucket.org/t6o/bytecodedeadlockanalysis/downloads)

2) Decomprimere l'archivio (*t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx*) in una posizione a piacere

3) Da terminale portarsi nella cartella radice del progetto (*t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx*) ed eseguire i comandi seguenti (carattere '$' escluso):


```
#!bash

$ find src -name "*.java" > sources.txt
```

```
#!bash

$ mkdir -p bin
```

```
#!bash

$ export CLASSPATH=$CLASSPATH:<AbsolutePath>/t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx/bin:<AbsolutePath>/t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx/lib/antlr-4.4-complete.jar
```

dove *<AbsolutePath>* è il percorso a partire dalla radice del filesystem (ad esempio */Users/<username>/Desktop/t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx*, se la cartella del progetto e' stata salvata sul Desktop in un sistema OS X).

```
#!bash

$ javac -d bin @sources.txt
```

## Esecuzione del software ed analisi dell'output mediante il tool DF4ABS ##

1) Assicurarsi che la variabile d'ambiente CLASSPATH sia configurata correttamente per puntare alla cartella */bin*, creata in precedenza, e alla libreria *lib/antlr-4.4-complete.jar*, entrambe contenute dentro la cartella *t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx*. Per verificarlo, basta eseguire da terminale il comando:

```
#!bash

$ echo $CLASSPATH

```
ed assicurarsi che i percorsi *<AbsolutePath>/t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx/bin* e *<AbsolutePath>/t6o-bytecodedeadlockanalysis-xxxxxxxxxxxx/lib/antlr-4.4-complete.jar* siano presenti. Se non presenti aggiungerli con il comando "export" come descritto prima.

2) Copiare i file .java del software da analizzare all'interno di una cartella da dare in input al programma (N.B. Tra i file deve essere presente un unico metodo main)

3) Lanciare l'esecuzione con il comando seguente:


```
#!bash

$ java com.laneve.deadlock.DeadlockAnalysis inputFolder [-o outputFolder] [-d maxSearchDepth]

```

dove:

* *inputFolder* --> è l'unico parametro obbligatorio ed è il percorso della suddetta cartella di input contenente i file .java su cui verificare la presenza di deadlock.

* *outputFolder* --> è la cartella in cui il software produrrà l'output necessario all'analisi finale.

* *maxSearchDepth* --> è la profondità massima considerata durante l'analisi ricorsiva degli oggetti annidati. Se, ad esempio, un oggetto di tipo A ha un campo di tipo B che, a sua volta, ha un campo di tipo C la profondità minima necessaria per prendere in considerazione il campo di tipo C è 2 
(N.B. Se il deadlock è causato da dipendenze tra campi situati a profondità maggiore di quella specificata allora non sarà rilevato).

4) All'interno della cartella di output (se questa non e' stata specificata ne verra' creata una automaticamente chiamata *output_DeadlockAnalysis*) si avranno:

* una cartella "classFiles", contenente i file .class generati dalla compilazione dei file .java del software dato in input

*  una cartella "bytecode", contenente i file .txt del bytecode generato dai suddetti file .class mediante il comando "javap"

*  un file chiamato "lams.txt" che contiene il programma Lam risultato dall'elaborazione; questo è costituito da una funzione lam per ogni metodo del software in esame

5) Analisi della presenza di un possibile deadlock mediante il tool DF4ABS

* Andare alla pagina http://df4abs.nws.cs.unibo.it

* Copiare il contenuto del file "lams.txt", ottenuto nel punto precedente, ed incollarlo nell'apposita area di testo

* Selezionare l'opzione "Lam program" e premere "Invia" per verificare la possibile presenza di deadlock nel software Java di partenza