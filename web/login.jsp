<!DOCTYPE html>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html lang="en">
  <head>
   <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Login</title>

    <!-- Bootstrap core CSS -->
    <link href="template/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="template/css/cover.css" rel="stylesheet">

    
  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

           <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">Centro Pokemon</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li class="active"><a href="#">Inicio</a></li>
                  <li><a href="Usuario/index.jsp">Usuario</a></li>
                  <li><a href="Pokemon/index.jsp">Pokemon</a></li>
                  <li><a href="Habilidades/index.jsp">Habilidad</a></li>
                  <li><a href="Tipo/index.jsp">Tipos</a></li>
                  <li><a href="Ciudades/index.jsp">Ciudades</a></li>
                  <li><a href="paises/index.jsp">paises</a></li>
                </ul>
              </nav>
            </div>
          </div>
            <sql:setDataSource 
		var="usr"
			url="jdbc:mysql://localhost:3306/pokedex"
			driver="com.mysql.jdbc.Driver"
			user="root" password="" 
		/>
		<sql:query dataSource="${usr}" var="result1" >
				select * from usuarios where nombre=? 
				<sql:param value="${param.nombre}"/>
		</sql:query>

		<c:forEach var="row1" items="${result1.rows}">
			<c:set var="flag1" scope="application" value="1"/>
		</c:forEach>

		<sql:query dataSource="${usr}" var="result2" >
			select * from usuarios where nombre=? and passwd=?
			<sql:param value="${param.nombre}"/>
			<sql:param value="${param.passwd}"/>
		</sql:query>

		<c:forEach var="row2" items="${result2.rows}">
		<c:set var="flag2" scope="application" value="1"/>
		</c:forEach>

			
			<c:choose>
			<c:when test="${flag2 eq 1}">
			<c:forEach var="row2" items="${result2.rows}">
		    <c:set var="flag2" scope="application" value="1"/>
			
                    <table class="table table-bordered">
                        <tbody>
                        <h1>Tus Datos</h1>
                            <tr>
                                <td>Usuario_id</td>
                                <td>NOMBRE</td>
                                <td>fecha</td>
                            </tr>
                            <tr>
                                <td><c:out value="${row2.usuario_id}"/></td>
                                <td><c:out value="${row2.nombre}"/></td>
                                <td><c:out value="${row2.fecha}"/></td>
                            </tr>
                        </tbody>
                    </table>

				
		    </c:forEach>
			    <c:set var="flag1" scope="application" value="0"/>
				<c:set var="flag2" scope="application" value="0"/>
			
			</c:when>
			
			<c:when test="${flag1 eq 0}">
			
				<h1>
                                    User Not Registered ...<br>
                                        <a href="index.html">volver</a>
				</h1>
			
			
				<c:set var="user_flag" scope="application" value="0"/>
				<c:set var="flag" scope="application" value="0"/>
			</c:when>
			
			<c:otherwise>
			
				<h1>
					Invalid Password , Try Again !!!
				</h1>
			
				<c:set var="user_flag" scope="application" value="0"/>
				<c:set var="flag" scope="application" value="0"/>
			</c:otherwise>
			</c:choose>
          </div>

        </div>

      </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="template/js/bootstrap.min.js"></script>
    
  </body>
</html>
