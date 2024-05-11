import React, { useEffect, useState } from 'react';
import firebase from 'firebase/app';
import 'firebase/firestore';

const RentalList = () => {
  const [rentals, setRentals] = useState([]);

  useEffect(() => {
    // Fetch rentals from Firestore
    const fetchRentals = async () => {
      const db = firebase.firestore();
      const rentalsCollection = db.collection('rentals');
      const snapshot = await rentalsCollection.get();
      const fetchedRentals = snapshot.docs.map((doc) => ({ id: doc.id, ...doc.data() }));
      setRentals(fetchedRentals);
    };

    fetchRentals();
  }, []);

  return (
    <div>
      <h2>Rentals</h2>
      <ul>
        {rentals.map((rental) => (
          <li key={rental.id}>
            {rental.make} {rental.model} - ${rental.pricePerDay}/day
          </li>
        ))}
      </ul>
    </div>
  );
};

export default RentalList;
