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
	
    <title>Consultation</title>
    
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
			<li><div class="Test" style ="padding-right:22px;height:57px;;background:white;color: #5386E4"><a href="Consultations" class="logo" style="font-size:19px;height=100px;background:white;color: #5386E4"><i class="fa fa-plus-square"></i>&nbsp;consultation</a></div></li>
        </ul>
    </div>
    <div class="Haw" style="height:80px"></div>
    
	<form action="${Consultation == null?'createConsultation':'editConsultation'}" method="POST">
            <h4>ajouter une Consultation</h4>
            <hr>
            <div class="name-field">
                <div>
                <label for="cars" >Medecin</label>
  				<select name="medcin" id="cars" style="border: 1px solid #0298cf;border-radius: 7px;padding-top:10px;padding-bottom:12px">
    			<option value="" >choisir un medecin</option>
    			<c:forEach var="medcin" items="${medcins}">
    			<option value="${medcin.getId()}" ${medcin.getId() == Consultation.getMedcin().getId()?'selected':'' }>${medcin.getNomComplet()}</option>
    			</c:forEach>
  				</select>
                </div> 
               
                <div>
                    <label for="cars" >Patient</label>
  				<select name="malade" id="cars" style="border: 1px solid #0298cf;border-radius: 7px;padding-top:10px;padding-bottom:12px">
    				<option value="malades" >choisir un patient</option>
    			<c:forEach var="malade" items="${malades}">
    				<option value="${malade.getId()}" ${malade.getId() == Consultation.getMalade().getId()?'selected':'' }>${malade.getNomComplet()}</option>
    			</c:forEach>    			
  				</select>
                </div>
            </div>
            
            <div class="name-field">
                <div>
                    <label>Date Consultation</label>
            		<input type="date" name="dateC" value="${Consultation.getDateC()}" style="border: 1px solid #0298cf;border-radius: 7px;">
                </div>      
                
            </div>
            
        	<div class="name-field">
                <div>
                <label style="text-align:left;">les symptomes</label>
    			<input type="text" name="symptome" id="myInput" style="width:100%;border: 1px solid #0298cf;border-radius: 7px;padding-top:10px;padding-bottom:12px" placeholder="Title...">
  				<label style="text-align:left;">les maladies</label>
  				<input type="text" name="maladie" value="${ diagnostiques.get(0).getMaladie().getNomM()}" id="myInput" style="width:100%;border: 1px solid #0298cf;border-radius: 7px;padding-top:10px;padding-bottom:12px" placeholder="Title...">
                </div> 
                <div>
               	<label> </label>
               	&nbsp;
				<span onclick="newElement()" class="btn" style="width:21%;padding:10px">Ajouter </span>
				
  			
                </div>
                <input type="text" name="idconsultation" value="${Consultation.getId()}"  id="" style="display: none;">
                <input type="text" name="symall"  id="symall" style="display: none;">
            </div>
            <ul id="myUL" style="border: 1px solid #0298cf;border-radius: 7px;margin-top:10px">
            <c:forEach var="diagnostique" items="${diagnostiques}">
            	<ul>${diagnostique.getSymptome().getNomS()}<span class="close"></span></ul>
            </c:forEach>
            
			</ul>
			
			<div>
			&nbsp;
            <label>Description</label><br>	
            <textarea type="textarea" name="description" value="${Consultation.getPrix()}" style="width:70%;border: 1px solid #0298cf;border-radius: 7px;"></textarea>
            <div>
			<label for="cars" >prix</label><br>
  			<input type="text" name="prix" value="${Consultation.getPrix()}" id="myInput"  style="width:20%;border: 1px solid #0298cf;border-radius: 7px;padding-top:10px;padding-bottom:12px" placeholder="">
            </div>
            <input type="submit" value="Ajouter" onclick="getSymptom();" style="margin-left:100px"></div>
            </form>
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
        </form>&nbsp;
			</div>	
  <style>
/* Style the close button */
.close {
  position: absolute;
  right: 340px;
  top: 320px;
  padding: 12px 16px 12px 16px;
}

.close:hover {
  background: white;	
    color: #5386E4;
}

/* Style the header */
.heade {
  background-color: #48CAE4;
  padding: 30px 40px;
  color: white;
  text-align: center;
}

/* Clear floats after the header */
.heade:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the input */
input {
  margin: 0;
  border: none;
  border-radius: 0;
  width: 75%;
  padding: 10px;
  float: left;
  font-size: 16px;
}

/* Style the "Add" button */
.addBtn {
  padding: 10px;
  width: 25%;
  background: #d9d9d9;
  color: #555;
  float: left;
  text-align: center;
  font-size: 16px;
  cursor: pointer;
  transition: 0.3s;
  border-radius: 0;
}

.addBtn:hover {
  background-color: #bbb;
}
  </style>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="script.js"></script>
  
       
</body>

</html>