<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	
    <title>Admin Panel</title>
    
</head>

<body>
    <div class="side-menu">
        <div class="brand-name">
		<a href="index.jsp" class="logo"> <i class="fas fa-heartbeat"></i> medcare</a></div>
        <ul>
            <!--<li><img src="dashboard (2).png" alt="">&nbsp; <span>Dashboard</span> </li>-->
			<li><div class="Test" style ="padding-right:22px"><i class="fa fa-user-md"></i>&nbsp;<span>médecines</span></div></li>
			<li><div class="Test" style ="padding-right:48px"><i class="fa fa-stethoscope"></i>&nbsp;<span>patients</span></div></li>
			<li><div class="Test" style ="width:210px"><i class="fa fa-plus-square" style ="font-size:20px"></i>&nbsp;<span style="margin-left:0px ; padding-right:10px ">consultation</span></div></li>
            <li><div class="Test" style ="padding-right:90px"><i class="fa fa-question-circle"></i>&nbsp;<span>Help</span></div></li>
            <li><div class="Test" style ="padding-right:52px"><i class="fa fa-cog"><i class="fa-regular fa-circle-info"></i></i>&nbsp;<span>Settings</span></div></li>
        </ul>
    </div>
    <div class="container">
        <div class="content">
            <div class="cards">
                <div class="card">
                    <div class="box">
                        <h1><i class="fa fa-user-md" style="margin-right:10px"></i>médecines</h1>
                        <h3 style="text-align:center"><b>2194</b></h3>
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1><i class="fa fa-stethoscope" style="margin-right:10px"></i>patients</h1>
                        <h3 style="text-align:center"><b>2194</b></h3>
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h1 style="font-size:35px"><i class="fa fa-plus-square" style="margin-right:10px"></i>consultation</h1>
                        <h3 style="text-align:center"><b>2194</b></h3>
                    </div>
                </div>
            </div>
            <div class="content-2">
                <div class="recent-payments">
                    <div class="title">
                        <h2><b>Modification récente</h2>
                        <a href="index.jsp" class="btn">Voir</a>
                    </div>
                    <table style="width:110%">
                        <tr>
                            <th>Professeur</th>
                            <th>Classe</th>
                            <th>Option</th>
                        </tr>
                        <tr>
                            <td>abdellatif</td>
                            <td>Genie info 4</td>
                            <td><a href="#" class="btn">Voir</a></td>
                        </tr>
                    </table>
                </div>
                <div class="new-students">
                    <div class="title">
                        <h2 style="font-size:25px;"><b>Nouveaux comptes </h2>
                        <a href="#" class="btn">Voir</a>
                    </div>
                    <table style="width:120%" >
                        <tr>
                            <th>Profil</th>
                            <th>Nom</th>
                            <th>option</th>
                        </tr>
                        <tr>
                            <td><img src="user.png" alt=""></td>
                            <td>aya</td>
                            <td>Admin</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>

</html>