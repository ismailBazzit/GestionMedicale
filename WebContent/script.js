// Create a "close" button and append it to each list item
var myNodelist = document.getElementsByTagName("LI");
var i;
for (i = 0; i < myNodelist.length; i++) {
  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
  close[i].onclick = function() {
    var div = this.parentElement;
    div.style.display = "none";
  }
}

// Create a new list item when clicking on the "Add" button
function newElement() {
  var ul = document.createElement("ul");
  var inputValue = document.getElementById("myInput").value;
  var t = document.createTextNode(inputValue);
  ul.appendChild(t);
  if (inputValue === '') {
    alert("You must write something!");
  } else {
    document.getElementById("myUL").appendChild(ul);
  }
  document.getElementById("myInput").value = "";

  var span = document.createElement("SPAN");
  var txt = document.createTextNode("\u00D7");
  span.className = "close";
  span.appendChild(txt);
  ul.appendChild(span);

  for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
      var div = this.parentElement;
      div.style.display = "none";
    }
  }
}
function getSymptom(){
	  var sym = document.getElementById("symall");
	  var symlist = document.getElementById("myUL").children;
	  for(var i = 0 ; i<symlist.length ; i++){
		sym.value +=","+symlist[i].childNodes[0].textContent;
		console.log(symlist[i].childNodes[0].textContent);
		}
}
function generatePDF(){
	
	var cpt = 50;
    var doc = new jsPDF();
    var medecin = document.getElementById("medecin").value;
    var datec = document.getElementById("datec").value;
    var patient = document.getElementById("patient").value;
    var malade = document.getElementById("malade").value;
    var symptome = document.querySelectorAll(".symptome");
    var description = document.getElementById("description").value;
    var prix = document.getElementById("prix").value;
    
    doc.text("Facture " , 100, 5);
    doc.text("" , 15,60);
    doc.text("" , 15,65);
    doc.text("" , 15,70);

    doc.text("Medecin : " + medecin, 15, 10);
    doc.text("Date Consultation : " + datec, 15, 20);
    doc.text("Patient : " + patient, 15, 30);
    doc.text("Malade : " + malade, 15, 40);
    doc.text("Symptome : \n" , 15,50);
    doc.text("" , 15,55);
    for(var i = 0 ; i<symptome.length ;i++){cpt+=10;
	 doc.text("          -" + symptome[i].value, 25, cpt);
	 
	}
   	doc.text("Description : " + description, 15,(cpt+10));
    doc.text("Prix : " + prix, 15, (cpt+20));
    
    doc.output("save", "Facture.pdf");
    
}