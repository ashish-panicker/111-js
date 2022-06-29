console.log("hellooooo");
const txtReminder = document.getElementById("txtReminder");
const btnCreate = document.getElementById("btnCreate");
const listReminders = document.getElementById("listReminders");

const addReminder = function (e) {
  let reminder = txtReminder.value;
  const li = createReminder(reminder);
  listReminders.appendChild(li);
  txtReminder.value = "";
};

const deleteReminder = function (e) {
    const li = e.target.parentElement
    li.classList.add("border", "border-success");
    e.target.remove()

    const em = document.createElement("em")
    em.classList.add("bi", "bi-check-lg", "me-2", "text-success")
    em.style.fontSize = "1.1em"

    li.insertBefore(em, li.firstChild)
    // console.log(li.innerText)
    // li.remove()
}

const createReminder = function (reminder) {
  const li = document.createElement("li");
  li.classList.add("list-group-item", "m-2");
  li.innerText = reminder;

  const checkbox = document.createElement("input");
  checkbox.type = "checkbox";
  checkbox.classList.add("form-check-input", "me-2");
  checkbox.addEventListener("change", deleteReminder);

  li.insertBefore(checkbox, li.firstChild);
  return li;
};

btnCreate.addEventListener("click", function (e) {
  addReminder(e);
});

txtReminder.addEventListener("keyup", function (e) {
  if (e.key === "Enter") {
    addReminder(e);
  }
});
