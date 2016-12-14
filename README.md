**SoftEng**
===========
*T.E.I of Piraeus 2013 - 2014*
------------------------------
*Project for Software Engineering Laboratory*
---------------------------------------------
*Monday 16:00 - 18:00*
----------------------
**Authors**
-----------

* ΑΡΜΕΝΗΣ ΣΤΑΜΑΤΗΣ - 39201
* ΤΣΙΛΑΦΑΚΗΣ ΓΙΑΝΝΗΣ - 39442
* ΖΑΧΑΡΙΟΥ ΚΩΣΤΑΣ - 39343

**Project**
-----------
**Εφαρμογή αγοράς εισιτηρίων υπεραστικών λεωφορείων**

1.    Το αρχείο Word περιέχει ότι μας ζητήθηκε απο την εκφώνηση , συμπεριλαμβανομένων και όλων τον παρακάτω.
2.	Στον φάκελο CoverageReport υπάρχει ολόκληρη η αναφορά η οποια δημιουργήθηκε κάνοντας Export το Project σαν Code Covarage Report με την βοήθεια του Eclipse.Επίσης υπάρχει και ένα print screen του Covarage του Eclipse.
3.	Στον φάκελο GUI Screenshots υπάρχουν print screen του GUI.
4.	Στον φάκελο JUnit Tests Screenshots υπάρχουν print screen των JUnit Test μεσα στο Eclipse.
5.	Στον φάκελο mysql Database dump βρίσκονται όλα τα .sql αρχέια της Βάσης μας (Backup - dump)
6.	Ο Φάκελος SoftEng είναι ουσιαστικά το Java Project του Eclipse.
7.	Στον φάκελο UML Diagrams βρίσκονται όλα τα UML Διαγράμματα σε PNG μορφή.Δημιουργήθηκαν  όλα (εκτος απο το διάγραμμα κλάσεων) με το Visual Paradigm
8.  Στον φάκελο PMD Reports βρίσκονται τα Reports απο το PMD Static Analysis πρίν και μετά.

Instructions
------------
Για την αλλαγή τον στοιχείων της Mysql πηγαίνεται στην κλάση *JDBCMySQLConnection*
Και αλλάξτε τα απαραίτητα στοιχεία με τα δικά σας !!!

```sh
public class JDBCMySQLConnection {
public static final String URL = "jdbc:mysql://localhost/test";
    	`public static final String USER = "root";
    	`public static final String PASSWORD = "password";
public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
...
...
```
Το αρχείο .txt με όνομα Announcements είναι απαραίτητο για την εφαρμογή !!!
Βρίσκετε ήδη μεσα στο Project (φάκελο SoftEng).

Extra
-----
Στον φάκελο **EXTRA** υπάρχει ένα αρχείο .jar το οποίο εκτελείται και ανοίγει η εφαρμογή μας , ομως υπάρχει η δυνατότητα πατώντας το κουμπί `Mysql Configuration` ανοίγει ένα παράθυρο όπου μπορείτε να εισάγετε τα στοιχεία ενός άλλου *Mysql Server(URL, USER, PASSWORD)* χωρίς να πειράξετε τον κώδικα !!! 
Ο κώδικας αυτός δεν περιλαμβάνεται στην τελική εργασία , αλλα υπάρχει μέσα στον φάκελο.  Το κάναμε αυτο σε περίπτωση που η δημιουργία ενός .jar αρχείου 
είναι υποχρεωτική, ετσι  ώστε να δουλέψει η εφαρμογή !!



    
