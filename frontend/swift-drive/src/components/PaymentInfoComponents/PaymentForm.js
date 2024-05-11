import React, { useState } from 'react';

const PaymentForm = ({ onSubmit }) => {
  const [amount, setAmount] = useState('');
  const [date, setDate] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    // Perform validation or other operations before submitting
    onSubmit({ amount, date });
    // Clear form fields after submission
    setAmount('');
    setDate('');
  };

  return (
    <div>
      <h2>Enter Payment Details</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Amount:
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            required
          />
        </label>
        <br />
        <label>
          Date:
          <input
            type="date"
            value={date}
            onChange={(e) => setDate(e.target.value)}
            required
          />
        </label>
        <br />
        <button type="submit">Submit Payment</button>
      </form>
    </div>
  );
};

export default PaymentForm;
