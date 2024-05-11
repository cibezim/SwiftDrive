import React from 'react';
import PaymentInfo from './PaymentInfo';

const PaymentHistory = ({ payments }) => {
  return (
    <div>
      <h2>Payment History</h2>
      {payments.map((payment) => (
        <PaymentInfo key={payment.id} payment={payment} />
      ))}
    </div>
  );
};

export default PaymentHistory;
