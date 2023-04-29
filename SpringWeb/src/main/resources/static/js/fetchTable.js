
alert("fetchTable");


async function loadTable(url,table) {
const tableBody = table.querySelector("tbody");

const response =await fetch(url);

const data =await response.json();

debugger;
const rowElement=document.createElement("tr");
for (const x of data){
const cellElement =document.createElement("td");

for (const y of row){
alert(y);
}
cellElement.textContent= x;
rowElement.appendChild(cellElement);
}
tableBody.appendChild(rowElement);

}





loadTable('http://localhost:8080/fetchTable',document.querySelector("table"));