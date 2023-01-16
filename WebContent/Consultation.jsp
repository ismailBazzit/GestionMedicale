<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" type="x-icon" href="logo.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	
    <title>Consultation</title>
    
</head>

<body>
	
    <div class="side-menu">
        <div class="brand-name">
		<a href="homeServlet" class="logo"> <i class="fas fa-heartbeat"></i> medcare</a></div>
        <ul>
            <!--<li><img src="dashboard (2).png" alt="">&nbsp; <span>Dashboard</span> </li>-->
			<li><div class="Test" style ="padding-right:22px"><a href="listMedcin" class="logo" style="font-size:21px"><i class="fa fa-user-md"></i>&nbsp;médecins</a></div></li>
			<li><div class="Test" style ="padding-right:22px"><a href="listPatient" class="logo" style="font-size:25px"><i class="fa fa-stethoscope"></i>&nbsp;patients</a></div></li>
			<li><div class="Test" style ="padding-right:22px;height:57px;background:white;color: #5386E4"><a href="Consultations" class="logo" style="font-size:19px;height=100px;background:white;color: #5386E4"><i class="fa fa-plus-square"></i>&nbsp;consultation</a></div></li>
        </ul>
    </div>
	<table class="table table-striped table-bordered " style="width:75%;margin-left:285px">
		<thead class="table-info ">
			<div class="table" >
				<div class="table_header" style="display: flex;justify-content: space-between;align-items: center;padding: 20px;">
					<p style="color: #000000"></p>
					<h2 style="margin-left:70px">Liste des Consultations</h2>
					<div>
						<a href ="createConsultation" class="add_new" style="font-size:22px">+ Ajouter</a>
					</div>
				</div>
			</div>
			<tr>
			<th>IdC</th>
			<th>Date</th>
			<th>Description</th>
			<th>Prix</th>
			<th>Nom medecin</th>
			<th>Nom malade</th>
			<th>Diagnostique</th>
			<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cons" items="${Consultations}">
			<tr>
			<td>${ cons.getId()}</td>
			<td>${ cons.getDateC()}</td>
			<td>${ cons.getDescription()}</td>
			<td>${ cons.getPrix()}</td>
			<td>${ cons.getMedcin().getNomComplet()}</td>
			<td>${ cons.getMalade().getNomComplet()}</td>
			<td><div class="box">
        <a href="diagnostique?id=${cons.getId()}" class="btn"><i class='far fa-file-alt'></i></a>
    </div>
   
    <style>
.box{
    text-align: center;
}
/*.button{
    font-size: 1em;
    padding: 15px 35px;
    color: #fff;
    text-decoration: none;
    cursor: pointer;
    transition: all 0.3s ease-out;
    background: ;
    border-radius: 50px;
}*/
.overlay{
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background: rgba(0, 0, 0, 0);
    transition: opacity 500ms;
    visibility: hidden;
    opacity: 0  ;
}
.overlay:target{
    visibility: visible;
    opacity: 1;
}
.wrapper{
    /*margin: 40px auto;*/
	margin-left: 720px;
	padding-bottom: 110px;
	padding-right: 110px;
    padding: 2px;
    background: red;
    border-radius: 5px;
    width: 35%;
    position: relative;
    transition: all 5s ease-in-out;
}
.wrapper h2{
    margin-top: 0;
    color: #333;
}
.wrapper .close{
    position: absolute;
    top: 20px;
    right: 30px;
    transition: all 200ms;
    font-size: 30px;
    font-weight: bold;
    text-decoration: none;
    color: #333;
}
.wrapper .content{
    max-height: 30%;
    overflow: auto;
}

.container{
    border-radius:5px ;
    background-color: #0298cf;
    padding: 20px 0;
}
form label{
    text-transform: uppercase;
    font-weight: 100;
    letter-spacing: 3px;
}
input[type=text],textarea{
    width: 70%;
    padding: 12px;
    border: 1px solid GREEN;
    border-radius: 5px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}
input[type="submit"]{
    background-color: GREEN;
    color: GREEN;
    padding: 15px 50px;
    border: none;
    border-radius: 50px;
    cursor: pointer;
    font-size: 15px;
    text-transform: uppercase;
    letter-spacing: 3px;
}
    </style>
    </td>
			<td>
			<a href="showConsultation?id=${cons.getId()}">Edit</a>
			<form action="deleteConsultation" method="POST">
			<input type="text" style="display: none;" value="${cons.getId()}" name="idCon">
				<button type="submit" class="ET">
				<style>
.ET{
    color: #5386E4;
    background: white;
    padding: 3px 8px;
    outline: none;border: 1px solid #0298cf;border-radius: 6px;
}
.ET:hover{
    color: white;
    background-color:RED;
    
}

    </style>
				Delete</button>
				
			</form>
		</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
        </div>
    </div>
    
</body>

</html>