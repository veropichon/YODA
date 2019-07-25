package fr.test.yoda;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GestionTestJDBCServlet",urlPatterns = {"/testjdbc"})
public class GestionTestJDBCServlet extends javax.servlet.http.HttpServlet {
    public static final String ATT_MESSAGES = "messages";
    public static final String VUE          = "/listJediMaster.jsp";

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Initialisation de l'objet Java et récupération des messages */
        ListeMJedi test = new ListeMJedi();
        List<String> listeJedi = test.executerTests( request );
        /* Enregistrement de la liste des messages dans l'objet requête */
        request.setAttribute( ATT_MESSAGES, listeJedi );

        /* Transmission vers la page en charge de l'affichage des résultats */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        //PrintWriter out = response.getWriter();
        //for(String message :messages){
        //    out.println(message);
        //}


    }
}
