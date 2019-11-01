document.addEventListener("DOMContentLoaded", function () {

    /**
     * Form Select
     */
    class FormSelect {
        constructor($el) {
            this.$el = $el;
            this.options = [...$el.children];
            this.init();
        }

        init() {
            this.createElements();
            this.addEvents();
            this.$el.parentElement.removeChild(this.$el);
        }

        createElements() {
            // Input for value
            this.valueInput = document.createElement("input");
            this.valueInput.type = "text";
            this.valueInput.name = this.$el.name;

            // Dropdown container
            this.dropdown = document.createElement("div");
            this.dropdown.classList.add("dropdown");

            // List container
            this.ul = document.createElement("ul");

            // All list options
            this.options.forEach((el, i) => {
                const li = document.createElement("li");
                li.dataset.value = el.value;
                li.innerText = el.innerText;

                if (i === 0) {
                    // First clickable option
                    this.current = document.createElement("div");
                    this.current.innerText = el.innerText;
                    this.dropdown.appendChild(this.current);
                    this.valueInput.value = el.value;
                    li.classList.add("selected");
                }

                this.ul.appendChild(li);
            });

            this.dropdown.appendChild(this.ul);
            this.dropdown.appendChild(this.valueInput);
            this.$el.parentElement.appendChild(this.dropdown);
        }

        addEvents() {
            this.dropdown.addEventListener("click", e => {
                const target = e.target;
                this.dropdown.classList.toggle("selecting");

                // Save new value only when clicked on li
                if (target.tagName === "LI") {
                    this.valueInput.value = target.dataset.value;
                    this.current.innerText = target.innerText;
                }
            });
        }
    }

    document.querySelectorAll(".form-group--dropdown select").forEach(el => {
        new FormSelect(el);
    });

    /**
     * Hide elements when clicked on document
     */
    document.addEventListener("click", function (e) {
        const target = e.target;
        const tagName = target.tagName;

        if (target.classList.contains("dropdown")) return false;

        if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
            return false;
        }

        if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
            return false;
        }

        document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
            el.classList.remove("selecting");
        });
    });

    /**
     * Switching between form steps
     */
    class FormSteps {
        constructor(form) {
            this.$form = form;
            this.$next = form.querySelectorAll(".next-step");
            this.$prev = form.querySelectorAll(".prev-step");
            this.$step = form.querySelector(".form--steps-counter span");
            this.currentStep = 1;

            this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
            const $stepForms = form.querySelectorAll("form > div");
            this.slides = [...this.$stepInstructions, ...$stepForms];

            this.init();
        }

        /**
         * Init all methods
         */
        init() {
            this.events();
            this.updateForm();
        }

        /**
         * All events that are happening in form
         */
        events() {
            // Next step
            this.$next.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    if (validate(this.currentStep)) {
                        this.currentStep++;
                    }
                    this.updateForm();
                });
            });

            // Previous step
            this.$prev.forEach(btn => {
                btn.addEventListener("click", e => {
                    e.preventDefault();
                    this.currentStep--;
                    this.updateForm();
                });
            });

            // Form submit
            this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
        }

        /**
         * Update form front-end
         * Show next or previous section etc.
         */
        updateForm() {
            this.$step.innerText = this.currentStep;

            // TODO: Validation

            this.slides.forEach(slide => {
                slide.classList.remove("active");

                if (slide.dataset.step == this.currentStep) {
                    slide.classList.add("active");
                }
            });

            this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
            this.$step.parentElement.hidden = this.currentStep >= 5;

            // TODO: get data from inputs and show them in summary]
            if (this.currentStep == 5) {
                summaryInfo();
            }
        }

    }

    const form = document.querySelector(".form--steps");
    if (form !== null) {
        new FormSteps(form);
    }

    function validate(step) {

        var currentStep = document.querySelector("div.active");
        var result = false;

        document.querySelectorAll(".error").forEach(el => el.innerHTML = '');
        if (step == '1') {
            currentStep.querySelectorAll('input').forEach(function (el) {
                if (el.checked == true)
                    result = true;
            });
            if (result == false) {
                currentStep.querySelector(".error").innerHTML = "Przynajmniej 1 pole musi byc zaznaczone";
            }
        }
        if (step == '2') {
            currentStep.querySelectorAll('input').forEach(function (el) {
                if (el.value > 0) {
                    result = true;
                }
            });
            if (result == false) {
                currentStep.querySelector(".error").innerHTML = "Podaj liczbe workow";
            }
        }
        if (step == '3') {
            currentStep.querySelectorAll('input').forEach(function (el) {
                if (el.checked == true) {
                    result = true;
                }
            });
            if (result == false) {
                currentStep.querySelector(".error").innerHTML = "Wybierz instytucje";
            }
        }
        if (step == '4') {
            var iterator = 0;
            result = true;
            currentStep.querySelectorAll('input').forEach(function (el) {
                if (el.value == "" && iterator != 6) {
                    result = messageBlank(el);
                } else if (!(/^[0-9]{9}$/.test(el.value)) && iterator == 3) {
                    result = messageWrongValue(el);
                } else if (!(/^[0-9]{2}-[0-9]{3}$/.test(el.value)) && iterator == 2) {
                    result = messageWrongValue(el);
                }
                iterator++;
            })
        }

        function messageBlank(element) {
            element.parentElement.parentElement.nextElementSibling.innerHTML = "Pole nie moze byc puste";
            return false;
        }

        function messageWrongValue(element) {
            element.parentElement.parentElement.nextElementSibling.innerHTML = "Błędna wartość";
            return false;
        }

        return result;
    }

    function summaryInfo() {

        var summaryMessage = "";
        var fields = document.querySelectorAll("#category input");
        var quantity = document.querySelector("#quantity input").value;


        if (quantity == 1) {
            summaryMessage = quantity + " worek zawierajacy: ";
        } else if (quantity < 5) {
            summaryMessage = quantity + " worki zawierajace: ";
        } else
            summaryMessage = quantity + " worków zawierajacych: ";

        fields.forEach(function (el) {
            if (el.checked == true) {
                summaryMessage += el.getAttribute('data-name') + ", ";
            }
        });

        document.querySelector("#summaryQuantityAndCategory").innerHTML = summaryMessage.substring(0, summaryMessage.length - 2).concat(".");
        summaryMessage = "Dla fundacji ";
        document.querySelectorAll("#institution input").forEach(function (el) {
            if (el.checked == true) {
                summaryMessage += "\"" + el.getAttribute('data-name') + "\".";
            }
        });
        document.querySelector("#summaryInstitution").innerHTML = summaryMessage;
        document.querySelector("#summaryStreet").innerHTML = document.querySelector("#street input").value;
        document.querySelector("#summaryCity").innerHTML = document.querySelector("#city input").value;
        document.querySelector("#summaryZipCode").innerHTML = document.querySelector("#zipCode input").value;
        document.querySelector("#summaryPhone").innerHTML = document.querySelector("#phone input").value;
        document.querySelector("#summaryPickUpDate").innerHTML = document.querySelector("#pickUpDate input").value;
        document.querySelector("#summaryPickUpTime").innerHTML = document.querySelector("#pickUpTime input").value;

        function comment() {
            var result = document.querySelector("#comment input").value;
            if (result == "") {
                return "Brak uwag";
            }
            return result;
        }

        document.querySelector("#summaryComment").innerHTML = comment();
    }
});
