import React, { useState } from 'react';
import firebase from '../services/firebase';

const CarForm = () => {
  const [make, setMake] = useState('');
  const [model, setModel] = useState('');
  const [year, setYear] = useState('');
  const [type, setType] = useState('');
  const [price, setPrice] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    const carRef = firebase.firestore().collection('cars');
    await carRef.add({ make, model, year, type, price });
    // Reset form fields
    setMake('');
    setModel('');
    setYear('');
    setType('');
    setPrice('');
  };

  return (
    <form onSubmit={handleSubmit}>
      <input type="text" value={make} onChange={(e) => setMake(e.target.value)} placeholder="Make" />
      <input type="text" value={model} onChange={(e) => setModel(e.target.value)} placeholder="Model" />
      <input type="text" value={year} onChange={(e) => setYear(e.target.value)} placeholder="Year" />
      <input type="text" value={type} onChange={(e) => setType(e.target.value)} placeholder="Type" />
      <input type="number" value={price} onChange={(e) => setPrice(e.target.value)} placeholder="Price" />
      <button type="submit">Add Car</button>
    </form>
  );
};

export default CarForm;
