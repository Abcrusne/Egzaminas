import React from 'react';
import ReactDOM from 'react-dom';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Switch, Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import NavigationComponent from './components/Navigation/NavigationComponent';
import SveikinimuSarasasContainer from './components/Sveikinimai/SveikinimuSarasasContainer';
import VienoSveikinimoContainer from './components/Sveikinimai/VienoSveikinimoContainer';
import SveikinimaiAdministrationContainer from './components/Sveikinimai/SveikinimaiAdministrationContainer';
import NaujasSveikinimasContainer from './components/Sveikinimai/NaujasSveikinimasContainer';

var NoMatch = (props) => {
  var goApp = () => props.history.push("/");
  return (
    <div className="text-center ">
        <h5>Route did not match.</h5>
      <button className="btn btn-dark ml-3" onClick={goApp}>Go Home</button>
    </div>
  );
};



ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter basename={process.env.PUBLIC_URL}>
        <NavigationComponent />
          <Switch>
            <Route exact path='/' component={SveikinimuSarasasContainer} />
            <Route exact path='/greetings' component={SveikinimuSarasasContainer} />
            <Route exact path='/greetings/:id' component={VienoSveikinimoContainer} />
            <Route exact path='/admin' component={SveikinimaiAdministrationContainer} />
            <Route exact path='/admin/new' component={NaujasSveikinimasContainer} />
            <Route path="*" component={NoMatch} />
          </Switch>
    </BrowserRouter>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
