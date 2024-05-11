import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import firebase from '../services/firebaseService';

const Home = () => {
  const [cars, setCars] = useState([]);

  // Function to fetch list of cars from Firestore
  const fetchCars = async () => {
    const carRef = firebase.firestore().collection('cars');
    const snapshot = await carRef.get();
    const carList = snapshot.docs.map(doc => ({ id: doc.id, ...doc.data() }));
    setCars(carList);
  };

  useEffect(() => {
    fetchCars();
  }, []);

  return (
    <div>
      <h1>Welcome to SwiftDrive</h1>
      <h2>Available Cars:</h2>
      <div className="car-list">
        {cars.map(car => (
          <div key={car.id} className="car-item">
            <h3>{car.make} {car.model}</h3>
            <p>Year: {car.year}</p>
            <p>Type: {car.type}</p>
            <p>Price per day: ${car.price}</p>
            <Link to={`/cars/${car.id}`} className="view-details-link">
              View Details
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Home;
