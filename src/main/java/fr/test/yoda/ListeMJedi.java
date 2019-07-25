package fr.test.yoda;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class ListeMJedi {
    /* La liste qui contiendra tous les résultats de nos essais */
    private List<String> listJedi = new ArrayList<String>();

    public List<String> executerTests(HttpServletRequest request) {
        /* Chargement du driver JDBC pour MySQL */
        try {
         //   messages.add("Chargement du driver...");
            Class.forName("com.mysql.jdbc.Driver");
         //   messages.add("Driver chargé !");
        } catch (ClassNotFoundException e) {
            listJedi.add("Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                    + e.getMessage());
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/starwars?serverTimezone=GMT";
        String utilisateur = "root";
        String motDePasse = "flotit33";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
         //   messages.add("Connexion à la base de données...");
            connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
         //   messages.add("Connexion réussie !");

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
         //   messages.add("Objet requête créé !");

            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery("SELECT name ,surname FROM jedi_masters");
            //messages.add("Requête \"SELECT name, surname FROM jedi_masters;\" effectuée !");

            /* Récupération des données du résultat de la requête de lecture */
            while (resultat.next()) {
                String nameJedi = resultat.getString("name");
                String surnameJedi = resultat.getString("surname");

                /* Formatage des données pour affichage dans la JSP finale. */
               // messages.add("Données retournées par la requête : name= " + nameJedi + " surname = " + surnameJedi
                //       + ".");
                listJedi.add( nameJedi + " " + surnameJedi);
            }
        } catch (SQLException e) {
            listJedi.add("Erreur lors de la connexion : <br/>"
                    + e.getMessage());
        } finally {
            //messages.add("Fermeture de l'objet ResultSet.");
            if (resultat != null) {
                try {
                    resultat.close();
                } catch (SQLException ignore) {
                }
            }
            //messages.add("Fermeture de l'objet Statement.");
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ignore) {
                }
            }
           // messages.add("Fermeture de l'objet Connection.");
            if (connexion != null) {
                try {
                    connexion.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return listJedi;
    }

}


