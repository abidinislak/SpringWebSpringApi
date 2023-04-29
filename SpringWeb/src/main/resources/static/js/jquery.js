


async function getUsers() {
    let url = 'http://localhost:8080/test';
    try {
        let res = await fetch(url);
        return await res.text();
    } catch (error) {
        console.log(error);
    }
}



async function renderUsers() {
    let users = await getUsers();
document.getElementById("p1").innerHTML = users+" .......    this return from 8081 post rest api";
}

renderUsers();

///////// static json file
//async function getUsers() {
//    let url = 'test.json';
//    try {
//        let res = await fetch(url);
//        return await res.json();
//    } catch (error) {
//        console.log(error);
//    }
//}
//
//
//
//async function renderUsers() {
//    let users = await getUsers();
//    let html = '';
//    users.forEach(user => {
//        let htmlSegment = `<div class="user">
//
//                            <h2>${user.firstName} ${user.lastName}</h2>
//                            <div class="email"><a href="email:${user.email}">${user.email}</a></div>
//                        </div>`;
//
//        html += htmlSegment;
//    });
//
//    let container = document.querySelector('.container');
//    container.innerHTML = html;
//}
//
//renderUsers();


//
// fetch('http://localhost:8080/test', {
//  method: 'GET',
//headers: {
//        "Content-type": "application/json; charset=UTF-8"
//    }
//})
//
//.then(response => {
//debugger;
//
//alert(response.status); // 200
//   alert(response.statusText); // OK
//   alert(response.json().body); // OK
//   alert(response.text()); // OK
//
//
//
//
//
//})
//
//               .catch(error => new Error(error));

//then(json => {
//
//debugger;
//           alert(json.text());
//
//        })
//        .catch(err => {
//           alert("olamdi");
//        });
//
//        alert(response);