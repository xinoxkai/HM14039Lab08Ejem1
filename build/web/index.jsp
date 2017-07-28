<%-- 
    Document   : index
    Created on : 08-nov-2016, 18:29:28
    Author     : PRN-315
--%>


<%@page import="Modelo.Carrera"%>
<%@page import="Modelo.Facultad"%>
<jsp:useBean id="FacultadBD" scope="session" class="BD.FacultadBD" />
<jsp:useBean id="CarreraBD" scope="session" class="BD.CarreraBD" />


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 if (request.getParameter("cmd") == null) {
    FacultadBD.obtenerFacultades();
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
%>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Registro de carreras por facultad</title>
 <script type="text/javascript">
 function asignarAccion(accion) {
 document.forms['carrerafrm'].cmd.value = accion;
 }
 </script>
 </head>
 <body>
 <form id="carrerafrm">
 <table>
 <tbody>
 <tr>
 <td>Código:</td>
 <td><input name="codigotxt" type="text"/></td>
 </tr>
 <tr>
 <td>Nombre:</td>
 <td><input name="nombretxt" type="text"/></td>
 </tr>
 <tr>
 <td>Facultad:</td>
 <td>
<select name="facultadlst">
 <%for (Facultad facultad : FacultadBD.getFacultades()) {%>
 <option value="<%=facultad.idFacultad%>"><%=facultad.nomFacultad%>
 </option>
 <%}%>
 </select>
 </td>
 </tr>
 </tbody>
 <tfoot>
<tfoot>
 <tr>
 <td><input type="submit" value="Guardar" onclick="asignarAccion('guardar')"/>
 </td>
 </tr>
 </tfoot>
 </table>
 <input name="cmd" type="hidden"/>
 </form>
 <br/>
 <br/>
 <table border="1">
 <thead>
 <tr>
 <th>Código</th>
 <th>Nombre</th>
 <th>Facultad</th>
 </tr>
 </thead>
 <tbody>
 <tr>
<%
 for (Carrera carrera : CarreraBD.getCarreras()) {
 %>
 <tr>
 <td><%=carrera.idCarrera%></td>
 <td><%=carrera.nomCarrera%></td>
 <td><%=carrera.Facultad.nomFacultad%></td>
 </tr>
 <%
 }
 %>
 </tbody>
 </table>
 </body>
</html>
