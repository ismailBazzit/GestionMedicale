<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="x-icon" href="logo.png">
	<link rel="shortcut icon" type="x-icon" href="logo.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	
    <title>Patients</title>
    
</head>

<body id="anass">
	
    <div class="side-menu">
        <div class="brand-name">
		<a href="homeServlet" class="logo"> <i class="fas fa-heartbeat"></i> medcare</a></div>
        <ul>
            <!--<li><img src="dashboard (2).png" alt="">&nbsp; <span>Dashboard</span> </li>-->
			<li><div class="Test" style ="padding-right:22px"><a href="listMedcin" class="logo" style="font-size:21px"><i class="fa fa-user-md"></i>&nbsp;médecins</a></div></li>
			<li><div class="Test" style ="padding-right:22px;background:white;color: #5386E4"><a href="listPatient" class="logo" style="font-size:25px;background:white;color: #5386E4"><i class="fa fa-stethoscope"></i>&nbsp;patients</a></div></li>
			<li><div class="Test" style ="padding-right:22px;height:57px"><a href="Consultations" class="logo" style="font-size:19px;height=100px"><i class="fa fa-plus-square"></i>&nbsp;consultation</a></div></li>
        </ul>
    </div>
   <div id="container">
	<table  class="table table-striped table-bordered " style="width:75%;margin-left:285px">
		<thead class="table-info ">
			<div class="table" >
				<div class="table_header" style="display: flex;justify-content: space-between;align-items: center;padding: 20px;">
					<p style="color: #000000"></p>
					<h2 style="margin-left:70px">Liste des Patients</h2>
					<div>
						<a href ="<%=request.getContextPath()%>/newPatient" class="add_new" style="font-size:22px">+ Ajouter</a>
					</div>
				</div>
			</div>
			<tr>
			<th>Id</th>
			<th>Adress</th>
			<th>Date Naissance</th>
			<th>Genre</th>
			<th>nom Complet</th>
			<th>Tel</th>
			<th>Actions</th>
			</tr>
		</thead>
		<c:forEach var="p" items="${list}">
			<tr>
                    <td><c:out value="${p.id}" /></td>
                    <td><c:out value="${p.adress}" /></td>
                    <td><c:out value="${p.dateNaissance}" /></td>
                    <td><c:out value="${p.genre}" /></td>
                    <td><c:out value="${p.nomComplet}" /></td>
                    <td><c:out value="${p.tel}" /></td>
				<td>
				 
				<a href ="<%=request.getContextPath()%>/editPatient?id=<c:out value='${p.id}' />" 
				class="btn btn-warning"><img src="edit.png" style="width:20px";height="20px";></a>
				<a href ="<%=request.getContextPath()%>/deletePatient?id=<c:out value='${p.id}' />" 
				class="btn btn-danger"><img src="trash.png" style="width:20px";height="20px";></a> 
				</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
        </div>
   </div>
</body>

</html>