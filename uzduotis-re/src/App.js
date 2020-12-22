import React from 'react';
import { Switch, Route } from 'react-router-dom';

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import NavBar from './components/Navbar/NavBarComponent.jsx';
import GreetingListContainer from './components/Greeting/GreetingListContainer';
import GreetingDetailContainer from './components/AboutGreeting/GreetingDetailContainer';
import GreetingAdminFormContainer from './components/GreetingAdmin/GreetingAdminFormContainer';
import AdminListContainer from './components/GreetingAdmin/GreetingListContainer';
import CartContainer from './components/Cart/CartContainer';
import NoMatch from './components/NoMatch/NoMatch';
// import KazkasListContainer
// import KazkasDetailContainer

const App = (props) => (
  <div>
    <NavBar />
    <Switch>
      <Route exact path="/" component={GreetingListContainer} />
      <Route path="/greetings" component={GreetingListContainer} />
      {/* <Route path="/kazkass" component={KazkasListContainer} /> */}
      {/* <Route path="/kazkas/:id" component={KazkasDetailContainer} /> */}
      <Route path="/greeting/:id" component={GreetingDetailContainer} />
      <Route
        path="/admin/greetings/new"
        component={GreetingAdminFormContainer}
      />
      <Route
        path="/admin/greetings/:id"
        component={GreetingAdminFormContainer}
      />
      <Route path="/admin/greetings" component={AdminListContainer} />
      {/* <Route path="/users/:username/cart-greetings" component={CartContainer} /> */}
      <Route path="*" component={NoMatch} />
      <Route component={NoMatch} />
    </Switch>
    {props.children}
  </div>
);

export default App;
