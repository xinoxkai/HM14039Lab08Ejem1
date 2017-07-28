package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.Facultad;
import Modelo.Carrera;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      BD.FacultadBD FacultadBD = null;
      synchronized (session) {
        FacultadBD = (BD.FacultadBD) _jspx_page_context.getAttribute("FacultadBD", PageContext.SESSION_SCOPE);
        if (FacultadBD == null){
          FacultadBD = new BD.FacultadBD();
          _jspx_page_context.setAttribute("FacultadBD", FacultadBD, PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');
      BD.CarreraBD CarreraBD = null;
      synchronized (session) {
        CarreraBD = (BD.CarreraBD) _jspx_page_context.getAttribute("CarreraBD", PageContext.SESSION_SCOPE);
        if (CarreraBD == null){
          CarreraBD = new BD.CarreraBD();
          _jspx_page_context.setAttribute("CarreraBD", CarreraBD, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

 if (request.getParameter("cmd") == null) {
    //FacultadBD.obtenerFacultades();
    CarreraBD.obtenerCarreras();
 } else {
 if (request.getParameter("cmd").equals("guardar")) {
 if (request.getParameter("codigotxt")
 != null && request.getParameter("nombretxt")
 != null && request.getParameter("facultadlst")
 != null) {
 if (!request.getParameter("codigotxt").isEmpty() &&
 !request.getParameter("nombretxt").isEmpty()) {
 String codigo = request.getParameter("codigotxt");
 String nombre = request.getParameter("nombretxt");
 Integer idFacultad = Integer.parseInt(request.getParameter("facultadlst"));
 if (CarreraBD.guardar(codigo, nombre, idFacultad)) {
 out.print("<strong>Guardado</strong>");
 CarreraBD.obtenerCarreras();
 } else {
 out.print("<strong>Ocurrió un error al guardar</strong>");
 }
 } else {
 out.print("<strong>Debe ingresar los campos solicitados</strong>");
 }
 } else {
 out.print("<strong>Debe ingresar los campos solicitados</strong>");
 }
 }
 }

      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write(" <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write(" <title>Registro de carreras por facultad</title>\n");
      out.write(" <script type=\"text/javascript\">\n");
      out.write(" function asignarAccion(accion) {\n");
      out.write(" document.forms['carrerafrm'].cmd.value = accion;\n");
      out.write(" }\n");
      out.write(" </script>\n");
      out.write(" </head>\n");
      out.write(" <body>\n");
      out.write(" <form id=\"carrerafrm\">\n");
      out.write(" <table>\n");
      out.write(" <tbody>\n");
      out.write(" <tr>\n");
      out.write(" <td>Código:</td>\n");
      out.write(" <td><input name=\"codigotxt\" type=\"text\"/></td>\n");
      out.write(" </tr>\n");
      out.write(" <tr>\n");
      out.write(" <td>Nombre:</td>\n");
      out.write(" <td><input name=\"nombretxt\" type=\"text\"/></td>\n");
      out.write(" </tr>\n");
      out.write(" <tr>\n");
      out.write(" <td>Facultad:</td>\n");
      out.write(" <td>\n");
      out.write("<select name=\"facultadlst\">\n");
      out.write(" ");
for (Facultad facultad : FacultadBD.getFacultades()) {
      out.write("\n");
      out.write(" <option value=\"");
      out.print(facultad.idFacultad);
      out.write('"');
      out.write('>');
      out.print(facultad.nomFacultad);
      out.write("\n");
      out.write(" </option>\n");
      out.write(" ");
}
      out.write("\n");
      out.write(" </select>\n");
      out.write(" </td>\n");
      out.write(" </tr>\n");
      out.write(" </tbody>\n");
      out.write(" <tfoot>\n");
      out.write("<tfoot>\n");
      out.write(" <tr>\n");
      out.write(" <td><input type=\"submit\" value=\"Guardar\" onclick=\"asignarAccion('guardar')\"/>\n");
      out.write(" </td>\n");
      out.write(" </tr>\n");
      out.write(" </tfoot>\n");
      out.write(" </table>\n");
      out.write(" <input name=\"cmd\" type=\"hidden\"/>\n");
      out.write(" </form>\n");
      out.write(" <br/>\n");
      out.write(" <br/>\n");
      out.write(" <table border=\"1\">\n");
      out.write(" <thead>\n");
      out.write(" <tr>\n");
      out.write(" <th>Código</th>\n");
      out.write(" <th>Nombre</th>\n");
      out.write(" <th>Facultad</th>\n");
      out.write(" </tr>\n");
      out.write(" </thead>\n");
      out.write(" <tbody>\n");
      out.write(" <tr>\n");

 for (Carrera carrera : CarreraBD.getCarreras()) {
 
      out.write("\n");
      out.write(" <tr>\n");
      out.write(" <td>");
      out.print(carrera.idCarrera);
      out.write("</td>\n");
      out.write(" <td>");
      out.print(carrera.nomCarrera);
      out.write("</td>\n");
      out.write(" <td>");
      out.print(carrera.Facultad.nomFacultad);
      out.write("</td>\n");
      out.write(" </tr>\n");
      out.write(" ");

 }
 
      out.write("\n");
      out.write(" </tbody>\n");
      out.write(" </table>\n");
      out.write(" </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
