//As default - all inputs is valid.
document.querySelectorAll("input, select").forEach((x) => x.classList.add("is-valid"));

//Some browsers don't support number type
document.getElementsByTagName("input[type=number]").value = 0;

//Get today's date
const currentDate = new Date();
const day = ("0" + currentDate.getDate()).slice(-2);
const month = ("0" + (currentDate.getMonth() + 1)).slice(-2);
const today = currentDate.getFullYear() + "-" + (month) + "-" + (day);

//Set default and standard value to today's date
var dates = document.querySelectorAll("input[type=date]");
for (let i = 0; i < dates.length; i++) {
    dates[i].setAttribute("defaultValue", today);

    if (!dates[i].getAttribute("value")) {
        dates[i].setAttribute("value", today);
    }
}

//Get list of inputs that may be invalid
const validTypes = ["date"];
const inputs = [...document.querySelectorAll("input")].filter((x) => !validTypes.includes(x.type));

inputs.forEach((input) => {
    //If input value is empty, make input invalid
    const value = input.getAttribute("value");
    if (!value || value === "") {
        input.classList.remove("is-valid");
    }

    //Set event listeners
    input.addEventListener("blur", (event) => {
        if (event.target.value) {
            input.classList.add("is-valid");
        } else {
            input.classList.remove("is-valid");
        }
    });
});