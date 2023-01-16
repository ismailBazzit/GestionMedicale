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
	<link rel="shortcut icon" type="x-icon" href="logo.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	
    <title>Patients</title>
    
</head>

<body>
	
    <div class="side-menu">
        <div class="brand-name">
		<a href="homeServlet" class="logo"> <i class="fas fa-heartbeat"></i> medcare</a>
		</div>
        <ul>
            <!--<li><img src="dashboard (2).png" alt="">&nbsp; <span>Dashboard</span> </li>-->
			<li><div class="Test" style ="padding-right:22px;background:white;color: #5386E4"><a href="listMedcin" class="logo" style="font-size:21px;;background:white;color: #5386E4"><i class="fa fa-user-md"></i>&nbsp;médecins</a></div></li>
			<li><div class="Test" style ="padding-right:22px"><a href="listPatient" class="logo" style="font-size:25px"><i class="fa fa-stethoscope"></i>&nbsp;patients</a></div></li>
			<li><div class="Test" style ="padding-right:22px;height:57px"><a href="Consultations" class="logo" style="font-size:19px;height=100px"><i class="fa fa-plus-square"></i>&nbsp;consultation</a></div></li>
        </ul>
    </div>
    <div class="Haw" style="height:80px"></div>
    <c:if test="${medcin != null}">
            <form action="updateMedcin" method="post">
    </c:if>
	<c:if test="${medcin == null}">
            <form action="insertMedcin" method="post">
    </c:if>
            <h4>
                    <c:if test="${medcin != null}">
                        Editer un medcin
                    </c:if>
                    <c:if test="${medcin == null}">
                        Ajouter un medcin
                    </c:if>
            </h4>
                <c:if test="${medcin != null}">
                    <input type="hidden" name="idM" value="<c:out value='${medcin.id}' />" />
                </c:if>
            <hr>
            <div class="name-field">
                <div>
                    <label>Nom Complet</label>
                    <input type="text" name ="nomComplet" value="<c:out value='${medcin.nomComplet}'/>">
                </div> 
                <div>
                    <label>Adress Email</label>
                    <input type="email" name ="email" value="<c:out value='${medcin.email}'/>">
                </div>
            </div>
            <label>Tel</label>
            <input type="tel" name = "tel" value="<c:out value='${medcin.tel}' />">
            <label>Specialite</label>
            <input type="text" name = "specialite" value="<c:out value='${medcin.specialite}' />">
            <input type="submit" value="<c:if test="${medcin != null}">Editer</c:if><c:if test="${medcin == null}">Ajouter</c:if>">
            <!--<p>Vous aver déjè un compte ?<a href="#">se connecter</a></p>-->
            <style>
form{
	margin-left:400px;
	margin-right:300px;
    display: flex;
    flex-direction: column;
    background-color: #fff;
    padding: 10px;
    border-radius: 6px;
    width : 60%;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2  );
}
h4{
    text-align: center;
    font-size: 20px;
}
hr{
    margin: 10px 0;
    background-color: #ccc;
    border: 0;
    height: 1px;
    width: 100%;
}
.name-field{
    display: flex;
    width: 100%;
    justify-content: space-between;
}
.name-field div{
    display: flex;
    flex-direction: column;
}
.name-field div{
    width: 49%;
}
label{
    margin-bottom: 6px;
}
input{
    margin-bottom: 5px;
    padding: 5px;
    outline: 0;
    border: 1px solid rgba(0, 0, 0, 0.4);
}
input:focus{
    border: 1px solid #17a2b8;
}
input[type="submit"]{
    margin-top: 15px;
    background-color: #17a2b8;
    color: #fff;
    border: 1px solid #17a2b8;
    cursor: pointer;
}
p{
    text-align: center;
    margin: 5px 0;
    font-size: 14px;
}
p a{
    text-decoration: 0;
    color: #17a2b8;
}
            </style>
        </form>
        </div>
</body>

</html>