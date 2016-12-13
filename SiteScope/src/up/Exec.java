/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package up;

//import group.Group;
//import javax.servlet.annotation.*;
import PerfomanceMonitor.*;
import group.Node;
import group.SimpleCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PerfomanceMonitor.PerfomanceMonitor;

//import com.sun.glass.ui.CommonDialogs.Type;

import sun.font.Type1Font;

/**
 *
 * @author out-zaikin-sn
 */
@WebServlet(name = "Exec", urlPatterns = {"/cgi/go.exe/SiteScope"})
public class Exec extends HttpServlet {
    private final SimpleDateFormat sdf = new SimpleDateFormat("E,dd MMM yyyy HH:mm:ss");

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

        response.setContentType("text/xml;charset=Cp1251");
        response.addHeader("Server", "SiteScope/8.1.2.0 10:03 pm 03/09/06 build 509");
        response.addDateHeader("Date", System.currentTimeMillis());
        PrintWriter out = null;
        try  {
        	out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Exec</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Exec at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        	/*
            out.println("<?xml version=\"1.0\"?>");
            out.print("<PerformanceMonitor>");
                out.print("<object class=\"group\" name=\"NewGroup\" desc=\"NewGroup\">");
                    out.print("<object class=\"monitor\" name=\"Localhost\" desc=\"Localhost\"> type=\"PDHMonitor\"");
                        out.print("<counter name =\"Name1\" desc=\"Name1\"/>");
                        out.print("<counter name =\"Name2\" desc=\"Name2\"/>");
                    out.print("</object>");
                out.print("</object>");
                //Type t = group.Group.Type.GROUP;
                //Group<Type> e = new Group<Type>();
                */
                PerfomanceMonitor p = new PerfomanceMonitor();
                Group gr = p.addGroup("SmartVista", "For SmartVista Testing");
                Monitor mon = gr.addMonitor("SmartVista", "For SmartVista Testing","PDHMonitor");
                Counter cn = mon.addCounter("CountRequests", "Count Request");
                Counter cn2 = mon.addCounter("CountThread", "Count Thread");
                cn.set("http://127.0.0.1:8085/CountRequests","(.*)");
                cn2.set("http://127.0.0.1:8085/CountThread","(.*)");
                out.print(p.toString());
                
                /*
                SimpleCounter CountRequests = new SimpleCounter("CountRequests", "CountRequests metric");
                
                SimpleCounter CountThread = new SimpleCounter("CountThread", "CountThread metric");
                Group group = new Group("SmartVista", "For SmartVista Testing", Group.Type.GROUP );
                Group counters = new Group("SmartVista Counters", "SmartVista Metrics", Group.Type.MONITOR );
                out.print(group.toString(true));
                out.print(counters.toString(true));
            out.print("</PerformanceMonitor>");
            */
            out.flush();
        }finally{
        	out.close();
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
