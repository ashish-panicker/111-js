class Subscription {
  constructor(firstName, lastName, email, gender, subscriptions) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
    this.subscriptions = subscriptions;
  }
}

const formSubscription = document.querySelector("#formSubscription");

document.querySelector("#signUp").addEventListener("click", (e) => {
  e.preventDefault();
  const formData = new FormData(formSubscription);
  let subscription = new Subscription();

  subscription = Object.fromEntries(formData);
  subscription.subscriptions = formData.getAll("subscriptions");

  console.log(JSON.stringify(subscription));
  saveSubscription(subscription);
});

/**
 * Main HTTP methods
 * 1. GET - get data from server
 * 2. POST - send data to server
 * 3. PUT - update data on server
 * 4. DELETE - delete data from server
 */
const saveSubscription = (subscription) => {
  const url = "http://localhost:3000/subscriptions";

  const http = new XMLHttpRequest();

  http.open("POST", url, true);
  http.setRequestHeader("Content-Type", "application/json");
  //   http.onload = () => {
  //     if (http.readyState === XMLHttpRequest.DONE && http.status === 200) {
  //       console.log(http.responseText);
  //     }
  //   };
  http.send(JSON.stringify(subscription));
};

window.addEventListener("DOMContentLoaded", (event) => {
  console.log("DOM fully loaded and parsed");

  const url = "http://localhost:3000/subscriptions";
  const http = new XMLHttpRequest();
  const tbl = document.querySelector("#tblSubscriptions");
  http.open("GET", url, true);
  http.onreadystatechange = () => {
    if (http.readyState === XMLHttpRequest.DONE && http.status === 200) {
      const data = JSON.parse(http.responseText);
      data.forEach((sub) => {
        // const row = tbl.insertRow(-1);
        // const id = row.insertCell(0);
        // const firstName = row.insertCell(1);
        // const lastName = row.insertCell(2);
        // const email = row.insertCell(3);
        // const subs = row.insertCell(4);

        // id.innerHTML = sub.id;
        // firstName.innerHTML = sub.firstName;
        // lastName.innerHTML = sub.lastName;
        // email.innerHTML = sub.email;
        // subs.innerHTML = sub.subscriptions.join(", ");
        const row = createRow(sub);
        tbl.appendChild(row);
      });
    }
  };
  http.send();
});


const createRow = (obj) => {
    const row = document.createElement("tr");

    const id = document.createElement("td");
    const firstName = document.createElement("td");
    const lastName = document.createElement("td");
    const email = document.createElement("td");
    const subscriptions = document.createElement("td");

    id.innerHTML = obj.id;
    firstName.innerHTML = obj.firstName;
    lastName.innerHTML = obj.lastName;
    email.innerHTML = obj.email;
    subscriptions.innerHTML = obj.subscriptions.join(", ");

    row.appendChild(id);
    row.appendChild(firstName);
    row.appendChild(lastName);
    row.appendChild(email);
    row.appendChild(subscriptions);

    return row;

}