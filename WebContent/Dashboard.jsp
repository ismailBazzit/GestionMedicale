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
	
    <title>Medcare</title>
    
</head>

<body>
    <div class="side-menu">
        <div class="brand-name">
		<a href="homeServlet" class="logo"> <i class="fas fa-heartbeat"></i> medcare</a>
		</div>
        <ul>
            <!--<li><img src="dashboard (2).png" alt="">&nbsp; <span>Dashboard</span> </li>-->
			<li><div class="Test" style ="padding-right:22px"><a href="listMedcin" class="logo" style="font-size:21px"><i class="fa fa-user-md"></i>&nbsp;médecins</a></div></li>
			<li><div class="Test" style ="padding-right:22px"><a href="listPatient" class="logo" style="font-size:25px"><i class="fa fa-stethoscope"></i>&nbsp;patients</a></div></li>
			<li><div class="Test" style ="padding-right:22px;height:57px"><a href="Consultations" class="logo" style="font-size:19px;height=100px"><i class="fa fa-plus-square"></i>&nbsp;consultation</a></div></li>
        </ul>
    </div>
    <div class="container" style="width:75%">
        <div class="content" style="margin-left:10px">
            <div class="cards">
                <div class="card">
                    <div class="box">
                        <h1><i class="fa fa-user-md" style="margin-right:10px"></i>médecins</h1>
                        <h3 style="text-align:center"><b>${nbrMedcins}</b></h3>
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1><i class="fa fa-stethoscope" style="margin-right:10px"></i>patients</h1>
                        <h3 style="text-align:center"><b>${nbrMalades}</b></h3>
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1 style="font-size:35px"><i class="fa fa-plus-square" style="margin-right:10px"></i>consultation</h1>
                        <h3 style="text-align:center"><b>${nbrConsultation}</b></h3>
                    </div>
                </div>
            </div>
            <div class="content-2" >
                <div class="recent-payments" style="width:100%;margin-left:0px">
                    <div class="title">
                        <h2><b>Consultation récente</h2>
                        <a href="Consultations" class="btn">Voir</a>
                    </div>
                    <table style="width:110%">
                        <tr>
                            <th>médecins</th>
                            <th>patients</th>
                            <th>Date</th>
                        </tr>
                        <c:forEach items="${consultations}" var= "con">
                        <tr>
                            <td>${con.medcin.nomComplet}</td>
                            <td>${con.malade.nomComplet}</td>
                            <td style="font-size:14px;padding-right:50px">${con.dateC}</td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="new-students" style="width:100%;margin-right:2px">
                    <div class="title">
                        <h2 style="font-size:25px"><b>Nouveaux patients</h2>&nbsp;
                        <a href="listPatient" class="btn">Voir</a>
                    </div>
                    <table style="width:100%;margin-right:10px">
                        <tr>
                            <th>Nom</th>
                            <th>Adresse</th>
                            <th style="font-size:15px">date de naissance</th>
                        </tr>
                        <c:forEach items="${malades}" var="m">
                        <tr>
                            <td>${m.nomComplet}</td>
                            <td>${m.adress}</td>
                            <td>${m.dateNaissance}</td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>