import React from 'react';
import { Switch, Route } from 'react-router-dom';

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import NavBar from './components/Navbar/NavBarComponent.jsx';
import ItemListContainer from './components/Item/ItemCardListContainer';
import ItemDetailContainer from './components/Item/ItemDetailContainer';
import ItemAdminContainer from './components/Item/ItemAdminContainer';
import FormContainer from './components/Item/FormContainer';

import NoMatch from './components/NoMatch/NoMatch';
import NotReady from './components/NotReady/NotReadyComponent';
// import KazkasListContainer
// import KazkasDetailContainer

const App = (props) => (
  <div>
    <NavBar />
    <Switch>
      <Route exact path="/" component={ItemListContainer} />
      <Route exact path="/greetings" component={ItemListContainer} />
      <Route exact path="/greeting/:id" component={ItemDetailContainer} />
      {/* <Route path="/kazkass" component={KazkasListContainer} /> */}
      {/* <Route path="/kazkas/:id" component={KazkasDetailContainer} /> */}
      <Route exact path="/admin/greetings" component={ItemAdminContainer} />
      <Route exact path="/admin/greetings/new" component={FormContainer} />
      <Route exact path="/admin/greetings/:id" component={FormContainer} />
      <Route exact path="/places" component={NotReady} />
      {/* <Route path="/admin/items" component={AdminListContainer} /> */}
      {/* <Route path="/users/:username/cart-Items" component={CartContainer} /> */}
      <Route path="*" component={NoMatch} />
      <Route component={NoMatch} />
    </Switch>
    {props.children}
  </div>
);

export default App;
