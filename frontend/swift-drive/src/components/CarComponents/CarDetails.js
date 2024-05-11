import React from 'react';

const CarDetails = ({ car }) => {
  return (
    <div>
      <h2>{car.make} {car.model}</h2>
      <p>Year: {car.year}</p>
      <p>Type: {car.type}</p>
      <p>Price per day: ${car.price}</p>
      {/* Add more details as needed */}
    </div>
  );
};

export default CarDetails;
