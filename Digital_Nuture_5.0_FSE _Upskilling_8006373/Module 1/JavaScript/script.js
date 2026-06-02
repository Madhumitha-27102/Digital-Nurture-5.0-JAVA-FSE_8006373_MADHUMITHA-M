console.log("Community Portal Loaded Successfully");

const eventList = [

    {
        name: "Music Festival",
        category: "Music",
        seats: 50,
        image:
            "https://images.unsplash.com/photo-1506157786151-b8491531f063"
    },

    {
        name: "Food Carnival",
        category: "Food",
        seats: 40,
        image:
            "https://images.unsplash.com/photo-1555939594-58d7cb561ad1"
    },

    {
        name: "Sports Meet",
        category: "Sports",
        seats: 30,
        image:
            "https://images.unsplash.com/photo-1517649763962-0c623066013b"
    }

];

const eventContainer =
    document.getElementById("eventContainer");

function displayEvents(events = eventList) {

    eventContainer.innerHTML = "";

    events.forEach(event => {

        eventContainer.innerHTML += `

        <div class="eventCard">

            <img src="${event.image}"
                alt="${event.name}">

            <h3>${event.name}</h3>

            <p>Category: ${event.category}</p>

            <p>Seats Available: ${event.seats}</p>

        <div class="button-group">

    <button onclick="registerEvent('${event.name}')">
        Register
    </button>

    <button onclick="cancelRegistration('${event.name}')">
        Cancel
    </button>

</div>

        </div>

        `;
    });
}

function registerEvent(eventName) {

    const event =
        eventList.find(
            e => e.name === eventName
        );

    if (event && event.seats > 0) {

        event.seats--;

        alert(
            `Registered for ${event.name}`
        );
    }
    else {

        alert("No seats available");
    }

    displayEvents();
}

function cancelRegistration(eventName) {

    const event =
        eventList.find(
            e => e.name === eventName
        );

    if (event) {

        event.seats++;

        alert(
            `Registration cancelled for ${event.name}`
        );
    }

    displayEvents();
}

function filterEvents() {

    const category =
        document.getElementById(
            "categoryFilter"
        ).value;

    if (category === "All") {

        displayEvents();

        return;
    }

    const filteredEvents =
        eventList.filter(
            event =>
                event.category === category
        );

    displayEvents(filteredEvents);
}

function searchEvent() {

    const searchText =
        document.getElementById(
            "searchBox"
        )
        .value
        .toLowerCase();

    const filteredEvents =
        eventList.filter(
            event =>
                event.name
                    .toLowerCase()
                    .includes(searchText)
        );

    displayEvents(filteredEvents);
}

/* Form Validation */

document
    .getElementById("registrationForm")
    .addEventListener(
        "submit",
        function (e) {

            e.preventDefault();

            document.getElementById(
                "nameError"
            ).innerHTML = "";

            document.getElementById(
                "emailError"
            ).innerHTML = "";

            document.getElementById(
                "eventError"
            ).innerHTML = "";

            let valid = true;

            const userName =
                this.userName.value.trim();

            const email =
                this.email.value.trim();

            const event =
                this.eventName.value;

            if (userName === "") {

                document.getElementById(
                    "nameError"
                ).innerHTML =
                    "Name is required";

                valid = false;
            }

            if (
                email === "" ||
                !email.includes("@")
            ) {

                document.getElementById(
                    "emailError"
                ).innerHTML =
                    "Enter valid email";

                valid = false;
            }

            if (event === "") {

                document.getElementById(
                    "eventError"
                ).innerHTML =
                    "Select an event";

                valid = false;
            }

            if (valid) {

                document.getElementById(
                    "successMessage"
                ).innerHTML =
                    `Registration Successful for ${event}`;

                this.reset();
            }
        }
    );

/* Async API Demo */

const loading =
    document.getElementById("loading");

async function fetchUsers() {

    try {

        loading.style.display =
            "block";

        const response =
            await fetch(
                "https://jsonplaceholder.typicode.com/users"
            );

        const data =
            await response.json();

        console.log(data);
    }
    catch (error) {

        console.log(error);
    }
    finally {

        loading.style.display =
            "none";
    }
}

fetchUsers();

displayEvents();