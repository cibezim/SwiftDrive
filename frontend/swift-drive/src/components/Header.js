// Header.js

import React from 'react';
import { Link } from 'react-router-dom';

const Header = ({ user, onSignOut }) => {
  return (
    <header>
      <nav>
        <ul>
          <li><Link to="/">Home</Link></li>
          <li><Link to="/cars">Cars</Link></li>
          <li><Link to="/rentals">Rentals</Link></li>
          {user ? (
            <>
              <li>Welcome, {user.displayName}</li>
              <li><button onClick={onSignOut}>Sign Out</button></li>
            </>
          ) : (
            <li><Link to="/signin">Sign In</Link></li>
          )}
        </ul>
      </nav>
    </header>
  );
};

export default Header;
