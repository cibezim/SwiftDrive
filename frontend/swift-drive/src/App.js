import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './components/Home';
import SignIn from './components/SignIn';
import SignUp from './components/SignUp';
import CarList from './components/CarList';
import RentalList from './components/RentalList';
import RentalForm from './components/RentalForm';
import PaymentForm from './components/PaymentForm';
import NotFound from './components/NotFound';
import Header from './components/Header';

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Switch>
          <Route exact path="/" component={Home} />
          <Route path="/signin" component={SignIn} />
          <Route path="/signup" component={SignUp} />
          <Route path="/cars" component={CarList} />
          <Route exact path="/rentals" component={RentalList} />
          <Route path="/rentals/new" component={RentalForm} />
          <Route path="/rentals/:id/edit" component={RentalForm} />
          <Route path="/payments/new" component={PaymentForm} />
          <Route component={NotFound} />
        </Switch>
      </div>
    </Router>
  );
}

export default App;
