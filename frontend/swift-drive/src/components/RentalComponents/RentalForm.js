import React, { useState } from 'react';
import firebase from 'firebase/app';
import 'firebase/firestore';

const RentalForm = () => {
  const [make, setMake] = useState('');
  const [model, setModel] = useState('');
  const [pricePerDay, setPricePerDay] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const db = firebase.firestore();
    await db.collection('rentals').add({
      make,
      model,
      pricePerDay: parseFloat(pricePerDay),
    });
    // Clear form fields after submission
    setMake('');
    setModel('');
    setPricePerDay('');
  };

  return (
    <div>
      <h2>Add New Rental</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Make:
          <input type="text" value={make} onChange={(e) => setMake(e.target.value)} required />
        </label>
        <br />
        <label>
          Model:
          <input type="text" value={model} onChange={(e) => setModel(e.target.value)} required />
        </label>
        <br />
        <label>
          Price per Day:
          <input
            type="number"
            value={pricePerDay}
            onChange={(e) => setPricePerDay(e.target.value)}
            required
          />
        </label>
        <br />
        <button type="submit">Add Rental</button>
      </form>
    </div>
  );
};

export default RentalForm;
