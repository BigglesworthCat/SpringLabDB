const validTypes = ["date"];
const inputs = [...document.querySelectorAll("input")].filter((x) => !validTypes.includes(x.type));

inputs.forEach((input) => {
    input.addEventListener("blur", (event) => {
        if (event.target.value) {
            input.classList.add("is-valid");
        } else {
            input.classList.remove("is-valid");
        }
    });
});

//Set "is-valid" css class for form elements
document.querySelectorAll("input[type=date], select").forEach((x) => x.classList.add("is-valid"));

//Set today's date as default for date input
const currentDate = new Date();
const day = ("0" + currentDate.getDate()).slice(-2);
const month = ("0" + (currentDate.getMonth() + 1)).slice(-2);
const today = currentDate.getFullYear() + "-" + (month) + "-" + (day);
document.getElementById("date").value = today;

//Some browsers don't support number type
document.getElementsByTagName("input[type=number]").value = 0;