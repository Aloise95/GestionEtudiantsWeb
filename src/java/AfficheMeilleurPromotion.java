/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author benoit
 */
public class AfficheMeilleurPromotion extends HttpServlet {

    private void affichePromotionsDispo (PrintWriter out) {
        // Affichage de la liste des étudiants
        ArrayList<Promotion> listP = (ArrayList<Promotion>)getServletContext().getAttribute("listPromotions");
        int i = 0;
        if (listP.size() == 0) {
            out.println("Aucune promotion disponible !<br>");
            return;
        }
        for (Promotion p:listP)
            out.println(i++ +": "+p.getNom()+"<br>");
        
        // Affichage du formulaire permettant de saisir un étudiant de cette liste
        out.println("<form action=\"AfficheMeilleurPromotion\" method=\"get\"><table border=\"0\">\n" +
                            "<tbody>\n" +
                            "<tr>\n" +
                            "   <td>numero</td>\n" +
                            "   <td><input type=\"text\" name=\"numero\" value=\"\" size=\"20\" /></td>\n" +
                            "   </tr>\n" +
                            "   <tr>\n" +
                            "   <td></td>\n" +
                            "   <td> <input type=\"submit\" value=\"valider\" name=\"validation\" /></td>\n" +
                            "   </tr>\n" + "   </tbody>\n" + "   </table>\n" + "</form>");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AffichePromotion</title>");            
            out.println("</head>");
            out.println("<body>");
            String valeur = request.getParameter("numero");
            if (valeur == null) {
                // On considère qu'on veut afficher la liste des promotions disponibles
                out.println("Choisir une promotion:<br>");
                affichePromotionsDispo(out);
            }
            else {
                // On considère que valeur contient le numéro de la promotion à afficher
                int numero = Integer.parseInt(valeur);
                ArrayList<Promotion> listP = (ArrayList<Promotion>)getServletContext().getAttribute("listPromotions");
                out.println("Le meilleur étudiant de cette promotion est: ");
                out.println(listP.get(numero).meilleurEtudiant());
            }
            out.println("<br><a href=\"index.html\">Retour au menu</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
