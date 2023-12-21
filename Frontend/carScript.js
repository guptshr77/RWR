function init(){
    if(localStorage.getItem("email") != null){
        //do whatever
    }
    //localStorage.clear(); ==> When logging out
}


// script.js
document.addEventListener("DOMContentLoaded", function () {
    // Sample car data (replace this with data from the backend)
    const carData = [
        {
            model: "Model X",
            manufactuer: "Manufacturer",
            price: "$25000",
            description: "Description"
        }
        // Add more car objects as needed
    ];

    // Reference to the car listings section
    const carListingsSection = document.getElementById("carListings");

    
    // Generate car cards dynamically
    carData.forEach(car => {
        const carCard = document.createElement("div");
        carCard.className = "car-card";

        carCard.innerHTML = `
            <p>${car.model}</p>
            <p>${car.manufactuer}</p>
            <p>$${car.price}</p>
            <p>${car.description}</p>
        `;

        carListingsSection.appendChild(carCard);
    });
});
