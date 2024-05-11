import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import api from '../services/api'; // Import the pre-configured axios instance

const CarList = () => {
  const [cars, setCars] = useState([]);

  useEffect(() => {
    const fetchCars = async () => {
      try {
        const response = await api.get('/cars'); // Making a GET request to '/cars' endpoint
        setCars(response.data); // Set state with the fetched data
      } catch (error) {
        console.error('Error fetching cars:', error);
      }
    };

    fetchCars(); // Call the fetchCars function on component mount
  }, []);

  return (
    <div>
      <h1>Car Inventory</h1>
      <ul>
        {cars.map(car => (
          <li key={car.id}>
            <Link to={`/cars/${car.id}`}>
              {car.make} {car.model}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CarList;
